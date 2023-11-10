package xyz.zrxjuly.pojo;

import java.sql.Date;

public class InteractTask {
    private String id;
    private String context;
    private String child_name;
    private String volunteer_name;
    private Date start_date;
    private Date end_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getChild_name() {
        return child_name;
    }

    public void setChild_name(String child_name) {
        this.child_name = child_name;
    }

    public String getVolunteer_name() {
        return volunteer_name;
    }

    public void setVolunteer_name(String volunteer_name) {
        this.volunteer_name = volunteer_name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "InteractTask{" +
                "id='" + id + '\'' +
                ", context='" + context + '\'' +
                ", child_name='" + child_name + '\'' +
                ", volunteer_name='" + volunteer_name + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
