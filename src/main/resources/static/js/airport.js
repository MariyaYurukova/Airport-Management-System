$(document).ready(function() {

    $("#airportForm").submit(function(event) {
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost() {
        let formData = {
            name : $("#airport").val(),

        }

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : window.location + "add-airport",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if (result.status == "success") {

                    $("#postAirportResultDiv")
                        .html(
                            "<p style='background-color:white; color:black; ' >"
                            + "Save Successfully-->"
                            + result.object.name+"<br>"
                            + "</p>"
                        );
                } else {
                    $("#postAirportResultDiv").html(
                        "<strong>Error</strong>");
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error! exists in the system")
                console.log("ERROR: exists in the system", e);
            }
        })

        $('#airport').val('');

    }
})