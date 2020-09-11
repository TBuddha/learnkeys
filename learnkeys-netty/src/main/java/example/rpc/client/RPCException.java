package example.rpc.client;

/**
 * @author zhout
 * @date 2020/9/10 17:00
 */
public class RPCException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public RPCException(String message, Throwable cause) {
    super(message, cause);
  }

  public RPCException(String message) {
    super(message);
  }

  public RPCException(Throwable cause) {
    super(cause);
  }
}
