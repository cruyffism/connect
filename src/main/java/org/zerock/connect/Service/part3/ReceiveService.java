package org.zerock.connect.Service.part3;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.connect.entity.Progress;
import org.zerock.connect.entity.Receive;
import org.zerock.connect.repository.ProgressRepository;
import org.zerock.connect.repository.ReceiveRepository;

import java.util.List;

@Service
public class ReceiveService {

    @Autowired
    ReceiveRepository receiveRepository;

    // 입고 예정 품목 리스트 아작스
    public List<Receive> getReceiveListAjax(String itemCode, String itemName, String receiveYn) {
        return receiveRepository.getReceiveListAjax(itemCode, itemName, receiveYn);
    }

    // 입고 버튼 api
    @Transactional
    public Integer receive(Long receiveNum) {
        return receiveRepository.receive(receiveNum);
    }





    // receiveYn 확인 (입고예정/ 완료 각 리스트 출력)
    public List<Receive> getReceiveListByReceiveYn(String receiveYn) {
        return receiveRepository.findByReceiveYn(receiveYn);
    }


    public List<Receive> getAllReceive() {
        return receiveRepository.getAllReceive();
    }

}
