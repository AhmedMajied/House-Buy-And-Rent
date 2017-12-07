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
            url: "/IA_Project/UserController?action=authenticateUser",
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
/*function validateInputs()
{
        var Name=document.getElementById("user").value;
        var password=document.getElementById("pass").value;
        var valid=false;
        if(Name.length<3 || password.length<4)
        {
            document.getElementById("warning").innerHTML="Invalid UserName or Password";
            return false;
        }
        var xmlhttp=new XMLHttpRequest();
        xmlhttp.open("GET","UserController?ACTION=authenticateUser&name="+Name+"&password="+password,true);
        xmlhttp.send();
        xmlhttp.onreadystatechange=function()
        {
            if(xmlhttp.readyState===4&&xmlhttp.status===200)
            {
                alert(xmlhttp.responseText)
                if(xmlhttp.responseText==="true")
                {
                    valid= true;
                }
                else
                {
                    document.getElementById("warning").innerHTML="Invalid UserName or Password";
                    valid= false;
                }
            }
           
        };
    return valid;
}*/
