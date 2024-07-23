package low_level_design_three.parking_lot.model;

import java.time.LocalDateTime;

public class EntryTicket extends BaseModel {
    Gate gate;
    LocalDateTime entryTime;
    //The operator who issued this ticket, not the one currently referred in the Gate object above
    Operator operator;
    ParkingSlot slotAllotted;
    Vehicle vehicle;

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public ParkingSlot getSlotAllotted() {
        return slotAllotted;
    }

    public void setSlotAllotted(ParkingSlot slotAllotted) {
        this.slotAllotted = slotAllotted;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
