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
        <script src="js/handlesAdvancedOptions.js" type="text/javascript"></script>
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
                                
                                
                            <div id="options">

                                       
                                            <h3>Upload file(s)</h3>
                                            <div>
                                                <form>
                                                    Upload File: <input id="sampleFile" name="sampleFile" type="file"  multiple=""/><br/>
                                                    <br style="clear:both" /> 
                                                 </form>
                                            </div> 
                                            <div>
                                                <p>Example of advanced options!!! Need to change later on</p>
                                                <form id="advancedForm">
                                                    <input class="option" type="checkbox" name="rFunction" value="Default">Default (Done)<br /> 
                                                    <input class="option" type="checkbox" name="rFunction" value="Advanced">Advanced (Working on)<br />
                                                    <label class="advanced">Bins:</label> <input class="advanced" type="number" name="bins" value="800"><br />
                                                    <label class="advanced">Univariate max time: </label> <input class="advanced" type="number" name="uMaxT" value="30"><br />
                                                    <label class="XtraAdvanced">Multivariate max time: </label> <input class="advanced" type="number" name="mMaxT" value="300"><br />
                                                    <input type="hidden" id="tempDir" value="" />
                                                </form>
                                            </div> 
                                             <input id="uploadBtn" type="button" value="Submit" onClick="performAjaxUpload();">
                                        

                                 </div>
                                
                                <div id="resultsTest"></div>
                                
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
