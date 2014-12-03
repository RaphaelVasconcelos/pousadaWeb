<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap, from Twitter</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
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

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
  	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="../assets/ico/favicon.png">
  </head>
	<body>
		<jsp:include page="menu.jsp"/> 
		<h2>Registro de quarto</h2>
	
		<ul id="myTab" class="nav nav-tabs">
	      <li class="active"><a href="#quartoComum" data-toggle="tab">Quarto Comum</a></li>
	      <li class=""><a href="#chale" data-toggle="tab">Chale</a></li>
	    </ul>
		
		<div id="myTabContent" class="tab-content">
          <div class="tab-pane fade active in" id="quartoComum">
            <form:form method="POST" action="/quartoRegistrado">
				<c:choose>
			        <c:when test="${todosOcupados}">
			            <i class="icon-warning-sign"></i> Todos os quartos estão ocupados
			        </c:when>
			        <c:otherwise>
			            <form:select path="numero" items="${quartos}" />
			            <form:label path="possuiBanheira" class="checkbox">
					    <form:checkbox path="possuiBanheira"/> Banheira
					    </form:label>
					    <button type="submit" class="btn">Submit</button>
			        </c:otherwise>
			    </c:choose>
			</form:form>
          </div>
          <div class="tab-pane fade" id="chale">
            porquinho da india
          </div>
        </div>
         <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="viewResources/js/bootstrap.js"></script>
    <script src="viewResources/js/bootstrap.min.js"></script>
    
    
	</body>
</html>