package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;
import bean.VehicleDisposal;

@Repository
public class VehicleDisposalDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    public void disposeVehicle(VehicleDisposal disposal) { //logging
    	
        String sql = "INSERT INTO VehicleDisposal (vehicleId, disposalReason, disposalDate, replacementPlan) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
            disposal.getVehicleId(),
            disposal.getDisposalReason(),
            new Date(disposal.getDisposalDate().getTime()),
            disposal.getReplacementPlan());
        
    }

    public List<VehicleDisposal> getAllVehicleDisposals() {
    	
        String sql = "SELECT * FROM VehicleDisposal";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(VehicleDisposal.class));
        
    }
    
    
}


