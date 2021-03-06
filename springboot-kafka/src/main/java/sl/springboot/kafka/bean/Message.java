package sl.springboot.kafka.bean;

import lombok.Data;

@Data
public class Message {
    private Long id;    //id

    private String msg; //消息

    private String localDateTime;
}
