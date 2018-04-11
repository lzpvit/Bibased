<%--
  Created by IntelliJ IDEA.
  User: LZP
  Date: 2018/3/29
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>手机地磁地震预测网</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FreeHTML5.co"/>
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive"/>

    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content=""/>
    <meta name="twitter:image" content=""/>
    <meta name="twitter:url" content=""/>
    <meta name="twitter:card" content=""/>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">

    <link href="https://fonts.googleapis.com/css?family=Roboto+Mono:300,400" rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" type="text/css" href="css/icomoon.css">
    <!-- Simple Line Icons -->
    <link rel="stylesheet" type="text/css" href="css/simple-line-icons.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <!-- Style -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/lzp.css">

    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<header role="banner" id="fh5co-header">
    <div class="container">
        <div class="row">
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="navbar-header">
                    <!-- Mobile Toggle Menu Button -->
                    <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse"
                       data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
                    <a class="navbar-brand" href="index.html">首页</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="#" data-nav-section="home"><span>主页</span></a></li>
                        <li><a href="#" data-nav-section="services"><span>预警</span></a></li>
                        <li><a href="#" data-nav-section="explore"><span>公告</span></a></li>
                        <li><a href="#" data-nav-section="testimony"><span>免责声明</span></a></li>
                        <%--<li><a href="#" data-nav-section="pricing"><span>支持一下</span></a></li>--%>
                        <li><a href="#" data-nav-section="blog"><span>给我留言</span></a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</header>

<section id="fh5co-home" data-section="home" style="background-image: url(images/full_image_4.jpg);"
         data-stellar-background-ratio="0.5">
    <div class="gradient"></div>
    <div class="container">
        <div class="text-wrap">
            <div class="text-inner">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 text-center">
                        <h1 class="animate-box"><span class="big">手机</span> <br><span>地磁</span> <br><span
                                class="medium">地震</span><br><span>预警</span> <br> <span class="medium">系统</span></h1>
                        <!--<h2 class="animate-box">Crafted with love by <a href="#" target="_blank" title="Free HTML5 Bootstrap Templates" class="fh5co-link">FREEHTML5.co</a></h2>-->
                        <div class="call-to-action">
                            <a href="app_download/Test_08.apk" class="demo animate-box"><i class="icon-download"></i>
                                安卓版</a>
                            <a href="#" class="download animate-box"><i class="icon-download"></i> ios版</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section id="fh5co-services" data-section="services">
    <div id="lists">
        <div class="spinner mid">
            <div class="rect1"></div>
            <div class="rect2"></div>
            <div class="rect3"></div>
            <div class="rect4"></div>
        </div>
    </div>
    <script>
        document.onreadystatechange = function addData() {
            var lists = null;
            $.ajax({
                type: "GET",
                contentType: 'application/json',
                url: "/history",
                cache: false,
                async: false,
                dataType: "json",
                success: function (json) {
                    lists = json;
                    if (json.size == 0) {
                        document.getElementById("lists").innerHTML = "暂时没有历史地震预警信息"
                    } else {
                        var innerHtml = "<table class='table'> <caption class='mid'>历史地震预警数据</caption>";
                        innerHtml += "<thead>" + "<tr>" + "<th>经度</th><th>纬度</th><th>详情</th>" + "</tr>"
                        "</thead><tbody>";
                        for (i = 0; i < json.length; i++) {
                            var link = "/map?lat=" + json[i]['lat'] + "&lon=" + json[i]['lon'];
                            innerHtml += '<tr>' + '<td>' + json[i]['lat'] + '</td>' + '<td>' + json[i]['lon'] + '</td>' + '<td><a href="' + link + '">' + '详情</a></td>' +
                                '</tr>';
                        }
                        innerHtml += "</tbody></table>";
                        console.log(innerHtml);
                        document.getElementById("lists").innerHTML = innerHtml;
                    }
                },
                error: function () {
                    alert("历史数据获取失败");
                }
            });

        }
    </script>

    </div>
    </div>
