package com.sphinx.common.component.sms.dto;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 * <small> 2018/8/30 21:25 | Aron</small>
 */
@Data
public class SendDTO {
    private String scene;
    private String mobile;
	public String getScene() {
		return scene;
	}
	public void setScene(String scene) {
		this.scene = scene;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
    
}
