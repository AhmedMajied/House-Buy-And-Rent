$(document).ready(function(){
    $("#signUpButton").attr('disabled', 'disabled');
    
});

function validateInputs()
    {
        var passwordValid=false;
        var Name=document.getElementById("user").value;
        var password=document.getElementById("pass").value;
        var confirmPassword=document.getElementById("cPass").value;
        if(password.length!=confirmPassword.length || (password!=confirmPassword))
        {
            passwordValid=false;
            //document.getElememtById("passWarn").innerHTML="confirm password doesn't match password";
            $("#passWarn").html("confirm password doesn't match password");
        }
        else if(password.length==confirmPassword.length && password==confirmPassword)
        {
            passwordValid=true;
        }

     var returnType;
     var valid=false;
       var xmlhttp=new XMLHttpRequest();
        xmlhttp.open("GET","process_ajax?name="+Name);
        xmlhttp.send();
        xmlhttp.onreadystatechange=function()
        {
            if(xmlhttp.readyState==4&&xmlhttp.status==200)
            {
                var result=xmlhttp.responseText==="true";
                if(result)
                {
                    valid=true;
                    document.getElementById("userWarn").innerHTML="valid name ";

                }
                else
                {
                    document.getElementById("userWarn").innerHTML="this name already exists";
                    valid=false;
                }
            }
        }        
        if(valid===true&&passwordValid===true)
            return true;
        else
            return false;
    }

function validateCaptcha(){
        $("#signUpButton").removeAttr('disabled');
    }



