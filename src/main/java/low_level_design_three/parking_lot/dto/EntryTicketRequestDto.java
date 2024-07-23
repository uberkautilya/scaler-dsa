package low_level_design_three.parking_lot.dto;

import low_level_design_three.parking_lot.model.Gate;

public class EntryTicketRequestDto {
    private int gateId;
    private String vehicleNumber;

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
