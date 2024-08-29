<%-- 
    Document   : welcome
    Created on : 27 Aug 2024, 12:48:36
    Author     : andre
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>
<%@tag import="app.util.Auth"%>
<%@tag import="app.util.Session"%>

<%-- any content can be specified here e.g.: --%>
<div class="welcome-page">
    <canvas id="confetti-canvas"></canvas>
    <img src="/static/assets/welcome-bookie.svg" alt="alt"/>
    <p class="welcome-message">
        your new trusty book outlet <span class="opening-soon">opening soon</span>!
    </p>
    <script type="text/javascript" src="/static/js/confetti.js" defer></script>
    <% 
        Session s = Auth.getSession(request);
        if(s != null){
    %>
    <script>
        (() => {
            const url = 'LibraryApp://open?arg1=<%= s.getUsername() %>';
            let a = document.createElement('a');
            a.setAttribute("href", url);
            a.click();
            })()
     <%}%>
    </script>
</div>