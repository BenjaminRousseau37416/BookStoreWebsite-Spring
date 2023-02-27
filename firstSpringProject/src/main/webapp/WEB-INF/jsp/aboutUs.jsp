<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <spring:message code = "aboutUs"/>
    </title>
</head>
<body>
    <div class="d-flex flex-column justify-content-center">

        <img src="images/Bookshop.jpg" height="435" width="600" class="d-block w-75 mt-3 align-self-center border border-dark border-2" alt="...">

        <div>
            <div class="h1 d-block mt-3 align-self-center">
                <spring:message code = "aboutUs"/> :
            </div>
            <div>
                <spring:message code = "about"/> :
            </div>
        </div>

    </div>
</body>
</html>
