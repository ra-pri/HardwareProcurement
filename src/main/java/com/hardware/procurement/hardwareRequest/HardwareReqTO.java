package com.hardware.procurement.hardwareRequest;

import com.hardware.procurement.hardware.HardwaresList;

import javax.persistence.*;
import java.util.List;

public class HardwareReqTO {

        private int requestId;

        private List<HardwaresList> hardwaresList;

        private boolean engHeadApproval;

        private boolean financeHeadApproval;

    public int getRequestId() {
        return requestId;
    }

    public boolean isFinanceHeadApproval() {
        return financeHeadApproval;
    }

    public void setFinanceHeadApproval(boolean financeHeadApproval) {
        this.financeHeadApproval = financeHeadApproval;
    }

    public boolean isEngHeadApproval() {

        return engHeadApproval;
    }

    public void setEngHeadApproval(boolean engHeadApproval) {
        this.engHeadApproval = engHeadApproval;
    }

    public List<HardwaresList> getHardwaresList() {
        return hardwaresList;
    }

    public void setHardwaresList(List<HardwaresList> hardwaresList) {
        this.hardwaresList = hardwaresList;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
}
