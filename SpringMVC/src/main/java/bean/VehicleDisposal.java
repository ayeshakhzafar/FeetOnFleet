package bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class VehicleDisposal {
	
    private int id;
    private int vehicleId;
    private String disposalReason;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date disposalDate;
    
    private String replacementPlan;

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public String getDisposalReason() { return disposalReason; }
    public void setDisposalReason(String disposalReason) { this.disposalReason = disposalReason; }

    public Date getDisposalDate() { return disposalDate; }
    public void setDisposalDate(Date disposalDate) { this.disposalDate = disposalDate; }

    public String getReplacementPlan() { return replacementPlan; }
    public void setReplacementPlan(String replacementPlan) { this.replacementPlan = replacementPlan; }
    
}

