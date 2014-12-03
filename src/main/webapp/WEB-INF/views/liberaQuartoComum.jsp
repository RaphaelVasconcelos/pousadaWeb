<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

    <title>Spring MVC Form Handling</title>
    <link href="viewResources/css/bootstrap.css" rel="stylesheet">
    <link href="viewResources/css/bootstrap-responsive.css" rel="stylesheet">
	<style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    </style>
	
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="menu.jsp"/> 
<h2>Libera quarto</h2>
<form:form method="POST" action="/quartoComumLiberado">
	<form:select path="numero" items="${quartos}" />
    <button type="submit" class="btn">Submit</button>
</form:form>
</body>
</html>