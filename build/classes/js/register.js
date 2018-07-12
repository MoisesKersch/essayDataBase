$(document).ready(function (){
	
	$( ".clicked" ).click(function() 
	{
		  $.ajax({
			  type: 'GET',
			  url: 'register',
			  data: {choice: $( this ).attr("id")},
			  success: function(response){
				  console.log(response);
			  }
	
		  });
	});
});
