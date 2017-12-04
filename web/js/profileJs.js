/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
   var loadFile = function(event) {
    document.getElementById('userImage').src = URL.createObjectURL(event.target.files[0]);
  };
  
  function displayPhone()
  {
       	document.getElementById("displayPhone").style.display = (document.getElementById("displayPhone").style.display === 'block') ? 'none' :"";
        document.getElementById("Phone").style.display = (document.getElementById("Phone").style.display === 'block') ? 'none' : 'block';
  }
  function displayFields()
  {
        document.getElementById("changePassword").style.display = (document.getElementById("changePassword").style.display === 'block') ? 'none' :"";
        document.getElementById("password").style.display = (document.getElementById("password").style.display === 'block') ? 'none' : 'block';
  }

$(document).ready(function() {
    var frm = $('#passwordForm');
    
    frm.submit(function(e){
        var name=$('input:hidden[name=userName]').val();
        var password=$("#oPassword").val();
        if(password.length<4)
        {
            $('#valid').html("password is wrong");
        }
        e.preventDefault();

        $.ajax({
            type: "POST",
            url: "/IAProject/UserController?action=authenticateUser",
            data:"name="+name+"&password="+password,
            success: function(data){
                if(data==="true")
                {
                    $("#passwordForm").off("submit");
                    $("#passwordForm").submit();
                }
                else
                {
                    $('#valid').html("password is wrong");
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                $('#valid').html(textStatus);
            }
        });
    });
});