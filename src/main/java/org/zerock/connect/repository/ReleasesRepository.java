package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Releases;

@Repository
public interface ReleasesRepository extends JpaRepository<Releases, Long> {


/*    Releases findByreleaseNum(Long releaseNum);*/
}
