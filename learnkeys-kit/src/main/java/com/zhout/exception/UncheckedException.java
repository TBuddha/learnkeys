package com.zhout.exception;

/**
 * 无需处理的异常
 *
 * @author zhout
 * @date 2020/4/8 15:17
 */
public class UncheckedException extends RuntimeException {
  protected UncheckedException() {}

  public UncheckedException(String message) {
    super(message);
  }

  public UncheckedException(String message, Throwable cause) {
    super(message, cause);
  }

  public UncheckedException(Throwable cause) {
    super(cause);
  }
}
