<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel-group">
<div class="panel panel-primary">
	<div class="panel-heading">Add Souvenir Request</div>
	<form method="get" id="form-souvenir-settlement-request-add">
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
							    <option value="${eventModel.id}">${eventModel.code}
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
						<input type="hidden" id="requestBy" name="requestBy" class="form-control" value="${requestBy}" readonly="readonly"/>
						<input type="text" id="requestByUser" name="requestByUser" class="form-control" value="${requestByUser.username}" readonly="readonly"/>
					</td>
				
				</tr>
				<tr>
					<td align="right">
						*Request Date	
					</td>
					<td>
						 <input type="text" id="requestDate" name="requestDate" class="form-control" value="${date}" readonly="readonly"/>
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
						 <textarea id="note" name="note" class="form-control" rows="5" cols="4"></textarea>
					</td>
				</tr>
			</table>
		</div>
		</div>
			
			
		<div class="panel-body">
			<input type="hidden" id="numberRow" name="numberRow" value="0">
			<div>
				<button type="button" class="btn btn-primary btn-md add-more" onclick="addItem();"><i class="glyphicon glyphicon-plus"></i>&nbsp; Add Item</button>
			</div>
			<div>
			<table class="table" id="table-souvenir-settlement-item">
				<tr style="border-bottom-width: 1;">
					
					<th class="col-xs-4">Souvenir Name</th>
					<th class="col-xs-2">Qty</th>
					<th class="col-xs-4">Note</th>	
					<th></th>	
				</tr>
				
				<tbody id="list-data-item-souvenir-settlement-request">
				
				</tbody>
				
			</table>
			</div>
		</div>
			<div class="panel-footer" align="right"> 
	              <button type="submit" class="btn btn-primary">Save</button>
	              <button type="button" class="btn btn-warning" data-dismiss="modal">Cancel</button>
	     		 <!--  <button type="reset" class="btn btn-warning">Reset</button> -->
    		 </div> 
	</form>		
</div>
</div>

<script type="text/javascript">
	
	function addItem(){
		var table = document.getElementById("table-souvenir-settlement-item");
		var row = table.insertRow(1);
		var numberRow = document.getElementById("numberRow").value;
		var tableRow =table.rows.length - 2;
		var number = 0;
		
		if (tableRow == 0) {
			document.getElementById("numberRow").value = tableRow;
			number = tableRow;
		} else {
			document.getElementById("numberRow").value = parseInt(numberRow) + 1;
			number = parseInt(numberRow) + 1
		}
		
		var souvenirName = row.insertCell(0);
		var qty = row.insertCell(1);
		var note = row.insertCell(2);
		var actionedit = row.insertCell(3);
		var actiondelete = row.insertCell(4);
		
		souvenirName.innerHTML = 
			'<select class="form-control" id="idSouvenir_'+number+'" name="idSouvenir_'+number+'">' 
				+'<option selected>- Select Souvenir -</option>'
					+'<c:forEach var="souvenirModel" items="${souvenirModelList}">'							
						+'<option value="${souvenirModel.id}-${souvenirModel.name}">'
							+'${souvenirModel.name}'
						+'</option>'
					+'</c:forEach>'
			+'</select>';
		qty.innerHTML = '<input type="text" id="qty_'+number+'" name="qty_'+number+'" size="5" class="form-control" />';
		note.innerHTML = '<input type="text" id="note_'+number+'" name="note_'+number+'" size="20"  class="form-control" />';
		actionedit.innerHTML = '<button type="button" style="border: none;padding: 0;background: none;" id="btn-edit" ><i class="fa fa-pencil"></i></button>';
		actiondelete.innerHTML = '<button type="button" style="border: none;padding: 0;background: none;" id="btn-delete"  onclick="deleteItem(this)" ><i class="fa fa-trash"></i></button>';

	}

	function deleteItem(baris){
		var parentRowIndex = baris.parentNode.parentNode.rowIndex;
		document.getElementById("table-souvenir-settlement-item").deleteRow(parentRowIndex);
	}
	
	
    $(document).ready(function() {
    	
	//DUEDATE
      $('#dueDate').datepicker({
		    autoclose: true,
		    format: 'dd-mm-yyyy'
		 });
	
    });

</script>

