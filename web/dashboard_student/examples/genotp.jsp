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
                           <form onsubmit="validateOTP()" >
				<span class="login100-form-title p-b-49">Forgot Password</span>
                                    <div class="" data-validate = "OTP is reauired">
                                          <h3>One Time Password</h3><small>verification</small> 
                                            <br><br>
                                            We have send you OTP on Email: <span id="optNo"><%= session.getAttribute("mob") %></span>
                                    </div>
                                        <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100"></span>
                                                <input id="inOTP" type="tel" class=" input100"" autocomplete="off" maxlength="6" placeholder="Enter OTP" required>
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
                                        <div class="" data-validate = "OTP is reauired"><center>
                                            <p class="label-input100" style="color: red;">OTP will be distroy in : <span id="timer">180</span> seconds. </p>
                                            </center>	
					</div>
                                            	
					<div class="container-login100-form-btn">
					<div class="wrap-login100-form-btn">
						<div class="login100-form-bgbtn"></div>
                                                        <button type="submit" value="Resend" class="login100-form-btn" >Submit</button>
                    
					</div>
                                        </div>
                           </form>
                                        <br>
                                        <div class="container-login100-form-btn">
					<div class="wrap-login100-form-btn">
						<div class="login100-form-bgbtn"></div>
                                                        <button type="button" value="Resend" class="login100-form-btn" onclick="generateOTP()">Resend</button>
                    
					</div>
                                        </div>
			</div>
		</div>
	</div>
	<div id="dropDownSelect1"></div>
       
<script>
    var counter = 180;  //3 minutes.
    
    setInterval(function(){
        var x = document.getElementById("timer").innerHTML;
        if(x != '0'){
            document.getElementById("timer").innerHTML=counter;
                counter = counter-1;
            }
        
    },1000); 
    
    var OTP = <%= session.getAttribute("otpcode") %> ;
    alert(OTP);
    
    function validateOTP(){
        var t = document.getElementById("timer").innerHTML;
        if(t != '0')
        {
                event.preventDefault();
                debugger
                if (document.getElementById("inOTP").value == OTP) 
		{
                    alert("Valid OTP")
                    window.open("forgot_main.jsp?s=true","_self");    
                }
            else{
                alert("You entered wrong OTP"); 		
                } 
        }
    }
    
    function generateOTP()
    {
		window.open("functions/genotp.jsp","_self");        
    }

    
</script>
	
       
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
 
 