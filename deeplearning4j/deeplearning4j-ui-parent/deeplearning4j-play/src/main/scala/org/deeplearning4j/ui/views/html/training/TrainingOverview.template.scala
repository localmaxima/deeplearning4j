
package org.deeplearning4j.ui.views.html.training

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object TrainingOverview_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class TrainingOverview extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[org.deeplearning4j.ui.api.I18N,play.twirl.api.HtmlFormat.Appendable] {

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
            <!-- Start Mobile Specific -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
            <!-- End Mobile Specific -->

        <link id="bootstrap-style" href="/assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="/assets/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="/assets/css/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="/assets/css/style-responsive.css" rel="stylesheet">
        """),format.raw/*33.251*/("""
        """),format.raw/*34.9*/("""<link href='/assets/css/opensans-fonts.css' rel='stylesheet' type='text/css'>
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
                    <a class="brand" href="#"><span>"""),_display_(/*59.54*/i18n/*59.58*/.getMessage("train.pagetitle")),format.raw/*59.88*/("""</span></a>
                    <div id="sessionSelectDiv" style="display:none; float:right">
                        """),_display_(/*61.26*/i18n/*61.30*/.getMessage("train.session.label")),format.raw/*61.64*/("""
                        """),format.raw/*62.25*/("""<select id="sessionSelect" onchange='selectNewSession()'>
                            <option>(Session ID)</option>
                        </select>
                    </div>
                    <div id="workerSelectDiv" style="display:none; float:right;">
                        """),_display_(/*67.26*/i18n/*67.30*/.getMessage("train.session.worker.label")),format.raw/*67.71*/("""
                        """),format.raw/*68.25*/("""<select id="workerSelect" onchange='selectNewWorker()'>
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
                            <li class="active"><a href="javascript:void(0);"><i class="icon-bar-chart"></i><span class="hidden-tablet">"""),_display_(/*84.137*/i18n/*84.141*/.getMessage("train.nav.overview")),format.raw/*84.174*/("""</span></a></li>
                            <li><a href="model"><i class="icon-tasks"></i><span class="hidden-tablet">"""),_display_(/*85.104*/i18n/*85.108*/.getMessage("train.nav.model")),format.raw/*85.138*/("""</span></a></li>
                            <li><a href="../evaluation/overview"><i class="icon-tasks"></i><span class="hidden-tablet">Evaluation</span></a></li>
                            <li><a href="system"><i class="icon-dashboard"></i><span class="hidden-tablet">"""),_display_(/*87.109*/i18n/*87.113*/.getMessage("train.nav.system")),format.raw/*87.144*/("""</span></a></li>
                            """),format.raw/*88.160*/("""
                            """),format.raw/*89.29*/("""<li>
                                <a class="dropmenu" href="javascript:void(0);"><i class="icon-folder-close-alt"></i><span class="hidden-tablet">"""),_display_(/*90.146*/i18n/*90.150*/.getMessage("train.nav.language")),format.raw/*90.183*/("""</span></a>
                                <ul>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('en', 'overview')"><i class="icon-file-alt"></i><span class="hidden-tablet">
                                        English</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('de', 'overview')"><i class="icon-file-alt"></i> <span class="hidden-tablet">
                                        Deutsch</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('ja', 'overview')"><i class="icon-file-alt"></i><span class="hidden-tablet">
                                        日本語</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('zh', 'overview')"><i class="icon-file-alt"></i><span class="hidden-tablet">
                                        中文</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('ko', 'overview')"><i class="icon-file-alt"></i><span class="hidden-tablet">
                                        한글</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('ru', 'overview')"><i class="icon-file-alt"></i><span class="hidden-tablet">
                                        русский</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('uk', 'overview')"><i class="icon-file-alt"></i><span class="hidden-tablet">
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
                            JavaScript</a> enabled to use this site.</p>
                    </div>
                </noscript>

                    <!-- Start Score Chart-->
                <div id="content" class="span10">

                    <div class="row-fluid">

                        <div class="box span8">
                            <div class="box-header">
                                <h2><b>"""),_display_(/*128.41*/i18n/*128.45*/.getMessage("train.overview.chart.scoreTitle")),format.raw/*128.91*/("""</b></h2>
                            </div>
                            <div class="box-content">
                                <div id="scoreiterchart" class="center" style="height: 300px;" ></div>
                                <p id="hoverdata"><b>"""),_display_(/*132.55*/i18n/*132.59*/.getMessage("train.overview.chart.scoreTitleShort")),format.raw/*132.110*/("""
                                    """),format.raw/*133.37*/(""":</b> <span id="y">0</span>, <b>"""),_display_(/*133.70*/i18n/*133.74*/.getMessage("train.overview.charts.iteration")),format.raw/*133.120*/("""
                                    """),format.raw/*134.37*/(""":</b> <span id="x">
                                    0</span></p>
                            </div>
                        </div>
                            <!-- End Score Chart-->
                            <!-- Start Model Table-->
                        <div class="box span4">
                            <div class="box-header">
                                <h2><b>"""),_display_(/*142.41*/i18n/*142.45*/.getMessage("train.overview.perftable.title")),format.raw/*142.90*/("""</b></h2>
                            </div>
                            <div class="box-content">
                                <table class="table table-bordered table-striped table-condensed">
                                    <tr>
                                        <td>"""),_display_(/*147.46*/i18n/*147.50*/.getMessage("train.overview.modeltable.modeltype")),format.raw/*147.100*/("""</td>
                                        <td id="modelType">Loading...</td>
                                    </tr>
                                    <tr>
                                        <td>"""),_display_(/*151.46*/i18n/*151.50*/.getMessage("train.overview.modeltable.nLayers")),format.raw/*151.98*/("""</td>
                                        <td id="nLayers">Loading...</td>
                                    </tr>
                                    <tr>
                                        <td>"""),_display_(/*155.46*/i18n/*155.50*/.getMessage("train.overview.modeltable.nParams")),format.raw/*155.98*/("""</td>
                                        <td id="nParams">Loading...</td>
                                    </tr>
                                    <tr>
                                        <td>"""),_display_(/*159.46*/i18n/*159.50*/.getMessage("train.overview.perftable.startTime")),format.raw/*159.99*/("""</td>
                                        <td id="startTime">Loading...</td>
                                    </tr>
                                    <tr>
                                        <td>"""),_display_(/*163.46*/i18n/*163.50*/.getMessage("train.overview.perftable.totalRuntime")),format.raw/*163.102*/("""</td>
                                        <td id="totalRuntime">Loading...</td>
                                    </tr>
                                    <tr>
                                        <td>"""),_display_(/*167.46*/i18n/*167.50*/.getMessage("train.overview.perftable.lastUpdate")),format.raw/*167.100*/("""</td>
                                        <td id="lastUpdate">Loading...</td>
                                    </tr>
                                    <tr>
                                        <td>"""),_display_(/*171.46*/i18n/*171.50*/.getMessage("train.overview.perftable.totalParamUpdates")),format.raw/*171.107*/("""</td>
                                        <td id="totalParamUpdates">Loading...</td>
                                    </tr>
                                    <tr>
                                        <td>"""),_display_(/*175.46*/i18n/*175.50*/.getMessage("train.overview.perftable.updatesPerSec")),format.raw/*175.103*/("""</td>
                                        <td id="updatesPerSec">Loading...</td>
                                    </tr>
                                    <tr>
                                        <td>"""),_display_(/*179.46*/i18n/*179.50*/.getMessage("train.overview.perftable.examplesPerSec")),format.raw/*179.104*/("""</td>
                                        <td id="examplesPerSec">Loading...</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                            <!--End Model Table -->
                    </div>


                    <div class="row-fluid">
                            <!--Start Ratio Table -->
                        <div class="box span6">
                            <div class="box-header">
                                <h2><b>"""),_display_(/*193.41*/i18n/*193.45*/.getMessage("train.overview.chart.updateRatioTitle")),format.raw/*193.97*/(""": log<sub>10</sub></b></h2>
                            </div>
                            <div class="box-content">
                                <div id="updateRatioChart" class="center" style="height: 300px;" ></div>
                                <p id="hoverdata"><b>"""),_display_(/*197.55*/i18n/*197.59*/.getMessage("train.overview.chart.updateRatioTitleShort")),format.raw/*197.116*/("""
                                    """),format.raw/*198.37*/(""":</b> <span id="yRatio">0</span>, <b>log<sub>
                                    10</sub> """),_display_(/*199.47*/i18n/*199.51*/.getMessage("train.overview.chart.updateRatioTitleShort")),format.raw/*199.108*/("""
                                    """),format.raw/*200.37*/(""":</b> <span id="yLogRatio">0</span>
                                    , <b>"""),_display_(/*201.43*/i18n/*201.47*/.getMessage("train.overview.charts.iteration")),format.raw/*201.93*/(""":</b> <span id="xRatio">
                                        0</span></p>
                            </div>
                        </div>
                            <!--End Ratio Table -->
                            <!--Start Variance Table -->
                        <div class="box span6">
                            <div class="box-header">
                                <h2><b>"""),_display_(/*209.41*/i18n/*209.45*/.getMessage("train.overview.chart.stdevTitle")),format.raw/*209.91*/(""": log<sub>10</sub></b></h2>
                                <ul class="nav tab-menu nav-tabs" style="position:absolute; margin-top: -11px; right: 22px;">
                                    <li class="active" id="stdevActivations"><a href="javascript:void(0);" onclick="selectStdevChart('stdevActivations')">"""),_display_(/*211.156*/i18n/*211.160*/.getMessage("train.overview.chart.stdevBtn.activations")),format.raw/*211.216*/("""</a></li>
                                    <li id="stdevGradients"><a href="javascript:void(0);" onclick="selectStdevChart('stdevGradients')">"""),_display_(/*212.137*/i18n/*212.141*/.getMessage("train.overview.chart.stdevBtn.gradients")),format.raw/*212.195*/("""</a></li>
                                    <li id="stdevUpdates"><a href="javascript:void(0);" onclick="selectStdevChart('stdevUpdates')">"""),_display_(/*213.133*/i18n/*213.137*/.getMessage("train.overview.chart.stdevBtn.updates")),format.raw/*213.189*/("""</a></li>
                                </ul>
                            </div>
                            <div class="box-content">
                                <div id="stdevChart" class="center" style="height: 300px;" ></div>
                                <p id="hoverdata"><b>"""),_display_(/*218.55*/i18n/*218.59*/.getMessage("train.overview.chart.stdevTitleShort")),format.raw/*218.110*/("""
                                    """),format.raw/*219.37*/(""":</b> <span id="yStdev">0</span>, <b>log<sub>
                                    10</sub> """),_display_(/*220.47*/i18n/*220.51*/.getMessage("train.overview.chart.stdevTitleShort")),format.raw/*220.102*/("""
                                    """),format.raw/*221.37*/(""":</b> <span id="yLogStdev">0</span>
                                    , <b>"""),_display_(/*222.43*/i18n/*222.47*/.getMessage("train.overview.charts.iteration")),format.raw/*222.93*/(""":</b> <span id="xStdev">
                                        0</span></p>
                            </div>
                        </div>
                            <!-- End Variance Table -->
                    </div>
                </div>
            </div><!-- End Content Span10-->
        </div><!--End Row Fluid-->

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
        <script src="/assets/js/jquery.flot.selection.js"></script>
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
        <script src="/assets/js/train/overview.js"></script>    <!-- Charts and tables are generated here! -->
        <script src="/assets/js/train/train.js"></script>   <!-- Common (lang selection, etc) -->

        <!-- Execute once on page load -->
        <script>
                $(document).ready(function () """),format.raw/*268.47*/("""{"""),format.raw/*268.48*/("""
                    """),format.raw/*269.21*/("""renderOverviewPage(true);
                """),format.raw/*270.17*/("""}"""),format.raw/*270.18*/(""");
        </script>

            <!-- Execute periodically (every 2 sec) -->
        <script>
                setInterval(function () """),format.raw/*275.41*/("""{"""),format.raw/*275.42*/("""
                    """),format.raw/*276.21*/("""renderOverviewPage(false);
                """),format.raw/*277.17*/("""}"""),format.raw/*277.18*/(""", 2000);
        </script>
            <!-- End JavaScript-->

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
object TrainingOverview extends TrainingOverview_Scope0.TrainingOverview
              /*
                  -- GENERATED --
                  DATE: Tue Oct 16 10:20:33 CEST 2018
                  SOURCE: C:/data/projects/git/deeplearning4j/deeplearning4j/deeplearning4j-ui-parent/deeplearning4j-play/src/main/views/org/deeplearning4j/ui/views/training/TrainingOverview.scala.html
                  HASH: dd2146dcfdb8cb309a79366117bf80769f961c80
                  MATRIX: 604->1|737->39|765->41|1683->932|1696->936|1747->966|2310->1742|2347->1752|3465->2843|3478->2847|3529->2877|3677->2998|3690->3002|3745->3036|3799->3062|4115->3351|4128->3355|4190->3396|4244->3422|4998->4148|5012->4152|5067->4185|5216->4306|5230->4310|5282->4340|5583->4613|5597->4617|5650->4648|5725->4825|5783->4855|5962->5006|5976->5010|6031->5043|8763->7747|8777->7751|8845->7797|9133->8057|9147->8061|9221->8112|9288->8150|9349->8183|9363->8187|9432->8233|9499->8271|9917->8661|9931->8665|9998->8710|10315->8999|10329->9003|10402->9053|10643->9266|10657->9270|10727->9318|10966->9529|10980->9533|11050->9581|11289->9792|11303->9796|11374->9845|11615->10058|11629->10062|11704->10114|11948->10330|11962->10334|12035->10384|12277->10598|12291->10602|12371->10659|12620->10880|12634->10884|12710->10937|12955->11154|12969->11158|13046->11212|13643->11781|13657->11785|13731->11837|14039->12117|14053->12121|14133->12178|14200->12216|14321->12309|14335->12313|14415->12370|14482->12408|14589->12487|14603->12491|14671->12537|15101->12939|15115->12943|15183->12989|15523->13300|15538->13304|15617->13360|15793->13507|15808->13511|15885->13565|16057->13708|16072->13712|16147->13764|16470->14059|16484->14063|16558->14114|16625->14152|16746->14245|16760->14249|16834->14300|16901->14338|17008->14417|17022->14421|17090->14467|19760->17108|19790->17109|19841->17131|19913->17174|19943->17175|20112->17315|20142->17316|20193->17338|20266->17382|20296->17383
                  LINES: 20->1|25->1|26->2|48->24|48->24|48->24|57->33|58->34|83->59|83->59|83->59|85->61|85->61|85->61|86->62|91->67|91->67|91->67|92->68|108->84|108->84|108->84|109->85|109->85|109->85|111->87|111->87|111->87|112->88|113->89|114->90|114->90|114->90|152->128|152->128|152->128|156->132|156->132|156->132|157->133|157->133|157->133|157->133|158->134|166->142|166->142|166->142|171->147|171->147|171->147|175->151|175->151|175->151|179->155|179->155|179->155|183->159|183->159|183->159|187->163|187->163|187->163|191->167|191->167|191->167|195->171|195->171|195->171|199->175|199->175|199->175|203->179|203->179|203->179|217->193|217->193|217->193|221->197|221->197|221->197|222->198|223->199|223->199|223->199|224->200|225->201|225->201|225->201|233->209|233->209|233->209|235->211|235->211|235->211|236->212|236->212|236->212|237->213|237->213|237->213|242->218|242->218|242->218|243->219|244->220|244->220|244->220|245->221|246->222|246->222|246->222|292->268|292->268|293->269|294->270|294->270|299->275|299->275|300->276|301->277|301->277
                  -- GENERATED --
              */
          