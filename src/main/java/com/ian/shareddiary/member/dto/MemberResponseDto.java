package com.ian.shareddiary.member.dto;

import com.ian.shareddiary.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {

	private final Long id;
	private final String email;
	private final String password;
	private final String name;
	private final String nickname;
	private final String phoneNumber;

	public MemberResponseDto(Member member) {
		this.id = member.getId();
		this.email = member.getEmail();
		this.password = member.getPassword();
		this.name = member.getName();
		this.nickname = member.getNickname();
		this.phoneNumber = member.getPhoneNumber();
	}
}
