package sl.springboot.server.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @RequestMapping("/server/buy/{id}")
    @ResponseBody
    public String index(@PathVariable String id){
        System.out.println(id);
        return id;
    }
}
