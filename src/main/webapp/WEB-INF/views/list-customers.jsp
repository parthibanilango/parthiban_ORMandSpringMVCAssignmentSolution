<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<title>Customer Relationship Management Portal</title>
	</head>
	<body>
		<div class="container">
		
			<div class="p-3 mb-2 bg-success text-white rounded">
				<h1>Customer Relationship Management</h1>
			</div>
			
			<div class="row">
			<h2>
				<a href="/crmapp/customers/new" class="btn btn-secondary btn-sm float-end">Add a customer</a>
			</h2>
			</div>
			<div class="row">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th class="text-center align-middle">First Name</th>
						<th class="text-center align-middle">Last Name</th>
						<th class="text-center align-middle">Email</th>
						<th class="text-center align-middle">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Customers}" var="tmpCustomer">
						<tr >
							<td class="text-center align-middle"><c:out value="${tmpCustomer.firstName}" /></td>
							<td class="text-center align-middle"><c:out value="${tmpCustomer.lastName}"/></td>
							<td class="text-center align-middle"><c:out value="${tmpCustomer.email}" /></td>
							<td class="text-center align-middle">
								
									<a href="/crmapp/customers/edit?id=${tmpCustomer.id}" class="btn btn-secondary btn-sm">Update</a>
									<a href="/crmapp/customers/delete?id=${tmpCustomer.id}" class="btn btn-danger btn-sm" onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">Delete</a>
								
							</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
		
	</body>
</html>