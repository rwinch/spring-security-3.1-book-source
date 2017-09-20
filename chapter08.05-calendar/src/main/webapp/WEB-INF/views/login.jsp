<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Please Login" scope="request"/>
<jsp:include page="./includes/header.jsp"/>

<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post" id="openid_form">
    <c:if test="${param.error != null}">
        <div class="alert alert-error">
            Failed to login.
            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
              Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
            </c:if>
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            You have been logged out.
        </div>
    </c:if>
    <input type="hidden" name="action" value="verify" />
    <div id="openid_choice">
        <p>Please click your account provider:</p>
        <div id="openid_btns"></div>
    </div>
    <div id="openid_input_area">
        <input id="openid_identifier" name="openid_identifier" type="text" value="http://" />
        <input id="openid_submit" type="submit" value="Sign-In"/>
    </div>
</form>
<script type="text/javascript">
    $(document).ready(function() {
        openid.init('openid_identifier');
    });
</script>
<jsp:include page="./includes/footer.jsp"/>