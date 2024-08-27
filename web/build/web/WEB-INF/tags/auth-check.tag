<%-- 
    Document   : auth-check
    Created on : 27 Aug 2024, 23:37:15
    Author     : werne
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<% 
                Cookie[] cookies = request.getCookies();
                String username = "";
                
                if(cookies != null){
                    for(Cookie cookie: cookies){
                        if(cookie.getName().equals("username")) {
                        username = cookie.getValue();
                        }   
                    }
                }
                                
                if(username != ""){
                    response.sendRedirect("/");
                }
%>