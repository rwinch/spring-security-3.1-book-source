<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Welcome to myCalendar!" scope="request"/>
<jsp:include page="./includes/header.jsp"/>
<p>Below you can find some highlights about myCalendar. Each sample will have a slightly different summary depending on what has been done.</p>
<h2>Chapter 3</h2>
<ul>
    <li>This chapter starts off with some additional functionality to get us ready to support custom authentication and logging in after signing up. At this point we have not implemented signup so it will not work</li>
    <li>We add the ability to use the current user when creating events and viewing my events. Login with admin1@example.com / admin1 and see that the proper events are now displayed. Create an event and see that the owner is assigned to the proper user.</li>
    <li>We have added the ability to signup for a new account. The user will be automatically loged in after creating the account. Go ahead and try to create a new account.</li>
    <li>There are no changes from a users perspective. However, we have created a custom UserDetailService which means we no longer need to maintain two different representations of a user.</li>
    <li>Our calendar UserDetailsService now creates a CalendarUserDetails which allows us to display custom user attributes in our application. Login and you will see that we are now displaying the first and last name of the user.</li>
    <li><a id="eventsLink" href="events/">All Events</a> - shows all events for all users, but only allows administrators to access the page.</li>
    <li><a id="myEventsLink" href="events/my">My Events</a> - shows all events that user1@example.com is the owner or attendee. We will discuss in Chapter 3 how to obtain the current user's events.</li>
    <li><a id="createEventLink" href="events/form">Create Event</a> - will allow creating a new Event with user1@example.com as the owner. We will discuss in Chapter 3 how to make the current user the owner.</li>
    <li><a id="logoutLink" href="j_spring_security_logout">Logout</a> - we haven't discussed it yet, but you can logout using j_spring_security_logout. Later in in this chapter we will discuss how to customize logout and provide a logout link.</li>
    <li>
        <a id="h2Link" href="admin/h2/">H2 Database Console</a> - Allows you to interact with the database using a web console. To use it:
        <ul>
            <li>Click the link above.</li>
            <li>Ensure that Generic H2 (Embedded) is selected</li>
            <li>Ensure that org.h2.Driver is the Driver Class</li>
            <li>Enter <strong>jdbc:h2:mem:dataSource</strong> as the JDBC URL</li>
            <li>Ensure that the username is sa</li>
            <li>Ensure the password is left empty</li>
            <li>Click Connect</li>
        </ul>
    </li>
</ul>
<jsp:include page="./includes/footer.jsp"/>