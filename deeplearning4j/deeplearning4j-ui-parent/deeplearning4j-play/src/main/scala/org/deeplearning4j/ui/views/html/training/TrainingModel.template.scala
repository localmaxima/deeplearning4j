
package org.deeplearning4j.ui.views.html.training

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object TrainingModel_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class TrainingModel extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[org.deeplearning4j.ui.api.I18N,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(i18n: org.deeplearning4j.ui.api.I18N):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>

<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  ~ Copyright (c) 2015-2018 Skymind, Inc.
  ~
  ~ This program and the accompanying materials are made available under the
  ~ terms of the Apache License, Version 2.0 which is available at
  ~ https://www.apache.org/licenses/LICENSE-2.0.
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  ~ WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  ~ License for the specific language governing permissions and limitations
  ~ under the License.
  ~
  ~ SPDX-License-Identifier: Apache-2.0
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->

<html lang="en">
    <head>

        <meta charset="utf-8">
        <title>"""),_display_(/*24.17*/i18n/*24.21*/.getMessage("train.pagetitle")),format.raw/*24.51*/("""</title>
            <!-- start: Mobile Specific -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
            <!-- end: Mobile Specific -->

        <link id="bootstrap-style" href="/assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="/assets/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="/assets/css/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="/assets/css/style-responsive.css" rel="stylesheet">
        <link href='/assets/css/opensans-fonts.css' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="/assets/img/favicon.ico">

            <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
            <!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="/assets/css/ie.css" rel="stylesheet"/>
	<![endif]-->

            <!--[if IE 9]>
		<link id="ie9style" href="/assets/css/ie9.css" rel="stylesheet"/>
	<![endif]-->
    </head>

    <body>
            <!-- Start Header -->
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="index.html"><span>"""),_display_(/*57.63*/i18n/*57.67*/.getMessage("train.pagetitle")),format.raw/*57.97*/("""</span></a>
                    <div id="sessionSelectDiv" style="display:none; float:right">
                        """),_display_(/*59.26*/i18n/*59.30*/.getMessage("train.session.label")),format.raw/*59.64*/("""
                        """),format.raw/*60.25*/("""<select id="sessionSelect" onchange='selectNewSession()'>
                            <option>(Session ID)</option>
                        </select>
                    </div>
                    <div id="workerSelectDiv" style="display:none; float:right;">
                        """),_display_(/*65.26*/i18n/*65.30*/.getMessage("train.session.worker.label")),format.raw/*65.71*/("""
                        """),format.raw/*66.25*/("""<select id="workerSelect" onchange='selectNewWorker()'>
                            <option>(Worker ID)</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
            <!-- End Header -->

        <div class="container-fluid-full">
            <div class="row-fluid">

                    <!-- Start Main Menu -->
                <div id="sidebar-left" class="span2">
                    <div class="nav-collapse sidebar-nav">
                        <ul class="nav nav-tabs nav-stacked main-menu">
                            <li><a href="overview"><i class="icon-bar-chart"></i> <span class="hidden-tablet">"""),_display_(/*82.112*/i18n/*82.116*/.getMessage("train.nav.overview")),format.raw/*82.149*/("""</span></a></li>
                            <li class="active"><a href="javascript:void(0);"><i class="icon-tasks"></i> <span class="hidden-tablet">"""),_display_(/*83.134*/i18n/*83.138*/.getMessage("train.nav.model")),format.raw/*83.168*/("""</span></a></li>
                            <li><a href="../evaluation/overview"><i class="icon-tasks"></i><span class="hidden-tablet">Evaluation</span></a></li>
                            <li><a href="system"><i class="icon-dashboard"></i> <span class="hidden-tablet">"""),_display_(/*85.110*/i18n/*85.114*/.getMessage("train.nav.system")),format.raw/*85.145*/("""</span></a></li>
                            """),format.raw/*86.161*/("""
                            """),format.raw/*87.29*/("""<li>
                                <a class="dropmenu" href="javascript:void(0);"><i class="icon-folder-close-alt"></i> <span class="hidden-tablet">
                                """),_display_(/*89.34*/i18n/*89.38*/.getMessage("train.nav.language")),format.raw/*89.71*/("""</span></a>
                                <ul>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('en', 'model')"><i class="icon-file-alt"></i> <span class="hidden-tablet">
                                        English</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('de', 'model')"><i class="icon-file-alt"></i> <span class="hidden-tablet">
                                        Deutsch</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('ja', 'model')"><i class="icon-file-alt"></i> <span class="hidden-tablet">
                                        日本語</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('zh', 'model')"><i class="icon-file-alt"></i> <span class="hidden-tablet">
                                        中文</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('ko', 'model')"><i class="icon-file-alt"></i> <span class="hidden-tablet">
                                        한글</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('ru', 'model')"><i class="icon-file-alt"></i> <span class="hidden-tablet">
                                        русский</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('uk', 'model')"><i class="icon-file-alt"></i> <span class="hidden-tablet">
                                        український</span></a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                    <!-- End Main Menu -->

                <noscript>
                    <div class="alert alert-block span10">
                        <h4 class="alert-heading">Warning!</h4>
                        <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">
                            JavaScript</a>
                            enabled to use this site.</p>
                    </div>
                </noscript>

                <style>
                /* Graph */
                #layers """),format.raw/*123.25*/("""{"""),format.raw/*123.26*/("""
                    """),format.raw/*124.21*/("""height: 725px; /* IE8 */
                    height: 90vh;
                    width: 100%;
                    border: 2px solid #eee;
                """),format.raw/*128.17*/("""}"""),format.raw/*128.18*/("""
                """),format.raw/*129.17*/("""</style>

                    <!-- Start Content -->
                <div id="content" class="span10">

                    <div class="row-fluid span5">
                        <div id="layers"></div>
                    </div>
                        <!-- Start Layer Details -->
                    <div class="row-fluid span7" id="layerDetails">

                        <div class="box">
                            <div class="box-header">
                                <h2><b>"""),_display_(/*142.41*/i18n/*142.45*/.getMessage("train.model.layerInfoTable.title")),format.raw/*142.92*/("""</b></h2>
                            </div>
                            <div class="box-content">
                                <table class="table table-bordered table-striped table-condensed" id="layerInfo"></table>
                            </div>
                        </div>

                        <div class="box">
                            <div class="box-header">
                                <h2><b>"""),_display_(/*151.41*/i18n/*151.45*/.getMessage("train.overview.chart.updateRatioTitle")),format.raw/*151.97*/("""</b></h2><p id="updateRatioTitleLog10"><b>: log<sub>10</sub></b></p>
                                <ul class="nav tab-menu nav-tabs" style="position:absolute; margin-top: -36px; right: 27px;">
                                    <li id="mmRatioTab"><a href="javascript:void(0);" onclick="setSelectMeanMagChart('ratios')">"""),_display_(/*153.130*/i18n/*153.134*/.getMessage("train.model.meanmag.btn.ratio")),format.raw/*153.178*/("""</a></li>
                                    <li id="mmParamTab"><a href="javascript:void(0);" onclick="setSelectMeanMagChart('paramMM')">"""),_display_(/*154.131*/i18n/*154.135*/.getMessage("train.model.meanmag.btn.param")),format.raw/*154.179*/("""</a></li>
                                    <li id="mmUpdateTab"><a href="javascript:void(0);" onclick="setSelectMeanMagChart('updateMM')">"""),_display_(/*155.133*/i18n/*155.137*/.getMessage("train.model.meanmag.btn.update")),format.raw/*155.182*/("""</a></li>
                                </ul>
                            </div>
                            <div class="box-content">
                                <div id="meanmag" class="center" style="height: 300px;" ></div>
                                <p id="hoverdata"><span id="updateRatioTitleSmallLog10"><b>log<sub>
                                    10</sub> """),_display_(/*161.47*/i18n/*161.51*/.getMessage("train.overview.chart.updateRatioTitleShort")),format.raw/*161.108*/("""</b></span> <span id="yMeanMagnitudes">
                                    0</span>
                                    , <b>"""),_display_(/*163.43*/i18n/*163.47*/.getMessage("train.overview.charts.iteration")),format.raw/*163.93*/("""
                                        """),format.raw/*164.41*/(""":</b> <span id="xMeanMagnitudes">0</span></p>
                            </div>
                        </div>

                        <div class="box">
                            <div class="box-header">
                                <h2><b>"""),_display_(/*170.41*/i18n/*170.45*/.getMessage("train.model.activationsChart.title")),format.raw/*170.94*/("""</b></h2>
                            </div>
                            <div class="box-content">
                                <div id="activations" class="center" style="height: 300px;" ></div>
                                <p id="hoverdata"><b>"""),_display_(/*174.55*/i18n/*174.59*/.getMessage("train.model.activationsChart.titleShort")),format.raw/*174.113*/("""
                                    """),format.raw/*175.37*/(""":</b> <span id="yActivations">0</span>
                                    , <b>"""),_display_(/*176.43*/i18n/*176.47*/.getMessage("train.overview.charts.iteration")),format.raw/*176.93*/("""
                                        """),format.raw/*177.41*/(""":</b> <span id="xActivations">0</span></p>
                            </div>
                        </div>

                        <div class="box">
                            <div class="box-header">
                                <h2><b>"""),_display_(/*183.41*/i18n/*183.45*/.getMessage("train.model.paramHistChart.title")),format.raw/*183.92*/("""</b></h2>
                                <div id="paramhistSelected" style="float: left"></div>
                                <div id="paramHistButtonsDiv" style="float: right"></div>
                            </div>
                            <div class="box-content">
                                <div id="parametershistogram" class="center" style="height: 300px;"></div>
                            </div>
                        </div>

                        <div class="box">
                            <div class="box-header">
                                <h2><b>"""),_display_(/*194.41*/i18n/*194.45*/.getMessage("train.model.updateHistChart.title")),format.raw/*194.93*/("""</b></h2>
                                <div id="updatehistSelected" style="float: left"></div>
                                <div id="updateHistButtonsDiv" style="float: right"></div>
                            </div>
                            <div class="box-content">
                                <div id="updateshistogram" class="center" style="height: 300px;"></div>
                            </div>
                        </div>

                        <div class="box">
                            <div class="box-header">
                                <h2><b>"""),_display_(/*205.41*/i18n/*205.45*/.getMessage("train.model.lrChart.title")),format.raw/*205.85*/("""</b></h2>
                            </div>
                            <div class="box-content">
                                <div id="learningrate" class="center" style="height: 300px;" ></div>
                                <p id="hoverdata"><b>"""),_display_(/*209.55*/i18n/*209.59*/.getMessage("train.model.lrChart.titleShort")),format.raw/*209.104*/("""
                                    """),format.raw/*210.37*/(""":</b> <span id="yLearningRate">0</span>
                                    , <b>"""),_display_(/*211.43*/i18n/*211.47*/.getMessage("train.overview.charts.iteration")),format.raw/*211.93*/("""
                                        """),format.raw/*212.41*/(""":</b> <span id="xLearningRate">0</span></p>
                            </div>
                        </div>

                    </div>
                        <!-- End Layer Details-->

                        <!-- Begin Zero State -->
                    <div class="row-fluid span6" id="zeroState">
                        <div class="box">
                            <div class="box-header">
                                <h2><b>Getting Started</b></h2>
                            </div>
                            <div class="box-content">
                                <div class="page-header">
                                    <h1>Layer Visualization UI</h1>
                                </div>
                                <div class="row-fluid">
                                    <div class="span12">
                                        <h2>Overview</h2>
                                        <p>
                                            The layer visualization UI renders network structure dynamically. Users can inspect node layer parameters by clicking on the various elements of the GUI to see general information as well as overall network information such as performance.
                                        </p>
                                        <h2>Actions</h2>
                                        <p>On the <b>left</b>, you will find an interactive layer visualization.</p>
                                        <p>
                                    <ul>
                                        <li><b>Clicking</b> - Click on a layer to load network performance metrics.</li>
                                        <li><b>Scrolling</b>
                                            - Drag the GUI with your mouse or touchpad to move the model around. </li>
                                    </ul>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                        <!-- End Zero State-->
                </div>
                    <!-- End Content -->
            </div> <!-- End Container -->
        </div> <!-- End Row Fluid-->

        <!-- Start JavaScript-->
        <script src="/assets/js/jquery-1.9.1.min.js"></script>
        <script src="/assets/js/jquery-migrate-1.0.0.min.js"></script>
        <script src="/assets/js/jquery-ui-1.10.0.custom.min.js"></script>
        <script src="/assets/js/jquery.ui.touch-punch.js"></script>
        <script src="/assets/js/modernizr.js"></script>
        <script src="/assets/js/bootstrap.min.js"></script>
        <script src="/assets/js/jquery.cookie.js"></script>
        <script src="/assets/js/fullcalendar.min.js"></script>
        <script src="/assets/js/jquery.dataTables.min.js"></script>
        <script src="/assets/js/excanvas.js"></script>
        <script src="/assets/js/jquery.flot.js"></script>
        <script src="/assets/js/jquery.flot.pie.js"></script>
        <script src="/assets/js/jquery.flot.stack.js"></script>
        <script src="/assets/js/jquery.flot.resize.min.js"></script>
        <script src="/assets/js/jquery.chosen.min.js"></script>
        <script src="/assets/js/jquery.uniform.min.js"></script>
        <script src="/assets/js/jquery.cleditor.min.js"></script>
        <script src="/assets/js/jquery.noty.js"></script>
        <script src="/assets/js/jquery.elfinder.min.js"></script>
        <script src="/assets/js/jquery.raty.min.js"></script>
        <script src="/assets/js/jquery.iphone.toggle.js"></script>
        <script src="/assets/js/jquery.uploadify-3.1.min.js"></script>
        <script src="/assets/js/jquery.gritter.min.js"></script>
        <script src="/assets/js/jquery.imagesloaded.js"></script>
        <script src="/assets/js/jquery.masonry.min.js"></script>
        <script src="/assets/js/jquery.knob.modified.js"></script>
        <script src="/assets/js/jquery.sparkline.min.js"></script>
        <script src="/assets/js/counter.js"></script>
        <script src="/assets/js/retina.js"></script>
        <script src="/assets/js/cytoscape.min.js"></script>
        <script src="/assets/js/dagre.min.js"></script>
        <script src="/assets/js/cytoscape-dagre.js"></script>
        <script src="/assets/js/train/model.js"></script> <!-- Charts and tables are generated here! -->
        <script src="/assets/js/train/model-graph.js"></script> <!-- Layer graph generated here! -->
        <script src="/assets/js/train/train.js"></script> <!-- Common (lang selection, etc) -->

            <!-- Execute once on page load -->
       <script>
               $(document).ready(function () """),format.raw/*294.46*/("""{"""),format.raw/*294.47*/("""
                   """),format.raw/*295.20*/("""renderModelGraph();
                   renderModelPage(true);
               """),format.raw/*297.16*/("""}"""),format.raw/*297.17*/(""");
       </script>

               <!-- Execute periodically (every 2 sec) -->
        <script>
                setInterval(function () """),format.raw/*302.41*/("""{"""),format.raw/*302.42*/("""
                    """),format.raw/*303.21*/("""renderModelPage(false);
                """),format.raw/*304.17*/("""}"""),format.raw/*304.18*/(""", 2000);
        </script>
    </body>
