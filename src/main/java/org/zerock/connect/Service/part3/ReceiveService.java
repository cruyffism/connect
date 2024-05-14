package org.zerock.connect.Service.part3;

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

    // receiveYn 확인 (입고예정/ 완료 각 리스트 출력)
    public List<Receive> getReceiveListByReceiveYn(String receiveYn) {
        return receiveRepository.findByReceiveYn(receiveYn);
    }

}
