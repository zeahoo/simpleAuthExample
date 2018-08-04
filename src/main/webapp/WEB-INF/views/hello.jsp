<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="zh">
<head>

    <title>Hello Spring MVC</title>

</head>
<body>
<div class="container">

    <h2>Hello ${name}!</h2>

</div>
<!-- /container -->
</body>
</html>