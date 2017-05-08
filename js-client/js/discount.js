var discount="http://localhost:8088/discount";

$.dto=null;


 $('#btnDiscountSave').click(function(){
  if(($('#id').val()!='')&&($('#value').val()!='')){
  updateDiscount();
  return false;
  }
  else{
  alert("please, write data in the form");
  }
  });

 $('#btnDiscountAdd').click(function(){
    if($('#newValue').val()!=''){
    addDiscount();
    return false;}
    else{
    alert("please, write data in the form");
    }
});


getAllDiscount();

function getAllDiscount(){
   $.ajax({
   type: 'GET',
   url: discount +"s",
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
    $('#discountList tr').remove();

    $.each(dto, function (index, discount) {
        drawRow(discount);
    });
}


function drawRow(discount) {
    var row = $("<tr />")
    $("#discountList").append(row);

   row.append($("<td>" +discount.id+'</td>'));
   row.append($("<td>"   + discount.valueDiscount + '</td>'));
 }

 function updateDiscount(){
         console.log('updateDiscount');
         $.ajax({
         type:'PUT',
         contentType:'application/json',
         url:discount,
         data:formToJSON(),
         success:function(data,textStatus,jqXHR){
          alert('Discount updated succesfully');
           $("#id").val("");
           $("#value").val("");
          getAllDiscount();
          },
          error:function(jqXHR,textStatus,errorThrown){
          alert('updateDiscount error: '+errorThrown);
          }
         });
   }


  function addDiscount() {
         console.log('addDiscount');
         $.ajax({
             type: 'POST',
             contentType: 'application/json',
             url: discount,
             dataType: 'json',
             data: formToAddJSON(),
             success: function (data, textStatus, jqXHR) {
                 alert('Discount created successfully');
                 console.log('Discount created successfully');
                 $('#discountId').val(data.id);
                 $('#newValue').val('');
                 getAllDiscount();
             },
             error: function (jqXHR, textStatus, errorThrown) {
                 alert('addDiscount error: ' + errorThrown);
             }
         });
 }

 function formToJSON() {
     var id = $('#id').val();
     return JSON.stringify({
         "id": id == "" ? null : id,
         "valueDiscount": $('#value').val()
     });
   }

   function formToAddJSON() {
          return JSON.stringify({
              "id":  null,
              "valueDiscount": $('#newValue').val()
          });
 }