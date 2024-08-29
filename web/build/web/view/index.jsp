<%-- 
    Document   : index
    Created on : 26 Aug 2024, 21:18:36
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@page import="app.util.Auth"%>
<%@page import="app.util.Session"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bookie - Book Store</title>
        <link rel="stylesheet" href="/static/style/globals.css" />
    </head>
    <body>
        <main class="main-section">
            <tags:header />
            <% 
                Session s = Auth.getSession(request);
                if(s.validateSession()){
            %>
            <tags:welcome />
            <%}else{%>
            <tags:prompt-login />
            <%}%>
        </main>
    </body>
</html>