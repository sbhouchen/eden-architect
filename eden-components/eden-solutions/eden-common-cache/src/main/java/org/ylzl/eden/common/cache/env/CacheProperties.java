package org.ylzl.eden.common.cache.env;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.ylzl.eden.common.cache.core.config.CacheConfig;

/**
 * 缓存配置
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@RefreshScope
@Setter
@Getter
@ConfigurationProperties(prefix = CacheProperties.PREFIX)
public class CacheProperties {

	public static final String PREFIX = "cache";

	public static final String ENABLED = PREFIX + ".enabled";

	private CacheConfig config;
}
