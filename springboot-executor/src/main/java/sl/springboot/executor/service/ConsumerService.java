package sl.springboot.executor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
public class ConsumerService {

    @Autowired
    private RestTemplate template;
    private String url;

    @PostConstruct
    private void init(){
        url = "http://localhost:8080/server/buy/";
    }

    @Async
    public void buyPhone(String id){
        template.getForObject(url + id,String.class);
    }
}
