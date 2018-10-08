
/* ---------- Render page ---------- */
var lastUpdateTime = -1;
var lastUpdateSession = "";
function renderEvaluationPage(firstLoad) {
    updateSessionWorkerSelect();

    if(firstLoad || !lastUpdateSession || lastUpdateSession == "" || lastUpdateSession != currSession){
        executeEvaluationUpdate();
    } else {
        //Check last update time first - see if data has actually changed...
        $.ajax({
            url: "/train/sessions/lastUpdate/" + currSession,
            async: true,
            error: function (query, status, error) {
                console.log("Error getting data: " + error);
            },
            success: function (data) {
                if(data > lastUpdateTime){
                    executeEvaluationUpdate();
                }
            }
        });
    }
}

function executeEvaluationUpdate(){
    $.ajax({
        url: "/train/overview/data",
        async: true,
        error: function (query, status, error) {
            console.log("Error getting data: " + error);
        },
        success: function (data) {
            lastUpdateSession = currSession;
            lastUpdateTime = data["updateTimestamp"];
            renderAccuracyVsEpochChart(data);
            renderF1VsEpochChart(data);
            renderPrecisionVsEpochChart(data);
            renderRecallVsEpochChart(data);


        }
    });
}

/* ---------- F-1 vs. Epoch Chart ---------- */
function renderF1VsEpochChart(data) {
    var f1Arr = data["f1s"];
    var epoch = data["epoch"];

    var maxAccuracy = Math.max.apply(Math, f1Arr);
    var chartMin = Math.min.apply(Math, f1Arr);
    if(chartMin > 0){
        chartMin = 0.0;
    }

    var f1Chart = $("#f1_chart");
    f1Chart.unbind(); // prevent over-subscribing

    if (f1Chart.length) {
        var accuracyData = [];

        for (var i = 0; i < f1Arr.length; i++) {
            accuracyData.push([epoch[i], f1Arr[i]]);
        }

        var plotData = [{data: accuracyData, label: "accuracy"}];

        // calculate a EMA line to summarize training progress
        if(epoch.length > 10) {
            var bestFitLine = EMACalc(f1Arr, 10);
            var bestFitData = [];
            for (var i = 0; i < bestFitLine.length; i++) {
                bestFitData.push([epoch[i], bestFitLine[i]]);
            }
            plotData.push({data: bestFitData, label: "summary"});
        }

        // plot the chart
        var plotOptions = {
            series: {
                lines: {
                    show: true,
                    lineWidth: 2
                }
            },
            grid: {
                hoverable: true,
                clickable: true,
                tickColor: "#dddddd",
                borderWidth: 0
            },
            yaxis: {min: chartMin, max: maxAccuracy},
            colors: ["#FA5833","rgba(65,182,240,0.3)","#000000"],
            selection: {
                mode: "x"
            }
        };
        var plot = $.plot(f1Chart, plotData, plotOptions);

        // when selected, calculate best fit line
        f1Chart.bind("plotselected", function (event, ranges) {
            var indices = [];
            var fromIdx = parseInt(ranges.xaxis.from);
            var toIdx = parseInt(ranges.xaxis.to);
            var accuraciesCopy = f1Arr.slice();

            for (var i = fromIdx; i <= toIdx; i++) {
               indices.push(i);
            }

            var bestFitLine = findLineByLeastSquares(indices, accuraciesCopy.slice(fromIdx,toIdx+1));
            var bestFitData = [];
            for (var i = 0; i < bestFitLine[0].length; i++) {
                bestFitData.push([bestFitLine[0][i], bestFitLine[1][i]]);
            }
            plotData.push({data: bestFitData, label: "selection"});

            plot.setData(plotData);
            plot.draw();
        });

        f1Chart.bind("plotunselected", function (event) {
            plotData = plotData.slice(0,2);
            plot.setData(plotData);
            plot.draw();
        });

        function showTooltip(x, y, contents) {
            $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y + 8,
                left: x + 10,
                border: '1px solid #fdd',
                padding: '2px',
                'background-color': '#dfeffc',
                opacity: 0.80
            }).appendTo("#f1_chart").fadeIn(200);
        }

        var previousPoint = null;
        f1Chart.bind("plothover", function (event, pos, item) {
            if (typeof pos.x == 'undefined') return;

            var xPos = pos.x.toFixed(0);
            $("#x_f1").text(xPos < 0 || xPos == "-0" ? "" : xPos);
            $("#y_f1").text(pos.y.toFixed(5));

            if (item) {
                if (previousPoint != item.dataIndex) {
                    previousPoint = item.dataIndex;

                    $("#tooltip").remove();
                    var x = item.datapoint[0].toFixed(0);
                    var y = item.datapoint[1].toFixed(5);

                    showTooltip(item.pageX - f1Chart.offset().left, item.pageY - f1Chart.offset().top,
                        "(" + x + ", " + y + ")");
                }
            }
            else {
                $("#tooltip").remove();
                previousPoint = null;
            }
        });
    }
}


