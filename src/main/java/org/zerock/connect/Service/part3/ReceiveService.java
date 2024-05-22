package org.zerock.connect.Service.part3;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.connect.entity.Receive;
import org.zerock.connect.repository.ReceiveRepository;

import java.util.List;

@Service
public class ReceiveService {

    @Autowired
    ReceiveRepository receiveRepository;

    public List<Receive> getAllReceive() {
        return receiveRepository.getAllReceive();
    }

    public Receive findByReceiveNum(Long receiveNum){
        return receiveRepository.findByReceiveNum(receiveNum);
    }

    // 입고 예정 품목 리스트 아작스
    public List<Receive> getReceiveListAjax(String itemCode, String itemName, String receiveYn) {
        return receiveRepository.getReceiveListAjax(itemCode, itemName, receiveYn);
    }

    // 입고 버튼 api
    @Transactional
    public Integer receive(Long receiveNum) {
        return receiveRepository.receive(receiveNum);
    }

    // receive_yn 컬럼이 'Y'인 입고 완료된 품목 리스트 가져오기 (거래명세서페이지에서 보여줄)
    public List<Receive> getReceiveListByStatus(String status) {
        return receiveRepository.findByReceiveYn(status);
    }


}
