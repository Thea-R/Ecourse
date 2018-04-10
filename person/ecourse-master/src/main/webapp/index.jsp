
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
</head>
<body>
<h2>Hello World!</h2>
<input type="hidden" id="serverUrl" value="${pageContext.request.contextPath}"/>
<form action="${pageContext.request.contextPath}/user/login" >
    <table>
        <tr>
            <td>
                <div style="font-size: 1.3em">用户名</div>
            </td>
            <td><input name="ecUserId" id="ecUserId" type="text"></td>
        </tr>
        <tr>
            <td>
                <div style="font-size: 1.3em">密码</div>
            </td>
            <td><input name="password" id="password" type="password"></td>
        </tr>
    </table>
    <div style="margin-top: 50px;">
        <input value="登 录" type="submit" style="margin-right:20px; margin-top:20px; font-size: 1em">
    </div>
</form>
</body>
</html>
