<%@ include file="include/importTags.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <spring:message code = "login"/>
    </title>
</head>
<form:form id="form" method="POST" modelAttribute="user" class="form-control position-absolute top-50 start-50 translate-middle w-50">
    <div class="mb-3 ">
        <form:label for="inlineFormInput" class="form-label" path="username">
            <spring:message code = "login"/>
        </form:label>
        <form:input type="text" class="form-control" id="inlineFormInput" path="username"/>
    </div>
    <div class="mb-3">
        <form:label for="exampleInputPassword1" class="form-label" path="password">
            <spring:message code = "password"/>
        </form:label>
        <form:input type="password" class="form-control" id="exampleInputPassword1" path="password"/>
        <div id="exampleInputPassword1" class="form-text">
            <spring:message code = "passwordNeverShare"/>
        </div>
    </div>
    <form:button type="submit" class="btn btn-dark">
        <spring:message code = "connect"/>
    </form:button>
</form:form>
</html>
