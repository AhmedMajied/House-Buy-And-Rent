$(document).ready(function(){
    $("#signUpButton").attr('disabled', 'disabled');
    
});

function validateInputs()
    {
        var Name=$("#user").val();
        var mail=$("#email").val();

        var xmlhttp=new XMLHttpRequest();
        xmlhttp.open("GET","validate?name="+name+"&e-mail="+mail,true);
        xmlhttp.send();
        xmlhttp.onreadystatechange=function()
        {
            if(xmlhttp.readyState==4&&xmlhttp.status==200)
            {
                $("#userWarn").html(xmlhttp.responseText);

            }
        }
        // check if name or mail already exists in the system

        return valid ;
    }

function validateCaptcha(){
        $("#signUpButton").removeAttr('disabled');
    }




