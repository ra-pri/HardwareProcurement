package com.hardware.procurement.hardware;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HardwareListRepo extends CrudRepository<HardwaresList, Long> {

}
