<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>My Crud</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/bootstrap.min.css" />">


<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="row">

			<div class="row">
				<div class="col-sm-8">
				<form:form action="${typeclass}" commandName="nurse" method="get">
					<h4 class="page-header"> ${type} form</h4>
					
						<div class="form-group float-label-control">
							<label for="">Username</label> 
							<form:input path="name" class="form-control"/>
						</div>
						
						<div class="form-group float-label-control">
							<label for="">Birth</label> 
							<form:input path="birth" class="form-control"/>
						</div>
						
						<c:if test="${type.equals('Patient')}">
							<div class="form-group float-label-control">
								<label for="">Add a Nurse</label> 
									<a href="#">
								          <span class="glyphicon glyphicon-plus-sign"></span>
								    </a>
								<form:input path="name" class="form-control"/>
							</div>
					    </c:if>  
						 
					   <button type="submit" class="btn btn-secondary">Register a ${type}</button>
				  </form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>