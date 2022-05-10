<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

.h-custom {
	height: calc(100% - 73px);
}

@media ( max-width : 450px) {
	.h-custom {
		height: 100%;
	}
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">

				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
					<h1>Login Form</h1>
					<form method="post" action="/LoginServlet" style="margin-top: 50px">

						<!-- Email input -->
						<div class="form-outline mb-4">
							<input type="email" id="form3Example3"
								class="form-control form-control-lg"
								placeholder="Enter a Username" /> <label class="form-label"
								for="form3Example3">UserName</label>
						</div>

						<!-- Password input -->
						<div class="form-outline mb-3">
							<input type="password" id="form3Example4"
								class="form-control form-control-lg"
								placeholder="Enter password" /> <label class="form-label"
								for="form3Example4">Password</label> <a href="#!"
								class="text-body">Forgot password?</a>
						</div>

						<div class="text-center text-lg-start mt-4 pt-2">
							<button type="button" class="btn btn-primary btn-lg"
								style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>

						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
