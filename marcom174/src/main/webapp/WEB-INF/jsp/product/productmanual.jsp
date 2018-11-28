<div class="panel" style="background-color: white;">
	<br/><br/>
	<h1> &nbsp;  List Product</h1>
	<!-- box header -->
	<div class="panel panel-default" style="border-color: white; margin-bottom: 0px;">
		<div class="panel-body" style="padding: 10px;">
			<ol class="breadcrumb" style="background-color: #f5f5f5;">
		        <li><a href="/marcom174/"> Home</a></li>
		        <li><a href="#">Master</a></li>
		        <li class="active">List Product</li>
      		</ol>
		</div>
	</div>
	<!-- panel -->
	
	<div class="box-body">
	
		<table class="table table-hover">
			<thead>
				<tr>
					
					<th>
						<button type="button" id="button-add" class="btn btn-info">Add</button>
					</th>
					
				</tr>
			</thead>
		 </table>
		 
		<form method="get" id="form-product-search">
		 <table class="table table-hover">
		
			<thead>
		 
				
				<tr>
					
					<th></th>
					<th>
						
							<input class="form-control" type="text" id="codeSearch" name="codeSearch" placeholder="Product Code"/> 
						
					</th>					
					<th>
					
							<input class="form-control" type="text" id="nameSearch" name="nameSearch" placeholder="Product Name"/> 
						
					</th>
					<th>
						
							<input class="form-control" type="text" id="descriptionSearch" name="descriptionSearch" placeholder="Description"/> 
						
					</th>
					<th>
						
						<!-- <input type="text" class="form-control pull-right" id="datepicker"> -->
							<input type="text" class="form-control pull-right" id="dateSearch" name="dateSearch" placeholder="Created"/> 
						
					</th>
					<th>
						
							<input class="form-control" type="text" id="userSearch" name="userSearch" placeholder="Created By"/> 
						
					</th>
					<th>
						<button type="submit" style="size: 5" class="btn btn-warning btn-block">
						<span class="glyphicon glyphicon-search"></span>Search</button>
					</th>
				
				</tr>
				
			</thead>
		 </table>
		 </form>
		<table class="table table-hover" id="table-product">
			<thead>	
				<tr>
					<th>No.</th>
					<th>Product Code</th>
					<th>Product Name</th>
					<th>Description</th>
					<th>Created Date</th>
					<th>Created By</th>
					<th>Action</th>
				</tr>
				
			</thead>
		
		 </table>	
		<table class="table table-hover" id="table-product">
				
			<tbody id="list-data-product">
			
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

	$('#dateSearch').datepicker({
	    autoclose: true
	  });

	listDataProduct();

	function listDataProduct() {
		$.ajax({
			url: "product/list.html",
			type: "get",
			dataType: "html",
			success: function(result){
				$("#list-data-product").html(result);					
			}				
		});		
	}

	$(document).ready(function(){
		
		$("#button-add").on("click", function(){
			$.ajax({
				url: "product/add.html",
				type: "get",
				dataType: "html",
				success: function(result){
					$("#modal-input").find(".modal-dialog").html(result);
					$("#modal-input").modal("show");					
				}				
			});
		});	
		
		
		
		$("#modal-input").on("submit","#form-product-add", function(){
			
			var nameProduct = document.getElementById("name");
			var alertNameProduct = document.getElementById("alertNameProduct");
			
			if (nameProduct.value=="") {
				nameProduct.style.borderColor="red";
				alertNameProduct.style.display="block";
				return false;
			} else {
				nameProduct.style.borderColor="inherit";
				alertNameProduct.style.display="none";
			}
			$.ajax({
				url: "product/add/save.json",
				type: "get",
				dataType: "json",
				data: $(this).serialize(),
				success: function(result){
					$("#modal-input").modal("hide");					
					alert("Data Saved! New Product has been add with code" + result.productModel.code);
					listDataProduct();
				}				
			});
			return false;
		});	
		
		$("#modal-input").on("submit","#form-product-edit", function(){
			var nameProduct = document.getElementById("name");
			var alertNameProduct = document.getElementById("alertNameProduct");
			
			if (nameProduct.value=="") {
				nameProduct.style.borderColor="red";
				alertNameProduct.style.display="block";
				return false;
			} else {
				nameProduct.style.borderColor="inherit";
				alertNameProduct.style.display="none";
			}
			$.ajax({
				url: "product/edit/save.json",
				type: "get",
				dataType: "json",
				data: $(this).serialize(),
				success: function(result){
					$("#modal-input").modal("hide");					
					alert("Data Updated! New Product has been updated with code" + result.productModel.code);
					listDataProduct();
				}				
			});
			return false;
		});
		
		$("#modal-input").on("submit","#form-product-delete", function(){
			$.ajax({
				url: "product/delete/save.json",
				type: "get",
				dataType: "json",
				data: $(this).serialize(),
				success: function(result){
					$("#modal-input").modal("hide");					
					alert("Data Deleted! Data Product has been add with code " +  result.productModel.code + " has been deleted!");
					listDataProduct();
				}				
			});
			return false;
		});

	
	$("#list-data-product").on("click", "#button-detail", function(){
		var idDetail = $(this).val();
		$.ajax({
			url: "product/detail.html",
			type: "get",
			dataType: "html",
			data: {id:idDetail},
			success: function(result){
				$("#modal-input").find(".modal-dialog").html(result);
				$("#modal-input").modal("show");					
			}				
		});	
	});	
	
	$("#list-data-product").on("click", "#button-edit", function(){
		var idDetail = $(this).val();
		$.ajax({
			url: "product/edit.html",
			type: "get",
			dataType: "html",
			data: {id:idDetail},
			success: function(result){
				$("#modal-input").find(".modal-dialog").html(result);
				$("#modal-input").modal("show");					
			}				
		});	
	});
	
	$("#list-data-product").on("click", "#button-delete", function(){
		var idDelete = $(this).val();
		$.ajax({
			url: "product/delete.html",
			type: "get",
			dataType: "html",
			data: {id:idDelete},
			success: function(result){
				$("#modal-input").find(".modal-dialog").html(result);
				$("#modal-input").modal("show");					
			}				
		});	
	});	
	
	$("#form-product-search").on("submit", function(){
		var codeSearch = document.getElementById("codeSearch").value;
		
		$.ajax({
			url: "product/search/code.html",
			type: "get",
			dataType: "html",
			data : {codeSearch:codeSearch},
			success: function(result){
				$("#list-data-product").html(result);					
			}				
		});
		return false;
		
	});	
	
	$("#form-product-search").on("submit", function(){
		var nameSearch = document.getElementById("nameSearch").value;
		$.ajax({
			url: "product/search/name.html",
			type: "get",
			dataType: "html",
			data : {nameSearch:nameSearch},
			success: function(result){
				$("#list-data-product").html(result);					
			}				
		});
		return false;
		
	});	
	
	
	
});
</script>