</section>

<section id="fh5co-explore" data-section="explore">
    <div class="spinner mid">
        <div class="rect1"></div>
        <div class="rect2"></div>
        <div class="rect3"></div>
        <div class="rect4"></div>
    </div>
    <!--
            <div class="container">
                <div class="row">
                    <div class="col-md-12 section-heading text-center">
                        <h2 class="animate-box">Finished Work</h2>
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2 subtext animate-box">
                                <h3>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="fh5co-project">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="fh5co-portfolio animate-box">
                                <a href="#">
                                    <div class="portfolio-entry" style="background-image: url(images/portfolio-1.jpg);">
                                        <div class="desc">
                                            <p>Solid Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                        </div>
                                    </div>
                                    <div class="portfolio-text text-center">
                                        <h3>Solid</h3>
                                        <ul class="stuff">
                                            <li><i class="icon-heart2"></i>200</li>
                                            <li><i class="icon-eye2"></i>248</li>
                                            <li><i class="icon-download"></i>240</li>
                                        </ul>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="fh5co-portfolio animate-box">
                                <a href="#">
                                    <div class="portfolio-entry" style="background-image: url(images/portfolio-2.jpg);">
                                        <div class="desc">
                                            <p>Solid Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                        </div>
                                    </div>
                                    <div class="portfolio-text text-center">
                                        <h3>Air</h3>
                                        <ul class="stuff">
                                            <li><i class="icon-heart2"></i>200</li>
                                            <li><i class="icon-eye2"></i>248</li>
                                            <li><i class="icon-download"></i>240</li>
                                        </ul>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="fh5co-portfolio animate-box">
                                <a href="#">
                                    <div class="portfolio-entry" style="background-image: url(images/portfolio-3.jpg);">
                                        <div class="desc">
                                            <p>Solid Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                        </div>
                                    </div>
                                    <div class="portfolio-text text-center">
                                        <h3>Black</h3>
                                        <ul class="stuff">
                                            <li><i class="icon-heart2"></i>200</li>
                                            <li><i class="icon-eye2"></i>248</li>
                                            <li><i class="icon-download"></i>240</li>
                                        </ul>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="fh5co-portfolio animate-box">
                                <a href="#">
                                    <div class="portfolio-entry" style="background-image: url(images/portfolio-4.jpg);">
                                        <div class="desc">
                                            <p>Solid Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                        </div>
                                    </div>
                                    <div class="portfolio-text text-center">
                                        <h3>Soon</h3>
                                        <ul class="stuff">
                                            <li><i class="icon-heart2"></i>200</li>
                                            <li><i class="icon-eye2"></i>248</li>
                                            <li><i class="icon-download"></i>240</li>
                                        </ul>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="fh5co-portfolio animate-box">
                                <a href="#">
                                    <div class="portfolio-entry" style="background-image: url(images/portfolio-5.jpg);">
                                        <div class="desc">
                                            <p>Solid Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                        </div>
                                    </div>
                                    <div class="portfolio-text text-center">
                                        <h3>Homestate</h3>
                                        <ul class="stuff">
                                            <li><i class="icon-heart2"></i>200</li>
                                            <li><i class="icon-eye2"></i>248</li>
                                            <li><i class="icon-download"></i>240</li>
                                        </ul>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="fh5co-portfolio animate-box">
                                <a href="#">
                                    <div class="portfolio-entry" style="background-image: url(images/portfolio-6.jpg);">
                                        <div class="desc">
                                            <p>Solid Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                        </div>
                                    </div>
                                    <div class="portfolio-text text-center">
                                        <h3>Words</h3>
                                        <ul class="stuff">
                                            <li><i class="icon-heart2"></i>200</li>
                                            <li><i class="icon-eye2"></i>248</li>
                                            <li><i class="icon-download"></i>240</li>
                                        </ul>
                                    </div>
                                </a>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="fh5co-portfolio animate-box">
                                <a href="#">
                                    <div class="portfolio-entry" style="background-image: url(images/portfolio-7.jpg);">
                                        <div class="desc">
                                            <p>Solid Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                        </div>
                                    </div>
                                    <div class="portfolio-text text-center">
                                        <h3>Soon</h3>
                                        <ul class="stuff">
                                            <li><i class="icon-heart2"></i>200</li>
                                            <li><i class="icon-eye2"></i>248</li>
                                            <li><i class="icon-download"></i>240</li>
                                        </ul>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="fh5co-portfolio animate-box">
                                <a href="#">
                                    <div class="portfolio-entry" style="background-image: url(images/portfolio-8.jpg);">
                                        <div class="desc">
                                            <p>Solid Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                        </div>
                                    </div>
                                    <div class="portfolio-text text-center">
                                        <h3>Homestate</h3>
                                        <ul class="stuff">
                                            <li><i class="icon-heart2"></i>200</li>
                                            <li><i class="icon-eye2"></i>248</li>
                                            <li><i class="icon-download"></i>240</li>
                                        </ul>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="fh5co-portfolio animate-box">
                                <a href="#">
                                    <div class="portfolio-entry" style="background-image: url(images/portfolio-9.jpg);">
                                        <div class="desc">
                                            <p>Solid Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                        </div>
                                    </div>
                                    <div class="portfolio-text text-center">
                                        <h3>Words</h3>
                                        <ul class="stuff">
                                            <li><i class="icon-heart2"></i>200</li>
                                            <li><i class="icon-eye2"></i>248</li>
                                            <li><i class="icon-download"></i>240</li>
                                        </ul>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
            <div id="fh5co-counter-section" class="fh5co-counters">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 animate-box">
                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                        </div>
                    </div>
                    <div class="row animate-box">
                        <div class="col-md-3 text-center">
                            <span class="fh5co-counter js-counter" data-from="0" data-to="3452" data-speed="5000" data-refresh-interval="50"></span>
                            <span class="fh5co-counter-label">Cups of Coffee</span>
                        </div>
                        <div class="col-md-3 text-center">
                            <span class="fh5co-counter js-counter" data-from="0" data-to="234" data-speed="5000" data-refresh-interval="50"></span>
                            <span class="fh5co-counter-label">Client</span>
                        </div>
                        <div class="col-md-3 text-center">
                            <span class="fh5co-counter js-counter" data-from="0" data-to="6542" data-speed="5000" data-refresh-interval="50"></span>
                            <span class="fh5co-counter-label">Projects</span>
                        </div>
                        <div class="col-md-3 text-center">
                            <span class="fh5co-counter js-counter" data-from="0" data-to="8687" data-speed="5000" data-refresh-interval="50"></span>
                            <span class="fh5co-counter-label">Finished Projects</span>
                        </div>
                    </div>
                </div>
            </div>
            -->
