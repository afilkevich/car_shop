var brand="http://localhost:8088/brand";

$.dto=null;

 $('#btnBrandSave').click(function(){
  if(($('#brandId').val()!='')&&($('#name').val()!='')){
  updateBrand();
  return false;
  }
  else{
  alert("please, write data in the form");
  }
  });

 $('#btnBrandAdd').click(function(){
    if($('#newName').val()!='')
    addBrand();
    return false;
});


getAllBrand();

function getAllBrand(){
   $.ajax({
   type: 'GET',
   url: brand +"s",
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
    $('#brandList tr').remove();

    $.each(dto, function (index, brand) {
        drawRow(brand);
    });
}


function drawRow(brand) {
    var row = $("<tr />")
    $("#brandList").append(row);

   row.append($("<td>" +brand.id+'</td>'));
   row.append($("<td>"   + brand.name + '</td>'));

 }

function updateBrand(){
        console.log('updateBrand');
        $.ajax({
        type:'PUT',
        contentType:'application/json',
        url:brand,
        data:formToJSON(),
        success:function(data,textStatus,jqXHR){
         alert('Brand updated succesfully');
          $("#brandId").val("");
          $("#name").val("");
         getAllBrand();
         },
         error:function(jqXHR,textStatus,errorThrown){
         alert('updateBrand error: '+errorThrown);
         }
        });
  }


 function addBrand() {
        console.log('addBrand');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: brand,
            dataType: 'json',
            data: formToAddJSON(),
            success: function (data, textStatus, jqXHR) {
                alert('Brand created successfully');
                console.log('Brand created successfully');
                $('#brandId').val(data.id);
                $('#newName').val('');
                getAllBrand();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('addBrand error: ' + errorThrown);
            }
        });
}

function formToJSON() {
    var id = $('#brandId').val();
    return JSON.stringify({
        "id": id == "" ? null : id,
        "name": $('#name').val()
    });
 }


  function formToAddJSON() {
         return JSON.stringify({
             "id":  null,
             "name": $('#newName').val()
         });
}