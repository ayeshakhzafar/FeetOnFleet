# 🚗 FeetOnFleet

A full-featured **Fleet Management System** developed using **Spring Framework**, **JSP**, and **MySQL**. The system helps manage vehicles, drivers, maintenance schedules, fuel consumption, and disposal of old vehicles within an organization.

---

## 📌 Features

- **Vehicle Management**
  - Add, view, update, and delete vehicle details.
  - Track vehicle status (active, in maintenance, disposed).
  
- **Driver Management**
  - Register and manage drivers.
  - Assign drivers to vehicles.

- **Fuel Purchase Tracking**
  - Log and monitor fuel purchases for each vehicle.
  - Analyze fuel consumption over time.

- **Maintenance Scheduling**
  - Record maintenance history.
  - Schedule and manage regular services or repairs.

- **Vehicle Disposal**
  - Track vehicles that are decommissioned or sold.
  - Maintain a disposal history for auditing purposes.

- **User Interface**
  - Intuitive JSP-based frontend.
  - Simple and clean UI for easy navigation.

---

## 🛠️ Tech Stack

| Layer           | Technology                 |
|----------------|----------------------------|
| Frontend       | JSP, HTML, CSS             |
| Backend        | Java, Spring Framework     |
| Persistence    | MySQL                      |
| Data Access    | JDBC, DAO Pattern          |
| Build Tool     | Maven                      |
| Deployment     | Apache Tomcat              |

---

## ✅ How to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/FeetOnFleet.git
   cd FeetOnFleet

2. **Import into IDE**

Use IntelliJ IDEA or Eclipse.

Import as a Maven project.

3. **Set Up the Database**

Create a MySQL database (e.g., fleet_db).

Import the provided SQL script (/resources/db/fleet_schema.sql) to create tables.

4. **Configure application.properties**

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/fleet_db
spring.datasource.username=root
spring.datasource.password=yourpassword

5. **Run the Application**

Deploy the .war file to Tomcat or run the Spring Boot app.

Access the app via http://localhost:8080/FeetOnFleet.

## 🧪 Testing
Manual and automated test cases are documented.

All bugs tracked using JIRA.

Screenshots and test evidence included in /docs/test-report/.

## 📷 Screenshots



https://www.linkedin.com/posts/ayesha-khalid-616640310_fleetmanagement-springframework-jsp-activity-7220456919138779138-n0Oc?utm_source=share&utm_medium=member_desktop&rcm=ACoAAE8dz3IB44eb3fDKaajSHFS6KR6q6ny6Nmw

👩‍💻 Developer
Ayesha
Full-stack Developer
📧 ayeshakhalid.codes@gmail.com 

yaml
Copy
Edit