</section>
<section id="fh5co-testimony" data-section="testimony">
    <div class="mid">
        <div>本站根据相关法律法规，为用户提供一定程度的地震风险预警</div>
        <div> 由于自然灾害的不确定性，无法确保预警的绝对性，请用户酌情参考。</div>
        <div>不可根据本站信息传谣制谣，如发生此类事件，由相关人员自行承担事故责任。</div>
        <div>如因本站未能成功预测地震造成重大人员死亡和财产损失，本站拒不负责。请周知！</div>
    </div>
    <!--
    <div class="container">
        <div class="row">
            <div class="col-md-12 section-heading text-center">
                <h2 class="animate-box"><span>Our Happy Clients</span></h2>
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 subtext animate-box">
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="testimony-entry animate-box">
                    <div class="feed-bubble">
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                    <div class="author-img" style="background-image: url(images/user-1.jpg);"></div>
                    <span class="user">Randy White <br> <small>Bloger, Analyst</small></span>
                </div>

                <div class="testimony-entry animate-box">
                    <div class="feed-bubble">
                        <p>Vokalia and Consonantia, there live the blind texts Far far away, behind the word mountains</p>
                    </div>
                    <div class="author-img" style="background-image: url(images/user-2.jpg);"></div>
                    <span class="user">Randy White <br> <small>Bloger, Analyst</small></span>
                </div>

                <div class="testimony-entry animate-box">
                    <div class="feed-bubble">
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                    <div class="author-img" style="background-image: url(images/user-4.jpg);"></div>
                    <span class="user">Randy White <br> <small>Bloger, Analyst</small></span>
                </div>
            </div>

            <div class="col-md-4">
                <div class="testimony-entry animate-box">
                    <div class="feed-bubble">
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                    <div class="author-img" style="background-image: url(images/user-3.jpg);"></div>
                    <span class="user">Randy White <br> <small>Bloger, Analyst</small></span>
                </div>

                <div class="testimony-entry animate-box">
                    <div class="feed-bubble">
                        <p>Far far away, behind the word mountains. Vokalia and Consonantia</p>
                    </div>
                    <div class="author-img" style="background-image: url(images/user-5.jpg);"></div>
                    <span class="user">Randy White <br> <small>Bloger, Analyst</small></span>
                </div>

                <div class="testimony-entry animate-box">
                    <div class="feed-bubble">
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                    <div class="author-img" style="background-image: url(images/user-1.jpg);"></div>
                    <span class="user">Randy White <br> <small>Bloger, Analyst</small></span>
                </div>
            </div>

            <div class="col-md-4">
                <div class="testimony-entry animate-box">
                    <div class="feed-bubble">
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                    <div class="author-img" style="background-image: url(images/user-6.jpg);"></div>
                    <span class="user">Randy White <br> <small>Bloger, Analyst</small></span>
                </div>

                <div class="testimony-entry animate-box">
                    <div class="feed-bubble">
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                    <div class="author-img" style="background-image: url(images/user-3.jpg);"></div>
                    <span class="user">Randy White <br> <small>Bloger, Analyst</small></span>
                </div>

                <div class="testimony-entry animate-box">
                    <div class="feed-bubble">
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                    <div class="author-img" style="background-image: url(images/user-4.jpg);"></div>
                    <span class="user">Randy White <br> <small>Bloger, Analyst</small></span>
                </div>
            </div>
        </div>
    </div>
    -->
