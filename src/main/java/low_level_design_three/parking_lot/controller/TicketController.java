package low_level_design_three.parking_lot.controller;

import low_level_design_three.parking_lot.dto.EntryTicketRequestDto;
import low_level_design_three.parking_lot.dto.EntryTicketResponseDto;
import low_level_design_three.parking_lot.model.EntryTicket;
import low_level_design_three.parking_lot.model.enums.TicketStatus;
import low_level_design_three.parking_lot.services.TicketService;

public class TicketController {
    private TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    /**
     * EntryTicketRequestDto allows flexibility to add more fields for future scope
     * This allows the API contract to remain the same
     */
    public EntryTicketResponseDto issueTicket(EntryTicketRequestDto request) {

        //Sending the entire entity (Model) details to the client isn't advisable
        //Instead transfer only the fields required using a DTO: Data Transfer Object
        EntryTicket entryTicket = service.issueTicket(request.getGateId(), request.getVehicleNumber());

        //The above response can now be mapped into the DTO
        EntryTicketResponseDto response = new EntryTicketResponseDto();
        response.setTicketId(entryTicket.getId());
        response.setStatus(TicketStatus.SUCCESS);
        return response;
    }
}
