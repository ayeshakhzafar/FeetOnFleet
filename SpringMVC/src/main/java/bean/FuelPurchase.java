package bean;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


public class FuelPurchase {
	
    private int id;
    private int vehicleId;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfPurchase;
    
    private double amount; // in liters or gallons
    private double pricePerUnit; // price per liter or gallon
    private double totalCost;

    
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public Date getDateOfPurchase() { return dateOfPurchase; }
    public void setDateOfPurchase(Date dateOfPurchase) { this.dateOfPurchase = dateOfPurchase; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
}
