package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.MaintenanceHistory;
import dao.MaintenanceHistoryDao;

@Controller
public class MaintenanceHistoryController {

    @Autowired
    private MaintenanceHistoryDao historyDao;

    @RequestMapping("/maintenanceHistory/{vehicleId}")
    public String viewMaintenanceHistory(@PathVariable int vehicleId, Model m) {
    	
        List<MaintenanceHistory> list = historyDao.getMaintenanceHistoryByVehicleId(vehicleId);
        m.addAttribute("list", list);
        return "viewmaintenancehistory";
        
    }

    @RequestMapping("/addMaintenanceHistory/{vehicleId}")
    public String showForm(@PathVariable int vehicleId, Model m) {
    	
        MaintenanceHistory history = new MaintenanceHistory();
        history.setVehicleId(vehicleId);
        m.addAttribute("command", history);
        return "maintenancehistoryform";
        
    }

    @RequestMapping(value = "/saveMaintenanceHistory", method = RequestMethod.POST)
    public String save(@ModelAttribute("history") MaintenanceHistory history) {
    	
        historyDao.save(history);
        return "redirect:/maintenanceHistory/" + history.getVehicleId();
        
    }
}
