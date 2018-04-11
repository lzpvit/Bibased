<%--
  Created by IntelliJ IDEA.
  User: LZP
  Date: 2018/4/9
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String lat = request.getParameter("lat");//用request得到
    String lon = request.getParameter("lon");
%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>地图详情页</title>
    <style type="text/css">
        html{height:100%}
        body{height:100%;margin:0px;padding:0px}
        #container{height:100%}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=8uWqxcQ8HeKRjf5XUKDOvZrhGECvqk2g">
    </script>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>

<body>
<div id="container"></div>
<script type="text/javascript">
    var lat = <%=lat%>;
    var lon = <%=lon%>
    var map = new BMap.Map("container");
    // 创建地图实例
    var point = new BMap.Point(lon, lat);
    // 创建点坐标
    map.centerAndZoom(point, 10);
    // 初始化地图，设置中心点坐标和地图级别
    map.addControl(new BMap.NavigationControl());
    map.addControl(new BMap.ScaleControl());
    map.addControl(new BMap.OverviewMapControl());
    map.addControl(new BMap.MapTypeControl());
    var myIcon = new BMap.Icon("images/3.png", new BMap.Size(23, 25), {
        anchor: new BMap.Size(10, 25),
        imageOffset: new BMap.Size(0, 0 - 0 * 25)   // 设置图片偏移
    });
    // 创建标注对象并添加到地图
    var marker = new BMap.Marker(point, {icon: myIcon});
    map.addOverlay(marker);
    var opts = {
        width : 250,     // 信息窗口宽度
        height: 100,     // 信息窗口高度
        title : "Hello"  // 信息窗口标题
    }
    var infoWindow = new BMap.InfoWindow("World", opts);  // 创建信息窗口对象
    map.openInfoWindow(infoWindow, map.getCenter());      // 打开信息窗口
    marker.addEventListener("click",function () {
        marker.openInfoWindow(infoWindow, opts); //开启信息窗口
    });
</script>
</body>
</html>
