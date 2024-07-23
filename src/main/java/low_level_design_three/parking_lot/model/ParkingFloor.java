package low_level_design_three.parking_lot.model;

import low_level_design_three.parking_lot.model.enums.ParkingFloorStatus;

import java.util.List;

public class ParkingFloor extends BaseModel {
    private String floorNumber;
    private List<ParkingSlot> slots;
    private ParkingFloorStatus status;
    private List<VehicleTypeCapacity> vehicleTypeCapacities;

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    public ParkingFloorStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingFloorStatus status) {
        this.status = status;
    }

    public List<VehicleTypeCapacity> getVehicleTypeCapacities() {
        return vehicleTypeCapacities;
    }

    public void setVehicleTypeCapacities(List<VehicleTypeCapacity> vehicleTypeCapacities) {
        this.vehicleTypeCapacities = vehicleTypeCapacities;
    }
}
