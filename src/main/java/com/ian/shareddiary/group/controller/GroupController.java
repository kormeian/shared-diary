package com.ian.shareddiary.group.controller;

import com.ian.shareddiary.model.response.SingleResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/group")
@RestController
public class GroupController {

	@PostMapping
	@Operation(summary = "그룹 생성", description = "그룹을 생성 합니다.")
	public SingleResult<Long> createGroup() {
		return new SingleResult<>();
	}
}
