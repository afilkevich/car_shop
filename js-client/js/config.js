var config="http://localhost:8088/config";

$.dto=null;


 $('#btnConfigSave').click(function(){
  if(($('#configId').val()!='')&&($('#type').val()!='')&&($('#descr').val()!='')){
  updateConfig();
  return false;
  }
  else{
  alert("please, write data in the form");
  }
  });

 $('#btnConfigAdd').click(function(){
    if(($('#newType').val()!='')&&($('#newDescr').val()!='')){
    addConfig();
    return false;}
    else{
    alert("please, write data in the form");
    }
});


getAllConfig();

function getAllConfig(){
   $.ajax({
   type: 'GET',
   url: config +"s",
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
    $('#configList tr').remove();

    $.each(dto, function (index, config) {
        drawRow(config);
    });
}


function drawRow(config) {
    var row = $("<tr />")
    $("#configList").append(row);

   row.append($("<td>" +config.id+'</td>'));
   row.append($("<td>"   + config.type + '</td>'));
   row.append($("<td>"   + config.description + '</td>'));
 }

function updateConfig(){
         console.log('updateConfig');
         $.ajax({
         type:'PUT',
         contentType:'application/json',
         url:config,
         data:formToJSON(),
         success:function(data,textStatus,jqXHR){
          alert('Configuration updated succesfully');
           $("#configId").val("");
           $("#type").val("");
           $("#descr").val("");
          getAllConfig();
          },
          error:function(jqXHR,textStatus,errorThrown){
          alert('updateConfig error: '+errorThrown);
          }
         });
   }


  function addConfig() {
         console.log('addConfig');
         $.ajax({
             type: 'POST',
             contentType: 'application/json',
             url: config,
             dataType: 'json',
             data: formToAddJSON(),
             success: function (data, textStatus, jqXHR) {
                 alert('Config created successfully');
                 console.log('Config created successfully');
                 $('#configId').val(data.id);
                 $('#newType').val('');
                 $('#newDescr').val('');
                 getAllConfig();
             },
             error: function (jqXHR, textStatus, errorThrown) {
                 alert('addConfig error: ' + errorThrown);
             }
         });
 }

 function formToJSON() {
     var id = $('#configId').val();
     return JSON.stringify({
         "id": id == "" ? null : id,
         "type": $('#type').val(),
         "description": $('#descr').val()
     });
   }

   function formToAddJSON() {
          return JSON.stringify({
              "id":  null,
              "type": $('#newType').val(),
              "description": $('#newDescr').val()
          });
 }