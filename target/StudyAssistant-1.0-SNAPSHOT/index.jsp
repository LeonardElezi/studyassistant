<%-- 
    Document   : index
    Created on : Apr 26, 2015, 12:32:05 AM
    Author     : leonardelezi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Assistant</title>
        <meta charset="utf-8" />
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- css -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="assets/css/style.css" rel="stylesheet" media="screen">
        <link href="assets/color/default.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="assets/js/modernizr.custom.js"></script>
    </head>
    <body>
        <div class="menu-area">
            <div id="dl-menu" class="dl-menuwrapper">
                <button class="dl-trigger">Open Menu</button>
                <ul class="dl-menu">
                    <li>
                        <a href="#intro">Home</a>
                    </li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#services">Study Index</a></li>
                    <li><a href="#works">Timeline</a></li>
                    <li><a href="#more">Suggestions</a></li>
                    <li><a href="#techstuff">TechStuff</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </div><!-- /dl-menuwrapper -->
        </div>	

        <!-- intro area -->	  
        <div id="intro">

            <div class="intro-text">
                <div class="container">
                    <div class="row">


                        <div class="col-md-12">

                            <div class="brand">
                                <h1><a href="oldindex.html">Study Assistant</a></h1>
                                <div class="line-spacer"></div>
                                <p><span>Your environmental productivity advisor</span></p>
                                <div class="img-icon"><img src="assets/img/icons/thermometer.png" alt="" height="42" width="42"/><img src="assets/img/icons/loud.png" alt="" height="42" width="42"/>  <img src="assets/img/icons/lightbulb.png" alt="" height="42" width="42"/> <img src="assets/img/icons/pollution.png" alt="" height="42" width="42"/></div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>




        <!-- About -->
        <section id="about" class="home-section bg-white">
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <div class="section-heading">
                            <h2>About Study Assistant</h2>
                            <p>Did you know that your productivity decreases when your room is too cold, too hot, too noisy, too dim, too bright or the air is too polluted? Study assistant monitors all these factors for you and helps you tweak them for an environment where your productivity peaks!</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
                        <div class="box-team wow bounceInDown" data-wow-delay="0.1s">
                            <img src="assets/img/icons/thermometerblack.png" alt="" class="img-responsive" />
                            <h4>Too hot, too cold</h4>
                            <p>Productivity increases with temperature up to 21-22 o C, and decreases with temperature above 23-24 o C. The highest productivity is at temperature
                                of around 22 o C. </p>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3" data-wow-delay="0.3s">
                        <div class="box-team wow bounceInDown">
                            <img src="assets/img/icons/loudblack.png" alt="" class="img-responsive" />
                            <h4>Too noisy</h4>
                            <p>If you can hear someone talking while you’re reading or writing, your productivity dips by up to 66%.</p>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3" data-wow-delay="0.5s">
                        <div class="box-team wow bounceInDown">
                            <img src="assets/img/icons/lightbulbblack.png" alt="" class="img-responsive" />
                            <h4>Too dim, too bright</h4>
                            <p>Let there be light. Light not only causes an improvement of visual conditions, but it also has an effect on unconscious biological
                                functions. Moreover, it is always an emotional and decisive factor in increasing productivity.</p>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3" data-wow-delay="0.7s">
                        <div class="box-team wow bounceInDown">
                            <img src="assets/img/icons/pollutionblack.png" alt="" class="img-responsive" />
                            <h4>Too polluted</h4>
                            <p>It has  been shown beyond reasonable doubt by studies, that poor indoor air quality in buildings can decrease productivity in addition to causing visitors to express dissatisfaction. The size of the effect on most aspects of office work performance appears to be as high as 6-9%.</p>
                        </div>
                    </div>
                </div>			  
            </div>	  
        </section>

        <!-- spacer -->	  
        <section id="spacer1" class="home-section spacer">	
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="color-light">
                            <h2 class="wow bounceInDown" data-wow-delay="1s">Details are the key for perfection</h2>
                            <p class="lead wow bounceInUp" data-wow-delay="2s">We mix all detailed things together</p>	
                        </div>
                    </div>				
                </div>
            </div>
        </section>	  

        <!-- Services -->
        <section id="services" class="home-section bg-white">
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <div class="section-heading">
                            <h2>Your current Environment Study Index!</h2>
                            <p>Index is a number between 0 (Worst environment conditions) and 100% (Best environment conditions). It assigns a score - environmental study suitability index - and provides usable advice in order to improve your productivity!</p>
                            
                            <div id="chart_div" style="width: 400px; height: 120px;"></div>
                            <div style="margin-top: -135px; margin-left: 80px;"><h3>Advice</h3><div id="advice"><div></div>

                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Works -->
        <section id="works" class="home-section bg-gray">
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                            <h2 style="font-size: 38px; text-transform: uppercase;">Timeline</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <div id="tabs" style=" margin-left: -130px; width: 900px; height: 500px;">
                              <ul>
                                <li><a id="index_chart_link" href="#index_chart">Index History</a></li>
                                <li><a id="temperature_chart_link" href="#temperature_chart">Temperature</a></li>
                                <li><a id="humidity_chart_link" href="#humidity_chart">Humidity</a></li>
                                <li><a id="loudness_chart_link" href="#loudness_chart">Loudness</a></li>
                                <li><a id="light_chart_link" href="#light_chart">Light</a></li>
                                <li><a id="extremes_chart_link" href="#light_chart">Extremes</a></li>
                              </ul>
                                <div id="index_chart" style="width: 850px; height: 400px;"></div>
                                <div id="temperature_chart" style="width: 850px; height: 400px;"></div>
                                <div id="humidity_chart" style="width: 850px; height: 400px;"></div>
                                <div id="loudness_chart" style="width: 850px; height: 400px;"></div>
                                <div id="light_chart" style="width: 850px; height: 400px;"></div>
                                <div id="extremes_chart" style="width: 850px; height: 400px; margin-top: -350px; box-sizing: border-box;"></div>
                            </div>
                    </div>
                </div>
            </div>
        </section>
        
        <!-- More -->
        <section id="more" class="home-section bg-gray">
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <div class="section-heading">
                            <h2>Sound Therapy</h2>
                            <p>Binaural beats are signals of two different frequencies which are presented separately, one to each ear. Your brain detects the phase variation between the frequencies and tries to reconcile that difference. Research has proven that introducing a binaural beat will cause the brain to begin resonating in tune with that beat. Alpha waves are especially useful for increased concentration.</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/WPni755-Krg?list=RDWPni755-Krg" frameborder="0" allowfullscreen></iframe>
                    </div>
                </div>
            </div>
        </section>
        
        <!-- Tech Stuff -->
        <section id="techstuff" class="home-section bg-gray">
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <div class="section-heading">
                            <h2>Behind the scenes</h2>
                                <img style="width: 828px; height: 480px;" src="assets/img/architecture.png"/>
                            </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- spacer 2 -->	  
        <section id="spacer2" class="home-section spacer">	
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="color-light">
                            <h2 class="wow bounceInDown" data-wow-delay="1s">Details are the key for perfection</h2>
                            <p class="lead wow bounceInUp" data-wow-delay="2s">We mix all detailed things together</p>	
                        </div>
                    </div>				
                </div>
            </div>
        </section>	

        <!-- Contact -->
        <section id="contact" class="home-section bg-white">
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <div class="section-heading">
                            <h2>Contact us</h2>
                            <p>Contact via form below and we will be get in touch with you within 24 hours. </p>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-offset-1 col-md-10">

                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-8">
                                    <input type="text" class="form-control" id="inputName" placeholder="Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-8">
                                    <input type="email" class="form-control" id="inputEmail" placeholder="Email">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-8">
                                    <input type="text" class="form-control" id="inputSubject" placeholder="Subject">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-8">
                                    <textarea name="message" class="form-control" rows="3" placeholder="Message"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-8">
                                    <button type="button" class="btn btn-theme btn-lg btn-block">Send message</button>
                                </div>
                            </div>
                        </form>

                    </div>


                </div>
                <div class="row mar-top30 ">
                    <div class="col-md-offset-2 col-md-8">
                        <h5>We're on social networks</h5>
                        <ul class="social-network">
                            <li><a href="#">
                                    <span class="fa-stack fa-2x">
                                        <i class="fa fa-circle fa-stack-2x"></i>
                                        <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                    </span></a>
                            </li>
                            <li><a href="#">
                                    <span class="fa-stack fa-2x">
                                        <i class="fa fa-circle fa-stack-2x"></i>
                                        <i class="fa fa-dribbble fa-stack-1x fa-inverse"></i>
                                    </span></a>
                            </li>
                            <li><a href="#">
                                    <span class="fa-stack fa-2x">
                                        <i class="fa fa-circle fa-stack-2x"></i>
                                        <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                    </span></a>
                            </li>
                            <li><a href="#">
                                    <span class="fa-stack fa-2x">
                                        <i class="fa fa-circle fa-stack-2x"></i>
                                        <i class="fa fa-pinterest fa-stack-1x fa-inverse"></i>
                                    </span></a>
                            </li>
                        </ul>
                    </div>				
                </div>

            </div>
        </section>  

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <p>Copyright &copy;2015. All rights reserved.</p>
                    </div>
                </div>		
            </div>	
        </footer>

        <!-- js -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.smooth-scroll.min.js"></script>
        <script src="assets/js/jquery.dlmenu.js"></script>
        <script src="assets/js/wow.min.js"></script>
        <script src="assets/js/custom.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script type="text/javascript" src="//www.google.com/jsapi"></script>
        <script type="text/javascript" src="//www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['gauge']}]}"></script>
        <script type="text/javascript" src="//www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['corechart']}]}"></script>
        <script type="text/javascript" src="//www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['table']}]}"></script>

        <script type="text/javascript">
            
            var oldJsonData;
            
            $(function() {
                $( "#tabs" ).tabs();
                
                
                
                $( "#humidity_chart_link" ).click(function() {
                    var destinationUrl = "http://localhost:8080/StudyAssistant/resources/humidity";
                    var element = "humidity_chart";
                    var color = "green";
                    var format = "#";
                    var title = "Humidity History";
                    $("#extremes_chart").hide();
                    drawCoreChart(destinationUrl, element, color, format, title);
                });
                
                $( "#temperature_chart_link" ).click(function() {
                    var destinationUrl = "http://localhost:8080/StudyAssistant/resources/temperature";
                    var element = "temperature_chart";
                    var color = "red";
                    var format = '# C';
                    var title = 'Temperature History';
                    $("#extremes_chart").hide();
                    drawCoreChart(destinationUrl, element, color, format, title);
                });
                
                $( "#loudness_chart_link" ).click(function() {
                    var destinationUrl = "http://localhost:8080/StudyAssistant/resources/loudness";
                    var element = "loudness_chart";
                    var color = "blue";
                    var format = '#';
                    var title = 'Noise History';
                    $("#extremes_chart").hide();
                    drawCoreChart(destinationUrl, element, color, format, title);
                });
                
                $( "#light_chart_link" ).click(function() {
                    var destinationUrl = "http://localhost:8080/StudyAssistant/resources/light";
                    var element = "light_chart";
                    var color = "orange";
                    var format = '# lux';
                    var title = 'Luminance History';
                    $("#extremes_chart").hide();
                    drawCoreChart(destinationUrl, element, color, format, title);
                });
                
                $( "#index_chart_link" ).click(function() {
                    var destinationUrl = "http://localhost:8080/StudyAssistant/resources/bubbleindex";
                    var element = "index_chart";
                    var color = "black";
                    var format = '# &#37;';
                    var title = 'Environment Index Score History';
                    $("#extremes_chart").hide();
                    drawLineChart(destinationUrl, element, color, title);
                });
                
                $( "#extremes_chart_link" ).click(function() {
                    var destinationUrl = "http://localhost:8080/StudyAssistant/resources/minmax";
                    var element = "extremes_chart";
                    var color = "magenta";
                    $("#extremes_chart").show();
                    drawTableChart(destinationUrl, element, color);
                });
                
            });
            
            google.setOnLoadCallback(drawChart);
            //google.setOnLoadCallback(drawCoreChart("http://localhost:8080/StudyAssistant/resources/temperature", "temperature_chart", "red"));
            google.setOnLoadCallback(drawLineChart("http://localhost:8080/StudyAssistant/resources/bubbleindex", "index_chart", "black", "Environment Index Score History"));
            function drawChart() {

                //var destinationUrl = "https://"+window.location.host+"<%=request.getContextPath()%>" + "/resources/gauge";


                var jsonData = $.ajax({
                    url: "http://localhost:8080/StudyAssistant/resources/gauge",
                    dataType: "json",
                    async: false
                }).responseText;

                // Create our data table out of JSON data loaded from server.
                var data = new google.visualization.DataTable(jsonData);

                var options = {
                    width: 400, height: 200,
                    redFrom: 0, redTo: 60,
                    yellowFrom: 60, yellowTo: 80,
                    greenFrom: 80, greenTo: 100,
                    minorTicks: 5
                };

                var chart = new google.visualization.Gauge(document.getElementById('chart_div'));

                chart.draw(data, options);
                
                var obj = jQuery.parseJSON(jsonData);
                var htmlString = "<ul>";
                $.each(obj.messages, function(i, item) {
                    htmlString += "<li>"+item.text+"</li>"                    
                });
                htmlString += "</ul>";
                $("#advice").html(htmlString);
                

    //        setInterval(function() {
    //          data.setValue(0, 1, 40 + Math.round(60 * Math.random()));
    //          chart.draw(data, options);
    //        }, 13000);
    //        setInterval(function() {
    //          data.setValue(1, 1, 40 + Math.round(60 * Math.random()));
    //          chart.draw(data, options);
    //        }, 5000);
    //        setInterval(function() {
    //          data.setValue(2, 1, 60 + Math.round(20 * Math.random()));
    //          chart.draw(data, options);
    //        }, 26000);
            }

            function drawCoreChart(destUrl, element, color, format, title) {

                var jsonData = $.ajax({
                    url: destUrl,
                    dataType: "json",
                    async: false
                }).responseText;

                var data = new google.visualization.DataTable(jsonData);

    //        var data = google.visualization.arrayToDataTable([
    //          ['Year', 'Sales', 'Expenses'],
    //          ['2013',  1000,      400],
    //          ['2014',  1170,      460],
    //          ['2015',  660,       1120],
    //          ['2016',  1030,      540]
    //        ]);

                var options = {
                    title: title,
                    colors: [color],
                    hAxis: {title: 'Date', titleTextStyle: {color: '#333'}},
                    vAxis: {minValue: 0, format: format}
                };

                var chart = new google.visualization.AreaChart(document.getElementById(element));
                chart.draw(data, options);
            }
            
            function drawBubbleChart(destUrl, element, color) {

                var jsonData = $.ajax({
                    url: destUrl,
                    dataType: "json",
                    async: false
                }).responseText;

                var data = new google.visualization.DataTable(jsonData);

    //        var data = google.visualization.arrayToDataTable([
    //          ['Year', 'Sales', 'Expenses'],
    //          ['2013',  1000,      400],
    //          ['2014',  1170,      460],
    //          ['2015',  660,       1120],
    //          ['2016',  1030,      540]
    //        ]);

                var options = {
                    title: 'Environment History',
                    colors: [color],
                    hAxis: {title: 'Date', titleTextStyle: {color: '#333'}},
                    vAxis: {title: 'Study Index', minValue: 0},
                    bubble: {textStyle: {fontSize: 11}}
                };

                var chart = new google.visualization.BubbleChart(document.getElementById(element));
                chart.draw(data, options);
            }
            
            function drawLineChart(destUrl, element, color, title) {
                
                var jsonData = $.ajax({
                    url: destUrl,
                    dataType: "json",
                    async: false
                }).responseText;

                var data = new google.visualization.DataTable(jsonData);

                var options = {
                  title: title,
                  colors: [color],
                  curveType: 'function',
                  legend: { position: 'bottom' }
                };

                var chart = new google.visualization.LineChart(document.getElementById(element));

                chart.draw(data, options);
            }

            function drawTableChart(destUrl, element, color) {
                
                var jsonData = $.ajax({
                    url: destUrl,
                    dataType: "json",
                    async: false
                }).responseText;
                
                oldJsonData = jsonData;
                
                var options = {
                    title: 'Minimal and maximal values of all sensors',
                    width: '800px',
                    height: '350px',
                    allowHtml: true,
                    showRowNumber: false
                };

                var data = new google.visualization.DataTable(jsonData);

                var chart = new google.visualization.Table(document.getElementById(element));

                chart.draw(data, options);
            }

        </script>

</html>
