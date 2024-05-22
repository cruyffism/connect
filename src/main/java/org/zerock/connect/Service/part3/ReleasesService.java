package org.zerock.connect.Service.part3;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.connect.entity.Receive;
import org.zerock.connect.entity.Releases;
import org.zerock.connect.repository.ReceiveRepository;
import org.zerock.connect.repository.ReleasesRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReleasesService {

    @Autowired
    ReleasesRepository releasesRepository;

    @Autowired
    ReceiveRepository receiveRepository;

    // 재고 현황 리스트
    public List<Releases> getAllReleases() {
        return releasesRepository.findAll();
    }

    // 출고수량저장
    public Releases save(Releases releases) {
        return releasesRepository.save(releases);
    }

}
