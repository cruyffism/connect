package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}
