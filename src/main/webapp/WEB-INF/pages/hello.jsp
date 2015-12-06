<%-- Default page, show the use of Spring Security JSP taglib sec:authorize to display content to users who have “ROLE_USER” authority. --%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<body>
<h1>Title : ${title}</h1>

<h1>Message : ${message}</h1>

<sec:authorize access="hasRole('ROLE_USER')">
    <!-- For login user -->
    <c:url value="/logout" var="logoutUrl"/>
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            User : ${pageContext.request.userPrincipal.name}
            | <a href="javascript:formSubmit()"> Logout</a>
        </h2>
    </c:if>

    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>
</sec:authorize>
</body>
</html>

<%-- Include resources in jsp - Method 1 --%>
<spring:url value="/resources/js/external/angular-1.4.8.min.js" var="angularjs" />

<script src="${angularjs}"></script>