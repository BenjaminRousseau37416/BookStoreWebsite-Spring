<%@ include file="include/importTags.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <spring:message code = "catalogue"/>
    </title>
</head>
<body>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="border border-dark border-2 p-3">
            <h5 class="fw-bolder"> <spring:message code = "categorie"/> :</h5>
            <form name="input" action="${pageContext.request.contextPath}/catalogue">
                <c:forEach var="name" items="${names}">
                <div class="form-check mt-2">
                    <input type="checkbox" name="category" value="${name.category.id}">
                    <label class="form-check-label" for="${name.name}">${name.name}</label>
                </div>
                </c:forEach>
                <div>
                    <input type="submit" value="Submit" class="btn btn-dark mt-3">
                </div>
            </form>
        </div>
    </div>
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach var="book" items="${books}">
                <spring:url var="isbn" value="">
                    <spring:param name="isbn" value="${book.isbn}"/>
                </spring:url>
            <div class="col mb-5">
                <div class="card h-100 shadow p-3 bg-body rounded border-dark border-3">
                    <!-- Sale badge-->
                    <c:choose>
                        <c:when test="${book.priceWithPromotion != 0}">
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
                                <spring:message code = "sale"/>
                            </div>
                        </c:when>
                    </c:choose>
                    <!-- Product image-->
                    <img class="card-img-top" height="350px" src="ImageLivres/${book.imgPath}" alt="..." />
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">${book.label}</h5>
                            <!-- Product price-->
                            <c:choose>
                                <c:when test="${book.priceWithPromotion == 0}">
                                    <span>${book.price}€</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="text-muted text-decoration-line-through">${book.price}</span>
                                    ${book.priceWithPromotion}€
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent d-inline-flex">
                        <form:form id="form" method="POST" action="${pageContext.request.contextPath}/catalogue/send${isbn}" modelAttribute="currentCart">
                            <div class="text-center me-2"><form:button class="btn btn-outline-dark mt-auto">
                                <spring:message code = "add"/>
                            </form:button></div>
                        </form:form>
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${pageContext.request.contextPath}/productDetails${isbn}">
                            <spring:message code = "details"/>
                        </a></div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</section>
</body>
</html>
