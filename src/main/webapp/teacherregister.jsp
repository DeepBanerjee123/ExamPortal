<!DOCTYPE html>
<html>
<head>
    <title>Animated Sign-Up Form</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <img class="wave" src="img/wave.png">
    <div class="container">
        <div class="img">
            <img src="img/bg.svg">
        </div>
        <div class="login-content">
            <form action="teacherregister" method = "post">
                <img src="img/avatar.svg">
                <h2 class="title" style="font-size: 24px;">Teacher Sign Up</h2>
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-user"></i>
                    </div>
                    <div class="div">
                        <h5>Username</h5>
                        <input type="text" class="input" name="name">
                    </div>
                </div>
                
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-envelope"></i> 
                    </div>
                    <div class="div">
                        <h5>Email</h5> 
                        <input type="email" class="input" name="email"> 
                    </div>
                </div>
                
                <div class="input-div pass">
                    <div class="i"> 
                        <i class="fas fa-lock"></i>
                    </div>
                    <div class="div">
                        <h5>Password</h5>
                        <input type="password" class="input" name="pass">
                    </div>
                </div>
                <input type="submit" class="btn" value="Sign Up">
                <a href="teacherlogin.jsp" id="forgot_pswd">Already have an account? Sign In</a><br/>
               // <h5 style="color:red; text-align: center;">${ermsg}</h5>
            </form>
			    <%
        			String status = (String) request.getAttribute("status");
    			%>
    			<input type="hidden" id="status" value="<%= status %>">
            
                <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
				    <link rel="stylesheet" href="alert/dist/sweetalert.css">
				    
				       <script type="text/javascript">
						    let status = document.getElementById("status").value;
						    if (status == "success") {
						        swal("Congrats", "Account created", "success").then(() => {
				            window.location.href = "teacherlogin.jsp";
				        });
				 }
	  		</script>
        </div>
    </div>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>
