package com.hardware.procurement.hardwareRequest;

import com.hardware.procurement.hardware.HardwaresList;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hardwaresRequest")
public class HardwaresRequest {

    @Id
    @Column(name = "requestId")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    @OneToMany(mappedBy = "hardwarerequest",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<HardwaresList> hardwaresList;

    @Column(name = "engheadapproval")
    private boolean engHeadApproval;

    @Column(name = "financeHeadApproval")
    private boolean financeHeadApproval;

    public HardwaresRequest() {

    }

    public boolean isFinanceheadapproval() {
        return financeHeadApproval;
    }

    public void setFinanceheadapproval(boolean financeheadapproval) {
        this.financeHeadApproval= financeheadapproval;
    }

    public HardwaresRequest(int requestid, List<HardwaresList> hardwaresList, boolean engheadapproval,boolean financeheadapproval) {
        this.requestId = requestid;
        this.hardwaresList = hardwaresList;
        this.engHeadApproval = engheadapproval;
        this.financeHeadApproval = financeheadapproval;
    }

    public boolean getEngheadapproval() {
        return engHeadApproval;
    }

    public void setEngheadapproval(boolean engheadapproval) {
        this.engHeadApproval = engheadapproval;
    }

    public List<HardwaresList> getHardwaresList() {
        return hardwaresList;
    }

    public void setHardwareList(List<HardwaresList> hardwaresList) {
        this.hardwaresList = hardwaresList;
    }

    public int getRequestid() {
        return requestId;
    }

    public void setrequestid(int requestId) {
        this.requestId = requestId;
    }
}
