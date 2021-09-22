package com.hardware.procurement.hardwareRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/procurementAPI")
public class HardwareRequestController {

    @Autowired
    private HardwareRequestRepo hardwareRequestRepo;


    @PostMapping("/engineering/createRequest")
    public ResponseEntity<HardwaresRequest> createRequests(@RequestBody HardwareReqTO hardwaresReqTO){
        try{
            HardwaresRequest hardwaresRequest1 = hardwareRequestRepo
                    .save(new HardwaresRequest(hardwaresReqTO.getRequestId(),hardwaresReqTO.getHardwaresList(),false,false));
            return new ResponseEntity<>(hardwaresRequest1, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/engineering/requests")
    public ResponseEntity<List<HardwaresRequest>> getAllRequests(){
        try {
            List<HardwaresRequest> hardwaresRequestList = new ArrayList<>();
            hardwareRequestRepo.findAll().forEach(hardwaresRequestList::add);
            if (hardwaresRequestList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(hardwaresRequestList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/engineering/requests/{requestId}")
    public ResponseEntity<HardwaresRequest> getRequestById(@PathVariable int id){
        Optional<HardwaresRequest> hardwareRequest = hardwareRequestRepo.findById(id);
        if (hardwareRequest.isPresent()) {
            return new ResponseEntity<>(hardwareRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/finance/approvedRequests/{requestId}")
    public ResponseEntity<HardwaresRequest> getEngAppRequestById(@PathVariable long id){
        try {
            Optional<HardwaresRequest> hardwareRequest = hardwareRequestRepo.findByRequestIdAndEngHeadApproval(id, true);
            if (hardwareRequest.isPresent()) {
                return new ResponseEntity<>(hardwareRequest.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/finance/requests")
    public ResponseEntity<List<HardwaresRequest>> getAllEngAppRequestById(){
        try {
            List<HardwaresRequest> hardwareRequest = hardwareRequestRepo.findByEngHeadApproval(true);
            if (hardwareRequest.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(hardwareRequest, HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/engineering/requests/approve/{requestId}/")
    public ResponseEntity<HardwaresRequest> approveHardwareRequest(@PathVariable("id") int id){
        Optional<HardwaresRequest> hardwaresRequest = hardwareRequestRepo.findById(id);
        if (hardwaresRequest.isPresent()) {
            HardwaresRequest hardwaresRequest1 = hardwaresRequest.get();
            hardwaresRequest1.setEngheadapproval(true);
            return new ResponseEntity<>(hardwareRequestRepo.save(hardwaresRequest1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/finance/requests/approve/{requestId}")
    public ResponseEntity<HardwaresRequest> financeApproveHardwareRequest(@PathVariable("id") long id){
        Optional<HardwaresRequest> hardwaresRequest = hardwareRequestRepo.findByRequestIdAndEngHeadApproval(id, true);
        if (hardwaresRequest.isPresent()) {
            HardwaresRequest hardwaresRequest1 = hardwaresRequest.get();
            hardwaresRequest1.setFinanceheadapproval(true);
            return new ResponseEntity<>(hardwareRequestRepo.save(hardwaresRequest1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/vendor/requests")
    public ResponseEntity<List<HardwaresRequest>> getAllRequestsForVendor(){
        try {
            List<HardwaresRequest> hardwareRequest = hardwareRequestRepo.findByEngHeadApprovalAndFinanceHeadApproval(true,true);
            if (hardwareRequest.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(hardwareRequest, HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vendor/requests/{requestId}")
    public ResponseEntity<HardwaresRequest> getVendorRequestsById(@PathVariable long id){
        try {
            Optional<HardwaresRequest> hardwareRequest = hardwareRequestRepo.findByRequestIdAndEngHeadApprovalAndFinanceHeadApproval(id, true,true);
            if (hardwareRequest.isPresent()) {
                return new ResponseEntity<>(hardwareRequest.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
