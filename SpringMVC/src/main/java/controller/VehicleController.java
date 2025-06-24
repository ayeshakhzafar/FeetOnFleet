package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;


import bean.Vehicle;
import bean.FuelPurchase;

import bean.VehicleDisposal;

import dao.VehicleDao;
import dao.FuelPurchaseDao;

import dao.VehicleDisposalDao;


import java.sql.Date;
import java.time.LocalDate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;





@Controller
public class VehicleController {

    @Autowired
    private VehicleDao dao;
    
    @Autowired
    private FuelPurchaseDao fuelPurchaseDao; 
    
    @Autowired
    private VehicleDisposalDao vehicleDisposalDao;
    
    
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @RequestMapping("/manageVehicles")
    public String manageVehicles(Model m) {
    	
        List<Vehicle> list = dao.getVehicles();
        m.addAttribute("list", list);
        return "managevehicles";
        
    }

    @RequestMapping(value = "/viewVehicle/{id}")
    public String viewVehicle(@PathVariable int id, Model m) {
    	
        Vehicle vehicle = dao.getVehicleById(id);
        m.addAttribute("vehicle", vehicle);
        return "viewvehicle";
        
    }
    
    
    @RequestMapping("/managevehicles")
    public String viewVehicles(Model model) {
    	
        List<Vehicle> vehicles = dao.getVehicles(); 
        model.addAttribute("availableBuses", vehicles);
        return "managevehicles";  
        
    }
    
    

    @RequestMapping(value = "/editVehicle/{id}")
    public String editVehicle(@PathVariable int id, Model m) {
    	
        Vehicle vehicle = dao.getVehicleById(id);
        m.addAttribute("command", vehicle);
        return "vehicleeditform";
        
    }

    @RequestMapping(value = "/editSaveVehicle", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("vehicle") Vehicle vehicle) {
    	
        dao.update(vehicle);
        return "redirect:/manageVehicles";
        
    }
    
    
    
    @RequestMapping("/checkBusAvailability")
    public String checkBusAvailability(Model model) {
    	
       // updateBusAvailability(); 
        List<Vehicle> availableBuses = dao.getAvailableBuses();
        model.addAttribute("availableBuses", availableBuses);
        
        return "busAvailability"; 
    }


    
    @GetMapping("/updateVehicleStatus")
    public String updateVehicleStatus() {
    	
        dao.updateBusAvailability();
        return "redirect:/managevehicles"; 
        
    }
    
    @Scheduled(cron = "0 0 0 * * ?") 
    public void updateBusAvailability() {
        LocalDate today = LocalDate.now();
        String sql = "UPDATE Vehicle SET status = 'Unavailable' WHERE id IN (" +
                     "SELECT vehicleId FROM MaintenanceSchedule WHERE nextMaintenanceDate = ? " +
                     "UNION " +
                     "SELECT vehicleId FROM DriverSchedule WHERE tripDate = ?)";
        template.update(sql, Date.valueOf(today), Date.valueOf(today));
    } 
    
    
    @RequestMapping(value = "/addFuelPurchase", method = RequestMethod.GET)
    public String showAddFuelForm(Model model) {
    	
        model.addAttribute("purchase", new FuelPurchase());
        return "addFuelPurchase";
        
    }

    
    @RequestMapping(value = "/addFuelPurchase", method = RequestMethod.POST)
    public String addFuelPurchase(@ModelAttribute("purchase") FuelPurchase purchase, Model model) {
    	
        try {
            fuelPurchaseDao.addFuelPurchase(purchase);
            model.addAttribute("message", "Fuel purchase recorded successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Error recording fuel purchase: " + e.getMessage());
        }
        
        return "redirect:/viewFuelPurchases"; 
    }

    @RequestMapping("/viewFuelPurchases")
    public String viewFuelPurchases(Model m) {
    	
        List<FuelPurchase> list = fuelPurchaseDao.getAllFuelPurchases();
        
        m.addAttribute("list", list);
        return "viewFuelPurchases";
        
    }
    
    
    
   

    @RequestMapping(value = "/vehicleDisposal", method = RequestMethod.GET)
    public String showVehicleDisposalForm(Model model) {
    	
        model.addAttribute("vehicleDisposal", new VehicleDisposal());
        return "vehicleDisposalForm";
        
    }

    @RequestMapping(value = "/disposeVehicle", method = RequestMethod.POST)
    public String disposeVehicle(@ModelAttribute("vehicleDisposal") VehicleDisposal disposal, Model model) {
        try {
            vehicleDisposalDao.disposeVehicle(disposal); // logging disposal information
            dao.delete(disposal.getVehicleId()); 
            
            model.addAttribute("message", "Vehicle disposal recorded successfully!");
            
        } catch (Exception e) {
        	
            model.addAttribute("error", "Error recording vehicle disposal: " + e.getMessage());
        }
        
        return "redirect:/manageVehicles";
        
    }

    @RequestMapping("/viewVehicleDisposals")
    public String viewVehicleDisposals(Model model) {
    	
        List<VehicleDisposal> list = vehicleDisposalDao.getAllVehicleDisposals();
        model.addAttribute("list", list);
        return "viewVehicleDisposals";
        
    }
    
    
 
 
}