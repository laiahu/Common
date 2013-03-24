<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* div 两栏 结构,clear:both 表示独自占一块 */
body {font:12px Simsun; margin:0px; background:#FFFFFF; color:#000000;}
#Wrap { clear:both; width:900px; }
#Header {clear:both; height:100px; backgroud:#FFCC99}
#PageBody {clear:both; height:400px; background:#CCFF00;}
#Sidebar {width:200px; float:left;}
#MainBody {width:700px;float:right; height:100%; background:#EEE;}
#Footer {clear:both; height:50px; background:#00FFFF;}
</style>
</head>
<body>

<div id="Wrap">
  <div id="Header">页面头部</div>
  <div id="PageBody">
  	<div id="Sidebar">侧边栏</div>
  	<div id="MainBody">主体内容</div>
  </div>
  <div id="Footer">页面底部</div>
</div>
</body>
</html>