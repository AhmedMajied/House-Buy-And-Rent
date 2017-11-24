$(document).ready(function(){
    $("#signUpButton").attr('disabled', 'disabled');
    
});

function validateInputs()
    {
        var Name=$("#user").val();
        var password=$("#pass").val();
        var mail=$("#email").val();
        var phoneNumber=$("#phoneNumber").val();
        valid=false;

        if(Name.length<4)
        {
            $("#userWarn").html("user name must have at least 4 characters");
            valid=false;
        }
        // check if name or mail already exists in the system

        return valid ;
    }

function validateCaptcha(){
        $("#signUpButton").removeAttr('disabled');
    }




