package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.Driver;
import dao.DriverDao;

@Controller
public class DriverProfileController {

    @Autowired
    private DriverDao dao;

    
    
    @RequestMapping("/manageDriverProfiles")
    public String manageDriverProfiles(Model m) {
    	
        List<Driver> list = dao.getDrivers();
        m.addAttribute("list", list);
        return "managedriverprofiles";
        
    }

    @RequestMapping(value = "/viewDriver/{id}")
    public String viewDriver(@PathVariable int id, Model m) {
    	
        Driver driver = dao.getDriverById(id);
        m.addAttribute("driver", driver);
        return "viewdriver";
        
    }

    @RequestMapping(value = "/editDriver/{id}")
    public String editDriver(@PathVariable int id, Model m) {
    	
        Driver driver = dao.getDriverById(id);
        m.addAttribute("command", driver);
        return "drivereditform";
        
    }

    @RequestMapping(value = "/editSaveDriver", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("driver") Driver driver) {
    	
        dao.update(driver);
        return "redirect:/manageDriverProfiles";
    }
    
    
}
