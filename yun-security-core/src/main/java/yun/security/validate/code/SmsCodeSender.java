/**
 * 
 */
package yun.security.validate.code;

/**
 * @author zhailiang
 *
 */
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
