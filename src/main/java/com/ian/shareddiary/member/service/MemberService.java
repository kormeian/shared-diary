package com.ian.shareddiary.member.service;

import com.ian.shareddiary.member.dto.MemberDto;
import com.ian.shareddiary.member.entity.Member;
import com.ian.shareddiary.member.repository.MemberRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

	private final MemberRepository memberRepository;

	public Member createMember(MemberDto.RequestMemberDto request){
		request
	}

	public void modifyMember(Member member){

	}

	public void deleteMember(Member member){

    }

}
