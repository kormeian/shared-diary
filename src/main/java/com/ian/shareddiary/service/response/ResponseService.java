package com.ian.shareddiary.service.response;


import com.ian.shareddiary.model.response.CommonResult;
import com.ian.shareddiary.model.response.ListResult;
import com.ian.shareddiary.model.response.SingleResult;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ResponseService {

	// 단일건 결과 처리 메소드
	public <T> SingleResult<T> getSingleResult(T data) {
		SingleResult<T> result = new SingleResult<>();
		result.setData(data);
		setSuccessResult(result);
		return result;
	}

	// 복수건 결과 처리 메서드
	public <T> ListResult<T> getListResult(List<T> list) {
		ListResult<T> result = new ListResult<>();
		result.setList(list);
		setSuccessResult(result);
		return result;
	}

	// 성공 결과만 처리
	public CommonResult getSuccessResult() {
		CommonResult result = new CommonResult();
		setSuccessResult(result);
		return result;
	}

	// API 요청 성공 시 응답 모델을 성공 데이터로 세팅
	private void setSuccessResult(CommonResult result) {
		result.setSuccess(true);
		result.setCode(CommonResponse.SUCCESS.getCode());
		result.setMsg(CommonResponse.SUCCESS.getMsg());
	}

	// 실패 결과만 처리
	public CommonResult getFailResult(int code, String msg) {
		CommonResult result = new CommonResult();
		result.setSuccess(false);
		setFailResult(result, code, msg);
		return result;
	}

	// API 요청 실패 시 응답 모델을 실패 데이터로 세팅
	private void setFailResult(CommonResult result, int code, String msg) {
		result.setSuccess(false);
		result.setCode(code);
		result.setMsg(msg);
	}
}
