function addNote()
{
 var param ={
		 
		 title:$("#note_title").val(),
		 content:$("#note_detail").val()
 }
 
 var ser_data=JSON.stringify(param);
 $.ajax({
	 
	 type:"POST",
	 contentType:"application/json; charset:UTF-8",
	 url:"addNote",
	 data: ser_data,
	 success:function(data){
		alert(data);
		 window.history.back();
	 },error:function(data)
	 {
		 alert("Notunuz Kayıt Edilemedi");
	 }
 });
 
 
}