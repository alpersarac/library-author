<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	
<!DOCTYPE html>

	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>BLOG</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="açıklama" />
	<meta name="keywords" content="arama kelimeleri" />
	<meta name="author" content="Onur Ciner" />


  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">
	<!-- Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
	<!-- Animate -->
	<link rel="stylesheet" href="./../asset/css/animate.css">
	<!-- Icomoon -->
	<link rel="stylesheet" href="./../asset/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="./../asset/css/bootstrap.css">

	<link rel="stylesheet" href="./../asset/css/style.css">


	<!-- Modernizr JS -->
	<script src="./../asset/js/modernizr-2.6.2.min.js"></script>

	</head>
	<body>
	<input type="text" hidden style="display:none" value="${id}" id="id"/>
	
	<div id="fh5co-offcanvas">
		<a href="#" class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i class="icon-cross3"></i> <span>Kapat</span></span></a>
		<div class="fh5co-bio">
			<figure>
				<img src="./../asset/images/person1.jpg" alt="Free HTML5 Bootstrap Template" class="img-responsive">
			</figure>
			<h3 class="heading">Hakkımda</h3>
			<h2>${user.name} ${user.surname}</h2>
			<ul class="fh5co-social">
				<li><a href="logout">Çıkış</li></a>
				
			</ul>
		</div>

	</div>

	<!-- END #fh5co-offcanvas -->
	<header id="fh5co-header">
		
		<div class="container-fluid">

			<div class="row">
				<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
				<ul class="fh5co-social">
					<li><a href="#"><i class="icon-twitter"></i></a></li>
					<li><a href="#"><i class="icon-facebook"></i></a></li>
					<li><a href="#"><i class="icon-instagram"></i></a></li>
				</ul>
				<div class="col-lg-12 col-md-12 text-center">
					<h1 id="fh5co-logo"><a href="index.html">BLOĞUM</a></h1>
				</div>

			</div>
		
		</div>

	</header>
	<!-- END #fh5co-header -->
	<div class="container-fluid">
		<div class="row fh5co-post-entry single-entry">
			<article class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">
				
			
				<h2 class="fh5co-article-title animate-box"><input type="text" id="note_title" placeholder="başlık" disabled="disabled"></h2>
				
				
				<div class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">
					<div class="row">
						<div class="col-lg-8 cp-r animate-box">
							<textarea class="form form-control" id="note_detail" style="height: 400px; width: 100%" placeholder="içerik" disabled="disabled"></textarea>

						</div>
						<div class="col-lg-4 animate-box">
							<div class="fh5co-highlight right">
								
									<button class="btn btn-primary" style="width: 100%" onclick="update()" id="updateBtn">GÜNCELLE</button>
									<br>
									<button class="btn btn-danger" style="width: 100%" onclick="deleteNote()">SİL</button>
							</div>
						</div>
					</div>

				</div>

			</article>
		</div>
	</div>

	<footer id="fh5co-footer">
		<p><small>&copy; Alper SARAÇ 2020.</small></p>
	</footer>
	
	<!-- jQuery -->
	<script src="./../asset/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="./../asset/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="./../asset/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="./../asset/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="./../asset/js/main.js"></script>
	<!-- Main JS -->
	<script src="./../asset/custom/detail.js"></script>
	

	</body>
</html>

