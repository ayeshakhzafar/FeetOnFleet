<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Maintenance Schedules</title>
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
            width: 70%;
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
        <h2>Maintenance Schedules</h2>
        <a href="${pageContext.request.contextPath}/createMaintenanceSchedule">Create Maintenance Schedule</a>
        <table>
            <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Frequency</th>
                <th>Assigned Vehicle</th>
                <th>Next Maintenance Date</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="schedule" items="${list}">
                <tr>
                    <td>${schedule.id}</td>
                    <td>${schedule.type}</td>
                    <td>${schedule.frequency}</td>
                    <td>${schedule.assignedVehicle}</td>
                    <td>${schedule.nextMaintenanceDate}</td>
                    <td><a href="${pageContext.request.contextPath}/editMaintenanceSchedule/${schedule.id}">Edit</a></td>
                    <td><a href="${pageContext.request.contextPath}/deleteMaintenanceSchedule/${schedule.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="${pageContext.request.contextPath}/">Back</a>
    </div>
</body>
</html>
