package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;
import bean.FuelPurchase;  

@Repository
public class FuelPurchaseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;  

    
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    public void addFuelPurchase(FuelPurchase purchase) {
    	
        String sql = "INSERT INTO fuel_purchase (vehicle_id, date_of_purchase, amount, price_per_unit, total_cost) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
            purchase.getVehicleId(),
            new Date(purchase.getDateOfPurchase().getTime()),
            purchase.getAmount(),
            purchase.getPricePerUnit(),
            purchase.getAmount() * purchase.getPricePerUnit()); // calculate total cost
        
    }

    
    public List<FuelPurchase> getAllFuelPurchases() {
    	
        String sql = "SELECT * FROM fuelpurchase";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(FuelPurchase.class));
        
    }

    
    public FuelPurchase getFuelPurchaseById(int id) {
    	
        String sql = "SELECT * FROM fuelpurchase WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(FuelPurchase.class));
   
    }

    
    public void updateFuelPurchase(FuelPurchase purchase) {
        String sql = "UPDATE fuelpurchase SET vehicle_id = ?, date_of_purchase = ?, amount = ?, price_per_unit = ? WHERE id = ?";
        jdbcTemplate.update(sql, 
            purchase.getVehicleId(),
            new Date(purchase.getDateOfPurchase().getTime()),
            purchase.getAmount(), 
            purchase.getPricePerUnit(),
            purchase.getId());
        
    }

    
    public void deleteFuelPurchase(int id) {
        String sql = "DELETE FROM fuelpurchase WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    
}
