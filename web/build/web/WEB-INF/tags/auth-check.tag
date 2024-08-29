
<%@tag import="app.util.Auth"%>
<%@tag import="app.util.Session"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="message"%>


<% 
    Session s = Auth.getSession(request);
    if(s != null && s.validateSession()) response.sendRedirect("/");
%>