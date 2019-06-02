package com.sphinx.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年4月28日 | Aron</small>
 */
@Component
@ConfigurationProperties(prefix = "sphinx.jwt")
@Data
public class JWTConfigProperties {

    private String userPrimaryKey;

    private String expireTokenKeyPrefix;

    /**
     * jwt过期时间,默认2小时，单位为毫秒
     */
    private Long expireTime = 7200000L;
    /**
     *  refresh_token过期时间，默认7天，单位为毫秒
     */
    private Long refreshTokenExpire = 604800000L;
	public String getUserPrimaryKey() {
		return userPrimaryKey;
	}
	public void setUserPrimaryKey(String userPrimaryKey) {
		this.userPrimaryKey = userPrimaryKey;
	}
	public String getExpireTokenKeyPrefix() {
		return expireTokenKeyPrefix;
	}
	public void setExpireTokenKeyPrefix(String expireTokenKeyPrefix) {
		this.expireTokenKeyPrefix = expireTokenKeyPrefix;
	}
	public Long getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}
	public Long getRefreshTokenExpire() {
		return refreshTokenExpire;
	}
	public void setRefreshTokenExpire(Long refreshTokenExpire) {
		this.refreshTokenExpire = refreshTokenExpire;
	}
    
    

}
