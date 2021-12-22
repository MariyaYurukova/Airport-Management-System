$(document).ready(function() {

    $("#airlineForm").submit(function(event) {
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost() {
        let formData = {
            name : $("#name").val(),

        }

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : window.location + "add-airline",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if (result.status == "success") {

                    $("#postAirlineResultDiv")
                        .html(
                            "<p style='background-color:white; color:black;'>"
                            + "Save Successfully-->"
                            + result.object.name+"<br>"
                            + "</p>"
                        );
                } else {
                    $("#postAirlineResultDiv").html(
                        "<strong>Error</strong>");
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error! exists in the system")
                console.log("ERROR:exists in the system ", e);
            }
        })

        $('#name').val('');

    }
})