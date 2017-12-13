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
            url: "/UserController?action=validateUserName",
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
function validateCaptcha(){
        $("#signUpButton").removeAttr('disabled');
    }




