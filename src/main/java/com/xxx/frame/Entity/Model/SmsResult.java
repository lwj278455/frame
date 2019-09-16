package com.xxx.frame.Entity.Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("returnsms")
public class SmsResult implements Serializable {

    private static final long serialVersionUID = 7995617845934342949L;

    private String returnstatus;
    private String message;
    private String remainpoint;
    private String taskID;
    private String successCounts;

    public String getReturnstatus() {
        return returnstatus;
    }

    public void setReturnstatus(String returnstatus) {
        this.returnstatus = returnstatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemainpoint() {
        return remainpoint;
    }

    public void setRemainpoint(String remainpoint) {
        this.remainpoint = remainpoint;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getSuccessCounts() {
        return successCounts;
    }

    public void setSuccessCounts(String successCounts) {
        this.successCounts = successCounts;
    }

    @Override
    public String toString() {
        return "SmsResult{" +
                "returnstatus='" + returnstatus + '\'' +
                ", message='" + message + '\'' +
                ", remainpoint='" + remainpoint + '\'' +
                ", taskID='" + taskID + '\'' +
                ", successCounts='" + successCounts + '\'' +
                '}';
    }
}
