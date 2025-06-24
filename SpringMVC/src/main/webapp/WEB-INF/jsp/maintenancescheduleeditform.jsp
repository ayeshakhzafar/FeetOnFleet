<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Maintenance Schedule</title>
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
        <h2>Edit Maintenance Schedule</h2>
        <form action="${pageContext.request.contextPath}/editSaveMaintenanceSchedule" method="post">
            <input type="hidden" name="id" value="${command.id}" />
            <table>
                <tr>
                    <td>Type:</td>
                    <td>
                        <input type="text" name="type" value="${command.type}" required>
                    </td>
                </tr>
                <tr>
                    <td>Frequency:</td>
                    <td>
                        <input type="text" name="frequency" value="${command.frequency}" required>
                    </td>
                </tr>
                <tr>
                    <td>Assigned Vehicle:</td>
                    <td>
                        <input type="text" name="assignedVehicle" value="${command.assignedVehicle}" required>
                    </td>
                </tr>
                <tr>
                    <td>Next Maintenance Date:</td>
                    <td>
                        <input type="date" name="nextMaintenanceDate" value="${formattedDate}" required>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save Changes">
                    </td>
                </tr>
            </table>
        </form>
        <a href="${pageContext.request.contextPath}/manageMaintenanceSchedules">Back to List</a>
    </div>
</body>
</html>
