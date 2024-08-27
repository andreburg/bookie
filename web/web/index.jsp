<%-- 
    Document   : index
    Created on : 26 Aug 2024, 21:18:36
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/static/style/globals.css" />
    </head>
    <body>
        <main class="main-section">
            <tags:header />
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
            <tags:welcome />
            <%}else{%>
            <tags:prompt-login />
            <%}%>
        </main>
    </body>
</html>