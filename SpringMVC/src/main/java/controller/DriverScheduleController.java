package controller;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;
import bean.DriverSchedule;
import dao.DriverScheduleDao;

@Controller
public class DriverScheduleController {

    @Autowired
    private DriverScheduleDao scheduleDao;

    @RequestMapping("/driverSchedules")
    public String viewDriverSchedules(Model m) {
    	
        List<DriverSchedule> list = scheduleDao.getDriverSchedules();
        
        m.addAttribute("list", list);
        
        return "viewDriverSchedules";
    }

    @RequestMapping("/createDriverSchedule")
    public String showCreateForm(Model m) {
    	
        m.addAttribute("command", new DriverSchedule());
        
        return "createDriverSchedule";
    }

    @RequestMapping(value = "/saveDriverSchedule", method = RequestMethod.POST)
    public String saveDriverSchedule(@ModelAttribute("schedule") DriverSchedule schedule,
                                     @RequestParam("shiftStart") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date shiftStart,
                                     @RequestParam("shiftEnd") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date shiftEnd,
                                     @RequestParam("restPeriodStart") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date restPeriodStart,
                                     @RequestParam("restPeriodEnd") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date restPeriodEnd) {
        schedule.setShiftStart(shiftStart);
        schedule.setShiftEnd(shiftEnd);
        schedule.setRestPeriodStart(restPeriodStart);
        schedule.setRestPeriodEnd(restPeriodEnd);
        scheduleDao.save(schedule);
        return "redirect:/driverSchedules";
    }

    @RequestMapping(value = "/editDriverSchedule/{id}")
    
    public String editDriverSchedule(@PathVariable int id, Model m) {
    	
        DriverSchedule schedule = scheduleDao.getDriverScheduleById(id);
        
        m.addAttribute("command", schedule);
        
        return "editDriverSchedule";
    }

    @RequestMapping(value = "/updateDriverSchedule", method = RequestMethod.POST)
    public String updateDriverSchedule(@ModelAttribute("schedule") DriverSchedule schedule,
                                       @RequestParam("shiftStart") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date shiftStart,
                                       @RequestParam("shiftEnd") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date shiftEnd,
                                       @RequestParam("restPeriodStart") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date restPeriodStart,
                                       @RequestParam("restPeriodEnd") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date restPeriodEnd) {
        schedule.setShiftStart(shiftStart);
        schedule.setShiftEnd(shiftEnd);
        schedule.setRestPeriodStart(restPeriodStart);
        schedule.setRestPeriodEnd(restPeriodEnd);
        scheduleDao.update(schedule);
        return "redirect:/driverSchedules";
    }

    @RequestMapping(value = "/deleteDriverSchedule/{id}", method = RequestMethod.GET)
    public String deleteDriverSchedule(@PathVariable int id) {
    	
        scheduleDao.delete(id);
        
        return "redirect:/driverSchedules";
    }

    @RequestMapping("/optimizeDriverSchedules")
    public String optimizeDriverSchedules() {
        
        List<DriverSchedule> schedules = scheduleDao.getDriverSchedules();

        optimizeSchedules(schedules);

        notifyDrivers(schedules);

        return "redirect:/driverSchedules";
    }

    private void optimizeSchedules(List<DriverSchedule> schedules) {
  
        for (DriverSchedule schedule : schedules) {

            if (schedule.getRestPeriodEnd().getTime() - schedule.getRestPeriodStart().getTime() < 8 * 60 * 60 * 1000) {
                
                schedule.setRestPeriodEnd(new Date(schedule.getRestPeriodStart().getTime() + 8 * 60 * 60 * 1000));
            }
           
            scheduleDao.update(schedule);
        }
    }

    private void notifyDrivers(List<DriverSchedule> schedules) {
       
        for (DriverSchedule schedule : schedules) {
            System.out.println("Notifying driver " + schedule.getDriverId() + " of schedule:");
            System.out.println("Shift start: " + schedule.getShiftStart());
            System.out.println("Shift end: " + schedule.getShiftEnd());
            System.out.println("Rest period start: " + schedule.getRestPeriodStart());
            System.out.println("Rest period end: " + schedule.getRestPeriodEnd());
        }
    }
}