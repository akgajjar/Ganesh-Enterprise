<%@page import="java.util.Base64"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>

<%@page import="com.bean.product_imagesbean"%>
<%@page import="com.model.category_product_mastermodel"%>
<%@page import="com.bean.user_masterbean"%>
<%@page import="com.bean.category_masterbean"%>
<%@page import="java.util.List"%>
<%@page import="com.model.category_mastermodel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<!--  Header Css -->

<title>Modernize an Admin Panel Category Bootstrap Responsive
	Web Template | Home :: w3layouts</title>
<!-- Meta Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords"
	content="Modernize Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- //Meta Tags -->

<!-- Style-sheets -->
<!-- Bootstrap Css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Bootstrap Css -->

<!-- Common Css -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--// Common Css -->
<!-- Nav Css -->
<link rel="stylesheet" href="css/style4.css">
<!--// Nav Css -->
<!-- Fontawesome Css -->
<link href="css/fontawesome-all.css" rel="stylesheet">
<!--// Fontawesome Css -->
<!--// Style-sheets -->

<!--web-fonts-->
<link href="//fonts.googleapis.com/css?family=Poiret+One"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
	rel="stylesheet">
<!--//web-fonts-->

<!-- form -->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<!-- <link rel="stylesheet" href="css/registrationcss/css/style.css">
 -->
<link href="css/registrationcss/stureg1.css" rel='stylesheet'
	type='text/css' media="all" />



<style type="text/css">
h1, h2, h3, h4, h5, h6 {
	margin: 0;
	font-weight: 400;
	transition: 0.5s all;
	-webkit-transition: 0.5s all;
	-moz-transition: 0.5s all;
	-o-transition: 0.5s all;
	-ms-transition: 0.5s all;
}

h1 {
	font-size: 45px;
	font-weight: 500;
	text-align: center;
	text-transform: capitalize;
	letter-spacing: 3px;
	margin: 40px 0 40px 0;
	color: #fff;
	font-family: 'Josefin Sans', sans-serif;
}

.w3l-lef1 h3 {
	font-size: 25px;
	color: #ffd200;
	margin: 0.5em 0 0.5em;
	text-transform: capitalize;
	font-family: 'Josefin Sans', sans-serif;
}

.my{
padding-top:2em;
padding-right: 2em;

}
</style>

<!-- form -->
</head>


