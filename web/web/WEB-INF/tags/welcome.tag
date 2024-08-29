<%-- 
    Document   : welcome
    Created on : 27 Aug 2024, 12:48:36
    Author     : andre
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

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
        (function runJavaProgram() {
            const { exec } = require('child_process');
            exec('java -jar "C:\Users\olwia\OneDrive\Documents\GitHub\bookie\desktop\LibraryApplication\dist\LibraryApplication.jar" <%= s.getUsername() %>', (error, stdout, stderr) => {
                if (error) {
                    console.error(Error: ${error});
                    return;
                }
                console.log(Output: ${stdout});
                if (stderr) {
                    console.error(stderr: ${stderr});
                }
            });
        })()
     <%}%>
    </script>
</div>