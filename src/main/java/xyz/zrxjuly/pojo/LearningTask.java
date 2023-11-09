package xyz.zrxjuly.pojo;

public class LearningTask {
    private String id;
    private String context;
    private String child_name;

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

    @Override
    public String toString() {
        return "LearningTask{" +
                "id='" + id + '\'' +
                ", context='" + context + '\'' +
                ", child_name='" + child_name + '\'' +
                '}';
    }
}
