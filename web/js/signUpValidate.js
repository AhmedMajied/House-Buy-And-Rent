/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validate()
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

