package org.ylzl.eden.spring.integration.sms.core;

import lombok.*;

import java.io.Serializable;

/**
 * 发送短信响应
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
public class SendTemplateSmsResponse implements Serializable {

	/**
	 * 处理成功
	 */
	private boolean success;

	/**
	 * 错误码
	 */
	private String errCode;

	/**
	 * 错误描述
	 */
	private String errMessage;
}