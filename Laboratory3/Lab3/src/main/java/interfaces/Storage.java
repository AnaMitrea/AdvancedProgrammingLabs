package interfaces;

public interface Storage {
    double getStorageCapacity();
    void setStorageCapacity(double storageCapacity);

    default double getStorageCapacityInMegaByte(double storageCapacity) {
        return storageCapacity * 1024;
    }

    default double getStorageCapacityInKyloByte(double storageCapacity) {
        return storageCapacity * 1_048_576;
    }

    default double getStorageCapacityInByte(double storageCapacity) {
        return storageCapacity * 1_073_741_824;
    }
}