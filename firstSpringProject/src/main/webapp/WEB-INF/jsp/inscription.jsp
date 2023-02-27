<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
  <meta charset="utf-8" />
  <title>
    <spring:message code = "create"/>
  </title>
</head>
<body>
<form:form id="form" method="POST" modelAttribute="user" action="/BookStore/inscription/send" class="row g-3 form-control d-flex position-absolute top-50 start-50 translate-middle w-50">
  <div class="col-md-6">
    <form:label for="inlineFormInput" class="form-label" path="firstName">
      <spring:message code = "firstName"/>
      *</form:label>
    <form:input type="text" class="form-control" id="inlineFormInput" path="firstName"/>
    <form:errors class="text-danger" path="firstName"/>
  </div>
  <div class="col-md-6">
    <form:label for="inlineFormInput2" class="form-label" path="lastName">
      <spring:message code = "lastName"/>
      *</form:label>
    <div class = "d-inline">
      <form:input type="text" class="form-control" id="inlineFormInput2" path="lastName"/>
      <form:errors class="text-danger" path="lastName"/>
    </div>
  </div>
  <div class="col-md-6">
    <form:label for="inlineFormInput3" class="form-label" path="username">
      <spring:message code = "userName"/>
      *</form:label>
    <form:input type="text" class="form-control" id="inlineFormInput3" path="username"/>
    <form:errors class="text-danger" path="username"/>
  </div>
  <div class="col-md-6">
    <form:label for="exampleInputPassword1" class="form-label" path="password">
      <spring:message code = "password"/>
      *</form:label>
    <form:input type="password" class="form-control" id="exampleInputPassword1" path="password"/>
    <div id="exampleInputPassword1" class="form-text">
      <spring:message code = "passwordNeverShare"/>
    </div>
    <form:errors class="text-danger" path="password"/>
  </div>
  <div class="col-md-6">
    <form:label for="inlineFormInput5" class="form-label" path="emailAddress">
      <spring:message code = "email"/>
      *</form:label>
    <form:input type="text" class="form-control" id="inlineFormInput5" path="emailAddress"/>
    <form:errors class="text-danger" path="emailAddress"/>
  </div>
  <div class="col-12">
    <form:label for="inputAddress" class="form-label" path="address">
      <spring:message code = "address"/>
      *</form:label>
    <form:input type="text" class="form-control" id="inputAddress" path="address" />
    <form:errors class="text-danger" path="address"/>
  </div>
  <div class="col-md-6">
    <form:label for="inlineFormInput4" class="form-label" path="phoneNumber">
      <spring:message code = "phone"/>
    </form:label>
    <form:input type="text" class="form-control" id="inlineFormInput4" path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
  </div>
    <form:button type="submit" class="btn btn-dark justify-content-end ">
      <spring:message code = "create"/>
    </form:button>
    (*)       <spring:message code = "notOptional"/>
</form:form>
</body>
</html>
