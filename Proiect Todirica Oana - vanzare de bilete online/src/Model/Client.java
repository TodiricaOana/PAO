package Model;

import java.util.Objects;

public class Client {
    private static Integer id;
    private Integer clientId;

    static {
        id = 0;
    }

    protected String name;

    public Client() {
        id++;
    }

    public Client(String name) {
        this.name = name;
        id++;
        this.clientId = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getClientId(), client.getClientId()) &&
                Objects.equals(getName(), client.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getName());
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }

    public Double getPrice(Event event) {
        return event.getPrice();
    }


}
