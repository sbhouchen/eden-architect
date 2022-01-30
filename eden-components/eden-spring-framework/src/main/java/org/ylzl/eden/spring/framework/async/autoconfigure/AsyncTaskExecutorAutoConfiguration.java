/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ylzl.eden.spring.framework.async.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.ylzl.eden.spring.framework.async.env.AsyncProperties;
import org.ylzl.eden.spring.framework.async.interceptor.ExceptionHandlingAsyncTaskExecutor;
import org.ylzl.eden.spring.framework.core.constant.SpringFrameworkConstants;

import java.util.concurrent.Executor;

/**
 * 异步执行自动装配
 *
 * @author gyl
 * @since 2.4.x
 */
@EnableAsync
@EnableConfigurationProperties(AsyncProperties.class)
@Slf4j
@Configuration
public class AsyncTaskExecutorAutoConfiguration implements AsyncConfigurer {

	public static final String BEAN_TASK_EXECUTOR = "asyncTaskExecutor";

	private static final String MSG_AUTOWIRED_EXECUTOR = "Autowired AsyncTaskExecutor";

	private final AsyncProperties.TaskExecutor properties;

	@Value(SpringFrameworkConstants.NAME_PATTERN)
	private String applicationName;

	public AsyncTaskExecutorAutoConfiguration(AsyncProperties asyncProperties) {
		this.properties = asyncProperties.getTaskExecutor();
	}

	@Bean(name = BEAN_TASK_EXECUTOR)
	@Override
	public Executor getAsyncExecutor() {
		log.debug(MSG_AUTOWIRED_EXECUTOR);
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(properties.getCorePoolSize());
		executor.setMaxPoolSize(properties.getMaxPoolSize());
		executor.setQueueCapacity(properties.getQueueCapacity());
		executor.setThreadNamePrefix(applicationName);
		return new ExceptionHandlingAsyncTaskExecutor(executor);
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SimpleAsyncUncaughtExceptionHandler();
	}
}