/* ---------- Recall vs. Epoch Chart ---------- */
function renderRecallVsEpochChart(data) {
    var recallArr = data["recalls"];
    var epoch = data["epoch"];

    var maxAccuracy = Math.max.apply(Math, recallArr);
    var chartMin = Math.min.apply(Math, recallArr);
    if(chartMin > 0){
        chartMin = 0.0;
    }

    var recallChart = $("#recall_chart");
    recallChart.unbind(); // prevent over-subscribing

    if (recallChart.length) {
        var accuracyData = [];

        for (var i = 0; i < recallArr.length; i++) {
            accuracyData.push([epoch[i], recallArr[i]]);
        }

        var plotData = [{data: accuracyData, label: "accuracy"}];

        // calculate a EMA line to summarize training progress
        if(epoch.length > 10) {
            var bestFitLine = EMACalc(recallArr, 10);
            var bestFitData = [];
            for (var i = 0; i < bestFitLine.length; i++) {
                bestFitData.push([epoch[i], bestFitLine[i]]);
            }
            plotData.push({data: bestFitData, label: "summary"});
        }

        // plot the chart
        var plotOptions = {
            series: {
                lines: {
                    show: true,
                    lineWidth: 2
                }
            },
            grid: {
                hoverable: true,
                clickable: true,
                tickColor: "#dddddd",
                borderWidth: 0
            },
            yaxis: {min: chartMin, max: maxAccuracy},
            colors: ["#FA5833","rgba(65,182,240,0.3)","#000000"],
            selection: {
                mode: "x"
            }
        };
        var plot = $.plot(recallChart, plotData, plotOptions);

        // when selected, calculate best fit line
        recallChart.bind("plotselected", function (event, ranges) {
            var indices = [];
            var fromIdx = parseInt(ranges.xaxis.from);
            var toIdx = parseInt(ranges.xaxis.to);
            var accuraciesCopy = recallArr.slice();

            for (var i = fromIdx; i <= toIdx; i++) {
               indices.push(i);
            }

            var bestFitLine = findLineByLeastSquares(indices, accuraciesCopy.slice(fromIdx,toIdx+1));
            var bestFitData = [];
            for (var i = 0; i < bestFitLine[0].length; i++) {
                bestFitData.push([bestFitLine[0][i], bestFitLine[1][i]]);
            }
            plotData.push({data: bestFitData, label: "selection"});

            plot.setData(plotData);
            plot.draw();
        });

        recallChart.bind("plotunselected", function (event) {
            plotData = plotData.slice(0,2);
            plot.setData(plotData);
            plot.draw();
        });

        function showTooltip(x, y, contents) {
            $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y + 8,
                left: x + 10,
                border: '1px solid #fdd',
                padding: '2px',
                'background-color': '#dfeffc',
                opacity: 0.80
            }).appendTo("#recall_chart").fadeIn(200);
        }

        var previousPoint = null;
        recallChart.bind("plothover", function (event, pos, item) {
            if (typeof pos.x == 'undefined') return;

            var xPos = pos.x.toFixed(0);
            $("#x_recall").text(xPos < 0 || xPos == "-0" ? "" : xPos);
            $("#y_recall").text(pos.y.toFixed(5));

            if (item) {
                if (previousPoint != item.dataIndex) {
                    previousPoint = item.dataIndex;

                    $("#tooltip").remove();
                    var x = item.datapoint[0].toFixed(0);
                    var y = item.datapoint[1].toFixed(5);

                    showTooltip(item.pageX - recallChart.offset().left, item.pageY - recallChart.offset().top,
                        "(" + x + ", " + y + ")");
                }
            }
            else {
                $("#tooltip").remove();
                previousPoint = null;
            }
        });
    }
}

