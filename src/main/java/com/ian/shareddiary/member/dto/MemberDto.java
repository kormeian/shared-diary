package com.ian.shareddiary.member.dto;

import com.ian.shareddiary.member.entity.Member;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MemberDto {

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Builder
	@Setter
	public static class RequestMemberDto{
		private Long id;

		@NotBlank(message = "이메일은 필수 입력값입니다.")
		@Email(message = "이메일 형식이 올바르지 않습니다.")
		private String emailAddress;
		@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
		private String password;
		@NotBlank(message = "이름은 필수 입력값입니다.")
		private String name;
		@NotBlank(message = "닉네임은 필수 입력값입니다.")
		@Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}$" , message = "닉네임은 특수문자를 포함하지 않은 2~10자리여야 합니다.")
		private String nickname;
		@NotBlank(message = "핸드폰 번호는 필수 입력값입니다.")
		@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "올바른 핸드폰 번호를 입력해주세요.")
		private String phoneNumber;

		private LocalDateTime createdAt;
		private LocalDateTime updatedAt;

		private boolean isDeleted;
		private LocalDateTime deletedAt;


		public void encryptPassword(String BCryptPassword) {
			this.password = BCryptPassword;
		}

		public Member toEntity(){
			return Member.builder()
				.id(id)
				.emailAddress(emailAddress)
                .password(password)
				.name(name)
                .nickname(nickname)
				.phoneNumber(phoneNumber)
                .createdAt(createdAt)
				.updatedAt(updatedAt)
                .isDeleted(isDeleted)
				.deletedAt(deletedAt)
                .build();
		}
	}

}
