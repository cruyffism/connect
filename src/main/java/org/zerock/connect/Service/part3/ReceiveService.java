package org.zerock.connect.Service.part3;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
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

    public int findByreceiveN(){
        return receiveRepository.findByreceiveN();
    }

    public int findByreceiveY(){
        return receiveRepository.findByreceiveY();
    }

    // receive_yn 컬럼이 'Y' + publish에 없는 (거래명세서페이지에서 보여줄)
    public List<Receive> findReceiveNotInPublishAndReceiveYn() {
        return receiveRepository.findReceiveNotInPublishAndReceiveYn();
    }

//    // Publish 테이블에 속하지 않은 Receive 조회
//    public List<Receive> findReceiveNotInPublish() {
//        return receiveRepository.findReceiveNotInPublish();
//    }

    public List<Receive> searchReceive(String keyword) {
        return  receiveRepository.searchReceive(keyword);
    }

    // 정렬된 입고 완료 품목
    public List<Receive> getAllReceiveSortedByReceiveDate() {
        return receiveRepository.findAll(Sort.by(Sort.Direction.ASC, "receiveDate"));
    }
}
