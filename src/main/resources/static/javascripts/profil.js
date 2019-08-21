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

