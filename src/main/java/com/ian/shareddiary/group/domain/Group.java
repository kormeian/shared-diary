package com.ian.shareddiary.group.domain;

import com.ian.shareddiary.domain.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Group extends BaseTimeEntity {

	@Id
	@GeneratedValue
	Long id;

	@Column(nullable = false)
	Long memberId;

	@Column(nullable = false)
	String groupName;
}
