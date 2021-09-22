package com.hardware.procurement.hardwareRequest;


import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HardwareRequestRepo extends CrudRepository<HardwaresRequest, Integer> {
    List<HardwaresRequest> findByEngHeadApproval(boolean approval);

    List<HardwaresRequest> findByEngHeadApprovalAndFinanceHeadApproval(boolean engHeadApproval,boolean financeHeadApproval);

    Optional<HardwaresRequest> findByRequestIdAndEngHeadApproval(long requestId, boolean engHeadApproval);

    Optional<HardwaresRequest> findByRequestIdAndEngHeadApprovalAndFinanceHeadApproval(long requestId, boolean engHeadApproval,boolean financeHeadApproval);
}
