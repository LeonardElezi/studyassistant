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
        <title>Mamba - Free Bootstrap 3 one page template</title>
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
                    <li><a href="#works">Charts</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <li>
                        <a href="#">Sub Menu</a>
                        <ul class="dl-submenu">
                            <li><a href="#">Sub menu</a></li>
                            <li><a href="#">Sub menu</a></li>
                        </ul>
                    </li>
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
                                <p><span>Your environment and productivity advisor</span></p>
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
                            <p>Did you know that your productivity decreases when your room is too cold, too hot, too noisy, too dim, too bright or the air is too polluted? Study assistant monitors all these factors for you and helps you tweak them around for an environment where your productivity peaks.</p>
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
                            <p>If you can hear someone talking while you’re reading or writing, your productivity dips by up to 66%. A 20 decibel increase in aircraft noise is enough to delay a student’s reading level by up to 8 months.</p>
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
                            <p>It has now been shown beyond reasonable doubt that poor indoor air quality in buildings can decrease productivity in addition to causing visitors to express dissatisfaction. The size of the effect on most aspects of office work performance appears to be as high as 6-9%.</p>
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
                            <p>Index is a number between 0 (Worst environment conditions) and 100% (Best environment conditions). It is gives a score to your environment and predicts the productivity gains from your environment.</p>
                            
                            <div id="chart_div" style="width: 400px; height: 120px;"></div>

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
                            <h2 style="font-size: 38px; text-transform: uppercase;">Charts</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <div id="tabs" style=" margin-left: -130px; width: 900px; height: 500px;">
                              <ul>
                                <li><a id="temperature_chart_link" href="#temperature_chart">Temperature</a></li>
                                <li><a id="humidity_chart_link" href="#humidity_chart">Humidity</a></li>
                                <li><a id="loudness_chart_link" href="#loudness_chart">Loudness</a></li>
                                <li><a id="light_chart_link" href="#light_chart">Light</a></li>
                                <li><a href="#tabs-3">Bubble Chart</a></li>
                              </ul>
                                <div id="temperature_chart" style="width: 900px; height: 400px;"></div>
                                <div id="humidity_chart" style="width: 900px; height: 400px;"></div>
                                <div id="loudness_chart" style="width: 900px; height: 400px;"><p>Just dummy text</p></div>
                                <div id="light_chart" style="width: 900px; height: 400px;"><p>Just dummy text</p></div>
                                <div id="core_chart_div" style="width: 900px; height: 400px;"></div>
                              <div id="tabs-3">
                                <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>
                                <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
                              </div>
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
                        <p>Copyright &copy;2014 Mamba company. All rights reserved. By <a href="http://bootstraptaste.com">Bootstraptaste</a></p>
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

        <script type="text/javascript">
            
            $(function() {
                $( "#tabs" ).tabs();
                
                $( "#humidity_chart_link" ).click(function() {
                    var destinationUrl = "http://localhost:8080/StudyAssistant/resources/humidity";
                    var element = "humidity_chart";
                    var color = "green";
                    drawCoreChart(destinationUrl, element, color);
                });
                
                $( "#temperature_chart_link" ).click(function() {
                    var destinationUrl = "http://localhost:8080/StudyAssistant/resources/temperature";
                    var element = "temperature_chart";
                    var color = "red";
                    drawCoreChart(destinationUrl, element, color);
                });
                
                $( "#loudness_chart_link" ).click(function() {
                    var destinationUrl = "http://localhost:8080/StudyAssistant/resources/loudness";
                    var element = "loudness_chart";
                    var color = "blue";
                    drawCoreChart(destinationUrl, element, color);
                });
                
                $( "#light_chart_link" ).click(function() {
                    var destinationUrl = "http://localhost:8080/StudyAssistant/resources/light";
                    var element = "light_chart";
                    var color = "orange";
                    drawCoreChart(destinationUrl, element, color);
                });
                
            });

            //google.setOnLoadCallback(drawChart);
            google.setOnLoadCallback(drawCoreChart("http://localhost:8080/StudyAssistant/resources/temperature", "temperature_chart", "red"));
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

            function drawCoreChart(destUrl, element, color) {

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
                    vAxis: {minValue: 0}
                };

                var chart = new google.visualization.AreaChart(document.getElementById(element));
                chart.draw(data, options);
            }

        </script>

</html>
