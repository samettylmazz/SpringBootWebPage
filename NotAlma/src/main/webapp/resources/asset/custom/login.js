function loginBtn()
{
 var param ={
		 
		 username:$("#username").val(),		
		    password:$("#pass").val()
		     
 }
 
 var ser_data=JSON.stringify(param);
 $.ajax({
	 
	 type:"POST",
	 contentType:"application/json; charset:UTF-8",
	 url:"controlUser",
	 data: ser_data,
	 success:function(data){
		
		 if(data=='OK'){
			 $(location).attr('href', 'index');

		 }
		 else if(data=='ERROR'){
			 alert("Kullanıcı Adı ve Şifre Kontrol Ediniz");
		 }
			 
		 window.history.back();
	 },error:function(data)
	 {
		 alert("Bir Hata Oluştu");
	 }
 });
 
 
}