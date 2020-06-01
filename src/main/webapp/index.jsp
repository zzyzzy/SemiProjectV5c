<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Hello World!</h2>
</body>
</html>

<c:if test="${empty param.cp}">
   <c:set var="cp" value="222" />
</c:if>

${cp}

