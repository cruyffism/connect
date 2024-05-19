package org.zerock.connect.Service.part3;

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
        return receiveRepository.findAll();
    }

    public Receive findByReceiveNum(Long receiveNum){
        return receiveRepository.findByReceiveNum(receiveNum);
    }

}
