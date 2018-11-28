<div class="panel panel-primary">
	<div class="panel-heading">Edit Product - ${productModel.name} ( ${productModel.code} )   </div>
	<form method="get" id="form-product-edit">
		<div class="panel-body">
			<input type="hidden" id="id" name="id" value="${productModel.id}" />
			<table class="table" >
				<tr>
					<td>
						Product Code	: 
					</td>
					<td>
						<input type="hidden" id="code" name="code" value="${productModel.code}"/>
			  		  	<input type="text" class="form-control" id="code_disabled" name="code_disabled" value="${productModel.code}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td>
						Product Name	:
					</td>
					<td>	
						 <input type="text" class="form-control" id="name" name="name" value="${productModel.name}" />
						 <a style="font-size: small; color: red; display: none;" id="alertNameProduct">Name must be filled out!</a>
						 <a style="font-size: small; color: red; display: none;" id="alertNameProductSame">Product name is exist !</a>
					</td>
				</tr>
				<tr>
					<td>
						Description 	:
					</td>
					<td>
						 <input type="text" class="form-control" id="description" name="description" value="${productModel.description}" />
					</td>
				</tr>
	
			</table>
		</div>
	<div class="panel-footer">
		<button type="submit" class="btn btn-primary">Update</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Cancel</button>
    </div>
	</form>
</div>