<br/><br/><br/>
<div class="box box-primary box-solid">
	<div class="box-header with-border">
		<h3 class="box-title">List Souvenir Settlement Request</h3>
	</div>
	<!-- box header -->
	<div class="panel panel-default" style="border-color: white; margin-bottom: 0px;">
		<div class="panel-body" style="padding: 10px;">
			<ol class="breadcrumb" style="background-color: #f5f5f5;">
		        <li><a href="/marcom174/"> Home</a></li>
		        <li><a href="#">Master</a></li>
		        <li class="active">List Souvenir Settlement Request</li>
      		</ol>
      		
		</div>
		
		<div class="row">
			<div class="col-md-11"></div>
			<div class="col-md-1">
				<button type="button" id="button-add" class="btn btn-info">Add</button>
			</div>
		</div>
	</div>
	
	<div class="box-body">
	
		
		 
		 <!-- FORM SEARCH -->
		
		 <table class="table table-hover" id="table-souvenir-settlement-request-search">
			<thead>
				
				<tr>
					<th>
							<input class="form-control" type="text" id=data1 name="data1" placeholder="Transaction Code"/> 
						
					</th>					
					<th>
							<input class="form-control" type="text" id="data2" name="data2" placeholder="Request By"/> 
						
					</th>
					<th>
						<div class="input-group date">
							<input type="text" class="form-control pull-right" id="data3" name="data3" placeholder="Request Date "/> 
							
							<div class="input-group-addon">
							<i class="fa fa-calendar"></i>
							</div>
						</div>
					</th>
					<th>
						<div class="input-group date">
							<input type="text" class="form-control pull-right" id="data4" name="data4" placeholder="Due Date"/> 
							
							<div class="input-group-addon">
							<i class="fa fa-calendar"></i>
							</div>
						</div>
					</th>
					<th>
							<input class="form-control" type="text" id="data5" name="data5" placeholder="Status"/> 
						
					</th>
					<th>
							<div class="input-group date">
							<input type="text" class="form-control pull-right" id="data6" name="data6" placeholder="Created"/> 
							
							<div class="input-group-addon">
							<i class="fa fa-calendar"></i>
							</div>
						</div>
						
					</th>
					<th>
							<input class="form-control" type="text" id="data7" name="data7" placeholder="Created By"/> 
						
					</th>
					<th>
						<button type="button" id="button-search" style="size: 5" class="btn btn-warning btn-block">
						<span class="glyphicon glyphicon-search"></span>Search</button>
					</th>
					
				</tr>
			</thead>
		 </table>
		
		 
		 
		<table class="table table-hover" id="table-souvenir-settlement-request">
			<thead>	
				
				<tr>
					<th>No.</th>
					<th>Trans Code</th>
					<th>Request By</th>
					<th>Request Date</th>
					<th>Due Date</th>
					<th>Status</th>
					<th>Created Date</th>
					<th>Created By</th>
					<th>Action</th>
					
				</tr>
			</thead>
			
			<tbody id="list-data-souvenir-settlement-request">
			
			</tbody>
		</table>
	</div>
	   
</div>

<!-- Pop-Up -->
<div id="modal-input" class="modal fade">
	<div class="modal-dialog">
		
	</div>
</div>
<!-- Pop-Up -->



