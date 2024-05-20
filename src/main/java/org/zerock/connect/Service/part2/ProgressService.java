package org.zerock.connect.Service.part2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.connect.entity.Orders;
import org.zerock.connect.repository.OrdersRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProgressService {
    @Autowired
    OrdersRepository ordersRepository;

    //검수 예정 품목 리스트 아작스
    public List<Orders> progressScheduleAjax(String itemCode, String itemName, LocalDate startDate, LocalDate endDate) {
        return ordersRepository.progressScheduleAjax(itemCode, itemName, startDate, endDate);
    }

    public List<Orders> findProgressScheduleList(String itemCode, String itemName) {
        return ordersRepository.findProgressScheduleList(itemCode, itemName);
    }

    //검수 선택 api
    public Orders progressChoiceAjax(Long orderNum) {
        return ordersRepository.progressChoiceAjax(orderNum);
    }
}
