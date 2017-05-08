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

 $('#btnShoppingCartAdd').click(function(){
    if(($('#newIdCar').val()!='')&&($('#newAmountCar').val()!=''))
    addCart();
    return false;
});

$('#btnCartSave').click(function(){
  if(($('#cartId').val()!='')&&($('#idCar').val()!='') &&($('#amountCar').val()!='')){
  updateCart();
  return false;
  }
  else{
  alert("please, write data in the form");
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
      console.log('delete cart');
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



 function updateCart(){
         console.log('updateCart');
         $.ajax({
         type:'PUT',
         contentType:'application/json',
         url:cart,
         data:formToJSON(),
         success:function(data,textStatus,jqXHR){
          alert('Cart updated succesfully');
           $("#cartId").val("");
           $("#idCar").val("");
           $('#amountCar').val('');
          getAllCart();
          },
          error:function(jqXHR,textStatus,errorThrown){
          alert('updateCart error: '+errorThrown);
          }
         });
   }


  function addCart() {
         console.log('addShoppingCart');
         $.ajax({
             type: 'POST',
             contentType: 'application/json',
             url: cart,
             dataType: 'json',
             data: formToAddJSON(),
             success: function (data, textStatus, jqXHR) {
                 alert('Cart created successfully');
                 console.log('Cart created successfully');
                 $('#newIdCar').val('');
                 $('#newAmountCar').val('');
                 getAllCart();
             },
             error: function (jqXHR, textStatus, errorThrown) {
                 alert('addCart error: ' + errorThrown);
             }
         });
 }



function formToJSON() {
          return JSON.stringify({
         "id": $('#cartId').val(),
         "idCar": $('#idCar').val(),
         "amountCar":$('#amountCar').val()
     });
  }

 function formToAddJSON() {
          return JSON.stringify({
                "id":null,
              "idCar":  $('#newIdCar').val(),
              "amountCar": $('#newAmountCar').val()
          });
 }