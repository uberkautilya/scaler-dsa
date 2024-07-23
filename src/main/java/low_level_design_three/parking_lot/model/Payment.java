package low_level_design_three.parking_lot.model;

import low_level_design_three.parking_lot.model.enums.PaymentMode;
import low_level_design_three.parking_lot.model.enums.PaymentStatus;

import java.util.Date;

public class Payment extends BaseModel {
    int amount;
    Date time;
    PaymentMode mode;
    PaymentStatus status;
    // In case of cash payments, there wouldn't be any reference number
    int referenceNumber;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
