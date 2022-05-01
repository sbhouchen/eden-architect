package org.ylzl.eden.spring.integration.sms.core;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 相同内容群发短信请求
 *
 * @author <a href="mailto:guoyuanlu@puyiwm.com">gyl</a>
 * @since 2.4.x
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class BatchSendSmsRequest implements Serializable {

	/**
	 * 手机号码
	 */
	private List<String> phoneNumbers;

	/**
	 * 短信内容
	 */
	private String smsContent;

	/**
	 * 自定义短信ID
	 */
	private String customSmsId;

	/**
	 * 扩展代码
	 */
	private String extendedCode;

	/**
	 * 定时发送时间（值为空表示立即发送）
	 */
	private String timerTime;
}
