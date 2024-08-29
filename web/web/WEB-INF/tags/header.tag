<%-- 
    Document   : header
    Created on : 26 Aug 2024, 22:35:46
    Author     : andre
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%--<%@attribute name="message"%>--%>

<%-- any content can be specified here e.g.: --%>
<div class="nav-header">
    <a href="/">
        <img src="/static/assets/bookie-logo.svg"/>        
    </a>
    <% 
        Cookie[] cookies = request.getCookies();
        String username = "";

        if(cookies != null){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("username")) {
                username = cookie.getValue();
                }   
            }
        }

        if(username != ""){
    %>
    <div class="header-profile">
        <div class="header-profile-picture"><%= username.charAt(0) %></div>
        <p class="header-profile-username"><%= username %></p>
        <a href="/logout" class="header-logout">Logout</a>
    </div>
    <%
        }
    %>
</div>