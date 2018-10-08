
package org.deeplearning4j.ui.views.html.training

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object TrainingSystem_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class TrainingSystem extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[org.deeplearning4j.ui.api.I18N,play.twirl.api.HtmlFormat.Appendable] {

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
                    <a class="brand" href="index.html"><span>"""),_display_(/*58.63*/i18n/*58.67*/.getMessage("train.pagetitle")),format.raw/*58.97*/("""</span></a>
                    <div id="sessionSelectDiv" style="display:none; float:right">
                        """),_display_(/*60.26*/i18n/*60.30*/.getMessage("train.session.label")),format.raw/*60.64*/("""
                        """),format.raw/*61.25*/("""<select id="sessionSelect" onchange='selectNewSession()'>
                            <option>(Session ID)</option>
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
                            <li><a href="overview"><i class="icon-bar-chart"></i><span class="hidden-tablet"> """),_display_(/*77.112*/i18n/*77.116*/.getMessage("train.nav.overview")),format.raw/*77.149*/("""</span></a></li>
                            <li><a href="model"><i class="icon-tasks"></i><span class="hidden-tablet"> """),_display_(/*78.105*/i18n/*78.109*/.getMessage("train.nav.model")),format.raw/*78.139*/("""</span></a></li>
                            <li><a href="../evaluation/overview"><i class="icon-tasks"></i><span class="hidden-tablet">Evaluation</span></a></li>
                            <li class="active"><a href="javascript:void(0);"><i class="icon-dashboard"></i><span class="hidden-tablet"> """),_display_(/*80.138*/i18n/*80.142*/.getMessage("train.nav.system")),format.raw/*80.173*/("""</span></a></li>
                            """),format.raw/*81.161*/("""
                            """),format.raw/*82.29*/("""<li>
                                <a class="dropmenu" href="javascript:void(0);"><i class="icon-folder-close-alt"></i><span class="hidden-tablet">
                                    """),_display_(/*84.38*/i18n/*84.42*/.getMessage("train.nav.language")),format.raw/*84.75*/("""</span></a>
                                <ul>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('en', 'system')"><i class="icon-file-alt"></i> <span class="hidden-tablet"> English</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('de', 'system')"><i class="icon-file-alt"></i> <span class="hidden-tablet"> Deutsch</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('ja', 'system')"><i class="icon-file-alt"></i> <span class="hidden-tablet"> 日本語</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('zh', 'system')"><i class="icon-file-alt"></i> <span class="hidden-tablet"> 中文</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('ko', 'system')"><i class="icon-file-alt"></i> <span class="hidden-tablet"> 한글</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('ru', 'system')"><i class="icon-file-alt"></i> <span class="hidden-tablet"> русский</span></a></li>
                                    <li><a class="submenu" href="javascript:void(0);" onclick="languageSelect('uk', 'system')"><i class="icon-file-alt"></i> <span class="hidden-tablet"> український</span></a></li>
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

                    <!-- Start Content -->
                <div id="content" class="span10">

                    <div class="row-fluid">

                        <div class="box span12">
                            <div class="box-header">
                                <h2><b>"""),_display_(/*115.41*/i18n/*115.45*/.getMessage("train.system.title")),format.raw/*115.78*/("""</b></h2>
                                <div class="btn-group" style="margin-top: -11px; position:absolute; right: 40px;">
                                <button class="btn dropdown-toggle btn-primary" data-toggle="dropdown">"""),_display_(/*117.105*/i18n/*117.109*/.getMessage("train.system.selectMachine")),format.raw/*117.150*/(""" """),format.raw/*117.151*/("""<span class="caret"></span></button>
                                    <ul class="dropdown-menu" id="systemTab"></ul>
                                </div>
                            </div>
                            <div class="box-content">

                                    <!--Start System Information -->
                                <div class="tab-content">
                                    <div class="tab-pane active">

                                            <!-- System Memory Utilization Chart -->
                                        <div class="row-fluid">

                                            <div class="box span12" id="systemMemoryChart">
                                                <div class="box-header">
                                                    <h2><b>"""),_display_(/*132.61*/i18n/*132.65*/.getMessage("train.system.chart.systemMemoryTitle")),format.raw/*132.116*/(""" """),format.raw/*132.117*/("""%</b></h2>
                                                </div>
                                                <div class="box-content">
                                                    <div id="systemMemoryChartPlot" class="center" style="height: 300px;" ></div>
                                                    <p id="hoverdata"><b>"""),_display_(/*136.75*/i18n/*136.79*/.getMessage("train.system.chart.memoryShort")),format.raw/*136.124*/(""":</b> <span id="y">0</span>, <b>
                                                        """),_display_(/*137.58*/i18n/*137.62*/.getMessage("train.overview.charts.iteration")),format.raw/*137.108*/(""":</b> <span id="x">0</span></p>
                                                </div>
                                            </div>

                                            <!-- GPU Memory Utlization Chart -->
                                            <div class="box span6" id="gpuMemoryChart">
                                                <div class="box-header">
                                                    <h2><b>"""),_display_(/*144.61*/i18n/*144.65*/.getMessage("train.system.chart.gpuMemoryTitle")),format.raw/*144.113*/(""" """),format.raw/*144.114*/("""%</b></h2>
                                                </div>
                                                <div class="box-content">
                                                    <div id="gpuMemoryChartPlot" class="center" style="height: 300px;" ></div>
                                                    <p id="hoverdata"><b>"""),_display_(/*148.75*/i18n/*148.79*/.getMessage("train.system.chart.memoryShort")),format.raw/*148.124*/(""":</b> <span id="y2">0</span>, <b>
                                                        """),_display_(/*149.58*/i18n/*149.62*/.getMessage("train.overview.charts.iteration")),format.raw/*149.108*/(""":</b> <span id="x2">0</span></p>
                                                </div>
                                            </div>

                                        </div>

                                            <!-- Tables -->
                                        <div class="row-fluid">

                                                <!-- Hardware Information -->
                                            <div class="box span12">
                                                <div class="box-header">
                                                    <h2><b>"""),_display_(/*161.61*/i18n/*161.65*/.getMessage("train.system.hwTable.title")),format.raw/*161.106*/("""</b></h2>
                                                </div>
                                                <div class="box-content">
                                                    <table class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th>"""),_display_(/*167.70*/i18n/*167.74*/.getMessage("train.system.hwTable.jvmCurrent")),format.raw/*167.120*/("""</th>
                                                                <th>"""),_display_(/*168.70*/i18n/*168.74*/.getMessage("train.system.hwTable.jvmMax")),format.raw/*168.116*/("""</th>
                                                                <th>"""),_display_(/*169.70*/i18n/*169.74*/.getMessage("train.system.hwTable.offHeapCurrent")),format.raw/*169.124*/("""</th>
                                                                <th>"""),_display_(/*170.70*/i18n/*170.74*/.getMessage("train.system.hwTable.offHeapMax")),format.raw/*170.120*/("""</th>
                                                                <th>"""),_display_(/*171.70*/i18n/*171.74*/.getMessage("train.system.hwTable.jvmProcs")),format.raw/*171.118*/("""</th>
                                                                <th>"""),_display_(/*172.70*/i18n/*172.74*/.getMessage("train.system.hwTable.computeDevices")),format.raw/*172.124*/("""</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td id="currentBytesJVM">Loading...</td>
                                                                <td id="maxBytesJVM">Loading...</td>
                                                                <td id="currentBytesOffHeap">Loading...</td>
                                                                <td id="maxBytesOffHeap">Loading...</td>
                                                                <td id="jvmAvailableProcessors">Loading...</td>
                                                                <td id="nComputeDevices">Loading...</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="row-fluid">

                                                <!-- Software Information -->
                                            <div class="box span12">
                                                <div class="box-header">
                                                    <h2><b>"""),_display_(/*196.61*/i18n/*196.65*/.getMessage("train.system.swTable.title")),format.raw/*196.106*/("""</b></h2>
                                                </div>
                                                <div class="box-content">
                                                    <table class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th>"""),_display_(/*202.70*/i18n/*202.74*/.getMessage("train.system.swTable.hostname")),format.raw/*202.118*/("""</th>
                                                                <th>"""),_display_(/*203.70*/i18n/*203.74*/.getMessage("train.system.swTable.os")),format.raw/*203.112*/("""</th>
                                                                <th>"""),_display_(/*204.70*/i18n/*204.74*/.getMessage("train.system.swTable.osArch")),format.raw/*204.116*/("""</th>
                                                                <th>"""),_display_(/*205.70*/i18n/*205.74*/.getMessage("train.system.swTable.jvmName")),format.raw/*205.117*/("""</th>
                                                                <th>"""),_display_(/*206.70*/i18n/*206.74*/.getMessage("train.system.swTable.jvmVersion")),format.raw/*206.120*/("""</th>
                                                                <th>"""),_display_(/*207.70*/i18n/*207.74*/.getMessage("train.system.swTable.nd4jBackend")),format.raw/*207.121*/("""</th>
                                                                <th>"""),_display_(/*208.70*/i18n/*208.74*/.getMessage("train.system.swTable.nd4jDataType")),format.raw/*208.122*/("""</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td id="hostName">Loading...</td>
                                                                <td id="OS">Loading...</td>
                                                                <td id="OSArchitecture">Loading...</td>
                                                                <td id="jvmName">Loading...</td>
                                                                <td id="jvmVersion">Loading...</td>
                                                                <td id="nd4jBackend">Loading...</td>
                                                                <td id="nd4jDataType">Loading...</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>

                                        </div>

                                            """),format.raw/*228.73*/("""
                                        """),format.raw/*229.82*/("""
                                            """),format.raw/*230.73*/("""
                                                """),format.raw/*231.77*/("""
                                                    """),format.raw/*232.88*/("""
                                                """),format.raw/*233.59*/("""
                                                """),format.raw/*234.78*/("""
                                                    """),format.raw/*235.92*/("""
                                                        """),format.raw/*236.68*/("""
                                                            """),format.raw/*237.69*/("""
                                                                """),format.raw/*238.79*/("""
                                                            """),format.raw/*239.70*/("""
                                                        """),format.raw/*240.69*/("""
                                                        """),format.raw/*241.68*/("""
                                                            """),format.raw/*242.69*/("""
                                                                """),format.raw/*243.108*/("""
                                                            """),format.raw/*244.70*/("""
                                                        """),format.raw/*245.69*/("""
                                                    """),format.raw/*246.65*/("""
                                                """),format.raw/*247.59*/("""
                                            """),format.raw/*248.55*/("""
                                        """),format.raw/*249.51*/("""
                                    """),format.raw/*250.37*/("""</div>
                                        <!-- End System Tab -->
                                </div>
                            </div>
                        </div>
                            <!-- End System Tab -->
                    </div><!-- End Row Fluid-->
                </div><!-- End Content -->
            </div><!-- End Container-->
        </div><!-- End Row Fluid-->

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
        <script src="/assets/js/train/system.js"></script> <!-- Charts and tables are generated here! -->
        <script src="/assets/js/train/train.js"></script>   <!-- Common (lang selection, etc) -->

        <!-- Execute once on page load -->
        <script>
                $(document).ready(function () """),format.raw/*296.47*/("""{"""),format.raw/*296.48*/("""
                    """),format.raw/*297.21*/("""renderSystemPage(true);
                    renderTabs();
                    selectMachine();
                    /* Default GPU to hidden */
                    $("#gpuTable").hide();
                    $("#gpuMemoryChart").hide();
                """),format.raw/*303.17*/("""}"""),format.raw/*303.18*/(""");
        </script>

            <!--Execute periodically (every 2 sec) -->
        <script>
                setInterval(function () """),format.raw/*308.41*/("""{"""),format.raw/*308.42*/("""
                    """),format.raw/*309.21*/("""renderSystemPage(false);
                """),format.raw/*310.17*/("""}"""),format.raw/*310.18*/(""", 2000);
        </script>
            <!--End JavaScript-->

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
object TrainingSystem extends TrainingSystem_Scope0.TrainingSystem
              /*
                  -- GENERATED --
                  DATE: Mon Oct 08 17:11:55 CEST 2018
                  SOURCE: C:/data/projects/git/deeplearning4j/deeplearning4j/deeplearning4j-ui-parent/deeplearning4j-play/src/main/views/org/deeplearning4j/ui/views/training/TrainingSystem.scala.html
                  HASH: a55e1459aaac5a0a7c8d47d0b121203881940bad
                  MATRIX: 600->1|733->39|761->41|1679->932|1692->936|1743->966|3404->2600|3417->2604|3468->2634|3616->2755|3629->2759|3684->2793|3738->2819|4470->3523|4484->3527|4539->3560|4689->3682|4703->3686|4755->3716|5085->4018|5099->4022|5152->4053|5227->4231|5285->4261|5501->4450|5514->4454|5568->4487|8003->6894|8017->6898|8072->6931|8332->7162|8347->7166|8411->7207|8442->7208|9303->8041|9317->8045|9391->8096|9422->8097|9798->8445|9812->8449|9880->8494|9999->8585|10013->8589|10082->8635|10558->9083|10572->9087|10643->9135|10674->9136|11047->9481|11061->9485|11129->9530|11249->9622|11263->9626|11332->9672|11965->10277|11979->10281|12043->10322|12502->10753|12516->10757|12585->10803|12689->10879|12703->10883|12768->10925|12872->11001|12886->11005|12959->11055|13063->11131|13077->11135|13146->11181|13250->11257|13264->11261|13331->11305|13435->11381|13449->11385|13522->11435|15169->13054|15183->13058|15247->13099|15706->13530|15720->13534|15787->13578|15891->13654|15905->13658|15966->13696|16070->13772|16084->13776|16149->13818|16253->13894|16267->13898|16333->13941|16437->14017|16451->14021|16520->14067|16624->14143|16638->14147|16708->14194|16812->14270|16826->14274|16897->14322|18297->15721|18368->15804|18443->15878|18522->15956|18605->16045|18684->16105|18763->16184|18846->16277|18933->16346|19024->16416|19119->16496|19210->16567|19297->16637|19384->16706|19475->16776|19571->16885|19662->16956|19749->17026|19832->17092|19911->17152|19986->17208|20057->17260|20124->17298|22786->19931|22816->19932|22867->19954|23153->20211|23183->20212|23351->20351|23381->20352|23432->20374|23503->20416|23533->20417
                  LINES: 20->1|25->1|26->2|48->24|48->24|48->24|82->58|82->58|82->58|84->60|84->60|84->60|85->61|101->77|101->77|101->77|102->78|102->78|102->78|104->80|104->80|104->80|105->81|106->82|108->84|108->84|108->84|139->115|139->115|139->115|141->117|141->117|141->117|141->117|156->132|156->132|156->132|156->132|160->136|160->136|160->136|161->137|161->137|161->137|168->144|168->144|168->144|168->144|172->148|172->148|172->148|173->149|173->149|173->149|185->161|185->161|185->161|191->167|191->167|191->167|192->168|192->168|192->168|193->169|193->169|193->169|194->170|194->170|194->170|195->171|195->171|195->171|196->172|196->172|196->172|220->196|220->196|220->196|226->202|226->202|226->202|227->203|227->203|227->203|228->204|228->204|228->204|229->205|229->205|229->205|230->206|230->206|230->206|231->207|231->207|231->207|232->208|232->208|232->208|252->228|253->229|254->230|255->231|256->232|257->233|258->234|259->235|260->236|261->237|262->238|263->239|264->240|265->241|266->242|267->243|268->244|269->245|270->246|271->247|272->248|273->249|274->250|320->296|320->296|321->297|327->303|327->303|332->308|332->308|333->309|334->310|334->310
                  -- GENERATED --
              */
          