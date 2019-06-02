package com.sphinx.api.pojo.dto;

import lombok.Data;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年4月26日 | Aron</small>
 */
@Data
public class UserLoginDTO {
    private String uname;
    private String passwd;
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
    
    
}
