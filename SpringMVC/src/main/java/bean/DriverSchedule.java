package bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DriverSchedule {
	
    private int id;
    private int driverId;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd") // to handle bad-request errors
    private Date shiftStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shiftEnd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date restPeriodStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date restPeriodEnd;
    
    
    
    public int getId() {
    	
        return id;
        
    }

    public void setId(int id) {
    	
        this.id = id;
        
    }

    public int getDriverId() {
    	
        return driverId;
        
    }

    public void setDriverId(int driverId) {
    	
        this.driverId = driverId;
        
    }

    public Date getShiftStart() {
    	
        return shiftStart;
        
    }

    public void setShiftStart(Date shiftStart) {
    	
        this.shiftStart = shiftStart;
        
    }

    public Date getShiftEnd() {
    	
        return shiftEnd;
        
    }

    public void setShiftEnd(Date shiftEnd) {
    	
        this.shiftEnd = shiftEnd;
        
    }

    public Date getRestPeriodStart() {
    	
        return restPeriodStart;
        
    }

    public void setRestPeriodStart(Date restPeriodStart) {
    	
        this.restPeriodStart = restPeriodStart;
        
    }

    public Date getRestPeriodEnd() {
    	
        return restPeriodEnd;
        
    }

    public void setRestPeriodEnd(Date restPeriodEnd) {
    	
        this.restPeriodEnd = restPeriodEnd;
        
    }
    
    
}
