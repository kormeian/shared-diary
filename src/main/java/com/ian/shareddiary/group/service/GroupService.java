package com.ian.shareddiary.group.service;


import com.ian.shareddiary.group.domain.Group;
import com.ian.shareddiary.group.exception.GroupAndMemberNotMatchException;
import com.ian.shareddiary.group.exception.GroupNotFoundException;
import com.ian.shareddiary.group.repository.GroupRepository;
import com.ian.shareddiary.member.domain.Member;
import com.ian.shareddiary.member.exception.MemberNotFoundException;
import com.ian.shareddiary.member.repository.MemberRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class GroupService {

	GroupRepository groupRepository;
	MemberRepository memberRepository;

	@Transactional
	public Long createGroup(String userEmail, String groupName) {
		Member member = memberRepository.findByEmail(userEmail).orElseThrow(
			MemberNotFoundException::new);
		Group group = Group.builder()
			.groupName(groupName)
			.memberId(member.getId())
			.build();
		groupRepository.save(group);
		log.info("Created Group : " + group.getGroupName());
		return group.getId();
	}

	@Transactional
	public Long updateGroup(Long groupId, String userEmail, String groupName) {
		Group group = groupRepository.findById(groupId).orElseThrow(
			GroupNotFoundException::new);
		Member member = memberRepository.findByEmail(userEmail)
			.orElseThrow(MemberNotFoundException::new);
		if (!Objects.equals(group.getMemberId(), member.getId())) {
			throw new GroupAndMemberNotMatchException();
		}
		group.setGroupName(groupName);
		groupRepository.save(group);
		log.info("Updated Group : " + group.getGroupName());
		return group.getId();
	}

	@Transactional
	public void deleteGroup(Long groupId) {
		groupRepository.deleteById(groupId);
	}
}
