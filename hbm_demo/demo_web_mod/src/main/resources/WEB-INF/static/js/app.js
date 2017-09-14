'use strict';


$(document).ready(function() {
	//this part hooking an ajax handler to the claim open button onClick event
	//run ajax query to retrieve a selected person 's current claims as JSON list
	//contruct a html table to display the claim list and insert right after the 
	//selected person record row as a collapsible row.
	$(".bt_claim").click(function(){
		var save=this;
		jQuery.ajax({
	        url: "http://localhost:8080/views/claim/personclaims",
	        type: 'GET',
	        data: {personId: this.id},
	        dataType: "json",
	        success: function(result)
	        {
	  
	        	var tbody=$(save).parentsUntil("tbody");
	        	var claimTblDiv=$("#personClaimTbl").children("div:first").clone();
	        	var tbl=claimTblDiv.find("tbody");
				//process JSON list returned by AJAX invoke and create a html table
	        	for(var claim in result)
				{
	  				var tr=$("<tr />");					
					tr.append(
							  $("<td />").text(result[claim].claimId),
							  $("<td />").text(result[claim].audit.createdDate),
							  $("<td />").text(result[claim].status),
							  $("<td />").text(result[claim].amount),
							  $("<td />").text(result[claim].description));
					tbl.append(tr);
				}
	  			//this part we will test if there is a collapsible result row already inserted by previous
	  			//click of the button. If it is exist then remove it to make way for new result list
	        	
	  			var nextRow=$(tbody[1]).next();
	  			if(typeof(nextRow) !== 'undefined') 
	  			{
	  				//Ok not a last row
		  			if(nextRow.hasClass("colRow"))
	  				{
		  				nextRow.remove();
	  				}
	  			}
	  			
	  			$(tbody[1]).after(
	  					$("<tr class='colRow'/>").append(
	  							$("<td colspan='6'/>").append(			
	  									$("<a data-toggle='collapse' data-target='#row_"+save.id+"'/>").append($("<i class='glyphicon glyphicon-plus'/>")),
					  					$("<div id='row_"+save.id+"' class='collapse in' />").append(claimTblDiv)
					  					)
				  				)
				  		);
	  			
	        }
		}); 
    });	    
});