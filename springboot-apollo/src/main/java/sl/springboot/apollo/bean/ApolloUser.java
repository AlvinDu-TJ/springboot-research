package sl.springboot.apollo.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ApolloUser {
    @Value( "${apollo.user.name}" )
    private String name;
    @Value( "${apollo.user.age}" )
    private int age;
}
