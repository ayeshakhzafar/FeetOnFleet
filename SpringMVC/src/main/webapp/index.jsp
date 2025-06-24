<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Fleet Management System</title>
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
            background-color: rgba(255, 255, 255, 0.8);
            margin: 100px auto;
            width: 50%;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-family: 'Poppins', sans-serif;
            color: #333;
            margin-bottom: 20px;
        }
        h2 {
            color: #5a5a5a;
        }
        .nav-links {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
        .nav-links a {
            display: block;
            width: 48%;
            margin: 10px 1%;
            padding: 20px;
            background-color: #8FDDE7;
            color: #333;
            text-decoration: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        .nav-links a:hover {
            background-color: #5a5a5a;
            color: #fff;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Fleet Management System</h1>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/manageVehicles">Manage Vehicle Information</a>
            <a href="${pageContext.request.contextPath}/fleetComposition">Fleet Composition Management</a>
            <a href="${pageContext.request.contextPath}/manageDriverProfiles">Manage Driver Profiles</a>
            <a href="${pageContext.request.contextPath}/manageMaintenanceSchedules">Manage Maintenance Schedules</a>
            <a href="${pageContext.request.contextPath}/maintenanceAlerts">Maintenance Alerts</a>
            <a href="${pageContext.request.contextPath}/driverSchedules">Optimize Driver Schedules</a>
            <a href="${pageContext.request.contextPath}/checkBusAvailability">Check Bus Availability</a>
            <a href="${pageContext.request.contextPath}/addFuelPurchase">Manage Fuel Purchases</a>
            <a href="${pageContext.request.contextPath}/vehicleDisposal">Vehicle Disposal Management</a>
        </div>
    </div>
</body>
</html>
