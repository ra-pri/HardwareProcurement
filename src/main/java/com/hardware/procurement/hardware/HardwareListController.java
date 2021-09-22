package com.hardware.procurement.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/procurementAPI")
public class HardwareListController {

    @Autowired
    private HardwareListService hardwareListService;

    @PostMapping("/createHardwares")
    public void saveHardware(@RequestBody HardwaresList hardwaresList){
        hardwareListService.saveOrUpdateHardware(hardwaresList);
    }

    @GetMapping("/allHardwares")
    public ResponseEntity<List<HardwaresList>> getHardwares(){
        try {
            ArrayList<HardwaresList> hardwares = hardwareListService.getHardwareList();
            if (hardwares.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(hardwares, HttpStatus.OK);
            }
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hardware/{id}")
    public Optional<HardwaresList> getHardwareById(@PathVariable long id){
        return hardwareListService.getHardwareListById(id);
    }


    @PutMapping("/hardwares")
    public HardwaresList updateHardware(@RequestBody HardwaresList hardwaresList){
        hardwareListService.saveOrUpdateHardware(hardwaresList);
        return hardwaresList;
    }

}
