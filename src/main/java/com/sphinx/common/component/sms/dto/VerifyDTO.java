package com.sphinx.common.component.sms.dto;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 * <small> 2018/8/30 21:25 | Aron</small>
 */
@Data
public class VerifyDTO {
    private String mobile;
    private String code;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
    
}
