package com.ian.shareddiary.member.controller;

import com.ian.shareddiary.member.domain.Member;
import com.ian.shareddiary.member.dto.MemberDto;
import com.ian.shareddiary.member.service.MemberService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/signup")
	public Member signup(@RequestBody @Valid MemberDto.RequestMemberDto request) {
		return memberService.createMember(request);
	}
}
