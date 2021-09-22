package com.hardware.procurement.hardware;

import com.hardware.procurement.hardwareRequest.HardwaresRequest;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "hardwaresList")
public class HardwaresList {


    @javax.persistence.Id
    @Column(name = "hardwareid")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hardwareid;

    @Column(name = "hardwarename")
    private String hardwarename;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestId")
    private HardwaresRequest hardwarerequest;

    public HardwaresList() {

    }

    public HardwaresList(long hardwareid, String hardwarename, HardwaresRequest hardwaresRequest){
        this.hardwareid = hardwareid;
        this.hardwarename = hardwarename;
        this.hardwarerequest = hardwaresRequest;
    }

    public HardwaresRequest getHardwarerequest() {
        return hardwarerequest;
    }

    public void setHardwarerequest(HardwaresRequest hardwarerequest) {
        this.hardwarerequest = hardwarerequest;
    }

    public String getHardwarename() {

        return hardwarename;
    }

    public void setHardwarename(String hardwarename) {
        this.hardwarename = hardwarename;
    }

    public long getHardwareid() {
        return hardwareid;

    }

    public void setHardwareid(long hardwareid) {
        this.hardwareid = hardwareid;
    }

}
