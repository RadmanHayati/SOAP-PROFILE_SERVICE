package com.radmanhayati.profile.exception;


import com.radmanhayati.profile.common.ResultStatus;

public class UserAlreadyExistsException extends BusinessException {

	public UserAlreadyExistsException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getResultStatus() {
		return ResultStatus.USER_DUPLICATE_EMAIL;
	}
}
