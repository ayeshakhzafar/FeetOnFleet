package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import bean.Driver;

public class DriverDao {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Driver driver) {
    	
        String sql = "INSERT INTO Driver(name, licenseNumber, phoneNumber) VALUES (?, ?, ?)";
        
        return template.update(sql, driver.getName(), driver.getLicenseNumber(), driver.getPhoneNumber());
        
    }

    public int update(Driver driver) {
    	
        String sql = "UPDATE Driver SET name = ?, licenseNumber = ?, phoneNumber = ? WHERE id = ?";
      
        return template.update(sql, driver.getName(), driver.getLicenseNumber(), driver.getPhoneNumber(), driver.getId());
    
    }

    public int delete(int id) {
    	
        String sql = "DELETE FROM Driver WHERE id = ?";
        return template.update(sql, id);
        
    }

    public Driver getDriverById(int id) {
    	
        String sql = "SELECT * FROM Driver WHERE id = ?";
        
        return template.queryForObject(sql, (rs, rowNum) -> mapRowToDriver(rs), id);
        
    }
    

    public List<Driver> getDrivers() {
    	
        String sql = "SELECT * FROM Driver";
        return template.query(sql, (rs, rowNum) -> mapRowToDriver(rs));
        
    }

    private Driver mapRowToDriver(ResultSet rs) throws SQLException {
    	
        Driver driver = new Driver();
        driver.setId(rs.getInt("id"));
        driver.setName(rs.getString("name"));
        driver.setLicenseNumber(rs.getString("licenseNumber"));
        driver.setPhoneNumber(rs.getString("phoneNumber"));
        return driver;
        
    }
}

