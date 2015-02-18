<%-- 
    Document   : results.jsp
    Created on : Feb 9, 2015, 9:09:32 AM
    Author     : Eriba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <base href="${initParam.base_url}">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eriba</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>

        <body>
        <div id="main">
            <%@include file='../includes/menu.jsp' %>	
                <div id="content">
                    <div class="content_item">
                        <div class='about'>
                            <div class='about'>
                                <h1>Results</h1>

                                <div>
                                    
                                    <c:choose>
                                        <c:when test="${requestScope.results != ''}">
                                            <h1>
                                                Results are shown here 
                                            </h1>
                                        </c:when>
                                        <c:otherwise>
                                            <h1>
                                                This text appears when there are no 
                                                results found
                                            </h1>
                                        </c:otherwise>
                                    </c:choose>
                                    
                                  
                                </div>
                                
                            </div>
                        </div>
                    </div><!--close content_item-->	
                </div><!--close content-->
                </div><!--close site_content-->	
            </div><!--close site_background-->	
            <%@include file='../includes/footer.jsp' %>
        </div><!--close main-->	
    </body>
</html>
