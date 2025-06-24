package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import bean.MaintenanceSchedule;

public class MaintenanceScheduleDao {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(MaintenanceSchedule schedule) {
    	
        String sql = "INSERT INTO MaintenanceSchedule(type, frequency, assignedVehicle, nextMaintenanceDate) VALUES (?, ?, ?, ?)";
        return template.update(sql, schedule.getType(), schedule.getFrequency(), schedule.getAssignedVehicle(), new java.sql.Date(schedule.getNextMaintenanceDate().getTime()));
    
    }

    public int update(MaintenanceSchedule schedule) {
       
    	String sql = "UPDATE MaintenanceSchedule SET type = ?, frequency = ?, assignedVehicle = ?, nextMaintenanceDate = ? WHERE id = ?";
        return template.update(sql, schedule.getType(), schedule.getFrequency(), schedule.getAssignedVehicle(), new java.sql.Date(schedule.getNextMaintenanceDate().getTime()), schedule.getId());
   
    }

    public int delete(int id) {
       
        String deleteAlertsSql = "DELETE FROM MaintenanceAlerts WHERE scheduleId = ?";
        template.update(deleteAlertsSql, id);

        String deleteScheduleSql = "DELETE FROM MaintenanceSchedule WHERE id = ?";
        return template.update(deleteScheduleSql, id);
    }

    public MaintenanceSchedule getMaintenanceScheduleById(int id) {
       
    	String sql = "SELECT * FROM MaintenanceSchedule WHERE id = ?";
       
    	return template.queryForObject(sql, (rs, rowNum) -> mapRowToMaintenanceSchedule(rs), id);
   
    }

    public List<MaintenanceSchedule> getMaintenanceSchedules() {
       
    	String sql = "SELECT * FROM MaintenanceSchedule";
   
    	return template.query(sql, (rs, rowNum) -> mapRowToMaintenanceSchedule(rs));
   
    }

    public List<MaintenanceSchedule> getUpcomingMaintenanceSchedules() {
       
    	String sql = "SELECT * FROM MaintenanceSchedule WHERE nextMaintenanceDate <= DATE_ADD(CURDATE(), INTERVAL 30 DAY)";
        
    	return template.query(sql, (rs, rowNum) -> mapRowToMaintenanceSchedule(rs));
    
    }

    
    private MaintenanceSchedule mapRowToMaintenanceSchedule(ResultSet rs) throws SQLException {
    	
        MaintenanceSchedule schedule = new MaintenanceSchedule();
        schedule.setId(rs.getInt("id"));
        schedule.setType(rs.getString("type"));
        schedule.setFrequency(rs.getString("frequency"));
        schedule.setAssignedVehicle(rs.getString("assignedVehicle"));
        schedule.setNextMaintenanceDate(rs.getDate("nextMaintenanceDate"));
        return schedule;
        
    }
}
