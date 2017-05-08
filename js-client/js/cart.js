var cart="http://localhost:8088/cart";

$.dto=null;


getAllCart();

$(document).on("click", "a", function() {
    var action = $(this).text();
    var selectedId = $(this).data("id");
    if (action == "delete") {
      deleteCart(selectedId);
    }
});

function getAllCart(){
   $.ajax({
   type: 'GET',
   url: cart +"s",
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
    $('#cartList tr').remove();

    $.each(dto, function (index, cart) {
        drawRow(cart);
    });
}


function drawRow(cart) {
    var row = $("<tr />")
    $("#cartList").append(row);

   row.append($("<td>" +cart.id+'</td>'));
   row.append($("<td>"  + cart.idCar + '</td>'));
   row.append($("<td>"  + cart.valueDiscount + '</td>'));
   row.append($("<td>"  + cart.amountCar + '</td>'));
    row.append($("<td>"  + cart.price  + '</td>'));
    row.append($("<td>" + '<a href="#" data-id="' + cart.id + '">delete</a></td>'));
 }

function deleteCart(id){
      console.log('delete car');
      $.ajax({
      type: 'DELETE',
      contentType: 'application/json',
      url:cart+"/"+id,
      success:function(textStatus){
      alert('Cart delete successful');
      getAllCart();
      },
      error:function (jqXHR, textStatus, errorThrown) {
            alert('delete Cart error: ' + errorThrown);
      }
      });
 }