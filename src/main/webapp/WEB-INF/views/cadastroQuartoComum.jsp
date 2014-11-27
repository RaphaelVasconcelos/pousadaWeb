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
<form:form method="POST" action="/quartoRegistrado">
	<form:select path="numero" items="${quartos}" />
	<form:label path="numero">Numero</form:label>
	<form:input path="numero" type="text" placeholder="Numero do quarto" />
    <form:label path="possuiBanheira" class="checkbox">
    <form:checkbox path="possuiBanheira"/> Banheira
    </form:label>
    <button type="submit" class="btn">Submit</button>
</form:form>
</body>
</html>