package sl.springboot.server.controller;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    RateLimiter rateLimiter = RateLimiter.create(10);

    @RequestMapping("/server/buy/{id}")
    @ResponseBody
    public String index(@PathVariable String id){
        System.out.println(id);
        if (rateLimiter.tryAcquire()) {
            System.out.println(id + "支付成功");
        } else {
            System.out.println(id + "支付失败请求繁忙，请稍后重试");
        }
        return id;
    }
}
