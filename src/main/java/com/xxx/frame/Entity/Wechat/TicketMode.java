package com.xxx.frame.Entity.Wechat;

import java.io.Serializable;

public class TicketMode  extends WXBaseResult implements Serializable {
    private static final long serialVersionUID = 1714568200902557216L;
    private String ticket;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

}
