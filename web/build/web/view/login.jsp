<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/static/style/globals.css" />
        <title>Bookie - Login</title>
    </head>
    <body>
        <main class="main-section">
            <tags:auth-check/>
            <tags:header />
            <div id="loginForm">
                <form action="authenticate" method="POST" id="side-One">
                    <div id="user-input-text">
                        <h2>Welcome back</h2>
                        <p>Welcome back! Please enter your details. </p>
                    </div>
                    <div class="user-input">
                        <div class="input-wrapper">
                            <input type="text" name ="txtUsername" id="username" placeholder="Username">
                            <input type="password" name ="txtPassword" id="password" placeholder="Password">
                        </div>
                        <input id="sign-in-button" type="submit" value="Sign in">
                             <% 
                            String errorMessage = request.getParameter("error");
                            if (errorMessage != null && !errorMessage.isEmpty() && errorMessage.contains("Invalid credentials")) {
                            %>
                                <div class="error-message">
                                    <p><%= errorMessage %></p>
                                </div>
                            <% 
                                }
                            %>
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
