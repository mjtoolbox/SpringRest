package main.java.mjtoolbox;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by msjo on 6/14/2015.
 */
@RestController
@RequestMapping("/service/greeting")
public class SpringRestController {
    @RequestMapping(value="/{name}", method= RequestMethod.GET)
    public String getGreeting(@PathVariable String name){
        String result = "Hello " + name;
        return result;
    }
}
