<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>
<%--<%@page contentType="text/html; charset=UTF-8" %>--%>
<meta charset="utf-8">
<html>
<head>
    <title>Клуб велосипедных прогулок по Киеву</title>
    <%--<meta charset="utf-8">--%>
    <link rel="stylesheet" type="text/css" href="../content/style.css" />
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">

</head>
<body>
<center>
    <table>
        <tr>
            <td colspan="2">
                <font color="#9370db"><h1>Клуб велосипедных прогулок по городу Киеву и его окрестностям...</h1></font>
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td>
                <div id="plank1">
                    <h3><p>Мы рады видеть Вас на нашем сайте "Клуба велосипедных прогулок по Киеву"!</p>
                        <p>Именно здесь Вы можете всегда забронировать любой из наших велосипедов для себя и ваших друзей в режиме
                            "он-лайн" предварительно выбрав любой подходящий вам день, время и модель самого экологически чистого вида транспорта.
                            Наши демократичные цены Вас порадуют!
                            Для возможности выбора и бронирования велосипеда просим зарегистрироваться на нашем сайте. Наша регистрация займет у Вас
                            меньше минуты, к тому же зарегистрировавшись на нашем сайте Вы в дальнейшем сможете участвовать в наших акциях и
                            программе лояльности для постоянных клиентов.
                        </p>
                    </h3>
                </div>
            </td>
            <td>
                <form action="/authorization" method="post">
                    <div id="plank2">
                            <h3> Введите, пожалуйста, Ваши логин и пароль! </h3>
                                    <p>Логин (Ваш номер телефона):</p>
                                    <h4><input type="text" name="login" value="${param.login}"/></h4>
                                    </br>
                                    <p style="color: red">
                                        ${ErrorLogin}
                                    <br>
                                    <p>Пароль:</p>
                                <br>
                                <input type="password" name="password" value="${param.password}"/>
                                <br>
                                <p style="color: red">
                                    ${ErrorPassw}
                                </p>
                                 <p style="color: red">
                                        ${Error}
                                    </p>
                                    <input type="submit" value="Войти"/>
                <a href = "/registration"><h6>Вы до сих пор у нас не зарегистрированы?!</h6></a>
                <a href = "/remember"><h6>Вспомнить пароль!</h6></a>
                    </div>
                </form>
            </td>
        </tr>
    </table>

                <h4 style="text-align: left; text-decoration-color: whitesmoke;">
                    <font color="#f5f5f5" face="monospace">
                        &nbsp; &nbsp; &nbsp; Developed by <br>
                        &nbsp; &nbsp; &nbsp; Ksimeo@gmail.com

                    </font>
                </h4>

</center>
</body>
</html>