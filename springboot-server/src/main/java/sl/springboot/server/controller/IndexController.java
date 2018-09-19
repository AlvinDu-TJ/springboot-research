package sl.springboot.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sl.springboot.server.bean.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model){
        Person single=new Person("aa",1);
        List<Person> people=new ArrayList<Person>();
        Person p1=new Person("bb",2);
        Person p2=new Person("cc",3);
        Person p3=new Person("dd",4);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "index";
    }
}
