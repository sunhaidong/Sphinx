package com.sphinx.common.base;

import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.Version;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@SuppressWarnings("serial")
public class BaseDO implements Serializable {
	/** 由mybatis-plus.global-config.sql-injector:com.baomidou.mybatisplus.mapper.LogicSqlInjector自动维护 */
	@TableLogic
	private boolean deleted;
	/** 由MyBatisConfig.optimisticLockerInterceptor自动维护 */
	@Version
	private int version;
	/** 由MySQL自动维护 */
	private Date createAt;
	private Date updateAt;
	/** 由LogAspect.logMapper自动维护 */
	private Long createBy;
	private Long updateBy;
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public Long getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	
	
	
}
