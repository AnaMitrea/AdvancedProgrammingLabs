package network.nodes;

import interfaces.Identifiable;
import interfaces.Storage;

public class Computer extends Node implements Identifiable, Storage {
    private String address;
    private double storageCapacity;

    public Computer(String name, String address, double storageCapacity) {
        this.name = name;
        this.address = address;
        this.storageCapacity = storageCapacity;
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
    public double getStorageCapacity() {
        return this.storageCapacity;
    }

    @Override
    public void setStorageCapacity(double storageCapacity) {
        this.storageCapacity = storageCapacity;
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
        return this.name + "(Nodes.Computer, addr= " + this.address + ", storage= " + this.storageCapacity + ") ";
    }
}
