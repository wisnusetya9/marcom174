<div class="col-md-4" style="margin-left: 40%; margin-top: 40%">
<div class="box box-default box-solid" style="width: fit-content; position: absolute; ">
	<div class="box-header with-border" align="center">
    	<h3 class="box-title">Delete Data ?</h3>
        <div class="box-tools pull-right">
	        <button type="button" class="btn btn-box-tool" data-dismiss="modal"><i class="fa fa-times"></i></button>
        </div>
        <!-- /.box-tools -->
     </div>
     
     <!-- /.box-header -->
	<div class="box-body" align="center">
		<form method="get" id="form-product-delete">
			<input type="hidden" id="id" name="id" value="${productModel.id}" />	
		          <button type="submit" class="btn btn-primary">Delete</button>
	              <button type="button" class="btn btn-warning" data-dismiss="modal">Cancel</button>
		</form>
	</div>
    <!-- /.box-body -->
</div>

</div>
