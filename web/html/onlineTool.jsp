<%-- 
    Document   : tutorial
    Created on : Feb 2, 2015, 4:44:26 PM
    Author     : jwlgoh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${initParam.base_url}">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eriba</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link href="css/nprogress.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/jquery-ui.js" type="text/javascript"></script>
        <script src="js/callServlet.js" type="text/javascript"></script>
        <script src="js/accordion.js" type="text/javascript"></script>
        <script src="js/handlesAnalysisSettings.js" type="text/javascript"></script>
        <script src="js/nprogress.js" type="text/javascript"></script>
    </head>

        <body>
        <div id="main">
            <%@include file='../includes/menu.jsp' %>	
                <div id="content">
                    <div class="content_item">
                        <div class='about'>
                            <div id="changeContent">
                                <%@include file="histonehmm.jsp" %>
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
