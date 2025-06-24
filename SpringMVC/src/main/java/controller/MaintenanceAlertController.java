package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import bean.MaintenanceSchedule;
import dao.MaintenanceScheduleDao;

@Controller
public class MaintenanceAlertController {

    @Autowired
    private MaintenanceScheduleDao scheduleDao;

    @RequestMapping("/maintenanceAlerts")
    public String showAlerts(Model m) {
        
        List<MaintenanceSchedule> upcomingSchedules = scheduleDao.getUpcomingMaintenanceSchedules();
        m.addAttribute("upcomingSchedules", upcomingSchedules);
        return "maintenancealerts";
        
    }
}

