package com.ian.shareddiary.member.controller;

import com.ian.shareddiary.member.dto.MemberRequestDto;
import com.ian.shareddiary.member.service.MemberService;
import com.ian.shareddiary.model.response.SingleResult;
import com.ian.shareddiary.service.response.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
	private final ResponseService responseService;

	@PostMapping("/signup")
	@Operation(summary = "회원가입", description = "회원가입을 합니다.")
	public SingleResult<Long> signup(
		@Parameter(description = "회원 가입 요청 DTO", required = true)
		@RequestBody @Valid MemberRequestDto.SignUpDto request) {
		Long id = memberService.createMember(request);
		return responseService.getSingleResult(id);
	}

	@PostMapping("/signin")
	@Operation(summary = "로그인", description = "이메일로 로그인을 합니다.")
	public SingleResult<String> signin(
		@Parameter(description = "로그인 요청 DTO", required = true)
		@RequestBody @Valid MemberRequestDto.SignInDto request) {
		String token = memberService.login(request);
		return responseService.getSingleResult(token);
	}

}
