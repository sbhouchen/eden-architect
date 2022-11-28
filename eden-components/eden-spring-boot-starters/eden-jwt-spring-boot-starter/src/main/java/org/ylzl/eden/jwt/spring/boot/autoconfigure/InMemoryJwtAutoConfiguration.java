package org.ylzl.eden.jwt.spring.boot.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ylzl.eden.jwt.spring.boot.env.JwtProperties;
import org.ylzl.eden.spring.security.jwt.model.AccessToken;
import org.ylzl.eden.spring.security.jwt.token.JwtTokenStore;


/**
 * Jwt 基于内存自动装配
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@ConditionalOnExpression(JwtAutoConfiguration.SECURITY_JWT_ENABLED)
@EnableConfigurationProperties(JwtProperties.class)
@Slf4j
@Configuration(proxyBeanMethods = false)
public class InMemoryJwtAutoConfiguration {

	private static final String AUTOWIRED_IN_MEMORY_JWT_TOKEN_STORE = "Autowired InMemoryJwtTokenStore";

	@ConditionalOnMissingBean
	@Bean
	public JwtTokenStore tokenStore() {
		log.debug(AUTOWIRED_IN_MEMORY_JWT_TOKEN_STORE);
		return new JwtTokenStore() {

			@Override
			public boolean validateAccessToken(AccessToken token) {
				return true;
			}

			@Override
			public void storeAccessToken(AccessToken token) {

			}

			@Override
			public void removeAccessToken(AccessToken token) {

			}
		};
	}
}
