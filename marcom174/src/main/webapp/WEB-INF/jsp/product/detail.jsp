<div class="panel panel-primary">
	<div class="panel-heading">View Product  - ${productModel.name} ( ${productModel.code} )  </div>
	<form method="get" id="form-product-detail">
		<div class="panel-body">
			<input type="hidden" id="id" name="id" value="${productModel.id}" />
			<table class="table" >
			
			<tr>
				<td>
					Product Code		:
				</td>
				<td>
					 <input type="hidden" id="code" class="form-control" name="code" value="${productModel.code}"/><br/>
			  		 <input type="text" id="kode_disabled" class="form-control" name="kode_disabled" value="${productModel.code}" disabled="disabled"/>
				</td>
			</tr>
			<tr>
				<td>
					Product Name		:
				</td>
				<td>
					<input type="text" id="name" name="name" class="form-control" value="${productModel.name}" disabled="disabled"/>
				</td>
			
			</tr>
	 		<tr>
	 			<td>
	 				Description 	:
	 			</td>
	 			<td>
	 				 <input type="text" id="description" name="description" class="form-control" value="${productModel.description}" disabled="disabled"/><br/><br/><br/>
	 			</td>
	 			
	 		</tr>
	
			</table>
		</div>
		<div class="panel-footer">
			<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
   		 </div>
	</form>		
</div>