package home.learn.sb.kafka.model;

public class UserDetails {
    String name;
    String technology;

    public UserDetails() {}

    public UserDetails(String name, String technology) {
        this.name = name;
        this.technology = technology;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }
    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "name='" + name + '\'' +
                ", technology='" + technology + '\'' +
                '}';
    }
}
