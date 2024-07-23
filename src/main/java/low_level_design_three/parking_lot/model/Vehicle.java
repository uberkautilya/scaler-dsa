package low_level_design_three.parking_lot.model;

import low_level_design_three.parking_lot.model.enums.VehicleType;

public class Vehicle extends BaseModel {
    private String licensePlate;
    private String ownerName;

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    private VehicleType type;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
