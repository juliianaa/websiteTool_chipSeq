<%-- 
    Document   : histonehmm
    Created on : Mar 19, 2015, 2:01:03 PM
    Author     : jwlgoh
--%>

<div id="changeContent">
    <script src="../js/callServlet.js" type="text/javascript"></script>
    <script src="../js/handlesAnalysisSettings.js" type="text/javascript"></script>

    <p>
        Perform another analysis on the same files but with different settings.
        To get the wanted results
    </p>
    <button id="performButton" onclick="showAnlaysisSettings()">Perform another analysis</button>
    
    <h3>Download results:</h3>
    <div id="resultsTest"></div>
    
    <p>Perform a new analysis with different files</p>
    <button>New analysis</button>
    
    <div id="show">
            <%@include file="histonehmm.jsp" %>
    </div>
       
    
</div>