<script>

	
listDataSouvenirSettlementRequest();

	function listDataSouvenirSettlementRequest() {
		$.ajax({
			url: "souvenirsettlement_request/list.html",
			type: "get",
			dataType: "html",
			success: function(result){
				$("#list-data-souvenir-settlement-request").html(result);					
			}				
		});		
	}

	$(document).ready(function(){
		
		 //////////////////DATA TABLE-----------------------
		
	 	
	 	// DataTable for datepicker
	 	
	 	$('#data3').datepicker({
		    autoclose: true,
		    format: 'dd/mm/yyyy'
		 });
	 	
	 	$('#data4').datepicker({
		    autoclose: true,
		    format: 'dd/mm/yyyy'
		 });
	 	
	 	$('#data6').datepicker({
		    autoclose: true,
		    format: 'dd/mm/yyyy'
		 });
		
     	
	 	////Data table
	 	var table = $('#table-souvenir-settlement-request').DataTable( {
	        'sDom':'tip',
	        ordering : false,
	       
	    } ); 
	 
	    // Filter event handler
	    
	    $("#table-souvenir-settlement-request-search").on("click", "#button-search", function() {
	    	for (var i = 1; i < 8; i++) {
	    		table.column(i).search($("#data"+i).val()).draw();
			}
	    	
	    });
	    
	    
	    
	    //////////////////Akhir DATA TABLE-----------------------
		////////////////////////////////////////////////////
	    
		
			//SETTLEMENT SAVE
		$("#modal-input").on("submit","#form-souvenir-settlement-request-settlement", function(){
			
			
			$.ajax({
				url: "souvenirsettlement_request/settlement/save.json",
				type: "get",
				dataType: "json",
				data: $(this).serialize(),
				success: function(result){
					$("#modal-input").modal("hide");					
					swal(
						  'Data Settlement Saved! Transaction souvenir settlement been submitted ',
						  '',
						  'success'
						)
					listDataSouvenirSettlementRequest();
				}
				/* ,
				error: function(jqXHR, textStatus, errorThrown){
					namesouvenirsettlement_request.style.borderColor="red";
					alertNamesouvenirsettlement_requestSame.style.display="block";
					alertNamesouvenirsettlement_request.style.display="none";
					
					// alert("Name is Exist!!!"); 
				} */
			});
			return false;
		});	
	    
	    //ADD------------
		$("#button-add").on("click", function(){
			$.ajax({
				url: "souvenirsettlement_request/add.html",
				type: "get",
				dataType: "html",
				success: function(result){
					$("#modal-input").find(".modal-dialog").html(result);
					$("#modal-input").modal("show");					
				}				
			});
		});	
	    
	    //DETAIL-------------
	    $("#list-data-souvenir-settlement-request").on("click", "#button-detail", function(){
		var idDetail = $(this).val();
		$.ajax({
			url: "souvenirsettlement_request/detail.html",
			type: "get",
			dataType: "html",
			data: {id:idDetail},
			success: function(result){
				$("#modal-input").find(".modal-dialog").html(result);
				$("#modal-input").modal("show");					
			}				
		});	
	});	
		
		//SETTLEMENT----------------------
		$("#list-data-souvenir-settlement-request").on("click", "#button-settlement", function(){
		var idSettlement = $(this).val();
		$.ajax({
			url: "souvenirsettlement_request/settlement.html",
			type: "get",
			dataType: "html",
			data: {id:idSettlement},
			success: function(result){
				$("#modal-input").find(".modal-dialog").html(result);
				$("#modal-input").modal("show");					
			}				
		});	
	});	
	    
		//ADD SAVE
 		$("#modal-input").on("submit","#form-souvenir-settlement-request-add", function(){
			
			
			$.ajax({
				url: "souvenirsettlement_request/add/save.json",
				type: "get",
				dataType: "json",
				data: $(this).serialize(),
				success: function(result){
					$("#modal-input").modal("hide");					
					swal(
							  'Data Saved! Transaction souvenir request has been add with code ' + result.souvenirSettlementModel.code,
							  '',
							  'success'
							)
					listDataSouvenirSettlementRequest();
				}
				/* ,
				error: function(jqXHR, textStatus, errorThrown){
					namesouvenirsettlement_request.style.borderColor="red";
					alertNamesouvenirsettlement_requestSame.style.display="block";
					alertNamesouvenirsettlement_request.style.display="none";
					
					// alert("Name is Exist!!!"); 
				} */
			});
			return false;
		});	
		
	
		
});
</script>