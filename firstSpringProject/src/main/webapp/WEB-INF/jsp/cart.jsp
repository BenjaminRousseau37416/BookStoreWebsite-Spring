<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>


<html>
<head>
    <title>
        <spring:message code = "cart"/>
    </title>
</head>
<body>
<div class="container px-3 my-5 clearfix">
    <!-- Shopping cart table -->
    <div class="card h-75">
        <div class="card-header">
            <h2>
                <spring:message code = "shoppingCart"/>
            </h2>
        </div>
        <div class="card-body h-75">
            <div class="table-responsive h-75">
                <table class="table table-bordered m-0">
                    <thead>
                    <tr>
                        <!-- Set columns width -->
                        <th class="text-center py-3 px-4" style="width: 200px;">
                            <spring:message code = "productName"/>
                        </th>
                        <th class="text-right py-3 px-4" style="width: 100px;">
                            <spring:message code = "price"/>
                        </th>
                        <th class="text-center py-3 px-4" style="width: 120px;">
                            <spring:message code = "quantity"/>
                        </th>
                        <th class="text-right py-3 px-4" style="width: 100px;">
                            <spring:message code = "total"/>
                        </th>
                        <th class="text-center align-middle py-3 px-0" style="width: 40px;"><a href="#" class="shop-tooltip float-none text-light" title="" data-original-title="Clear cart"><i class="ino ion-md-trash"></i></a></th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="cartItem" items="${currentCart.getCartItems()}">
                        <spring:url var="isbn" value="">
                            <spring:param name="isbn" value="${cartItem['key']}"/>
                        </spring:url>

                        <tr>
                            <td class="p-4">
                                <div class="media ms-5 d-inline-flex mt-4">
                                    <img src="ImageLivres/${cartItem['value'].imgPath}" class="d-block ui-w-40 ui-bordered mr-4 align-self-center" height="100" width="100" alt="">
                                    <div class="media-body align-self-center ms-2">
                                        ${cartItem['value'].label}
                                    </div>
                                </div>
                            </td>
                            <td class="text-right font-weight-semibold align-middle p-4 ms-5">${cartItem['value'].price}€</td>
                            <td class="align-middle p-4 d-inline-flex border border-0" height="200">
                                <form:form id="form" method="POST" action="${pageContext.request.contextPath}/cart/removeOne${isbn}" modelAttribute="currentCart" class="align-self-center">
                                    <form:button class="btn btn-dark h-25 align-self-center rounded-0">-</form:button>
                                </form:form>
                                <input type="text" class="form-control text-center align-self-center rounded-0 mb-3" value="${cartItem['value'].quantity}" disabled="true">
                            <form:form id="form" method="POST" action="${pageContext.request.contextPath}/cart/add${isbn}" modelAttribute="currentCart" class="align-self-center">
                                <form:button class="btn btn-dark h-25 align-self-center rounded-0">+</form:button>
                            </form:form>
                            </td>
                            <td class="text-right font-weight-semibold align-middle p-4">${cartItem['value'].totalPrice}€</td>
                            <form:form id="form" method="POST" action="${pageContext.request.contextPath}/cart/remove${isbn}" modelAttribute="currentCart">
                                <td class="text-center align-middle px-0"><a href="#" class="shop-tooltip close float-none text-danger" title="" data-original-title="Remove"><form:button class="btn btn-outline-danger">X</form:button></a></td>
                            </form:form>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
            <!-- / Shopping cart table -->
            <div class="border border-light border-1 rounded-bottom">
                <div class="d-flex flex-row-reverse flex-wrap justify-content-between align-items-center pb-4">
                    <div class="d-flex">
                        <div class="text-right mt-4">
                            <label class="text-muted font-weight-normal m-0 me-sm-4">
                                <spring:message code = "totalPrice"/>
                            </label>
                            <div class="text-large"><strong>${currentCart.totalPrice}€</strong></div>
                        </div>
                    </div>
                </div>

                <div class="float-right d-flex ">
                    <a class="btn btn-lg btn-dark md-btn-flat mt-2 mr-3" href="${pageContext.request.contextPath}/catalogue" >
                        <spring:message code = "backShopping"/>
                    </a>
                    <a class="btn btn-lg btn-dark mt-2 ms-auto" type="button" data-bs-toggle="modal" data-bs-target="#checkOut" >
                        <spring:message code = "checkOut"/>
                    </a>
                </div>
            </div>
            <!-- Modal -->
            <div class="modal fade" id="checkOut" tabindex="-1" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <c:choose>
                    <c:when test="${currentCart.nbItem > 0}">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">
                                        <spring:message code = "confirm"/>
                                    </h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <spring:message code = "confirmText"/>
                                </div>
                                <div class="modal-footer">
                                    <a class="btn btn-lg btn-dark mt-2 ms-auto" type="button" href="${pageContext.request.contextPath}/checkOut" >
                                        <spring:message code = "checkOut"/>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-body">
                                    <spring:message code = "emptyCartText"/>
                                </div>
                                <div class="modal-footer">
                                    <a class="btn btn-lg btn-dark mt-2 ms-auto" type="button" data-bs-dismiss="modal">
                                        <spring:message code = "ok"/>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
</body>
</html>
