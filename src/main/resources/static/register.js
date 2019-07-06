$(document).ready(function(){
    $("#registrationSubmitBtn").click(function () {
        runInfoAlert = false;
        const email = $('#email').val();
        const userName = $('#userName').val();
        const pwd = $('#pwd').val();
        const pwdRepeat = $('#pwdRepeat').val();
        // if(safeUserRegistrationData(email,userName,pwd,pwdRepeat)){
        // safeUserRegistrationData(email,userName,pwd,pwdRepeat);
        alert("email: " + email + "username: " + userName + " pwd: " + pwd + " pwdRepeat: " + pwdRepeat);

        let dataToSend ={
            email: email,
            username: userName,
            password: pwd
        };

        $.ajax({
            url: "/post/addUser",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(dataToSend),
            success: (response) => writeResults(response)

        });
    });

    function registerUser() {
        const email = $('#email').val();
        const userName = $('#userName').val();
        const pwd = $('#pwd').val();
        const pwdRepeat = $('#pwdRepeat').val();

        alert("email: " + email + "username: " + userName + " pwd: " + pwd + " pwdRepeat: " + pwdRepeat);
    }
});