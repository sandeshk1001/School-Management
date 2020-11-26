
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Admission</title>
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Font-->
	<link rel="stylesheet" type="text/css" href="assets/css/opensans-font.css">
	<link rel="stylesheet" type="text/css" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
	<!-- Main Style Css -->
        <link rel="stylesheet" href="assets/css/style_reg.css"/>
        <style>
            .b {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.b {background-color: #008CBA;} /* Blue */
            </style>
            
        
</head>
<body>
    <div class="page-content" >
		<div class="form-v1-content">
			<div class="wizard-form">
                            <form class="form-register" action="admission_std" method="post" enctype="multipart/form-data">
		        	<div id="form-total" style="padding: 50px;">
		        		<!-- SECTION 1 -->
			            <h2><center>
			            	<span class="step-text">Peronal Infomation</span></center>
                                    </h2>
                            <!-------section-------->
			            <section>
			               <div class="inner">
			                	<div class="wizard-header"></div>
                                                                <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Roll No</legend>
											<input type="text" class="form-control" id="phone" name="rollno" placeholder="rollno" required>
										 </fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Full Name</legend>
											<input type="text" class="form-control" id="phone" name="name" placeholder="Name" required>
										 </fieldset>
									</div>
								</div>
								
								
								  <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Date Of Birth</legend>
											<input type="date" class="form-control" id="phone" name="dob" placeholder="dob" >
										 </fieldset>
									</div>
								</div>
                                                                <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Address</legend>
											<input type="text" class="form-control" id="phone" name="address" placeholder="address" >
										 </fieldset>
									</div>
								</div>
                                                                 <div class="form-row">
									<div class="form-holder">
										<fieldset>
											<legend>Cast</legend>
                                            <select name="cast" style="border:none;" >
											<option value="cast" disabled selected>Cast</option>
											<option value="OBC">OBC</option>  
                                            <option value="SC">SC</option> 
                                            <option value="ST">ST</option>  
                                            <option value="general">general</option>  
                                             </select>
										</fieldset>
									</div>
									<div class="form-holder">
										<fieldset>
											<legend>Relesion</legend>
                                            <select name="relesion" style="border:none;" >
											<option value="cast" disabled selected>Relesion</option>
											<option value="hindu">hindu</option>  
                                              <option value="Sikh">Sikh</option> 
                                            <option value="Muslim">Muslim</option>  
                                                                                        
                                            </select>
                                        </fieldset>
									</div>
								</div>
                                           
								
                                   <div class="form-row">
									<div class="form-holder">
										<fieldset>
											<legend>Gender</legend>
                                            <select name="gender" style="border:none;" >
											<option value="cast" disabled selected>Gender</option>
											<option value="Male">Male</option>  
                                            <option value="Female">Female</option> 
                                            <option value="Other">Other</option>   
                                            </select>
										</fieldset>
									</div>
									
								</div>
                                                                <div class="form-row">
									<div class="form-holder">
										<fieldset>
											<legend>Class</legend>
                                                                                        <select name="class" style="border:none;" >
											<option value="" disabled selected>Class</option>
											<option value="1">1</option>  
                                                                                        <option value="2">2</option> 
                                                                                        <option value="3">3</option> 
                                                                                        <option value="4">4</option>  
                                                                                        <option value="5">5</option>  
                                                                                        <option value="6">6</option>    
                                                                                    </select>
										</fieldset>
									</div>
									
								</div>
                                                                
                                          
							</div>
			           
			            </section>
                                        
						<!-- SECTION 2 -->
			            <h2><center>
			            	<span class="step-text">Parent Information</span></center>
			            </h2>
			           <section>
			               <div class="inner">
			                	<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Father's Name</legend>
											<input type="text" class="form-control" id="phone" name="fname" placeholder="father Name" >
										 </fieldset>
									</div>
								</div>
                                                                <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Mother's Name</legend>
											<input type="text" class="form-control" id="phone" name="Mname" placeholder="Mother Name">
										 </fieldset>
									</div>
								</div>
                                           
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Father Occupation</legend>
                                            <input type="text" class="form-control" id="phone" name="focpt" placeholder="Father Occupation">
										 </fieldset>
									</div>
								</div>
                                   <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Mother's Occupation</legend>
											<input type="text" class="form-control" id="phone" name="Mocpt" placeholder="address" >
										 </fieldset>
									</div>
								</div>
                                                                 <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Parent mobile No</legend>
											<input type="text" class="form-control" id="phone" name="fmob" placeholder="Phone" >
										 </fieldset>
									</div>
								</div>
                                          
							</div>
			           
			            </section>
                                                
                <!-------------------------------------------------------------------->
                		<!-- SECTION 3 -->
			            <h2><center>
			            	<span class="step-text">Academic information</span></center>
			            </h2>
			            <section>
			                <div class="inner">
			                  <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Previous School Name</legend>
											<input type="text" class="form-control" id="phone" name="pschool" placeholder="School Name" >
										 </fieldset>
									</div>
								</div>
                                                                <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Previous Class</legend>
											<input type="text" class="form-control" id="phone" name="pclass" placeholder="Class" >
										 </fieldset>
									</div>
								</div>
                                           
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Previous Class Marks</legend>
											<input type="text" class="form-control" id="phone" name="pmarks" placeholder="Previous Marks" >
										 </fieldset>
									</div>
								</div>                             
							</div>
			            </section>
                <!--------------------------------------------------------------------->
			            <!-- SECTION 4 -->
			            <h2><center>
			            	<span class="step-text">Other Infomation</span></center>
			            </h2>
			            <section>
			               <div class="inner">
			                	<div class="wizard-header">
						</div>
                                                                
								
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Your Email</legend>
											<input type="text" name="email" id="email" class="form-control"  placeholder="example@email.com" >
										</fieldset>
									</div>
								</div>
                                                                    <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Phone</legend>
											<input type="text" class="form-control" id="phone" name="phone" placeholder="+91 888-999-7777" >
										</fieldset>
									</div>
								</div>
								<div class="form-row">
                                                                    <div class="form-holder form-holder-2">
										<fieldset>
											<legend>Password</legend>
											<input type="password" class="form-control" id="phone" name="pwd"  placeholder="Password" required>
										</fieldset>
                                                                    </div>
									</div>
								</div>  
                                                                <div class="form-row">
                                                                    <div class="form-holder form-holder-2">
										<fieldset>
											<legend>Photo</legend>
											<input type="file" class="form-control" id="phone" name="file" multiple required>
										</fieldset>
                                                                    </div>
								</div>

                            </section>
                                    <br><br>
                            <section>
			       <div class="inner">
                                   <div class="wizard-header"><center>
                                           <input type="submit" class="b" value="submit" /></center>
                               </div>
                          </div>
                          </div>  
			</div>   
                             </form> 
		        	</div>         
			 </div>
		</div>
	</div>
	<script src="assets/js/jquery-3.3.1.min.js"></script><!--
	<script src="assets/js/jquery.steps.js"></script>-->
	<script src="assets/js/main_reg.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>