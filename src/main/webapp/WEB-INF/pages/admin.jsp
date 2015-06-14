<%--
  Created by IntelliJ IDEA.
  User: raunakshakya
  Date: 5/6/15
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>

<%-- Password protected page, only authenticated user “ROLE_ADMIN” is allowed to access. --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html>
<body>
<h1>Title : ${title}</h1>

<h1>Message : ${message}</h1>

<c:url value="/j_spring_security_logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        Welcome : ${pageContext.request.userPrincipal.name} | <a
            href="javascript:formSubmit()"> Logout</a>
    </h2>
</c:if>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>
</body>
</html>