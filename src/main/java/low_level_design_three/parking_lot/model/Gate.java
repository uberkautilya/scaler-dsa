package low_level_design_three.parking_lot.model;

import low_level_design_three.parking_lot.model.enums.GateStatus;
import low_level_design_three.parking_lot.model.enums.GateType;

public class Gate extends BaseModel {
    private String gateNumber;
    private Operator operator;
    private GateType type;
    private GateStatus status;

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateType getType() {
        return type;
    }

    public void setType(GateType type) {
        this.type = type;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }
}
