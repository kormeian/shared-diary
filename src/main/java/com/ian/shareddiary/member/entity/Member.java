package com.ian.shareddiary.member.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, length = 50, unique = true)
	private String emailAddress;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, length = 50, unique = true)
	private String nickname;
	@Column(nullable = false)
	private String phoneNumber;

	@Column(nullable = false)
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@Column(nullable = false)
	private boolean isDeleted;
	private LocalDateTime deletedAt;
}
