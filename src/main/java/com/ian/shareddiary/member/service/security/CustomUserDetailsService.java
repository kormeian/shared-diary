package com.ian.shareddiary.member.service.security;

import com.ian.shareddiary.member.exception.MemberNotFoundException;
import com.ian.shareddiary.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final MemberRepository memberRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userPk) throws UsernameNotFoundException {
		return memberRepository.findById(Long.parseLong(userPk))
			.orElseThrow(MemberNotFoundException::new);
	}
}
