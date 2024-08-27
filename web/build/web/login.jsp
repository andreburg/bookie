<%-- 
    Document   : login.jsp
    Created on : 27 Aug 2024, 01:11:00
    Author     : werne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/style/globals.css" />
        <title>Login</title>
    </head>
    <body>
        <main class="main-section">
            <nav class="nav-header">
                <img src="/assets/bookie-logo.svg"/>
            </nav>
            <div id="loginForm">
                <form action="action" id="side-One">
                    <div id="user-input-text">
                        <h3>Welcome back</h3>
                        <p>Welcome back! Please enter your details. </p>
                    </div>
                    <div class="user-input">
                        <label for="username">Username</label>
                        <input type="text" name ="username" id="username"></input>
                    </div>
                    <div class="user-input">
                        <label for="password">Password</label>
                        <input type="password" name ="password" id="password"></input>
                    </div>
                    <div class="user-input">
                        <button>Sign in</button>
                    </div>
                </form>
                <div id="side-Two">
                    <img src="/assets/bird.svg" class="bird"/>
                </div>
            </div>
        </main>
    </body>
</html>
