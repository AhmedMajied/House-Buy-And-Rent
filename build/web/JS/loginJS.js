
function validateInputs()
    {
        var Name=$("#user").val();
        var password=$("#pass").val();
        valid=true;
        if(Name.length<4)
        {
            $("#warning").html("Invalid UserName or Password");
            valid=false;
        }
        return valid;
    }
