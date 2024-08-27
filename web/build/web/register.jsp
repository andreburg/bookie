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
        <title>Register</title>
    </head>
    <body>
        <main class="main-section">
            <tags:header />
            <div id="loginForm">
                <div id="side-Two">
                    <img src="/static/assets/bird.svg" class="bird"/>
                </div>
                <form action="action" id="side-One">
                    <div id="user-input-text">
                        <h3>Welcome</h3>
                        <p>Please fill in your details to get started.</p>
                    </div>
                    <div class="user-input">
                        <div class="user-input">
                            <input type="text" name ="username" id="username" placeholder="Username" required>
                        </div>
                        <div class="user-input">
                            <input type="text" name ="firstName" id="firstName" placeholder="First Name" required>
                            <input type="text" name ="lastName" id="lastName" placeholder="Last Name" required>
                        </div>
                        <div class="user-input">
                            <input type="email" name ="username" id="username" placeholder="Email" required>
                            <input type="tel" name ="password" id="password" placeholder="Phone Number" required>
                        </div>
                        <div class="user-input">
                            <input type="password" name ="password" id="password" placeholder="Password" required>
                            <input type="password" name ="password" id="password" placeholder="Confirm Password" required>
                        </div>

                        <button>Register</button>
                    </div>
                </form>
            </div>
        </main>
    </body>
</html>
