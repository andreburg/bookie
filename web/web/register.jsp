<%-- 
    Document   : registration
    Created on : 27 Aug 2024, 13:50:26
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/static/style/globals.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <main class="main-section">
            <tags:auth-check/>
            <tags:header/>
            <div id="loginForm">
                <form action="action" id="side-One">
                    <div id="user-input-text">
                        <h3>Welcome back</h3>
                        <p>Welcome back! Please enter your details. </p>
                    </div>
                    <div class="user-input">
                        <label for="username">Username</label>
                        <input type="text" name ="username" id="username" placeholder="Username">
                    </div>
                    <div class="user-input">
                        <label for="password">Password</label>
                        <input type="password" name ="password" id="password" placeholder="Password">
                    </div>
                    <div class="user-input">
                        <button>Sign in</button>
                    </div>
                </form>
                <div id="side-Two">
                    <img src="/static/assets/bird.svg" class="bird"/>
                </div>
            </div>
        </main>    
    </body>
</html