<!--
=========================================================
 Light Bootstrap Dashboard - v2.0.1
=========================================================

 Product Page: https://www.creative-tim.com/product/light-bootstrap-dashboard
 Copyright 2019 Creative Tim (https://www.creative-tim.com)
 Licensed under MIT (https://github.com/creativetimofficial/light-bootstrap-dashboard/blob/master/LICENSE)

 Coded by Creative Tim

=========================================================

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.  -->
<%@page import="java.sql.*"%>
<%
    String rollno=(String)session.getAttribute("rollno");
    String name = (String)session.getAttribute("name");
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3309/mini_project";
    String uid="root";
    String pass="poly";
    Connection con=DriverManager.getConnection(url, uid, pass);
    String qry="SELECT * FROM std_persional_detail WHERE rollno=? ";
    PreparedStatement ps=con.prepareStatement(qry);
    ps.setString(1,rollno);
    ResultSet rs=ps.executeQuery();
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>User Profile</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <!-- CSS Files -->
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../assets/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="../assets/css/demo.css" rel="stylesheet" />
</head>

<body>
    <div class="wrapper">
        <div class="sidebar" data-image="../assets/img/sidebar-5.jpg">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="http://www.creative-tim.com" class="simple-text">
                        Student
                    </a>
                </div>
                <ul class="nav">
                    <li>
                        <a class="nav-link" href="dashboard_student.jsp">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            <p>Dashboard</p>
                        </a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="./user.jsp">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>User Profile</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="">
                            <i class="nc-icon nc-notes"></i>
                            <p>Result</p>
                        </a>
                    </li>
                    <!--
                    <li>
                        <a class="nav-link" href="./typography.jsp">
                            <i class="nc-icon nc-paper-2"></i>
                            <p>Typography</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="./icons.jsp">
                            <i class="nc-icon nc-atom"></i>
                            <p>Icons</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="./maps.jsp">
                            <i class="nc-icon nc-pin-3"></i>
                            <p>Maps</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="./notifications.jsp">
                            <i class="nc-icon nc-bell-55"></i>
                            <p>Notifications</p>
                        </a>
                    </li>-->
                </ul>
            </div>
        </div>
        <div class="main-panel">
            <!-- Navbar -->
             <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#pablo"> <%=name%> </a>
                    <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar burger-lines"></span>
                        <span class="navbar-toggler-bar burger-lines"></span>
                        <span class="navbar-toggler-bar burger-lines"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <ul class="nav navbar-nav mr-auto">
                            <li class="nav-item">
                                <a href="#" class="nav-link" data-toggle="dropdown">
                                    <i class="nc-icon nc-palette"></i>
                                    <span class="d-lg-none">Dashboard</span>
                                </a>
                            </li>
                           
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="nc-icon nc-zoom-split"></i>
                                    <span class="d-lg-block">&nbsp;Search</span>
                                </a>
                            </li>
                        </ul>
                        <ul class="dropdown navbar-nav ml-auto">
                            <li class="nav-item">
                                <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                                    <i class="nc-icon nc-notification-70"></i>
                                    <span class="notification">5</span>
                                    <span class="d-lg-none"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <a class="dropdown-item" href="#">Notification 1</a>
                                    <a class="dropdown-item" href="#">Notification 2</a>
                                    <a class="dropdown-item" href="#">Another notification</a>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="nc-icon nc-single-02"></i>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="user.jsp">Profile</a>
                                     <a class="dropdown-item" href="#">Change Password</a>
                                    <div class="divider"></div>
                                   
                                    <a class="dropdown-item" href="../../logout">Log out</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="">
                                    <span class="no-icon"></span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="">
                                    <span class="no-icon"></span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            
<%  while(rs.next())
                    {
                        String s1=rs.getString("Rollno");
                        String s2=rs.getString("Scholar_no");
                        String s3=rs.getString("std_name");   
                        String s4=rs.getString("std_DOB");
                        String s5=rs.getString("std_address");
                        String s6=rs.getString("std_Mob"); 
                        String s7=rs.getString("std_Gender");
                        String s8=rs.getString("std_Cast");
                        String s9=rs.getString("releasion");   
                        String s10=rs.getString("std_Email");
                        String s11=rs.getString("class");
                        String s12=rs.getString("Father_name");    
                        String s13=rs.getString("F_occupation");
                        String s14=rs.getString("Mother_name");
                        String s15=rs.getString("Mother_occupation"); 
                        String s16=rs.getString("Parent_Mob"); 
                        String spic=rs.getString("std_photo"); 
%>
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Edit Profile</h4>
                                </div>
                                <div class="card-body">
                                    <form>
                                        <div class="row">
                                            <div class="col-md-3 pr-1">
                                                <div class="form-group">
                                                    <label>Roll No (disabled)</label>
                                                    <input type="text" class="form-control" disabled="" placeholder="Company" value="<%=s1%>">
                                                </div>
                                            </div>
                                            
                                            <div class="col-md-3 px-1">
                                                <div class="form-group">
                                                    <label>Schlar No.(disabled)</label>
                                                    <input type="text" class="form-control" disabled="" placeholder="Company" value="<%=s2%>">
                                                </div>
                                            </div>
                                            <div class="col-md-6 pr-1">
                                                <div class="form-group">
                                                    <label>Mobile No.</label>
                                                    <input type="number" class="form-control" placeholder="" value="<%=s6%>">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 pr-1">
                                                <div class="form-group">
                                                    <label>Full Name</label>
                                                    <input type="text" class="form-control" placeholder="Company" value="<%=s3%>">
                                                </div>
                                            </div>
                                            <div class="col-md-6 pl-1">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1">Email address</label>
                                                    <input type="email" class="form-control" placeholder="Email" value="<%=s10%>">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3 pr-1">
                                                <div class="form-group">
                                                    <label>DOB</label>
                                                    <input type="date" class="form-control" placeholder="Company" value="<%=s4%>">
                                                </div>
                                            </div>
                                            <div class="col-md-3 pl-1">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1">Gender</label>
                                                    <select class="form-control">
                                                        <option>Male</option>
                                                        <option>Female</option>
                                                    </select>
                                                </div>
                                            </div>
                                             <div class="col-md-3 pr-1">
                                                <div class="form-group">
                                                    <label>Cast</label>
                                                    <input type="text" class="form-control" placeholder="Company" value="<%=s8%>">
                                                </div>
                                            </div>
                                            <div class="col-md-3 pr-1">
                                                <div class="form-group">
                                                    <label>Releasion</label>
                                                    <input type="text" class="form-control" placeholder="Company" value="<%=s9%>">
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Address</label>
                                                    <input type="text" class="form-control" placeholder="Home Address" value="<%=s5%>">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4 px-1">
                                                <div class="form-group">
                                                    <label>Father Name</label>
                                                    <input type="text" class="form-control" placeholder="" value="<%=s12%>">
                                                </div>
                                            </div>
                                            <div class="col-md-4 pl-1">
                                                <div class="form-group">
                                                    <label>Father Ocupation</label>
                                                    <input type="text" class="form-control" value="<%=s13%>">
                                                </div>
                                            </div>
                                            <div class="col-md-4 pl-1">
                                                <div class="form-group">
                                                    <label>Parent Mobile No.</label>
                                                    <input type="number" class="form-control" value="<%=s16%>">
                                                </div>
                                            </div>
                                        </div>
                                         <div class="row">
                                            <div class="col-md-4 px-1">
                                                <div class="form-group">
                                                    <label>Mother Name</label>
                                                    <input type="text" class="form-control" value="<%=s14%>">
                                                </div>
                                            </div>
                                            <div class="col-md-4 pl-1">
                                                <div class="form-group">
                                                    <label>Mother Ocupation</label>
                                                    <input type="text" class="form-control" value="<%=s15%>">
                                                </div>
                                            </div>
                                            <div class="col-md-4 pl-1">
                                                <div class="form-group">
                                                    <br>
                                                    <button type="submit" class="btn btn-info btn-fill pull-right">Update Profile</button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card card-user">
                                <div class="card-image">
                                    <img src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400" alt="...">
                                </div>
                                <div class="card-body">
                                    <div class="author">
                                        <a href="#">
                                            <img class="avatar border-gray" src="../../image_data/<%=spic%>.jpg" alt="...">
                                            <h5 class="title"><%=name%></h5>
                                        </a>
                                        <div class="description">
                                            <label> Class <%=s11%>th</label>
                                        </div>
                                    </div>
                                    <p class="description text-center">
                                    </p>
                                </div>
                                <hr>
                                <div class="button-container mr-auto ml-auto">
                                    <button href="#" class="btn btn-simple btn-link btn-icon">
                                        <i class="fa fa-facebook-square"></i>
                                    </button>
                                    <button href="#" class="btn btn-simple btn-link btn-icon">
                                        <i class="fa fa-twitter"></i>
                                    </button>
                                    <button href="#" class="btn btn-simple btn-link btn-icon">
                                        <i class="fa fa-google-plus-square"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="card card-user"><br>
                                    <ul>
                                        <li>
                                            <a type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Change password</a>  
                                        </li>
                                    </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                        <%
                }
                con.close(); 
               %>
            <!--=================model change password================-->
             <!-- Modal -->
                <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                  <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Change Password</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <div class="modal-body">
                        <form action="../../change_pwd" method="post">
                       <!-- <form onsubmit="chng_p()">--->
                        <div class="col-md-12 px-1">
                            <div class="form-group">
                                <label>Current Password</label>
                                <input type="password" class="form-control" name="pass1" placeholder="Enter Current Password" required/>
                            </div>
                        </div>
                        
                        <div class="col-md-12 px-1">
                            <div class="form-group">
                                <label>New Password</label>
                                <input type="password" class="form-control" name="pass2" placeholder="Enter New Password" required/>
                            </div>
                        </div>
                        <div class="col-md-12 px-1">
                            <div class="form-group">
                                <label>Re-Enter New Password</label>
                                <input type="password" class="form-control" name="pass3" placeholder="Re-Enter Password" required/>
                            </div>
                        </div>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
            
            <!--================close =======-->
            <footer class="footer">
                <div class="container-fluid">
                    <nav>
                        <ul class="footer-menu">
                            <li>
                                <a href="#">
                                    Home
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Company
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Portfolio
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Blog
                                </a>
                            </li>
                        </ul>
                        <p class="copyright text-center">
                            ©
                            <script>
                                document.write(new Date().getFullYear())
                            </script>
                            <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                        </p>
                    </nav>
                </div>
            </footer>
        </div>
    </div>
    <script>
        function chng_p(){
            var cp = document.getElementById('pass1').value;
            var np = document.getElementById('pass2').value;
            var rnp = document.getElementById('pass3').value;
            
            if(np != rnp){
                document.getElementById('pass3').style.borderColor = "red";
            }else{
                document.getElementById('pass3').style.borderColor = "";
                //alert("hello "+cp+"  "+np+"  "+rnp);
                //var l = "../../change_pwd";
                var l = "../../change_pwd?x="+cp;
		// remove admin jsp page link
                //if(l== successfull){
                  //   alert(""+l+"change");
                     //window.open(l,'_self');	
                //}else{
                    alert(l);
                //}
                
            }
        }
    </script>
    <!--   -->
    <!-- <div class="fixed-plugin">
    <div class="dropdown show-dropdown">
        <a href="#" data-toggle="dropdown">
            <i class="fa fa-cog fa-2x"> </i>
        </a>

        <ul class="dropdown-menu">
			<li class="header-title"> Sidebar Style</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Background Image</p>
                    <label class="switch">
                        <input type="checkbox" data-toggle="switch" checked="" data-on-color="primary" data-off-color="primary"><span class="toggle"></span>
                    </label>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger background-color">
                    <p>Filters</p>
                    <div class="pull-right">
                        <span class="badge filter badge-black" data-color="black"></span>
                        <span class="badge filter badge-azure" data-color="azure"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-orange" data-color="orange"></span>
                        <span class="badge filter badge-red" data-color="red"></span>
                        <span class="badge filter badge-purple active" data-color="purple"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Sidebar Images</li>

            <li class="active">
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="../assets/img/sidebar-1.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="../assets/img/sidebar-3.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="..//assets/img/sidebar-4.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="../assets/img/sidebar-5.jpg" alt="" />
                </a>
            </li>

            <li class="button-container">
                <div class="">
                    <a href="http://www.creative-tim.com/product/light-bootstrap-dashboard" target="_blank" class="btn btn-info btn-block btn-fill">Download, it's free!</a>
                </div>
            </li>

            <li class="header-title pro-title text-center">Want more components?</li>

            <li class="button-container">
                <div class="">
                    <a href="http://www.creative-tim.com/product/light-bootstrap-dashboard-pro" target="_blank" class="btn btn-warning btn-block btn-fill">Get The PRO Version!</a>
                </div>
            </li>

            <li class="header-title" id="sharrreTitle">Thank you for sharing!</li>

            <li class="button-container">
				<button id="twitter" class="btn btn-social btn-outline btn-twitter btn-round sharrre"><i class="fa fa-twitter"></i> · 256</button>
                <button id="facebook" class="btn btn-social btn-outline btn-facebook btn-round sharrre"><i class="fa fa-facebook-square"></i> · 426</button>
            </li>
        </ul>
    </div>
</div>
 -->
</body>
<!--   Core JS Files   -->
<script src="../assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="../assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="../assets/js/plugins/bootstrap-switch.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!--  Chartist Plugin  -->
<script src="../assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="../assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="../assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="../assets/js/demo.js"></script>

</html>
