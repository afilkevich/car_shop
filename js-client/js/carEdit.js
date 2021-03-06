var car_edit = "http://localhost:8088/car";



 $('#saveBtn').click(function(){
         if(($('#id').val()!='')&&($('#brand').val()!='')&&($('#model').val()!='')&&($('#configType').val()!='')&&($('#date').val()!='')&&($('#price').val()!='')){
         updateCar();
        return false;
        }


});


$('#saveBtn').click(function(){
         if(($('#id').val()=='')&&($('#brand').val()!='')&&($('#model').val()!='')&&($('#configType').val()!='')&&($('#date').val()!='')&&($('#price').val()!='')){
         addCar();
        return false;
        }

});

    $('#cancelBtn').click(function () {
                 $('#brand').val(""),
                 $('#model').val(""),
                 $('#configType').val(""),
                 $('#date').val(""),
                 $('#price').val("")
            window.location = 'car.html';

    });


function addCar() {
        console.log('add Car');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: car_edit,
            dataType: "json",
            data: formToAddJSON(),
            success: function (data, textStatus, jqXHR) {
                alert('Car created successfully');
                console.log('Car created successfully');

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('addCar error: ' + errorThrown);
            }
        });
}

function updateCar() {
        console.log('update Car');
        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: car_edit,
            data: formToJSON(),
            success: function (data, textStatus, jqXHR) {
                alert('Car updated successfully');
                console.log('Car updated successfully');
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('update Car error: ' + errorThrown);
            }
        });
}

function formToAddJSON() {
        return JSON.stringify({
            "id": null ,
            "brandName": $('#brand').val(),
            "modelName": $('#model').val(),
            "configName": $('#configType').val(),
            "dateBuilder": $('#date').val(),
            "price":$('#price').val()
        });
}

function formToJSON() {
        return JSON.stringify({
            "id": $('#id').val() ,
            "brandName": $('#brand').val(),
            "modelName": $('#model').val(),
            "configName": $('#configType').val(),
            "dateBuilder": $('#date').val(),
            "price":$('#price').val()
        });
}