$(document).ready(function(){
    $("#signUpButton").attr('disabled', 'disabled');
    
});

$(document).ready(function() {
    var frm = $('#formSignup');
    $('#warning').html("");
    frm.submit(function(e){
        var name=$("#user").val();
        var password=$("#pass").val();
        var confirmPassword=$("#cPass").val();
        $("#passWarn").html("");
        $("#userWarn").html(""); 
        e.preventDefault();
        if((password.length!==confirmPassword.length || (password!==confirmPassword)))
        {
            $("#passWarn").html("confirm password must match password");
        }
        if(name.length<3)
        {
            $("#userWarn").html("name must be greater than or equal 3 characters");
        }
        else{
        $.ajax({
            type: "POST",
            url: "/IA_Project/UserController?action=validateUserName",
            data:"name="+name,
            success: function(data){
                if(data==="true")
                {
                    $("#formSignup").off("submit");
                    $("#formSignup").submit();
                }
                else
                {
                    $('#userWarn').html("name already exists");
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                $('#userWarn').html(textStatus);
            }
        });
    }
  });
});
document.getElementById("signUpButton").disabled = true;

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
        document.getElementById("signUpButton").disabled = false;
    }




