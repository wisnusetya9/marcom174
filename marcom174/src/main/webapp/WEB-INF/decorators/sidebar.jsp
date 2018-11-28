
<nav class="navbar" style="height: 100%; position: fixed;"
	role="navigation">
	<aside class="main-sidebar">

		<section class="sidebar">
			<ul class="sidebar-menu">
				<li class="header">MARCOM 174</li>
				<li>
					<a href="#"><i class="fa fa-book"></i><span>MENU</span><span class="pull-right-container"> </span></a>
					<ul class="treeview-menu">
						<li>
							<c:forEach items ="${menuModelList}" var="menuModel">
								<a href="${contextName}/${menuModel.controller}.html">
									<i class="fa fa-circle-o"></i>${menuModel.nama}
								</a> 
							</c:forEach>	
						</li>
						
					</ul>
					
				</li>
		<%-- 		<li>
					<a href="#"><i class="fa fa-exchange"></i><span>Transaksi</span><span class="pull-right-container"> </span></a>
					<ul class="treeview-menu">
						<li>
							
								<a href="${contextName}/souvenirsettlement_request.html">
									<i class="fa fa-circle-o"></i>Souvenir Settlement Request
								</a> 
							
						</li>
						
					</ul>
					
				</li> --%>
				
			</ul>
		</section>
		<!-- /.sidebar -->
	</aside>
</nav>