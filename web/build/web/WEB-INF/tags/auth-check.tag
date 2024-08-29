<%-- 
    Document   : auth-check
    Created on : 27 Aug 2024, 23:37:15
    Author     : werne
--%>

<%@tag import="app.util.Auth"%>
<%@tag import="app.util.Session"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<% 
    Session s = Auth.getSession(request);
    if(s.validateSession()) response.sendRedirect("/");
%>