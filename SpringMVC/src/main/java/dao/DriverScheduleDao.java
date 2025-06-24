package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import bean.DriverSchedule;

@Repository
public class DriverScheduleDao {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
    	
        this.template = template;
        
    }

    public int save(DriverSchedule schedule) {
    	
        String sql = "INSERT INTO DriverSchedule(driverId, shiftStart, shiftEnd, restPeriodStart, restPeriodEnd) VALUES (?, ?, ?, ?, ?)";
        return template.update(sql, schedule.getDriverId(), new java.sql.Timestamp(schedule.getShiftStart().getTime()), 
                               new java.sql.Timestamp(schedule.getShiftEnd().getTime()), 
                               new java.sql.Timestamp(schedule.getRestPeriodStart().getTime()), 
                               new java.sql.Timestamp(schedule.getRestPeriodEnd().getTime()));
        
    }

    
    public int update(DriverSchedule schedule) {
    	
        String sql = "UPDATE DriverSchedule SET driverId = ?, shiftStart = ?, shiftEnd = ?, restPeriodStart = ?, restPeriodEnd = ? WHERE id = ?";
        return template.update(sql, schedule.getDriverId(), new java.sql.Timestamp(schedule.getShiftStart().getTime()), 
                               new java.sql.Timestamp(schedule.getShiftEnd().getTime()), 
                               new java.sql.Timestamp(schedule.getRestPeriodStart().getTime()), 
                               new java.sql.Timestamp(schedule.getRestPeriodEnd().getTime()), schedule.getId());
   
    }
    

    public int delete(int id) {
    	
        String sql = "DELETE FROM DriverSchedule WHERE id = ?";
        return template.update(sql, id);
        
    }

    public DriverSchedule getDriverScheduleById(int id) {
    	
        String sql = "SELECT * FROM DriverSchedule WHERE id = ?";
        
        return template.queryForObject(sql, (rs, rowNum) -> mapRowToDriverSchedule(rs), id);
        
    }

    public List<DriverSchedule> getDriverSchedules() {
    	
        String sql = "SELECT * FROM DriverSchedule";
        return template.query(sql, (rs, rowNum) -> mapRowToDriverSchedule(rs));
        
    }

    private DriverSchedule mapRowToDriverSchedule(ResultSet rs) throws SQLException {
    	
        DriverSchedule schedule = new DriverSchedule();
        schedule.setId(rs.getInt("id"));
        schedule.setDriverId(rs.getInt("driverId"));
        schedule.setShiftStart(rs.getTimestamp("shiftStart"));
        schedule.setShiftEnd(rs.getTimestamp("shiftEnd"));
        schedule.setRestPeriodStart(rs.getTimestamp("restPeriodStart"));
        schedule.setRestPeriodEnd(rs.getTimestamp("restPeriodEnd"));
        return schedule;
        
    }
}

