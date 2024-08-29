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
                <div id="side-Two">
                    <img src="/static/assets/bird.svg" class="bird"/>
                </div>
                <form action="registerServlet" method="POST" id="side-One">
                    <div id="user-input-text">
                        <h2>Welcome back</h2>
                        <p>Welcome back! Please enter your details. </p>
                    </div>
                    <div class="user-input">
                        <div class="input-wrapper">
                            <input type="text" name="firstName" id="firstName" placeholder="First Name" required>
                            <input type="text" name="lastName" id="lastName" placeholder="Last Name" required>
                            <input type="text" name="email" id="email" placeholder="Email" required>
                            <input type="text" name="phone" id="phone" placeholder="Phone" required>
                        </div>
                        <div class="input-wrapper">
                            <input type="text" name="username" id="username" placeholder="Username" required>
                            <input type="password" name="password" id="password" placeholder="Password" required>
                            <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm Password" required>
                            <p id="message"></p>
                        </div>
                        <input id="registerButton" type="submit" value="Register">
                        <p>Already have an account? <span><a href='/login'>Login</a></span></p>
                    </div>
                </form>
            </div>
        </main> 
            <script type="text/javascript" src="/static/js/register.js" defer></script>
    </body>
</html