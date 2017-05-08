var car="http://localhost:8088/car";

$.dto=null;

$(document).on("click", "a", function() {
    var action = $(this).text();
    var selectedId = $(this).data("id");
    if (action == "delete") {
      deleteCar(selectedId);
    }
});



getAllCar();

function getAllCar(){
   $.ajax({
   type: 'GET',
   url: car +"s",
    dataType:'json',
    success: renderList,
    error:function(jqXHR, textStatus, errorThrown){
    console.log(jqXHR, textStatus, errorThrown);
    alert('getAll:'+textStatus +jqXHR)
     }
   });
 }

function renderList(data) {
    dto = data == null ? [] : (data instanceof Array ? data : [data]);
    $('#carList tr').remove();

    $.each(dto, function (index, car) {
        drawRow(car);
    });
}

function drawRow(car) {
    var row = $("<tr />")
    $("#carList").append(row);

   row.append($("<td>" +car.id+'</td>'));
   row.append($("<td>"   + car.brandName + '</td>'));
   row.append($("<td>"   + car.modelName + '</td>'));
   row.append($("<td>"   + car.configName + '</td>'));
   row.append($("<td>"   + car.configDescription + '</td>'));
   row.append($("<td>"   + car.dateBuilder + '</td>'));
   row.append($("<td>"   + car.price + '</td>'));
    row.append($("<td>" + '<a href="#" data-id="' + car.id + '">delete</a></td>'));
 }

 function deleteCar(id){
      console.log('delete car');
      $.ajax({
      type: 'DELETE',
      contentType: 'application/json',
      url:car+"/"+id,
      success:function(textStatus){
      alert('Car delete successful');
      getAllCar();
      },
      error:function (jqXHR, textStatus, errorThrown) {
            alert('delete Car error: ' + errorThrown);
      }
      });
 }