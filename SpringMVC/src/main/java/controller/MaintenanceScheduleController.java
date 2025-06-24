package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;

import bean.MaintenanceSchedule;
import dao.MaintenanceScheduleDao;

@Controller
public class MaintenanceScheduleController {

    @Autowired
    private MaintenanceScheduleDao dao;

    @RequestMapping("/manageMaintenanceSchedules")
    public String viewMaintenanceSchedules(Model m) {
    	
        List<MaintenanceSchedule> list = dao.getMaintenanceSchedules();
        m.addAttribute("list", list);
        return "manageMaintenanceSchedules";
        
    }

    @RequestMapping("/createMaintenanceSchedule")
    public String showForm(Model m) {
    	
        m.addAttribute("command", new MaintenanceSchedule());
        return "maintenancescheduleform";
        
    }
    
    @RequestMapping(value = "/saveMaintenanceSchedule", method = RequestMethod.POST)
    public String save(@ModelAttribute("schedule") MaintenanceSchedule schedule,
                       @RequestParam("nextMaintenanceDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date nextMaintenanceDate) {
        schedule.setNextMaintenanceDate(nextMaintenanceDate);
        dao.save(schedule);
        
        return "redirect:/manageMaintenanceSchedules";
        
    }


    @RequestMapping(value = "/editMaintenanceSchedule/{id}")
    public String edit(@PathVariable int id, Model m) {
    	
        MaintenanceSchedule schedule = dao.getMaintenanceScheduleById(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(schedule.getNextMaintenanceDate());
        m.addAttribute("command", schedule);
        m.addAttribute("formattedDate", formattedDate);  
        return "maintenancescheduleeditform";
        
    }

    @RequestMapping(value = "/editSaveMaintenanceSchedule", method = RequestMethod.POST)
    public String editSave(
    		
        @ModelAttribute("schedule") MaintenanceSchedule schedule,
        @RequestParam("nextMaintenanceDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date nextMaintenanceDate) {
        schedule.setNextMaintenanceDate(nextMaintenanceDate);
        dao.update(schedule);
        return "redirect:/manageMaintenanceSchedules";
        
    }
 
    
    

    @RequestMapping(value = "/deleteMaintenanceSchedule/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
    	
        dao.delete(id);
        return "redirect:/manageMaintenanceSchedules";
        
        
    }
}
