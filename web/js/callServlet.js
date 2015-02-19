/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function() {
    //The advanced option is first hidden as the user needs to upload his or her file first
    $( "#advancedOptions" ).hide();
    
});

//Function that will be called once the user submits the file(s) to the server.
//This function will connect with the Servlet and send the uploaded file to the Servlet
function performAjaxUpload() {
    
    var sampleFile = document.getElementById("sampleFile").files;

    var formdata = new FormData();
    
    //Loops through the list
    for (i = 0; i < sampleFile.length; i++) { 
        //Appends the files to a formdata that easily can be use for HTML forms multipart/form-data
        formdata.append("sampleFile", sampleFile[i]);
    }
    var xhr = new XMLHttpRequest();       
    
    //Sends the formdata as a Post to the Servlet
    xhr.open("POST","FileUploadServlet", true);
    xhr.send(formdata);

    xhr.onload = function(e) {

        //Shows the advanced options
        $( "#advancedOptions").show();
        //Hides the file upload option
        $( "#files").hide();
        //Receive the path of where the files are located and sends it to the 
        //next function?
        document.getElementById('tempDir').value =  this.responseText;
    };                    

}

//Function that will be called once the user has submit wanted advanced options 
//Will receive the wanted options and the path to where the files are
//Sends it to the next Servlet that will call up the Java method and connect with 
//the R packaged chromstaR
function performAJaxSubmit() {
    
    var checkbox_value = [];
    var JsonObjects = {};
    
    var hiddenTmpDirPath = $('input[type=hidden]:first').val(); 
    JsonObjects['filePath'] = hiddenTmpDirPath;
        
    $(":checkbox").each(function () {
        var ischecked = $(this).is(":checked");
        if (ischecked) {
            checkbox_value.push( $(this).val());
        }
    });
    
    JsonObjects['rFunctions'] = checkbox_value;
  
    json_data = JSON.stringify(JsonObjects);

    var xhr = new XMLHttpRequest();       

    xhr.open("POST","AdvancedServlet", true);

    xhr.send(json_data);

    xhr.onload = function(e) {
        
         alert(this.responseText);
        //Loads the next page? where the results will be viewed

    };                    

}

