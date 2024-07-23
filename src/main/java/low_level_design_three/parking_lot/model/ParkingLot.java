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
}