</section>

<%--<section id="fh5co-pricing" data-section="pricing">--%>
    <%--<div class="mid">--%>
        <%--<div>联系我们</div>--%>
        <%--<div>联系我们</div>--%>
        <%--<div>联系我们</div>--%>
    <%--</div>--%>
<%--</section>--%>

<section id="fh5co-blog" data-section="blog">
    <div class="fh5co-blog">
        <div class="container">
            <div class="row">
                <div class="col-md-12 section-heading text-center">
                    <h2 class="animate-box"><span>留言板</span></h2>
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 subtext">
                            <h3 class="animate-box">如果您对我们的产品有您独到的建议，欢迎给我们留下您宝贵的意见</h3>
                        </div>
                    </div>
                    <!--	<div class="col-md-4 animate-box">-->
                    <form class="contact-form" id="form_message">
                        <div class="form-group">
                            <label for="name" class="sr-only">Name</label>
                            <input type="name" class="form-control" id="name" name="name" placeholder="Name">
                        </div>
                        <div class="form-group">
                            <label for="email" class="sr-only">Email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <label for="content" class="sr-only">Message</label>
                            <textarea class="form-control" id="content" name="content" rows="7"
                                      placeholder="Message"></textarea>
                        </div>
                        <div class="form-group">
                            <input type="button" id="btn-submit" class="btn btn-send-message btn-md"
                                   onclick="send_message_board()" value="Send Message">
                        </div>
                    </form>
                    <!--</div>-->
                </div>
            </div>
        </div>
    </div>
</section>

<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Stellar Parallax -->
<script src="js/jquery.stellar.min.js"></script>
<!-- Counters -->
<script src="js/jquery.countTo.js"></script>
<!-- Main JS (Do not remove) -->
<script src="js/main.js"></script>
<script src="js/action.js"></script>

</body>
</html>


