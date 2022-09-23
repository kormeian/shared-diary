package com.ian.shareddiary.member.service;

import com.ian.shareddiary.config.security.JwtProvider;
import com.ian.shareddiary.member.domain.Member;
import com.ian.shareddiary.member.dto.MemberRequestDto.SignInDto;
import com.ian.shareddiary.member.dto.MemberRequestDto.SignUpDto;
import com.ian.shareddiary.member.dto.MemberResponseDto;
import com.ian.shareddiary.member.exception.EmailLoginFailedException;
import com.ian.shareddiary.member.exception.MemberAlreadyExistsException;
import com.ian.shareddiary.member.exception.MemberNotFoundException;
import com.ian.shareddiary.member.repository.MemberRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtProvider jwtProvider;

	@Transactional
	public Long createMember(SignUpDto request) {
		if (memberRepository.existsByEmail(request.getEmail())) {
			throw new MemberAlreadyExistsException();
		}
		request.encryptPassword(passwordEncoder.encode(request.getPassword()));

		Member member = request.toEntity();
		memberRepository.save(member);
		log.info("Created member : " + member.getEmail());

		return member.getId();
	}

	@Transactional
	public String login(SignInDto request) {
		Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow(
			EmailLoginFailedException::new);

		if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
			throw new EmailLoginFailedException();
		}
		log.info("Login Successful : " + member.getEmail());
		return jwtProvider.createToken(member.getId(), member.getRoles());
	}

	@Transactional
	public Long modifyMember(SignUpDto request) {
		Member member = memberRepository.findByEmail(request.getEmail())
			.orElseThrow(MemberNotFoundException::new);
		member.setPassword(passwordEncoder.encode(request.getPassword()));
		member.setName(request.getName());
		member.setNickname(request.getNickname());
		member.setPhoneNumber(request.getPhoneNumber());
		log.info("Modified member : " + member.getEmail());
		return member.getId();
	}

	@Transactional
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public MemberResponseDto findById(Long id) {
		Member member = memberRepository.findById(id)
			.orElseThrow(MemberNotFoundException::new);
		return new MemberResponseDto(member);
	}

	@Transactional(readOnly = true)
	public MemberResponseDto findByEmail(String email) {
		Member member = memberRepository.findByEmail(email)
			.orElseThrow(MemberNotFoundException::new);
		return new MemberResponseDto(member);
	}

	@Transactional(readOnly = true)
	public List<MemberResponseDto> findAllMember() {
		return memberRepository.findAll()
			.stream()
			.map(MemberResponseDto::new)
			.collect(Collectors.toList());
	}
}
