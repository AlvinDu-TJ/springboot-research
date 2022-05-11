package sl.springboot.apollo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sl.springboot.apollo.bean.ApolloUser;

@RestController
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger( HelloController.class );

    @Value( "${key1}" )
    String port;

    @Autowired
    ApolloUser user;

    @Value( "${db.url}" )
    String dbUrl;

    @GetMapping("hi")
    public String hi(String name) {

        logger.debug( "debug log..." );
        logger.info( "info log..." );
        logger.warn( "warn log..." );

        System.out.println("user = " + user);

        return "hi " + name + " ,i am from messge:" + port + " , user is:"+user + ", dbUrl is " + dbUrl;
    }
}
