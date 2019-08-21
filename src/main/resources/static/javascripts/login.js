$(document).ready(function(){
    $("#loginBtn").click(function () {

        const email = $('#email').val();
        const pwd = $('#pwd').val();
        const userName = "";
        // alert("login button and src ref to login.js WORKS!!! \n\n email: " + email + " pwd: " + pwd);

        let dataToSend ={
            email: email,
            username: userName,
            password: pwd
        };

        $.ajax({
            url: "/userLogin",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(dataToSend),
            success: function(resultData) {
                console.log("results:", resultData)
                if(resultData){

                    $("main").load("/htmlLoads/toProfil.txt")
                }

            }

        });
    });
});