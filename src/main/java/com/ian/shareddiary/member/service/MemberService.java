package com.ian.shareddiary.member.service;

import com.ian.shareddiary.member.domain.Member;
import com.ian.shareddiary.member.dto.MemberDto;
import com.ian.shareddiary.member.repository.MemberRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService implements UserDetailsService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	public Member createMember(MemberDto.RequestMemberDto request) {
		request.encryptPassword(passwordEncoder.encode(request.getPassword()));

		Member member = request.toEntity();
		memberRepository.save(member);
		log.info("Created member : " + member.getEmail());

		return member;
	}

	public void modifyMember(Member member) {

	}

	public void deleteMember(Member member) {

	}

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		return memberRepository.findById(Long.parseLong(id))
			.orElseThrow(() -> new UsernameNotFoundException("User " + id + " Not Found!"));
	}
}
