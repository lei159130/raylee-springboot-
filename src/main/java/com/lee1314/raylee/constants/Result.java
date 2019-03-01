package com.lee1314.raylee.constants;

public class Result<T> {
	private String message;
	private int retCode;
	private T data;

	private Result(T data) {
		this.retCode = CodeMsg.SUCCESS.getCode();
		this.message = CodeMsg.SUCCESS.getMsg();
		this.data = data;
	}

	private Result(CodeMsg cm) {
		if (cm == null) {
			return;
		}
		this.retCode = cm.getCode();
		this.message = cm.getMsg();
	}

	/**
	 * 成功时候的调用
	 * 
	 * @return
	 */
	public static <T> Result<T> success(T data) {
		return new Result<T>(data);
	}

	/**
	 * 成功，不需要传入参数
	 * 
	 * @return
	 */
	public static <T> Result<T> success() {
		return new Result<T>(CodeMsg.SUCCESS);
	}

	/**
	 * 失败时候的调用
	 * 
	 * @return
	 */
	public static <T> Result<T> error(CodeMsg cm) {
		return new Result<T>(cm);
	}

	/**
	 * 失败时候的调用,扩展消息参数
	 * 
	 * @param cm
	 * @param msg
	 * @return
	 */
	public static <T> Result<T> error(CodeMsg cm, String msg) {
		cm.setMsg(msg);
		return new Result<T>(cm);
	}

	public T getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public int getRetCode() {
		return retCode;
	}

}
