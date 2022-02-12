function addUser()
{
 var param ={
		 
		 username:$("#username").val(),
		 name:$("#name").val(),
		  surname:$("#surname").val(),
		   email:$("#email").val(),
		    password:$("#pass").val(),
		     pass2:$("#pass2").val()
 }
 
 var ser_data=JSON.stringify(param);
 $.ajax({
	 
	 type:"POST",
	 contentType:"application/json; charset:UTF-8",
	 url:"addUser",
	 data: ser_data,
	 success:function(data){
		 if(data=='1'){
		 alert("Parolalar eşleşmedi");}
		 else if(data=='OK'){
			 alert("başarıyla üye olundu");
		 }
		 else if(data=='ERROR'){
			 alert("Bir hata oluştu");
		 }
			 
		 window.history.back();
	 },error:function(data)
	 {
		 alert(data);
	 }
 });
 
 
}