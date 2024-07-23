package low_level_design_three.parking_lot.model;

import low_level_design_three.parking_lot.model.enums.ParkingLotStatus;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    private ParkingLotStatus status;
    private List<ParkingFloor> floors;
    private List<Gate> entryGates;
    private List<Gate> exitGates;

    //Each vehicle type capacity necessary -
    // don't use hashmap - additional information in the future may be difficult to incorporate
    private List<VehicleTypeCapacity> vehicleTypeCapacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<Gate> getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(List<Gate> entryGates) {
        this.entryGates = entryGates;
    }

    public List<Gate> getExitGates() {
        return exitGates;
    }

    public void setExitGates(List<Gate> exitGates) {
        this.exitGates = exitGates;
    }

    public List<VehicleTypeCapacity> getVehicleTypeCapacity() {
        return vehicleTypeCapacity;
    }

    public void setVehicleTypeCapacity(List<VehicleTypeCapacity> vehicleTypeCapacity) {
        this.vehicleTypeCapacity = vehicleTypeCapacity;
    }
}
