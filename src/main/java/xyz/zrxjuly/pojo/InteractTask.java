package xyz.zrxjuly.pojo;

public class InteractTask {
    private String id;
    private String context;
    private String child_name;
    private String volunteer_name;

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

    @Override
    public String toString() {
        return "InteractTask{" +
                "id='" + id + '\'' +
                ", context='" + context + '\'' +
                ", child_name='" + child_name + '\'' +
                ", volunteer_name='" + volunteer_name + '\'' +
                '}';
    }
}
