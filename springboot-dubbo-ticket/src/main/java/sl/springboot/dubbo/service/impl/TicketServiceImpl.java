package sl.springboot.dubbo.service.impl;

import sl.springboot.dubbo.service.TicketService;

public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "大话西游";
    }
}
