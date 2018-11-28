<nav class = "navbar-fixed-top">
<header class="main-header">
    <!-- Logo -->
    <a href="/marcom174/" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>MARCOM</b>174</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
		
		
          
    <!-- Control Sidebar Toggle Button -->
      <div class="navbar-custom-menu">
      <ul class="nav navbar-nav">
        <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
             <%--  <img src="${contextName}/assets/img/ft1.JPG" class="user-image" alt="User Image"> --%>
              <span class="hidden-xs">Hy, ${username}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <%-- <li class="user-header">
                <img src="${contextName}/assets/img/ft1.JPG" class="img-circle" alt="User Image">

                <p>
                  ${username}- Peserta Bootcamp
                  <small>Member since 09/18</small>
                </p>
              </li> --%>
              
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <form method="post" action="<c:url value="/j_spring_security_logout" />">
                		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
                		<button type="submit" class="btn btn-default btn-flat">Sign Out</button>
                	</form>
                </div>
              </li>
            </ul>
          </li>
          </ul> 
          <div>
          	
          </div>
         </div>
    <%--     <div class="pull-right">
        			
                	<form method="post" action="<c:url value="/j_spring_security_logout" />">
                		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
                		<button type="submit" class="btn btn-default btn-flat">Sign Out</button>
                	</form>
                </div> --%>
     
    </nav>
  </header>
  </nav>