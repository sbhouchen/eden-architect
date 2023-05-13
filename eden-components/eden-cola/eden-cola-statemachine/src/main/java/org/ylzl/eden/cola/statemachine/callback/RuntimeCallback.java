/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ylzl.eden.cola.statemachine.callback;

import org.ylzl.eden.cola.statemachine.exception.TransitionException;
import org.ylzl.eden.commons.lang.MessageFormatUtils;

/**
 * 默认事件回调处理
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
public class RuntimeCallback<S, E, C> implements Callback<S, E, C> {

	private static final String FIRE_EVENT_FAILED = "Cannot fire event '{}' on current state '{}' with context '{}'";

	@Override
	public void onSuccess(S sourceState, E event, C context) {
	}

	@Override
	public void onFail(S sourceState, E event, C context) {
		throw new TransitionException(MessageFormatUtils.format(FIRE_EVENT_FAILED, event, sourceState, context));
	}
}
