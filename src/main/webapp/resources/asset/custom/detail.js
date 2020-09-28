$(document).ready(function(){
	
	getNote();
});
	function getNote(){
		$.ajax({
			type:"POST",
			url:'getNote',
			contentType:'html/text; charset=UTF-8',
			data:$("#id").val(),
			success:function(data){
				alert(data.title);
			}, error:function(data){
				alert(data);
			}
			
		});
	}
