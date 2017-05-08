var model="http://localhost:8088/model";

$.dto=null;


 $('#btnModelSave').click(function(){
  if(($('#modelId').val()!='')&&($('#name').val()!='')){
  updateModel();
  return false;
  }
  else{
  alert("please, write data in the form");
  }
  });

 $('#btnModelAdd').click(function(){
    if($('#newName').val()!=''){
    addModel();
    return false;}
    else{
    alert("please, write data in the form");
    }
});


getAllModel();

function getAllModel(){
   $.ajax({
   type: 'GET',
   url: model +"s",
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
    $('#modelList tr').remove();

    $.each(dto, function (index, model) {
        drawRow(model);
    });
}


function drawRow(model) {
    var row = $("<tr />")
    $("#modelList").append(row);

   row.append($("<td>" +model.id+'</td>'));
   row.append($("<td>"   + model.name + '</td>'));
 }

 function updateModel(){
         console.log('updateModel');
         $.ajax({
         type:'PUT',
         contentType:'application/json',
         url:model,
         data:formToJSON(),
         success:function(data,textStatus,jqXHR){
          alert('Model updated succesfully');
           $("#modelId").val("");
           $("#name").val("");
          getAllModel();
          },
          error:function(jqXHR,textStatus,errorThrown){
          alert('updateModel error: '+errorThrown);
          }
         });
   }


  function addModel() {
         console.log('addModel');
         $.ajax({
             type: 'POST',
             contentType: 'application/json',
             url: model,
             dataType: 'json',
             data: formToAddJSON(),
             success: function (data, textStatus, jqXHR) {
                 alert('Model created successfully');
                 console.log('Model created successfully');
                 $('#modelId').val(data.id);
                 $('#newName').val('');
                 getAllModel();
             },
             error: function (jqXHR, textStatus, errorThrown) {
                 alert('addModel error: ' + errorThrown);
             }
         });
 }

 function formToJSON() {
     var id = $('#modelId').val();
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