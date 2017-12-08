function markNotificationsAsRead(){
    $.post("/IA_Project/UserController",{action:'markNotificationsAsRead'});
}