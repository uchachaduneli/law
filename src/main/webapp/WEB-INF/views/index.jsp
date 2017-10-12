<%--
  Created by IntelliJ IDEA.
  User: ucha
  Date: 9/26/2017
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>abara mobile</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#postButton").click(function () {
                $.ajax({
                    url: "http://localhost/users/auth?loginType=1&client_id=uchachaduneli@gmail.com&password=asd",
//                    data: {
//                        client_id: "10",
//                        user_id: "1709648992411172",
//                        token: "EAAVb7KZAppG8BAExW9ruLKrHIOxFr39SJMM533qpZBCDniQFOGQamkajOozfwIIYCMQZAyIGLR6hVxYZAuoI2Bvo3hZAZCvBRFYcZCHSi1N05mtSGdxMOdZCJpC1PCuG2DZBwE4QCS5barhJgfR0R4rxjd2bc3Ixp9NzENxZAtJTrYBwZDZD",
//                        loginType: 2
//                    },
                    success: function (result) {
                        console.log(result);
                        $("#div1").html(result);
                    },
                    error: function (request, status, error) {
                        $("#div1").html(request.responseText);
                    },
                    complete: function (xhr, textStatus) {
                        console.log(xhr.status);
                    }
                }).done(function () {
                    $("#div1").html("done");
                });
                ;
            });
            $("#getButton").click(function () {
                $.ajax({
                    url: "demo_test.txt", success: function (result) {
                        $("#div1").html(result);
                    },
                    error: function (request, status, error) {
                        $("#div1").html(request.responseText);
                    }
                });
            });
        });
    </script>
</head>
<body>
<center>
    This Is Abara Mobile Service <br/><br/>

    <button id="postButton">postButton</button>
    <br/> <br/>
    <button id="getButton">getButton</button>
</center>
</body>
</html>
