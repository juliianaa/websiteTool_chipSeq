/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $(".advanced").hide(); 
    $(".option").change(function(){
        $(".option").not(this).prop("disabled", this.checked);
        if($(this).val() === "Advanced"){
           $(".advanced").show(); 
        }else{
            $(".advanced").hide(); 
        }
    });    
});
