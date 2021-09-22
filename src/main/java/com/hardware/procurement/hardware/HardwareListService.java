package com.hardware.procurement.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class HardwareListService {

    @Autowired
    private HardwareListRepo hardwareListRepo;

    public void saveOrUpdateHardware(HardwaresList list){
        hardwareListRepo.save(list);
    }

    public ArrayList<HardwaresList> getHardwareList() {
        ArrayList<HardwaresList> hardwares = new ArrayList<>();
        Iterable<HardwaresList> hl = hardwareListRepo.findAll();
        System.out.println("enter");
        hardwareListRepo.findAll().forEach(hardwares::add);
        System.out.println(hardwares.size());
        for(int i=0;i<hardwares.size();i++){
            System.out.println(hardwares.get(i));
        }
        return hardwares;
    }

    public Optional<HardwaresList> getHardwareListById(long id){
        return hardwareListRepo.findById(id);
    }



}
