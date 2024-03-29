$(document).ready(function() {
    var frm = $('#formLogin');
    $('#warning').html("");
    frm.submit(function(e){
        var name=$("#user").val();
        var password=$("#pass").val();
        
        if(password.length<4||name.length<3)
        {
            $('#warning').html("invalid name or password");
        }
        e.preventDefault();

        $.ajax({
            type: "POST",
            url: "/UserController?action=authenticateUser",
            data:"name="+name+"&password="+password,
            success: function(data){
                if(data==="true")
                {
                    $("#formLogin").off("submit");
                    $("#formLogin").submit();
                }
                else
                {
                    $('#warning').html("invalid name or password");
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                $('#warning').html(textStatus);
            }
        });
    });
});