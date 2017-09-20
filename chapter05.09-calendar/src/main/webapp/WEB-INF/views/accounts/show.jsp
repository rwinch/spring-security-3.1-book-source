<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pageTitle" scope="request">
    <c:out value="Account - ${user.username}"/>
</c:set>

<jsp:include page="../includes/header.jsp"/>
<dl>
    <dt>Username</dt>
    <dd><c:out value="${user.username}"/></dd>
    <dt>DN</dt>
    <dd><c:out value="${user.dn}"/></dd>
    <c:if test="${isLdapPerson}">
        <dt>Description</dt>
        <dd><c:out value="${user.description}"/></dd>
        <dt>Telephone</dt>
        <dd id="phone"><c:out value="${user.telephoneNumber}"/></dd>
        <dt>Full Name(s)</dt>
        <c:forEach items="${user.cn}" var="cn">
            <dd><c:out value="${cn}"/></dd>
        </c:forEach>
    </c:if>
    <c:if test="${isLdapInetOrgPerson}">
        <dt>Email</dt>
        <dd><c:out value="${user.mail}"/></dd>
        <dt>Street</dt>
        <dd><c:out value="${user.street}"/></dd>
    </c:if>
</dl>
<jsp:include page="../includes/footer.jsp"/>