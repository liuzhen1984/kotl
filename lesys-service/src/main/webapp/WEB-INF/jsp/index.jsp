<%--
  Created by IntelliJ IDEA.
  User: zliu
  Date: 16/10/27
  Time: 下午8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>乐视互娱管理平台</title>
    <link rel="stylesheet" href="./lib/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="./lib/css/custom.css"/>
    <script src="./lib/js/jquery.1.12.1.min.js"></script>
    <script src="./lib/js/bootstrap.min.js"></script>
</head>
<body height="100%">
<div class="header">
    <div class="logo"></div>
    <div class="title">乐视互娱管理平台</div>
    <div class="user"><span class="welcome">欢迎： ${admin.userName}</span><a class="logout" href="/logout" target="_blank">退出</a></div>
</div>
<div class="main">
    <div class="line">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <a href="http://www.le.com/ptv/vplay/26826938" target="_blank">
                        <img src="./lib/images/carousel1.jpg" alt="LeEco全生态落地北美 美国市场迎来Big Bang">
                        <span class="tips">LeEco全生态落地北美 美国市场迎来Big Bang</span>
                    </a>
                </div>
                <div class="item">
                    <a href="http://www.le.com/ptv/vplay/26826935" target="_blank">
                        <img src="./lib/images/carousel2.jpg" alt="三年磨剑!YT携升级版超级汽车LeSEE Pro酷炫亮相">
                        <span class="tips">三年磨剑!YT携升级版超级汽车LeSEE Pro酷炫亮相</span>
                    </a>
                </div>
                <div class="item">
                    <a href="http://www.le.com/ptv/vplay/26826982" target="_blank">
                        <img src="./lib/images/carousel3.jpg" alt="LeEco全生态体验区开放 全球乐迷共同见证生态魅力">
                        <span class="tips">LeEco全生态体验区开放 全球乐迷共同见证生态魅力</span>
                    </a>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <ul class="links">
            <li>
                <a href="http://open.letv.cn/crm/" target="_blank">应用开放平台</a>
            </li>
            <li>
                <a href="http://10.154.28.32:8080/mstore_cms/" target="_blank">手机应用商店</a>
            </li>
            <li>
                <a href="http://115.182.94.54/?pvt=1" target="_blank">电视应用商店</a>
            </li>
            <li>
                <a href="http://gc.letvstore.com/opman/home/" target="_blank">电视游戏中心</a>
            </li>
            <li>
                <a href="http://10.154.30.47:8081/admin/index" target="_blank">SDK管理系统</a>
            </li>
            <li>
                <a href="http://10.185.29.113:8080/mstore_vstats/" target="_blank">手机应用统计系统</a>
            </li>
            <li>
                <a href="http://lestoreauto.letv.cn/" target="_blank">汽车应用商店</a>
            </li>
            <li>
                <a href="http://106.38.226.20:8087/" target="_blank">5.0电视应用商店</a>
            </li>
            <li>
                <a href="http://10.185.28.208/" target="_blank">电视应用商店国际版</a>
            </li>
            <li><a></a></li>
        </ul>
    </div>
    <div class="line no-padding-top">
        <ul class="list">
            <li>
                <img src="./lib/images/uservalue.jpg"/>
            </li>
            <li>
                <img src="./lib/images/incomerealization.jpg"/>
            </li>
            <li>
                <img src="./lib/images/terminalsales.jpg"/>
            </li>
            <li>
                <img src="./lib/images/LeEco.jpg" height="100%"/>
            </li>
        </ul>
    </div>
</div>
<div class="footer">
    <div>京ICP备09045969</div>
    <div>Copyright &copy; 2004-2015 乐视网(letv.com) All right reserved.</div>
</div>
</body>
</html>
