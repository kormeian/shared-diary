package com.ian.shareddiary.member.repository;

import com.ian.shareddiary.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
	boolean existsByEmailAddress(String emailAddress);
	boolean existsByNickname(String nickname);
	boolean existsByPhoneNumber(String phoneNumber);
}
