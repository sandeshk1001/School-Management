<!DOCTYPE html>
<html lang="en">
<head>
	<title>forgot</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="../../assets/login/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../assets/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../assets/loginfonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../assets/login/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="../../vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="../../vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../assets/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="../../assets/login/css/main.css">
<!--===============================================================================================-->
</head>
<body>
    <div class="limiter" >
		<div class="container-login100" style="background-image: url('../../assets/login/images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                            <form class="login100-form validate-form" action="forgot_check.jsp" method="post">
					<span class="login100-form-title p-b-49">
						Forgot Password
					</span>
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100">Roll No</span>
						<input class="input100" type="text" name="rollno" placeholder="Type your username">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
                                        <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100">Name</span>
						<input class="input100" type="text" name="name" placeholder="Type your Email">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
                                        <div class="text-right p-t-8 p-b-31">
						<a onclick="back_forgot()">
							Back
						</a>
					</div>
										
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
                                                        <button class="login100-form-btn" type="submit" >Conform</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="dropDownSelect1"></div>
	
       
<!--===============================================================================================-->
	<script src="../../assets/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../../assets/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="../../assets/vendor/bootstrap/js/popper.js"></script>
	<script src="../../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="../../assets/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="../../assets/vendor/daterangepicker/moment.min.js"></script>
	<script src="../../assets/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="../../assets/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="../../assets/login/js/main.js"></script>

</body>
</html>