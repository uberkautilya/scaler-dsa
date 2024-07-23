package low_level_design_three.parking_lot.model;

import low_level_design_three.parking_lot.model.enums.VehicleType;

public class VehicleTypeCapacity {
    private VehicleType vehicleType;
    private int capacity;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
