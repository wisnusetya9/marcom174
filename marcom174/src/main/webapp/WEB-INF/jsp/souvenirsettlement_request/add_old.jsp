<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel-group">
<div class="panel panel-primary">
	<div class="panel-heading">Add Souvenir Request</div>
	<form method="get" id="form-product-souvenirsettlement_request">
		<div class="panel-body">
		<div class="col-xs-7">
			<table class="table" style="border:none;">
				<tr>
					<td align="right">
						*Trans Code	
					</td>
					<td>
						 <input type="text" id="code" name="code" class="form-control col-xs-2" value="${codeAuto}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						*Event Code	
					</td>
					<td>	
					     <select class="form-control" id="eventName" name="eventName">
						     <option selected>- Select Event Code -</option>
						    
						     <c:forEach items ="${eventModelList}" var="eventModel">
							    <option value="${eventModel.id}">${eventModel.eventName}
							    </option>\
						     </c:forEach>
						     	
						  </select>
						
				       
					</td>
				</tr>
				<tr>
					<td align="right">
						*Request By 	
					</td>
					<td>
						<input type="text" id="requestBy" name="requestBy" class="form-control" value="${requestBy}" readonly="readonly"/>
					</td>
				
				</tr>
				<tr>
					<td align="right">
						*Request Date	
					</td>
					<td>
						 <input type="text" id="date" name="date" class="form-control" value="${date}" readonly="readonly"/>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						*Due Date	
					</td>
					<td>
						 <div class="input-group date">
							<input type="text" class="form-control pull-right" id="dueDate" name="dueDate" placeholder="Select Date"/> 
							<div class="input-group-addon">
							<i class="fa fa-calendar"></i>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td align="right">
						Note	
					</td>
					<td>
						 <textarea class="form-control" rows="5" cols="4"></textarea>
					</td>
				</tr>
			</table>
		</div>
		</div>
			</form>
			
		<div class="panel-body">
			<div>
				<button type="button" class="btn btn-primary btn-md add-more"><i class="glyphicon glyphicon-plus"></i>&nbsp; Add Item</button>
			</div>
			<div>
			<table class="table">
			<tr style="border-bottom-width: 1;">
			<th></th>
				<th class="col-xs-4">Souvenir Name</th>
				<th class="col-xs-2">Qty</th>
				<th class="col-xs-4">Note</th>	
				<th></th>	
			</tr>
			</table>
			</div>
			<form action="">
			<div class="input-group control-group after-add-more">
				<div class="col-sm-4"><input class="form-control"></div>
				<div class="col-sm-2"><input class="form-control"></div>
				<div class="col-sm-4"><input class="form-control"></div>
				<div>			
					<button type="button" style="background: none; border: 0; " id="button-edit"><i class="fa fa-pencil"></i></button>
					<button type="button" style="background: none; border: 0; " id="button-delete"><i class="fa fa-trash"></i></button>
				</div>
			</div>
			</form>
			<!-- copy addmore -->
        <div class="copy-fields hide">
          <div class="control-group input-group" style="margin-top:10px">
				<div class="col-sm-4"><input class="form-control"></div>
				<div class="col-sm-2"><input class="form-control"></div>
				<div class="col-sm-4"><input class="form-control"></div>
            <div> 
              <button type="button" style="background: none; border: 0; " id="button-edit"><i class="fa fa-pencil"></i></button>
			  <button class="remove" type="button" style="background: none; border: 0; " id="button-delete"><i class="fa fa-trash"></i></button>
            </div>
          </div>
        </div>			
			<!-- copy addmore -->
			
		</div>
		</div>
			<div class="panel-footer" align="right"> 
	              <button type="submit" class="btn btn-primary">Save</button>
	              <button type="button" class="btn btn-warning" data-dismiss="modal">Cancel</button>
	     		 <!--  <button type="reset" class="btn btn-warning">Reset</button> -->
    		 </div> 
					
</div>

<script type="text/javascript">

    $(document).ready(function() {

	//here first get the contents of the div with name class copy-fields and add it to after "after-add-more" div class.
      $(".add-more").click(function(){ 
          var html = $(".copy-fields").html();
          $(".after-add-more").after(html);
      });
	//here it will remove the current value of the remove button which has been pressed
      $("body").on("click",".remove",function(){ 
          $(this).parents(".control-group").remove();
      });

	//DUEDATE
      $('#dueDate').datepicker({
		    autoclose: true,
		    format: 'dd-mm-yyyy'
		 });
	
    });

</script>

