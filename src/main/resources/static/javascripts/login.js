$(document).ready(function(){
    $("#loginBtn").click(function () {

        const email = $('#email').val();
        const pwd = $('#pwd').val();
        alert("login button and src ref to login.js WORKS!!! \n\n email: " + email + " pwd: " + pwd);
    });
});