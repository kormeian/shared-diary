package com.ian.shareddiary.member.repository;

import com.ian.shareddiary.member.domain.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	List<Member> findByName(String name);

	Optional<Member> findByEmail(String email);
}
