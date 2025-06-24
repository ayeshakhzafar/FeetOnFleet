package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import bean.Vehicle;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.Date;
import java.time.LocalDate;


public class VehicleDao {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Vehicle vehicle) {
       
    	String sql = "INSERT INTO Vehicle(make, model, year, color) VALUES (?, ?, ?, ?)";
    	
        return template.update(sql, vehicle.getMake(), vehicle.getModel(), vehicle.getYear(), vehicle.getColor());
    
    }

    public int update(Vehicle vehicle) {
    	
        String sql = "UPDATE Vehicle SET make = ?, model = ?, year = ?, color = ? WHERE id = ?";
        return template.update(sql, vehicle.getMake(), vehicle.getModel(), vehicle.getYear(), vehicle.getColor(), vehicle.getId());
   
    }

    public int delete(int id) {
       
    	String sql = "DELETE FROM Vehicle WHERE id = ?";
        return template.update(sql, id);  
   
    }

    public Vehicle getVehicleById(int id) {
       
    	String sql = "SELECT * FROM Vehicle WHERE id = ?";
        return template.queryForObject(sql, (rs, rowNum) -> mapRowToVehicle(rs), id);
   
    }

    public List<Vehicle> getVehicles() {
      
    	String sql = "SELECT id, make, model, year, color, status FROM Vehicle";
        return template.query(sql, new BeanPropertyRowMapper<>(Vehicle.class));
    
    }


    private Vehicle mapRowToVehicle(ResultSet rs) throws SQLException {
       
    	Vehicle vehicle = new Vehicle();
        vehicle.setId(rs.getInt("id"));
        vehicle.setMake(rs.getString("make"));
        vehicle.setModel(rs.getString("model"));
        vehicle.setYear(rs.getInt("year"));
        vehicle.setColor(rs.getString("color"));
        vehicle.setStatus(rs.getString("status"));
       
        return vehicle;
    }
    

   
    public List<Vehicle> getAvailableBuses() {
        
    	String sql = "SELECT id, make, model, year, color, status FROM Vehicle WHERE status = 'Available'";
        
    	return template.query(sql, new BeanPropertyRowMapper<>(Vehicle.class));
   
    }

   
    
    public void setBusStatus(int vehicleId, String status) {
       
    	String sql = "UPDATE Vehicle SET status = ? WHERE id = ?";
        template.update(sql, status, vehicleId);
   
    }
    
 
    public void updateBusAvailability() {
    	
    	
        LocalDate today = LocalDate.now();
        Date sqlToday = Date.valueOf(today);
        
        String sql = "UPDATE Vehicle SET status = 'Unavailable' WHERE id IN (" +
                     "SELECT vehicleId FROM MaintenanceSchedule WHERE nextMaintenanceDate = ? " +
                     "UNION " +
                     "SELECT vehicleId FROM DriverSchedule WHERE tripDate = ?)";
        
        template.update(sql, Date.valueOf(today), Date.valueOf(today));
        
    }
    
    
    
    
}

