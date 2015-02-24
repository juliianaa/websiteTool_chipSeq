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
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/jquery-ui.js" type="text/javascript"></script>
        <script src="js/callServlet.js" type="text/javascript"></script>
        <script src="js/accordion.js" type="text/javascript"></script>
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
                                
                                
                            <div id='accordion'>
                                <h3>Upload file(s)</h3>
                                <div>
                                    <form>
                                        Upload File: <input id="sampleFile" name="sampleFile" type="file"  multiple=""/><br/>
                                        <br style="clear:both" /> 
                                     </form>
                                </div> 
                                <h3>Advanced options</h3>
                                <div>
                                    <p>Example of advanced options!!! Need to change later on</p>
                                    <form id="advancedForm">
                                        <input type="checkbox" name="rFunction" value="Default">Default (Working on this one first)<br /> 
                                        <input type="checkbox" name="rFunction" value="Dummy">Advanced (DUMMY)<br />
                                        <input type="hidden" id="tempDir" value="" />
                                        <!--<input id="uploadBtn" type="button" value="Submit" onClick="performAJaxSubmit();">-->
                                    </form>
                                </div> 
                                 <input id="uploadBtn" type="button" value="Submit" onClick="performAjaxUpload();">
                            </div>
                                

                            <div id="resultsDiv"></div>

                                
                                
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