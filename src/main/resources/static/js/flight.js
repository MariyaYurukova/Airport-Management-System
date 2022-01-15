




$(document).ready(function () {
    $('#planeId').on('click', function (e) {
        let id = $('#planeId').val();

        $.get('http://localhost:8080/flight/all/' + id, function (data) {
      //      alert("Data:" + data)

            $('#count1').text( data.numberOfSeats);

        });
        e.preventDefault(); // prevent actual form submit
    });

});


$(document).ready(function () {
    $('#planeId').on('click', function (e) {
        let id = $('#planeId').val();

        $.get('http://localhost:8080/flight/' + id, function (data) {
            //      alert("Data:" + data)
            $('#count2').val(data);

        });
        e.preventDefault(); // prevent actual form submit
    });

});


$(document).ready(function () {
    $('#planeId').on('click', function (e) {
        let id = $('#planeId').val();
        $.get('http://localhost:8080/flight/all/' + id, function (data) {


            $('#count1').val(data.numberOfSeats);
//$('#count2').attr('size',data.leght <= data.numberOfSeats.length);
        });
        e.preventDefault(); // prevent actual form submit
    });

});

$(document).ready(function () {

    $('#planeId').on('click', function (e) {
            let id = $('#planeId').val();

            $.get('http://localhost:8080/flight/all/' + id, function (data) {
                let num2 = $('#count2').val();


                $('#count3').val(data.numberOfSeats- num2);

            })
        }
    )
});
