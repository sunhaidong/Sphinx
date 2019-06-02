package com.sphinx.common.shiro.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *
 * </pre>
 * <small> 2018/8/27 21:50 | Aron</small>
 */
@Component
@ConfigurationProperties(prefix = "sphinx.shiro")
@Data
public class ShiroProperties {
    private String sessionKeyPrefix = "sphinx:session";
    private String jsessionidKey = "SESSION";
	public String getSessionKeyPrefix() {
		return sessionKeyPrefix;
	}
	public void setSessionKeyPrefix(String sessionKeyPrefix) {
		this.sessionKeyPrefix = sessionKeyPrefix;
	}
	public String getJsessionidKey() {
		return jsessionidKey;
	}
	public void setJsessionidKey(String jsessionidKey) {
		this.jsessionidKey = jsessionidKey;
	}
    
    
}
