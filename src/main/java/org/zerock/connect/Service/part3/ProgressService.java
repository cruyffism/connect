package org.zerock.connect.Service.part3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.connect.entity.Progress;
import org.zerock.connect.repository.ProgressRepository;

import java.util.List;

@Service
public class ProgressService {

    @Autowired
    ProgressRepository progressRepository;

    public List<Progress> noReceiveList(){
        return progressRepository.noReceiveList();
    }

}