<%
	user_masterbean user=null;
	if(session!=null)
	{
		if(session.getAttribute("user")!=null)
		{
			user=(user_masterbean)session.getAttribute("user");
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
	}
	else
	{
		response.sendRedirect("index.jsp");
	}
	
	%>
<body
	style="background: url(images/back2.jpeg) no-repeat; background-size: cover; font-family: 'PT Sans', sans-serif; background-attachment: fixed; background-position: center;">






	<div class="se-pre-con"></div>
	<div class="wrapper">
		<!-- Sidebar Holder -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<h1>
					<a href="dashboard.jsp">Ganesh Enterprise</a>
				</h1>
				<span>M</span>
			</div>
			<div class="profile-bg"></div>
			<ul class="list-unstyled components">
				<li class="active"><a href="dashboard.jsp"> <i
						class="fas fa-th-large"></i> Dashboard
				</a></li>
				<li><a href="#homeSubmenu" data-toggle="collapse"
					aria-expanded="false"> <i class="fas fa-laptop"></i> Category <i
						class="fas fa-angle-down fa-pull-right"></i>
				</a>
					<ul class="collapse list-unstyled" id="homeSubmenu">
						<li><a href="createcatpro.html">Add Category</a></li>
						<li><a href="showallcats.jsp">Show All Categories</a></li>

					</ul></li>
				<!-- <li><a href="charts.html"> <i class="fas fa-chart-pie"></i>
						Charts
				</a></li>
				<li><a href="grids.html"> <i class="fas fa-th"></i> Grid
						Layouts
				</a></li>
				<li><a href="#pageSubmenu1" data-toggle="collapse"
					aria-expanded="false"> <i class="far fa-file"></i> Pages <i
						class="fas fa-angle-down fa-pull-right"></i>
				</a>
					<ul class="collapse list-unstyled" id="pageSubmenu1">
						<li><a href="404.html">404</a></li>
						<li><a href="500.html">500</a></li>
						<li><a href="blank.html">Blank</a></li>
					</ul></li>
				<li><a href="mailbox.html"> <i class="far fa-envelope"></i>
						Mailbox <span
						class="badge badge-secondary float-md-right bg-danger">5
							New</span>
				</a></li>
				<li><a href="widgets.html"> <i
						class="far fa-window-restore"></i> Widgets
				</a></li>
				<li><a href="pricing.html"> <i class="fas fa-table"></i>
						Pricing Tables
				</a></li>
				<li><a href="#pageSubmenu3" data-toggle="collapse"
					aria-expanded="false"> <i class="fas fa-users"></i> User <i
						class="fas fa-angle-down fa-pull-right"></i>
				</a>
					<ul class="collapse list-unstyled" id="pageSubmenu3">
						<li><a href="login.html">Login</a></li>
						<li><a href="register.html">Register</a></li>
						<li><a href="forgot.html">Forgot password</a></li>
					</ul></li>
				<li><a href="maps.html"> <i class="far fa-map"></i> Maps
				</a></li> -->
			</ul>
		</nav>

		<!-- Page Content Holder -->
		<div id="content" style="width: 100%;">
			
 
			<!-- Required common Js -->
			<script src='js/jquery-2.2.3.min.js'></script>
			<!-- //Required common Js -->

			<!-- loading-gif Js -->
			<script src="js/modernizr.js"></script>
			<script>
				//paste this code under head tag or in a seperate js file.
				// Wait for window load
				$(window).load(function() {
					// Animate loader off screen
					$(".se-pre-con").fadeOut("slow");
					;
				});
			</script>
			<!--// loading-gif Js -->

			<!-- Sidebar-nav Js -->
			<script>
				$(document).ready(function() {
					$('#sidebarCollapse').on('click', function() {
						$('#sidebar').toggleClass('active');
					});
				});
			</script>
			<!--// Sidebar-nav Js -->


			<!-- dropdown nav -->
			<script>
				$(document).ready(
						function() {
							$(".dropdown").hover(
									function() {
										$('.dropdown-menu', this).stop(true,
												true).slideDown("fast");
										$(this).toggleClass('open');
									},
									function() {
										$('.dropdown-menu', this).stop(true,
												true).slideUp("fast");
										$(this).toggleClass('open');
									});
						});
			</script>
			<!-- //dropdown nav -->

			<!-- Js for bootstrap working-->
			<script src="js/bootstrap.min.js"></script>
			<!-- //Js for bootstrap working -->

			<!-- <form name="frm" method="post">
	<b>Search  Here: </b><input type="text" name="empname" onkeyup="searchInfo();" placeholder="Enter Name or Username" size="25">
	<span id="tops"></span>
</form> -->

			<%
			int id=Integer.parseInt(request.getParameter("id"));
category_product_mastermodel model=new category_product_mastermodel();
List<product_imagesbean> list=model.getimagebyid(id);
			
			
%>



			<br />

			<div class="h">
				<h1>
					<b><font color="white">Remove Images</font></b>
				</h1>
			</div>
			<br />
<!-- 
			<div class="w3l-main">
				<div class="w3l-from">
					<form action="productimageuploadcontroller" method="post"
						name="catadd" id="catadd"  enctype="multipart/form-data" >


					<div class="w3l-options2" style="width: 100%;">
							<label class="head">Images<span class="w3l-star">
									* </span></label> 
									
									
									<input name="file" type="file" id="file" multiple>
						</div>


						<div class="btn" style="text-align: center;">
							<input type="submit" name="action" id="action"
								value="Add Images">
						</div>

						<div class="btn">
							<input type="submit" name="action" value="back">
						</div>
				</form>
			</div>
			</div>
 -->
 
 <div class="w3l-main">
				<div class="w3l-from">
			
 	<%
 		for(product_imagesbean b : list)
 		{
 			Blob image=b.getImg();
 			byte[ ] imgData =null;
 			
 			imgData = image.getBytes(1,(int)image.length());
 			
 			String encode = Base64.getEncoder().encodeToString(imgData);
 			System.out.println("hii");
 			%>
 			
 			
 			<img alt="" src="data:image/jpeg;base64,<%=encode%>" height="500px" class="my" width="500px">
 			<form action="product_imagescontroller" method="post">
 				
 					<div class="btn" style="text-align: center;">
 					
 						<input type="hidden" name="id" value="<%=b.getProimg_Id() %>">
							<input type="submit" name="action" id="action"
								value="Remove Image">
						</div>
 				
 			
 			</form>
 			<br/>

 			<%
 		}
 	%>
</div>
			</div> 
 		</div>
	</div>

</body>
</html>
