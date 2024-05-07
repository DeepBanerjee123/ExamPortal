<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Animated Login Form</title>
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
            <form action="teacherlogin" method="post">
                <img src="img/avatar.svg">
                <h2 class="title">Teacher Login</h2>
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-user"></i>
                    </div>
                    <div class="div">
               
                        <input type="text" class="input" placeholder = "email" name="email">
                    </div>
                </div>
                <div class="input-div pass">
                    <div class="i"> 
                        <i class="fas fa-lock"></i>
                    </div>
                    <div class="div">
                        
                        <input type="password" class="input" placeholder = "password" name="pass">
                    </div>
                </div>
                <input type="submit" class="btn" value="Login">
            <a href="teacherregister.jsp" id="forgot_pswd" class = "custom-link">Don't have an account? Sign Up</a><br/>
            <h5 class="error-message">${err}</h5>
            </form>
           
        </div>
    </div>
   
    <%
        String status = (String) request.getAttribute("status");
    %>
    <input type="hidden" id="status" value="<%= status %>">
    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link rel="stylesheet" href="alert/dist/sweetalert.css">
    
    <script type="text/javascript">
        let status = document.getElementById("status").value;
        if (status == "failed") {
            swal("Oops", "Login failed", "error");
        }
    </script>

</body>
</html>
