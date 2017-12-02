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
       	document.getElementById("submit1").style.display = (document.getElementById("submit1").style.display === 'block') ? 'none' :"";
        document.getElementById("Phone").style.display = (document.getElementById("Phone").style.display === 'block') ? 'none' : 'block';
  }
  function displayEmail()
  {
       	document.getElementById("submit2").style.display = (document.getElementById("submit2").style.display === 'block') ? 'none' :"";
        document.getElementById("Email").style.display = (document.getElementById("Email").style.display === 'block') ? 'none' : 'block';
  }
