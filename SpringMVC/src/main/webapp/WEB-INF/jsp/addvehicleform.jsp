<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Vehicle</title>
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
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            margin: 50px auto;
            width: 50%;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            font-family: 'Poppins', sans-serif;
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid #ddd;
            padding: 10px;
        }
        th {
            background-color: #8FDDE7;
            color: #333;
        }
        td {
            background-color: #f9f9f9;
        }
        input[type=submit], a {
            display: inline-block;
            color: #333;
            text-decoration: none;
            background-color: #8FDDE7;
            padding: 10px 20px;
            border-radius: 10px;
            border: none;
            cursor: pointer;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        input[type=submit]:hover, a:hover {
            background-color: #5a5a5a;
            color: #fff;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add New Vehicle</h2>
        <form action="${pageContext.request.contextPath}/saveNewVehicle" method="post">
            <table>
                <tr>
                    <td>Make:</td>
                    <td><input type="text" name="make" required></td>
                </tr>
                <tr>
                    <td>Model:</td>
                    <td><input type="text" name="model" required></td>
                </tr>
                <tr>
                    <td>Year:</td>
                    <td><input type="number" name="year" required></td>
                </tr>
                <tr>
                    <td>Color:</td>
                    <td><input type="text" name="color" required></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Add Vehicle"></td>
                </tr>
            </table>
        </form>
        <br>
        <a href="${pageContext.request.contextPath}/fleetComposition">Back</a>
    </div>
</body>
</html>
