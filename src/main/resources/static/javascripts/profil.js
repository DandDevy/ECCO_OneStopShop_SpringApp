/*
 * written by Daniel Ashcroft
 */

$(document).ready(function (message){
    /**
     * Confirm location
     */
    $("#locationConfirmationBtn").click(function (message) {
        const locationForm = document.forms[0];
        let location;

        var i = 0;
        while( i < locationForm.length){
            if(locationForm[i].checked){
                location = locationForm[i].value;
                break;
            }
            i++
        }

        const dataToSend = {
            location: location
        }

        $.ajax({
            url: "/setUserLocation",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(location),
            success: function(resultData) {

                if(resultData){
                    alert("update success");
                }

            }

        });

    });

    $("#userTechConfirmationBtn").click(function (message) {
        const userTechForm = document.forms[1];
        let tech = {};

        let noTechSelected = true;
        for(let i =0; i < userTechForm.length; i++){
            if(userTechForm[i].checked){
                noTechSelected = false;
                $.ajax({
                    url: "/setUserTechnology",
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify({
                        name: userTechForm[i].value
                    }),
                    success: function(resultData) {

                        if(resultData){
                            alert("update success");
                        }

                    }

                });



                tech[i] = {
                    name: userTechForm[i].value
                };

            }
        }

        if(noTechSelected){
            $.ajax({
                url: "/setUserTechnologyToNone",
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    name: "none"
                }),
                success: function(resultData) {

                    if(resultData){
                        alert("update success");
                    }

                }

            });
        }



        const dataTosend = {
            technologies:tech
        }

        // $.ajax({
        //     url: "/setUserTechnology",
        //     type: 'POST',
        //     contentType: 'application/json',
        //     data: JSON.stringify(tech),
        //     success: function(resultData) {
        //
        //         if(resultData){
        //             alert("update success");
        //         }
        //
        //     }
        //
        // });

    });


    $("#matchUser").click(function (message) {
        $.ajax({
            url: "/matchUser",
            type: 'GET',

            success: function(resultData) {


                alert(resultData);
                // $("#matchResponse").innerHTML="<button type=\"button\" class=\"btn btn-primary\" id=\"matchUser\">Request contact for matches :"+ resultData +" </button>"
                const response =  "<hr><p>" + resultData +"</p><button type='button' class='btn btn-primary' id='setMatch' >Request contact?</button> ";
                document.getElementById("matchResponse").innerHTML=response;
            }

        });

    });

    $("#setMatch").click(function (message) {
            $.ajax({
                url: "/setMatch",
                type: 'GET',

                success: function(resultData) {


                    alert(resultData);
                }

            });

        });

    $("#profilConfirmationBtn").click(function (message) {

        const locationForm = document.forms[0];
        const userTechForm = document.forms[1];
        // const userTechForm2 = document.getElementById("userTech");

        // alert("userTechForm1[1]: " + userTechForm[1])
        // alert("userTech" + userTechForm2 + "+ userTechForm2[1]: "  + userTechForm2[1] + "\n " + "userTech1" + userTechForm + ", userTechForm1[1]: " + userTechForm[1])

        // var profilData = [];

        var userLocation;

        //getting location as first profil data
        var i = 0;
        while( i < locationForm.length){
            if(locationForm[i].checked){
                // profilData[0] = locationForm[i].value;
                userLocation = locationForm[i].value;
                alert(userLocation)
                break;
            }
            i++
        }

        const location = {
            name: userLocation
        };
        $.ajax({
            url: "/profilData",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(location),
            success: function(resultData) {

                if(resultData){
                   alert("update success");
                }

            }

        });
    });

});

