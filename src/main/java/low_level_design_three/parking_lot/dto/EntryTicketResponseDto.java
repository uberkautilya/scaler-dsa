package low_level_design_three.parking_lot.dto;

import low_level_design_three.parking_lot.model.enums.TicketStatus;

public class EntryTicketResponseDto {
    private int ticketId;
    private TicketStatus status;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
