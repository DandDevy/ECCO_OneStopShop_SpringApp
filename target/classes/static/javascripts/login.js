$(document).ready(function(){
    $("#loginBtn").click(function () {

        const email = $('#email').val();
        const pwd = $('#pwd').val();
        // alert("login button and src ref to login.js WORKS!!! \n\n email: " + email + " pwd: " + pwd);

        let dataToSend ={
            email: email,
            password: pwd
        };

        $.ajax({
            url: "/registration/checkLogin",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(dataToSend),
            success: function(resultData) {

                if(resultData){
                    window.open("/profil")
                }
                alert("Save Complete  " + "email: " + email + " pwd: " + pwd  + "result: "+ resultData);


            }

        });
    });
});