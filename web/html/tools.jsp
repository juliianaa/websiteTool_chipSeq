<%-- 
    Document   : tutorial
    Created on : Feb 2, 2015, 4:44:26 PM
    Author     : Eriba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                <h1>Tool</h1>

                                <p>
                                   Lorem ipsum dolor sit amet, consectetur adipiscing 
                                    elit. Sed quis enim fringilla, efficitur sem at, 
                                    porta justo. Nullam sit amet consectetur velit, at 
                                    laoreet eros. Nunc sit amet maximus metus. Sed 
                                    sollicitudin maximus pellentesque. Vestibulum 
                                    fermentum libero neque, quis pretium nibh facilisis 
                                    molestie. Curabitur quis tincidunt quam, nec auctor 
                                    ante. Curabitur non risus a ante tincidunt pharetra 
                                    vitae eu dui. Aenean vel turpis viverra, posuere 
                                    nunc et, tempus urna. Aliquam tristique mauris 
                                    magna, aliquam lobortis nibh dictum eget. 
                                </p>
                                <br style="clear:both" />

                                <div>
                                    <h3>Upload file</h3>
                                    <form action=""
                                    method="post" enctype="multipart/form-data">
                                        File name: <input type="text" name="fname"><br>
                                        File: <input type="file" name="file"><br>
                                        <input type="submit" value="Upload">
                                    </form>       
                                </div>
                                <br style="clear:both" />

                                <div>
                                    <h3>After file is uploaded</h3>
                                    <form action="">
                                        <input type="checkbox" name="rFunction" value="callPeaksUnivariate">call Peaks Univariate<br> 
                                        <input type="checkbox" name="rFunction" value="callPeaksMultivariate">call Peaks Multivariate<br> 
                                        <input type="checkbox" name="rFunction" value="changeFDR">change FDR<br>
                                        <input type="submit" value="Submit">
                                    </form>
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
