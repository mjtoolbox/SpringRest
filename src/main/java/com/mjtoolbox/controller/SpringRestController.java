package com.mjtoolbox.controller;

import com.mjtoolbox.bean.Message;
import com.mjtoolbox.service.SpringRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msjo on 6/14/2015.
 */
@RestController
@RequestMapping("/service")
public class SpringRestController {

    @Autowired
    private SpringRestService springRestService;


    @RequestMapping(value = "/messages", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Message> getMessageList()
    {
        return springRestService.getAllEvents();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addMessage(@RequestBody Message message) {
        springRestService.addEvent(message);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateMessage(@RequestBody  Message message) {
        springRestService.updateEvent(message);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeMessage(@PathVariable("id") Long id) {
        springRestService.deleteEventById(id);
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    public void removeAllMessages() {
        springRestService.deleteAll();
    }

//    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
//    public String getGreeting(@PathVariable String name) {
//        String result = "Hello " + name;
//        return result;
//    }

}
