<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Maintenance History</title>
    <style>
        body {
            background-image: url('${pageContext.request.contextPath}/resources/images/thisOne.webp');
            background-size: cover;
            font-family: Arial, sans-serif;
            color: #333;
        }
        .container {
            text-align: center;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8);
            margin: 50px auto;
            width: 50%;
            border-radius: 15px;
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
            background-color: #add8e6;
            color: #333;
        }
        td {
            background-color: #f9f9f9;
        }
        a, input[type="submit"] {
            color: #333;
            text-decoration: none;
            background-color: #add8e6;
            padding: 5px 10px;
            border-radius: 5px;
            border: none;
        }
        a:hover, input[type="submit"]:hover {
            background-color: #5a5a5a;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add Maintenance History</h2>
        <form action="${pageContext.request.contextPath}/saveMaintenanceHistory" method="post">
            <input type="hidden" name="vehicleId" value="${command.vehicleId}">
            <table>
                <tr>
                    <td>Maintenance Date:</td>
                    <td><input type="text" name="maintenanceDate" required></td>
                </tr>
                <tr>
                    <td>Details:</td>
                    <td><textarea name="details" required></textarea></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Add History"></td>
                </tr>
            </table>
        </form>
        <br>
        <a href="${pageContext.request.contextPath}/maintenanceHistory/${command.vehicleId}">Back</a>
    </div>
</body>
</html>
