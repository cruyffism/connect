package org.zerock.connect.Service.part3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.connect.entity.Releases;
import org.zerock.connect.repository.ReceiveRepository;
import org.zerock.connect.repository.ReleasesRepository;

import java.util.List;

@Service
public class ReleasesService {

    @Autowired
    ReleasesRepository releasesRepository;

    @Autowired
    ReceiveRepository receiveRepository;

    public List<Releases> getAllReleases() {
        return releasesRepository.findAll();
    }
}
