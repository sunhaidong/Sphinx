package com.sphinx.wxmp.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * <pre>
 * 微信配置表
 * </pre>
 * <small> 2018-04-11 23:27:06 | Aron</small>
 */
 @TableName("wx_mp_config")
 @Data
public class MpConfigDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /** 主键ID */
    @TableId
    private Integer id;
    /** token */
    private String token;
    /** APPID */
    private String appId;
    /** AppSecret */
    private String appSecret;
    /** 1加密 0不加密 */
    private Integer msgMode;
    /** 秘钥 */
    private String msgSecret;
    /** 公众号名字 */
    private String mpName;
    /** 公众号类型： 1.订阅号 2.服务号 3.企业号 4.小程序 5. 测试号 */
    private Integer appType;
    /** 认证授权：1已认证 0未认证 */
    private Integer isAuth;
    /** 提示订阅URL */
    private String subscribeUrl;
    /** logo */
    private String logo;
    /** 创建时间 */
    private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public Integer getMsgMode() {
		return msgMode;
	}
	public void setMsgMode(Integer msgMode) {
		this.msgMode = msgMode;
	}
	public String getMsgSecret() {
		return msgSecret;
	}
	public void setMsgSecret(String msgSecret) {
		this.msgSecret = msgSecret;
	}
	public String getMpName() {
		return mpName;
	}
	public void setMpName(String mpName) {
		this.mpName = mpName;
	}
	public Integer getAppType() {
		return appType;
	}
	public void setAppType(Integer appType) {
		this.appType = appType;
	}
	public Integer getIsAuth() {
		return isAuth;
	}
	public void setIsAuth(Integer isAuth) {
		this.isAuth = isAuth;
	}
	public String getSubscribeUrl() {
		return subscribeUrl;
	}
	public void setSubscribeUrl(String subscribeUrl) {
		this.subscribeUrl = subscribeUrl;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
