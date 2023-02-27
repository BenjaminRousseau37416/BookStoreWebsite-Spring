<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="../include/importTags.jsp" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<html>
    <head>
        <title>BookStore</title>

        <spring:url var="localeFr" value="">
            <spring:param name="locale" value="fr"/>
        </spring:url>
        <spring:url var="localeEn" value="">
            <spring:param name="locale" value="en"/>
        </spring:url>
        <nav class="navbar navbar-expand-lg sticky-top navbar-light bg-light">
            <div class="container px-4 px-lg-5 my-md-2">
                <img src="images/Book_nav.png" width="30" height="24" alt="..." />
                <a class="navbar-brand ms-2">BookStore</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/"><spring:message code = "home"/></a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/catalogue"><spring:message code = "catalogue"/></a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/aboutUs"><spring:message code = "aboutUs"/></a></li>
                    </ul>
                    <a class="btn btn-outline-dark d-block" href="${pageContext.request.contextPath}/cart" role="button">
                        <i class="bi-cart-fill me-1"></i>
                        <spring:message code = "cart"/>
                        <span class="badge bg-dark text-white ms-1 rounded-pill d-inline">${currentCart.nbItem}</span>
                    </a>
                    <ul class="navbar-nav ms-lg-2 me-3">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" data-bs-toggle="modal" data-bs-target="#account" href="#!"><spring:message code = "account"/></a></li>
                    </ul>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <spring:message code = "language"/>
                        </button>
                        <ul class="dropdown-menu bg-light">
                            <li><a href="${localeFr}" class="justify-content-xxl-center"><img height="50" width="50" alt="fr" src='<spring:url value="/images/Flag_Button_FR.png"/>'/></a></li>
                            <li class="mt-3"><a href="${localeEn}" class="justify-content-xxl-center"><img height="50" width="50" alt="en" src='<spring:url value="/images/Flag_Button_EN.png"/>'/></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>

        <!-- Modal -->
        <div class="modal fade" id="account" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel"><spring:message code = "account"/></h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body align-self-lg-center position-relative d-flex flex-column">
                        <div class="d-block align-self-center" ><a class="mx-auto"><img height="50" width="50" alt="en" src="images/User.png"/></a></div>
                        <sec:authorize access="!isAuthenticated()">
                            <div class="d-inline mt-2">
                                <a href="${pageContext.request.contextPath}/login" class="btn btn-dark mx-md-3" role="button" aria-disabled="true"><spring:message code = "connection"/></a>
                                <a href="${pageContext.request.contextPath}/inscription" class="btn btn-dark" role="button" aria-disabled="true"><spring:message code = "register"/></a>
                            </div>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <div class="my-xl-2 d-block">
                                <a class="btn btn-dark mx-md-3" role="button" aria-disabled="true" href="<spring:url value="/logout"/>"><spring:message code = "logout"/></a>
                            </div>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </div>

    </head>
    <body>
        <div class="min-vh-100">
            <tiles:insertAttribute name="main-content"/>
        </div>
        <div class="footer">
            <footer class="py-5 bg-dark">
                <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
            </footer>
        </div>
    </body>
</html>