/* ---------- Precision vs. Epoch Chart ---------- */
function renderPrecisionVsEpochChart(data) {
    var precisionsArr = data["precisions"];
    var epoch = data["epoch"];

    var maxAccuracy = Math.max.apply(Math, precisionsArr);
    var chartMin = Math.min.apply(Math, precisionsArr);
    if(chartMin > 0){
        chartMin = 0.0;
    }

    var precisionChart = $("#precision_chart");
    precisionChart.unbind(); // prevent over-subscribing

    if (precisionChart.length) {
        var accuracyData = [];

        for (var i = 0; i < precisionsArr.length; i++) {
            accuracyData.push([epoch[i], precisionsArr[i]]);
        }

        var plotData = [{data: accuracyData, label: "accuracy"}];

        // calculate a EMA line to summarize training progress
        if(epoch.length > 10) {
            var bestFitLine = EMACalc(precisionsArr, 10);
            var bestFitData = [];
            for (var i = 0; i < bestFitLine.length; i++) {
                bestFitData.push([epoch[i], bestFitLine[i]]);
            }
            plotData.push({data: bestFitData, label: "summary"});
        }

        // plot the chart
        var plotOptions = {
            series: {
                lines: {
                    show: true,
                    lineWidth: 2
                }
            },
            grid: {
                hoverable: true,
                clickable: true,
                tickColor: "#dddddd",
                borderWidth: 0
            },
            yaxis: {min: chartMin, max: maxAccuracy},
            colors: ["#FA5833","rgba(65,182,240,0.3)","#000000"],
            selection: {
                mode: "x"
            }
        };
        var plot = $.plot(precisionChart, plotData, plotOptions);

        // when selected, calculate best fit line
        precisionChart.bind("plotselected", function (event, ranges) {
            var indices = [];
            var fromIdx = parseInt(ranges.xaxis.from);
            var toIdx = parseInt(ranges.xaxis.to);
            var accuraciesCopy = precisionsArr.slice();

            for (var i = fromIdx; i <= toIdx; i++) {
               indices.push(i);
            }

            var bestFitLine = findLineByLeastSquares(indices, accuraciesCopy.slice(fromIdx,toIdx+1));
            var bestFitData = [];
            for (var i = 0; i < bestFitLine[0].length; i++) {
                bestFitData.push([bestFitLine[0][i], bestFitLine[1][i]]);
            }
            plotData.push({data: bestFitData, label: "selection"});

            plot.setData(plotData);
            plot.draw();
        });

        precisionChart.bind("plotunselected", function (event) {
            plotData = plotData.slice(0,2);
            plot.setData(plotData);
            plot.draw();
        });

        function showTooltip(x, y, contents) {
            $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y + 8,
                left: x + 10,
                border: '1px solid #fdd',
                padding: '2px',
                'background-color': '#dfeffc',
                opacity: 0.80
            }).appendTo("#precision_chart").fadeIn(200);
        }

        var previousPoint = null;
        precisionChart.bind("plothover", function (event, pos, item) {
            if (typeof pos.x == 'undefined') return;

            var xPos = pos.x.toFixed(0);
            $("#x_precision").text(xPos < 0 || xPos == "-0" ? "" : xPos);
            $("#y_precision").text(pos.y.toFixed(5));

            if (item) {
                if (previousPoint != item.dataIndex) {
                    previousPoint = item.dataIndex;

                    $("#tooltip").remove();
                    var x = item.datapoint[0].toFixed(0);
                    var y = item.datapoint[1].toFixed(5);

                    showTooltip(item.pageX - precisionChart.offset().left, item.pageY - precisionChart.offset().top,
                        "(" + x + ", " + y + ")");
                }
            }
            else {
                $("#tooltip").remove();
                previousPoint = null;
            }
        });
    }
}

