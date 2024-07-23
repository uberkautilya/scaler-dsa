package low_level_design_three.parking_lot.model;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {
    private Date exitTime;
    private int amount;
    private Gate exitGate;
    private Operator exitOperator;
    private EntryTicket ticket;

    // Total Rupees 70: 30 in cash, 40 in UPI payment possible.
    // Also, details for all failed or refund payments
    private List<Payment> payments;
}
