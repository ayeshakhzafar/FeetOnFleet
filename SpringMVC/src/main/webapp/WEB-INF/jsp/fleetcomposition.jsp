<!DOCTYPE html>
<html>
<head>
    <title>Fleet Composition Management</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@700&display=swap');

        body {
            background-image: url('${pageContext.request.contextPath}/resources/images/thisOne.webp');
            background-size: cover;
            background-position: center;
            font-family: Arial, sans-serif;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            text-align: center;
            padding: 50px;
            background-color: rgba(255, 255, 255, 0.9);
            margin: 100px auto;
            width: 50%;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            font-family: 'Poppins', sans-serif;
            color: #333;
            margin-bottom: 20px;
        }
        a {
            display: inline-block;
            margin: 20px 10px;
            padding: 10px 20px;
            background-color: #8FDDE7;
            color: #333;
            text-decoration: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        a:hover {
            background-color: #5a5a5a;
            color: #fff;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Fleet Composition Management</h2>
        <a href="addVehicleForm">Add Vehicle</a>
        <a href="removeVehicleForm">Remove Vehicle</a>
        <a href="retrieveVehicles">Retrieve Vehicles</a>
        <br>
        <a href="${pageContext.request.contextPath}/">Back</a>
    </div>
</body>
</html>


