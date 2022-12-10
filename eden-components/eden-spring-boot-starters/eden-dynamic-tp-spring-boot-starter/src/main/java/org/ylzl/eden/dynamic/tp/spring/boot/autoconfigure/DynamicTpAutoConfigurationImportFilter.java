package org.ylzl.eden.dynamic.tp.spring.boot.autoconfigure;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfigurationImportFilter;
import org.springframework.boot.autoconfigure.AutoConfigurationMetadata;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * DynamicTp 自动装配过滤
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public class DynamicTpAutoConfigurationImportFilter implements AutoConfigurationImportFilter, EnvironmentAware {

	private static final String MATCH_KEY = "spring.dynamic.tp.enabled";

	private static final String DEFAULT_VALUE = "true";

	private static final String[] IGNORE_CLASSES = {
		"com.dtp.starter.adapter.webserver.autocconfigure.WebServerTpAutoConfiguration",
		"com.dtp.starter.adapter.dubbo.autoconfigure.ApacheDubboTpAutoConfiguration",
		"com.dtp.starter.adapter.dubbo.autoconfigure.AlibabaDubboTpAutoConfiguration",
		"com.dtp.starter.adapter.grpc.autoconfigure.GrpcTpAutoConfiguration",
		"com.dtp.starter.adapter.rocketmq.autoconfigure.RocketMqTpAutoConfiguration",
		"com.dtp.starter.adapter.hystrix.autoconfigure.HystrixTpAutoConfiguration"
	};

	private Environment environment;

	@Override
	public void setEnvironment(@NotNull Environment environment) {
		this.environment = environment;
	}

	@Override
	public boolean[] match(String[] autoConfigurationClasses, AutoConfigurationMetadata autoConfigurationMetadata) {
		boolean disabled = !Boolean.parseBoolean(environment.getProperty(MATCH_KEY, DEFAULT_VALUE));
		boolean[] match = new boolean[autoConfigurationClasses.length];
		for (int i = 0; i < autoConfigurationClasses.length; i++) {
			int index = i;
			match[i] = !disabled || Arrays.stream(IGNORE_CLASSES).noneMatch(e -> e.equals(autoConfigurationClasses[index]));
		}
		return match;
	}
}
