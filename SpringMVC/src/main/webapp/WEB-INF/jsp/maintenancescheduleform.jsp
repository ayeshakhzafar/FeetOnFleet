<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Maintenance Schedule</title>
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
        a, input[type="submit"] {
            display: inline-block;
            margin: 20px 10px;
            padding: 10px 20px;
            background-color: #8FDDE7;
            color: #333;
            text-decoration: none;
            border-radius: 10px;
            border: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        a:hover, input[type="submit"]:hover {
            background-color: #5a5a5a;
            color: #fff;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Create Maintenance Schedule</h2>
        <form action="${pageContext.request.contextPath}/saveMaintenanceSchedule" method="post">
            <table>
                <tr>
                    <td>Type:</td>
                    <td>
                        <select name="type" required>
                            <option value="Oil Change">Oil Change</option>
                            <option value="Tire Rotation">Tire Rotation</option>
                            <option value="Brake Inspection">Brake Inspection</option>
                            <option value="Engine Check">Engine Check</option>
                            <option value="Battery Replacement">Battery Replacement</option>
                            <option value="Fluid Check">Fluid Check</option>
                            <option value="General Inspection">General Inspection</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Frequency:</td>
                    <td>
                        <select name="frequency" required>
                            <option value="Weekly">Weekly</option>
                            <option value="Monthly">Monthly</option>
                            <option value="Quarterly">Quarterly</option>
                            <option value="Annually">Annually</option>
                            <option value="Every 5000 miles">Every 5000 miles</option>
                            <option value="Every 10000 miles">Every 10000 miles</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Assigned Vehicle:</td>
                    <td><input type="text" name="assignedVehicle" required></td>
                </tr>
                <tr>
                    <td>Next Maintenance Date:</td>
                    <td><input type="date" name="nextMaintenanceDate" required></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Create Schedule"></td>
                </tr>
            </table>
        </form>
        <br>
        <a href="${pageContext.request.contextPath}/manageMaintenanceSchedules">Back</a>
    </div>
</body>
</html>
