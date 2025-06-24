package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import bean.MaintenanceHistory;

public class MaintenanceHistoryDao {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(MaintenanceHistory history) {
    	
        String sql = "INSERT INTO MaintenanceHistory(vehicleId, maintenanceDate, details) VALUES (?, ?, ?)";
        return template.update(sql, history.getVehicleId(), history.getMaintenanceDate(), history.getDetails());
    
    }

    public List<MaintenanceHistory> getMaintenanceHistoryByVehicleId(int vehicleId) {
    	
        String sql = "SELECT * FROM MaintenanceHistory WHERE vehicleId = ?";
        return template.query(sql, (rs, rowNum) -> mapRowToMaintenanceHistory(rs), vehicleId);
    
    }

    private MaintenanceHistory mapRowToMaintenanceHistory(ResultSet rs) throws SQLException {
    	
        MaintenanceHistory history = new MaintenanceHistory();
        history.setId(rs.getInt("id"));
        history.setVehicleId(rs.getInt("vehicleId"));
        history.setMaintenanceDate(rs.getString("maintenanceDate"));
        history.setDetails(rs.getString("details"));
        return history;
        
    }
}