/* ---------- Accuracy vs. Epoch Chart ---------- */
function renderAccuracyVsEpochChart(data) {
    var accuraciesArr = data["accuracies"];
    var epoch = data["epoch"];

    var maxAccuracy = Math.max.apply(Math, accuraciesArr);
    var chartMin = Math.min.apply(Math, accuraciesArr);
    if(chartMin > 0){
        chartMin = 0.0;
    }

    var accuracyChart = $("#accuracy_chart");
    accuracyChart.unbind(); // prevent over-subscribing

    if (accuracyChart.length) {
        var accuracyData = [];

        for (var i = 0; i < accuraciesArr.length; i++) {
            accuracyData.push([epoch[i], accuraciesArr[i]]);
        }

        var plotData = [{data: accuracyData, label: "accuracy"}];

        // calculate a EMA line to summarize training progress
        if(epoch.length > 10) {
            var bestFitLine = EMACalc(accuraciesArr, 10);
            var bestFitData = [];
            for (var i = 0; i < bestFitLine.length; i++) {
                bestFitData.push([epoch[i], bestFitLine[i]]);
            }
            plotData.push({data: bestFitData, label: "summary"});
        }

        // plot the chart
        var plotOptions = {
            series: {
                lines: {
                    show: true,
                    lineWidth: 2
                }
            },
            grid: {
                hoverable: true,
                clickable: true,
                tickColor: "#dddddd",
                borderWidth: 0
            },
            yaxis: {min: chartMin, max: maxAccuracy},
            colors: ["#FA5833","rgba(65,182,240,0.3)","#000000"],
            selection: {
                mode: "x"
            }
        };
        var plot = $.plot(accuracyChart, plotData, plotOptions);

        // when selected, calculate best fit line
        accuracyChart.bind("plotselected", function (event, ranges) {
            var indices = [];
            var fromIdx = parseInt(ranges.xaxis.from);
            var toIdx = parseInt(ranges.xaxis.to);
            var accuraciesCopy = accuraciesArr.slice();

            for (var i = fromIdx; i <= toIdx; i++) {
               indices.push(i);
            }

            var bestFitLine = findLineByLeastSquares(indices, accuraciesCopy.slice(fromIdx,toIdx+1));
            var bestFitData = [];
            for (var i = 0; i < bestFitLine[0].length; i++) {
                bestFitData.push([bestFitLine[0][i], bestFitLine[1][i]]);
            }
            plotData.push({data: bestFitData, label: "selection"});

            plot.setData(plotData);
            plot.draw();
        });

        accuracyChart.bind("plotunselected", function (event) {
            plotData = plotData.slice(0,2);
            plot.setData(plotData);
            plot.draw();
        });

        function showTooltip(x, y, contents) {
            $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y + 8,
                left: x + 10,
                border: '1px solid #fdd',
                padding: '2px',
                'background-color': '#dfeffc',
                opacity: 0.80
            }).appendTo("#accuracy_chart").fadeIn(200);
        }

        var previousPoint = null;
        accuracyChart.bind("plothover", function (event, pos, item) {
            if (typeof pos.x == 'undefined') return;

            var xPos = pos.x.toFixed(0);
            $("#x_accuracy").text(xPos < 0 || xPos == "-0" ? "" : xPos);
            $("#y_accuracy").text(pos.y.toFixed(5));

            if (item) {
                if (previousPoint != item.dataIndex) {
                    previousPoint = item.dataIndex;

                    $("#tooltip").remove();
                    var x = item.datapoint[0].toFixed(0);
                    var y = item.datapoint[1].toFixed(5);

                    showTooltip(item.pageX - accuracyChart.offset().left, item.pageY - accuracyChart.offset().top,
                        "(" + x + ", " + y + ")");
                }
            }
            else {
                $("#tooltip").remove();
                previousPoint = null;
            }
        });
    }
}

/* --------------- linear least squares (best fit line) ---------- */
function findLineByLeastSquares(values_x, values_y) {
    var sum_x = 0;
    var sum_y = 0;
    var sum_xy = 0;
    var sum_xx = 0;
    var count = 0;

    /*
     * We'll use those variables for faster read/write access.
     */
    var x = 0;
    var y = 0;
    var values_length = values_x.length;

    if (values_length != values_y.length) {
        throw new Error('The parameters values_x and values_y need to have same size!');
    }

    /*
     * Nothing to do.
     */
    if (values_length === 0) {
        return [ [], [] ];
    }

    /*
     * Calculate the sum for each of the parts necessary.
     */
    for (var v = 0; v < values_length; v++) {
        x = values_x[v];
        y = values_y[v];
        sum_x += x;
        sum_y += y;
        sum_xx += x*x;
        sum_xy += x*y;
        count++;
    }

    /*
     * Calculate m and b for the formular:
     * y = x * m + b
     */
    var m = (count*sum_xy - sum_x*sum_y) / (count*sum_xx - sum_x*sum_x);
    var b = (sum_y/count) - (m*sum_x)/count;

    /*
     * We will make the x and y result line now
     */
    var result_values_x = [];
    var result_values_y = [];

    for (var v = 0; v < values_length; v++) {
        x = values_x[v];
        y = x * m + b;
        result_values_x.push(x);
        result_values_y.push(y);
    }

    return [result_values_x, result_values_y];
}


/* --------------- exponential moving average (best fit line) ---------- */
function EMACalc(mArray,mRange) {
  var k = 2/(mRange + 1);
  // first item is just the same as the first item in the input
  emaArray = [mArray[0]];
  // for the rest of the items, they are computed with the previous one
  for (var i = 1; i < mArray.length; i++) {
    emaArray.push(mArray[i] * k + emaArray[i - 1] * (1 - k));
  }
  return emaArray;
}
