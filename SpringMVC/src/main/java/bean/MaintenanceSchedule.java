package bean;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MaintenanceSchedule {

    private int id;
    private String type;
    private String frequency;
    private String assignedVehicle;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nextMaintenanceDate;

    
    public int getId() {
    	
        return id;
        
    }

    public void setId(int id) {
    	
        this.id = id;
        
    }

    public String getType() {
    	
        return type;
        
    }

    public void setType(String type) {
    	
        this.type = type;
        
    }

    public String getFrequency() {
    	
        return frequency;
        
    }

    public void setFrequency(String frequency) {
    	
        this.frequency = frequency;
        
    }

    public String getAssignedVehicle() {
    	
        return assignedVehicle;
        
    }

    public void setAssignedVehicle(String assignedVehicle) {
    	
        this.assignedVehicle = assignedVehicle;
        
    }

    public Date getNextMaintenanceDate() {
    	
        return nextMaintenanceDate;
        
    }

    public void setNextMaintenanceDate(Date nextMaintenanceDate) {
    	
        this.nextMaintenanceDate = nextMaintenanceDate;
        
    }
    
}

