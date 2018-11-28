<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="panel-group">
<div class="panel panel-primary">
	<div class="panel-heading">Settlement Souvenir Request - ${souvenirSettlementModel.code}</div>
	<form method="get" id="form-souvenir-settlement-request-settlement">
		<div class="panel-body">
		<div class="col-xs-7">
			<table class="table" style="border:none;">
				<tr>
					<td align="right">
						*Transaction Code	
					</td>
					<td>
						 <input type="hidden" id="id" name="id" class="form-control col-xs-2" value="${souvenirSettlementModel.id}"/>						
						 <input type="text" id="code" name="code" class="form-control col-xs-2" value="${souvenirSettlementModel.code}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						*Event Code	
					</td>
					<td>	
					     <select class="form-control" id="eventName" name="eventName" disabled="disabled">
						     <option selected>- Select Event Code -</option>
						    
						     <c:forEach items ="${eventModelList}" var="eventModel">
							    <option value="${eventModel.id}"
							    				${eventModel.id == souvenirSettlementModel.tEventId ? 'selected="true"':'' }>
							    				${eventModel.code}
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
						<input type="hidden" id="requestBy" name="requestBy" class="form-control" value="${requestBy}"/>
						<input type="text" id="requestByUser" name="requestByUser" class="form-control" value="${requestByUser.username}" readonly="readonly"/>
					</td>
				
				</tr>
				<tr>
					<td align="right">
						*Request Date	
					</td>
					<td>
						<%--  <input type="text" id="requestDate" name="requestDate" class="form-control" 
						 value="<fmt:formatDate value="${souvenirSettlementModel.request_date}" pattern="dd/MM/yyyy"/>" readonly="readonly"/> --%>
						 	<fmt:formatDate value="${souvenirSettlementModel.request_date}" pattern="dd/MM/yyyy"/>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						*Due Date	
					</td>
					<td>
						 <%-- <div class="input-group date">
							<input type="text" class="form-control" id="dueDate" name="dueDate" 
							value="<fmt:formateDate value="${souvenirSettlementModel.dueDate}" pattern="dd/MM/yyyy"/>"readonly="readonly"/> 
							<div class="input-group-addon">
							<i class="fa fa-calendar"></i>
							</div>
						</div> --%>
						<fmt:formatDate value="${souvenirSettlementModel.dueDate}" pattern="dd/MM/yyyy"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						Note	
					</td>
					<td>
						 <textarea id="note" name="note" class="form-control" rows="5" cols="4" disabled="disabled">${souvenirSettlementModel.note}
						 </textarea>
					</td>
				</tr>
				<tr>
					<td align="right">
						Status	
					</td>
					<td>
						<c:choose>
							<c:when test="${souvenirSettlementModel.status == 1}">
								<input type="text" class="form-control" value="Submitted" readonly>
							</c:when>
							<c:when test="${souvenirSettlementModel.status == 2}">
								<input type="text" class="form-control" value="In Progress" readonly>
							</c:when>
							<c:when test="${souvenirSettlementModel.status == 3}">
								<input type="text" class="form-control" value="Received By Requester" readonly>
							</c:when>
							<c:when test="${souvenirSettlementModel.status == 4}">
								<input type="text" class="form-control" value="Settlement" readonly>
							</c:when>
							<c:when test="${souvenirSettlementModel.status == 5}">
								<input type="text" class="form-control" value="Approved Settlement" readonly>
							</c:when>
							<c:when test="${souvenirSettlementModel.status == 6}">
								<input type="text" class="form-control" value="Close Request" readonly>
							</c:when>
							<c:when test="${souvenirSettlementModel.status == 0}">
								<input type="text" class="form-control" value="Rejected" readonly>
							</c:when>
							<c:otherwise>
							
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
		</div>
		</div>
			
			
		<div class="panel-body">
			<input type="hidden" id="numberRow" name="numberRow" value="0">
			<div>
				
			</div>
			<div>
			<table class="table" id="table-souvenir-settlement-item">
				<tr style="border-bottom-width: 1;">
					
					<th class="col-xs-4">Souvenir Name</th>
					<th class="col-xs-2">Qty</th>
					<th class="col-xs-2">Qty Actual</th>
					<th class="col-xs-4">Note</th>	
					<th></th>	
				</tr>
				
				<c:forEach items="${souvenirSettlementModel.souvenirSettlementDetailModel}" var="souvenirSettlementDetailModel">
					<tr>
						<td>
							<input type="text" class="form-control" value="${souvenirSettlementDetailModel.souvenirModel.name}" disabled="disabled">
						</td>
						<td>
							<input type="text" class="form-control" value="${souvenirSettlementDetailModel.qty}" size="5" disabled="disabled">
						</td>
						<td>
							<input type="hidden" id="idDetail" name="idDetail" class="form-control col-xs-2" value="${souvenirSettlementDetailModel.id}"/>
							<input type="text" class="form-control" size="5" id="qtyActual" name="qtyActual"/>
						</td>
						<td>
							<input type="text" class="form-control" value="${souvenirSettlementDetailModel.note}" disabled="disabled">
						</td>
					</tr>
				</c:forEach>
				
			</table>
			</div>
		</div>
			<div class="panel-footer" align="right"> 
	               <button type="submit" class="btn btn-primary">Settlement</button>
	              <button type="button" class="btn btn-warning" data-dismiss="modal">Cancel</button>
	     		 </div> 
	</form>		
</div>
</div>


