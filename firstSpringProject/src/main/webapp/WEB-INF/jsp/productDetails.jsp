<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>
        <spring:message code = "details"/>
    </title>
</head>
<body>
<!-- Product section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0 border border-dark border-3 shadow p-3" height="700" src="ImageLivres/${book.imgPath}" /></div>
            <div class="col-md-6">
                <div class="small mb-1"><spring:message code = "isbn"/>: ${book.isbn}</div>
                <h1 class="display-5 fw-bolder">${book.label}</h1>
                <div class="fs-5 mb-5">
                    <span>Price : ${book.price}€</span>
                </div>
                <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium at dolorem quidem modi. Nam sequi consequatur obcaecati excepturi alias magni, accusamus eius blanditiis delectus ipsam minima ea iste laborum vero?</p>
                <div class="d-flex">
                    <spring:url var="isbn" value="">
                        <spring:param name="isbn" value="${book.isbn}"/>
                    </spring:url>
                    <form:form id="form" method="POST" action="${pageContext.request.contextPath}/productDetails/send${isbn}" modelAttribute="currentCart">
                        <div class="text-center me-2"><form:button class="btn btn-outline-dark flex-shrink-0">
                            <spring:message code = "add"/>
                        </form:button></div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
