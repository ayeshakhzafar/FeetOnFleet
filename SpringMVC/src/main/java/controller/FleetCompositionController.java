package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.Vehicle;
import dao.VehicleDao;

@Controller
public class FleetCompositionController {

    @Autowired
    private VehicleDao dao;

    @RequestMapping("/fleetComposition")
    public String fleetComposition(Model m) {
    	
        return "fleetcomposition";
        
    }

    @RequestMapping("/addVehicleForm")
    public String showAddForm(Model m) {
    	
        m.addAttribute("command", new Vehicle());
        return "addvehicleform";
        
    }

    @RequestMapping(value = "/saveNewVehicle", method = RequestMethod.POST)
    public String save(@ModelAttribute("vehicle") Vehicle vehicle) {
    	
        dao.save(vehicle);
        return "redirect:/fleetComposition";
        
    }

    @RequestMapping("/removeVehicleForm")
    public String showRemoveForm(Model m) {
    	
        List<Vehicle> list = dao.getVehicles();
        m.addAttribute("list", list);
        return "removevehicleform";
        
    }

    @RequestMapping(value = "/deleteVehicle/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
    	
        dao.delete(id);
        return "redirect:/fleetComposition";
        
    }

    @RequestMapping("/retrieveVehicles")
    public String retrieveVehicles(Model m) {
    	
        List<Vehicle> list = dao.getVehicles();
        m.addAttribute("list", list);
        return "retrievevehicles";
        
    }
}

