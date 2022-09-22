package com.ian.shareddiary.member.domain;

import com.ian.shareddiary.domain.BaseTimeEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member extends BaseTimeEntity implements UserDetails {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, length = 50, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, length = 50, unique = true)
	private String nickname;
	@Column(nullable = false)
	private String phoneNumber;


	@ElementCollection
	@Builder.Default
	private List<String> roles = new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles
			.stream().map(SimpleGrantedAuthority::new)
			.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
