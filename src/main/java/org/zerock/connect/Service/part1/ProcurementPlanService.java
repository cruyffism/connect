package org.zerock.connect.Service.part1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.connect.repository.ProcurementPlanRepository;

@Service
public class ProcurementPlanService {

    @Autowired
    ProcurementPlanRepository procurementPlanRepository;


}
