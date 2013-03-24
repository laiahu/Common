<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* div 三栏 结构,clear:both 表示独自占一块 */
body {font:12px Simsun; margin:0px; background:#FFFFFF; color:#000000;}
#Wrap { clear:both; width:900px; }
#Header {clear:both; height:100px; backgroud:#FFCC99}
#PageBody {clear:both; height:400px; background:#CCFF00;}
#Leftbar {width:200px; float:left;}
#Rightbar {width:200px; float:right;}
#MainBody {width:500px;float:left; height:100%; background:#EEE;}
#Footer {clear:both; height:50px; background:#00FFFF;}
</style>
</head>
<body>

<div id="Wrap">
  <div id="Header">页面头部</div>
  <div id="PageBody">
  	<div id="Leftbar">左侧栏</div>
  	<div id="MainBody">主体内容</div>
  	<div id="Rightbar">右侧栏</div>
  </div>
  <div id="Footer">页面底部</div>
</div>
</body>
</html>