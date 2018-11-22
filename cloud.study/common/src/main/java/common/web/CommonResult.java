package common.web;

public class CommonResult {
	
	int status;
	String message;
	
	public CommonResult() {
		this.status = 0;
		this.message = "";
	}
	
	public CommonResult(int status , String message) {
		this.message = message;
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
