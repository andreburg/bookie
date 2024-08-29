<%@tag import="app.util.Auth"%>
<%@tag import="app.util.Session"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>


<div class="nav-header">
    <a href="/">
        <img src="/static/assets/bookie-logo.svg"/>        
    </a>
    <% 
    Session s = Auth.getSession(request);
    if(s != null && s.validateSession()){
    %>
    <div class="header-profile">
        <div class="header-profile-picture"><%= s.getUsername().charAt(0) %></div>
        <p class="header-profile-username"><%= s.getUsername() %></p> <%--Display username of user the is currently logged in--%>
        <a href="/logout" class="header-logout">Logout</a>
    </div>
    <%}%>
</div>