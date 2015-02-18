/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 function performAjaxSubmit() {

    var sampleFile = document.getElementById("sampleFile").files;

    var formdata = new FormData();
    
    for (i = 0; i < sampleFile.length; i++) { 
        formdata.append("sampleFile", sampleFile[i]);
    }
    var xhr = new XMLHttpRequest();       

    xhr.open("POST","FileUploadServlet", true);

    xhr.send(formdata);

    xhr.onload = function(e) {
        $( "#advancedOptions").show();
        $( "#files").hide();
        
        //get paths or directory and send to the next servlet with the checked functions

    };                    

}

$(function() {
     $( "#advancedOptions" ).hide();
    
});