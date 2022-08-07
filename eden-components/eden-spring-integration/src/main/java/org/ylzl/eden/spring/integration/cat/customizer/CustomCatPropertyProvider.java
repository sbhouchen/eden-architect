package org.ylzl.eden.spring.integration.cat.customizer;

import com.dianping.cat.CatPropertyProvider;
import org.unidal.helper.Properties;

/**
 * TODO
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public class CustomCatPropertyProvider implements CatPropertyProvider {

	private final Properties.PropertyAccessor<String> config;

	public CustomCatPropertyProvider() {
		super();
		config = Properties.forString().fromEnv().fromSystem();
	}

	public String getProperty(final String name, final String defaultValue) {

		return config.getProperty(name, defaultValue);
	}
}
