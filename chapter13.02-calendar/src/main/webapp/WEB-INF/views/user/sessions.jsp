<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pageTitle" value="My Sessions" scope="request"/>
<jsp:include page="../includes/header.jsp"/>

<p>This shows all the sessions for a user.</p>
<c:url var="createUrl" value="/events/form"/>
<table class="table table-bordered table-striped table-condensed">
    <thead>
        <tr>
            <th>Last Used</th>
            <th>Session ID</th>
            <th>Remove</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${empty sessions}">
            <tr>
                <td colspan="3" class="msg">No sessions available. This may happen before the SessionRegistry is wired properly
                or when user's sessions are restored across container restarts. Read the Chapter text for details.</td>
            </tr>
        </c:if>
        <c:forEach items="${sessions}" var="session">
            <tr>
                <fmt:formatDate value="${session.lastRequest}" type="both" pattern="yyyy-MM-dd HH:mm" var="lastUsed"/>
                <td><c:out value="${lastUsed}"/></td>
                <td><c:out value="${session.sessionId}" /></td>
                <c:url var="deleteUrl" value="./${session.sessionId}"/>
                <td><form action="${deleteUrl}" class="form form-inline" method="post"><input type="hidden" name="_method" value="delete"/><input type="submit" value="Delete" class="btn"/></form></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jsp:include page="../includes/footer.jsp"/>