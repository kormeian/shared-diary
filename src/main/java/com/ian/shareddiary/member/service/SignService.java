package com.ian.shareddiary.member.service;

import com.ian.shareddiary.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignService {

	private final MemberRepository memberRepository;

}
