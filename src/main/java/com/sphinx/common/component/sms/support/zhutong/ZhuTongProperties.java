package com.sphinx.common.component.sms.support.zhutong;

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
@ConfigurationProperties(prefix = "ifast.sms.zt")
@Data
public class ZhuTongProperties {
    private String uname;
    private String passwd;
    private String productId;
    private Map<String, String> scenes;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Map<String, String> getScenes() {
		return scenes;
	}
	public void setScenes(Map<String, String> scenes) {
		this.scenes = scenes;
	}
    
    
}
