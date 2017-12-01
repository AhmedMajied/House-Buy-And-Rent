
function validateInputs()
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
}
