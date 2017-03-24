<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15.07.2014
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Клуб велосипедных прогулок по Киеву</title>
    <link rel="stylesheet" type="text/css" href="../content/style.css" />
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
</head>
<body>
<center>
    <font color="#9370db"><h1>Клуб велосипедных прогулок по городу Киеву и его окрестностям...</h1></font>
    <div id="plank3">
    <table>
        <tr>
            <td>
                <h2>Заполните, пожалуйста, форму регистрации!</h2>
            </td>
        </tr>
        <tr>
            <td>
                <h4>Ваш контактный номер телефона:</h4><br>
                <h4><input type="text" name="login" value="${param.login}"/></h4>
            </td>
        </tr>
        <tr>
            <td>
                <h4>Ваше имя:</h4><br>
                <input type="text" name="name" value="${param.login}"/>
            </td>
        </tr>
        <tr>
            <td>
                <h4>Ваш пароль:</h4><br>
                <input type="password" name="name" value="${param.password}"/>
            </td>
        </tr>
        <tr>
            <td>
                <h4>Еще раз ваш пароль:</h4><br>
                <input type="password" name="name" value="${param.password}"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Зарегистрироваться"/>
            </td>
        </tr>
    </table>
    </div>
</center>
</body>
</html>