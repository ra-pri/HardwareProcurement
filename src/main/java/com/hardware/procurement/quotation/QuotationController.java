package com.hardware.procurement.quotation;

import com.hardware.procurement.hardwareRequest.HardwaresRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/procurementAPI")
public class QuotationController {

    @Autowired
    private QuotationRepo quotationRepo;

    @Autowired
    private  QuotationService quotationService;

    @GetMapping("/finance/quotation/{id}")
    public ResponseEntity<Quotations> getQuotationById(@PathVariable long id){
        Optional<Quotations> quotation = quotationRepo.findById(id);
        if (quotation.isPresent()) {
            return new ResponseEntity<>(quotation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/finance/quotations/approve/{quotationId}")
    public ResponseEntity<Quotations> financeApproveHardwareRequest(@PathVariable("id") long id){
        Optional<Quotations> quotations = quotationRepo.findById(id);
        if (quotations.isPresent()) {
            Quotations quotations1 = quotations.get();
            quotations1.setApproval(true);
            return new ResponseEntity<>(quotationRepo.save(quotations1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/vendors/submitQuotation")
    public ResponseEntity<Quotations> submitQuotation(@RequestBody Quotations quotations){
        try{
            Quotations quotations1 = quotationRepo
                    .save(new Quotations(quotations.getQuotationId(),quotations.getRequestId(),quotations.getCost(),quotations.getDeliveryTime()));
            return new ResponseEntity<>(quotations1, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/finance/bestQuotations")
    public List<Long> getBestQuotation(){
        return quotationService.bestDeal();
    }
}
