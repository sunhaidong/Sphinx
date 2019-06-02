package com.sphinx.common.component.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 * <small> 2018/8/30 19:27 | Aron</small>
 */
@Component
@ConfigurationProperties(prefix = "sphinx.sms")
@Data
public class SmsBasicProperties {

    private String cacheKey = "sphinx:cache";
    private String cacheKeyPrefix = "sms";
    /**
     * 过期时间，单位为秒
     */
    private long codeExpireTime = 900;

    /**
     * 短信场景值&内容
     */
    private Map<String, String> scenes;

	public String getCacheKey() {
		return cacheKey;
	}

	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}

	public String getCacheKeyPrefix() {
		return cacheKeyPrefix;
	}

	public void setCacheKeyPrefix(String cacheKeyPrefix) {
		this.cacheKeyPrefix = cacheKeyPrefix;
	}

	public long getCodeExpireTime() {
		return codeExpireTime;
	}

	public void setCodeExpireTime(long codeExpireTime) {
		this.codeExpireTime = codeExpireTime;
	}

	public Map<String, String> getScenes() {
		return scenes;
	}

	public void setScenes(Map<String, String> scenes) {
		this.scenes = scenes;
	}
    
    
}
