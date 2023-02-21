<!DOCTYPE html>  
<html lang="en">  
<head>  
    <meta charset="UTF-8">
    <title>Index Page</title>
    <link href="css/style.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Peddana&display=swap" rel="stylesheet">
</head>  
<body>  
    <header>
        <div id="logo"><a href="#">truYum</a></div>
        <div id="logo-img">
            <img src="images/logo.png">
        </div>

    </header>

    <!--Section-->
    <section>
        <div class="main-container">
            <div class="login-container">
                <h1>Login here..</h1>
                <form action="index">
                    <input type="text" placeholder="Username" name="username" id="username" required="required" /> 
                    <input type="password" placeholder="Password" name="password" id="password" required="required"/> 
                    <div class="check">
                        <input type="checkbox" id="user" value="true" name="admin" id="admin">
                        <p>I am Admin</p>
                    </div>
                     
                    <button id="submit">Login</button> 
                    <br />
                	<h2 style="color:red">${invalidMsg}</h2>
                </form>
            </div>
        </div>


    </section>


</body>  
</html>