</html>
"""))
      }
    }
  }

  def render(i18n:org.deeplearning4j.ui.api.I18N): play.twirl.api.HtmlFormat.Appendable = apply(i18n)

  def f:((org.deeplearning4j.ui.api.I18N) => play.twirl.api.HtmlFormat.Appendable) = (i18n) => apply(i18n)

  def ref: this.type = this

}


}

/**/
object TrainingModel extends TrainingModel_Scope0.TrainingModel
              /*
                  -- GENERATED --
                  DATE: Tue Oct 16 10:20:33 CEST 2018
                  SOURCE: C:/data/projects/git/deeplearning4j/deeplearning4j/deeplearning4j-ui-parent/deeplearning4j-play/src/main/views/org/deeplearning4j/ui/views/training/TrainingModel.scala.html
                  HASH: aafbe57f2dd8d0a76555552281298457649e2de7
                  MATRIX: 598->1|731->39|759->41|1677->932|1690->936|1741->966|3402->2600|3415->2604|3466->2634|3614->2755|3627->2759|3682->2793|3736->2819|4052->3108|4065->3112|4127->3153|4181->3179|4910->3880|4924->3884|4979->3917|5158->4068|5172->4072|5224->4102|5526->4376|5540->4380|5593->4411|5668->4589|5726->4619|5939->4805|5952->4809|6006->4842|8541->7348|8571->7349|8622->7371|8807->7527|8837->7528|8884->7546|9411->8045|9425->8049|9494->8096|9954->8528|9968->8532|10042->8584|10397->8910|10412->8914|10479->8958|10649->9099|10664->9103|10731->9147|10903->9290|10918->9294|10986->9339|11399->9724|11413->9728|11493->9785|11650->9914|11664->9918|11732->9964|11803->10006|12085->10260|12099->10264|12170->10313|12455->10570|12469->10574|12546->10628|12613->10666|12723->10748|12737->10752|12805->10798|12876->10840|13155->11091|13169->11095|13238->11142|13862->11738|13876->11742|13946->11790|14569->12385|14583->12389|14645->12429|14931->12687|14945->12691|15013->12736|15080->12774|15191->12857|15205->12861|15273->12907|15344->12949|20198->17774|20228->17775|20278->17796|20386->17875|20416->17876|20587->18018|20617->18019|20668->18041|20738->18082|20768->18083
                  LINES: 20->1|25->1|26->2|48->24|48->24|48->24|81->57|81->57|81->57|83->59|83->59|83->59|84->60|89->65|89->65|89->65|90->66|106->82|106->82|106->82|107->83|107->83|107->83|109->85|109->85|109->85|110->86|111->87|113->89|113->89|113->89|147->123|147->123|148->124|152->128|152->128|153->129|166->142|166->142|166->142|175->151|175->151|175->151|177->153|177->153|177->153|178->154|178->154|178->154|179->155|179->155|179->155|185->161|185->161|185->161|187->163|187->163|187->163|188->164|194->170|194->170|194->170|198->174|198->174|198->174|199->175|200->176|200->176|200->176|201->177|207->183|207->183|207->183|218->194|218->194|218->194|229->205|229->205|229->205|233->209|233->209|233->209|234->210|235->211|235->211|235->211|236->212|318->294|318->294|319->295|321->297|321->297|326->302|326->302|327->303|328->304|328->304
                  -- GENERATED --
              */
          