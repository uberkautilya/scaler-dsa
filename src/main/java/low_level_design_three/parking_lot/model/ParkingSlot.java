package low_level_design_three.parking_lot.model;

import low_level_design_three.parking_lot.model.enums.ParkingSlotStatus;

import java.util.List;

public class ParkingSlot {
    private String slotNumber;
    private List<VehicleTypeCapacity> vehicleTypeCapacities;
    private ParkingSlotStatus status;
    private ParkingFloor floor;

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public List<VehicleTypeCapacity> getVehicleTypeCapacities() {
        return vehicleTypeCapacities;
    }

    public void setVehicleTypeCapacities(List<VehicleTypeCapacity> vehicleTypeCapacities) {
        this.vehicleTypeCapacities = vehicleTypeCapacities;
    }

    public ParkingSlotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSlotStatus status) {
        this.status = status;
    }
}
