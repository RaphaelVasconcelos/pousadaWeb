<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
    <link href="viewResources/css/bootstrap.css" rel="stylesheet">
    <link href="viewResources/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->
</head>
<body>

<h2>Registro de quarto</h2>
<form:form method="POST" action="/quartoComumLiberado">
	<form:select path="numero" items="${quartos}" />
    <button type="submit" class="btn">Submit</button>
</form:form>
</body>
</html>