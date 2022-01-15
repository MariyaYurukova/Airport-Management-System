
$(document).ready(function () {

    $("#planeForm").submit(function (event) {
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost() {
        let formData = {

            codeName: $("#code").val(),
            captain: $("#captain").val(),
            coPilot: $("#pilot").val(),
            numberOfSeats: $("#seats").val(),
            countStewardesses: $("#count").val(),
            flightAttendantOne: $("#one").val(),
            flightAttendantTwo: $("#two").val(),
            flightAttendantThree: $("#three").val(),
            flightAttendantFour: $("#four").val(),
            flightAttendantFive: $("#five").val(),
            flightAttendantSix: $("#six").val(),
            flightAttendantSeven: $("#seven").val(),

        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: window.location + "add-plane",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function (result) {
                if (result.status == "success") {

                    $("#postPlaneResultDiv")
                        .html(
                            "<p style='background-color:white; color:black;' >"
                            + "Save Successfully-->"
                            + result.object.codeName + "<br>"
                            + "</p>"
                        );
                } else {
                    $("#postPlaneResultDiv").html(
                        "<strong>Error</strong>");
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error! check code-name of the plane " +
                    "must to have 3 capital letters 2 numbers")
                console.log("ERROR: check code-name of the plane " +
                    "must to have 3 capital letters 2 numbers  ", e);
            }
        })


            $("#code").val('');
            $("#captain").val('');
            $("#pilot").val('');
            $("#seats").val('');
            $("#count").val('');
            $("#one").val('');
            $("#two").val('');
            $("#three").val('');
            $("#four").val('');
            $("#five").val('');
            $("#six").val('');
            $("#seven").val('');
    }
})




