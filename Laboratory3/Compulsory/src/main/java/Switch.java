public class Switch extends Node implements Identifiable{
    private String address;

    public Switch(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + "(Switch) ";
    }
}
