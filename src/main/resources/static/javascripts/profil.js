/*
 * written by Daniel Ashcroft
 */

$(document).ready(function(){
    $("#profilConfirmationBtn").click(function () {

        const locationForm = document.forms[0];

        var profilData = [];

        //getting location as first profil data
        var i = 0;
        while( i < locationForm.length){
            if(locationForm[i].checked){
                profilData[0] = locationForm[i].value;
                break;
            }
            i++
        }

        $.ajax({
            url: "/profilData",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.parse(profilData),
            success: function(resultData) {

                if(resultData){
                   alert("update success");
                }

            }

        });
    });
});

