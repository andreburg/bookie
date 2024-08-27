<%-- 
    Document   : login.jsp
    Created on : 27 Aug 2024, 01:11:00
    Author     : werne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/static/style/globals.css" />
        <title>Login</title>
    </head>
    <body>
        <main class="main-section">
            <tags:header />
            <div id="loginForm">
                <form action="action" id="side-One">
                    <div id="user-input-text">
                        <h2>Welcome back</h2>
                        <p>Welcome back! Please enter your details. </p>
                    </div>
                    <div class="user-input">
                        <div class="input-wrapper">
                            <input type="text" name ="username" id="username" placeholder="Username">
                            <input type="password" name ="password" id="password" placeholder="Password">
                        </div>
                        <button>Sign in</button>
                        <p>Don't have an account? <span><a href='/register'>Register</a></span></p>
                    </div>
                </form>
                <div id="side-Two">
                    <img src="/static/assets/bird.svg" class="bird"/>
                </div>
            </div>
        </main>
    </body>
</html>
