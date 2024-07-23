package low_level_design_three.parking_lot.services;

import low_level_design_three.parking_lot.model.*;
import low_level_design_three.parking_lot.model.enums.ParkingFloorStatus;
import low_level_design_three.parking_lot.model.enums.ParkingSlotStatus;

import java.util.Date;

public class TicketService {
    private ParkingLot lot;

    public TicketService(ParkingLot lot) {
        this.lot = lot;
    }

    public EntryTicket issueTicket(int gateId, String vehicleNumber) {
        ParkingSlot parkingSlot = lot.getFloors().stream()
                .filter(floorStatus -> floorStatus.getStatus() == ParkingFloorStatus.OPEN)
                .flatMap(parkingFloor -> parkingFloor.getSlots().stream())
                .filter(s -> s.getStatus() == ParkingSlotStatus.EMPTY)
                .findFirst().orElse(new ParkingSlot());
        Gate entryGate = lot.getEntryGates().stream()
                .filter(gate -> gate.getId() == gateId)
                .findFirst().orElse(new Gate());
        Operator operator = entryGate.getOperator();
        EntryTicket entryTicket = new EntryTicket();
        entryTicket.setSlotAllotted(parkingSlot);
        entryTicket.setEntryTime(new Date());
        entryTicket.setOperator(operator);
        entryTicket.setCreatedAt(new Date());
        entryTicket.setUpdatedAt(new Date());
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate(vehicleNumber);
        entryTicket.setVehicle(vehicle);

        return entryTicket;
    }
}
