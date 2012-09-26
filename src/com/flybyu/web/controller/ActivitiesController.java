package com.flybyu.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.flybyu.web.model.ActivitiesDAO;
import com.flybyu.web.model.Activity;

@Controller
public class ActivitiesController {
	@Autowired
    private ActivitiesDAO activitiesDAO;
        
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
        
    @RequestMapping("/searchActivities")
    @ResponseBody
    public Object searchContacts(@RequestParam(required= false, defaultValue="") String name)
    {
        List<Activity> activities = activitiesDAO.searchContacts(name.trim());

        return activities;
    }

    @RequestMapping("/viewAllActivities")
    @ResponseBody
    public Object getAllActivities()
    {
        List<Activity> activities = activitiesDAO.getAllActivities();
        return activities;
    }
    
    @RequestMapping(value="/saveActivity", method=RequestMethod.POST)
    @ResponseBody
    public Integer create(Activity activity, BindingResult result, SessionStatus status)
    {
//        validator.validate(contact, result);
//        if (result.hasErrors())
//        {                
//            return "newContact";
//        }
        Integer id = activitiesDAO.save(activity);
        status.setComplete();
        return id;
    }
    
    @RequestMapping(value="/updateActivity", method=RequestMethod.POST)
    @ResponseBody
    public String update(Activity activity  , BindingResult result, SessionStatus status)
    {
//        validator.validate(contact, result);
//        if (result.hasErrors()) {
//            return "editContact";
//        }
        activitiesDAO.update(activity);
        status.setComplete();
        return "true";
    }
        
    @RequestMapping("deleteActivity")
    @ResponseBody
    public String delete(@RequestParam("id")Integer id)
    {
        activitiesDAO.delete(id);
        return "true";
    }
}
