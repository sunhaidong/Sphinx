package com.sphinx.common.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Aron
 * @email izenglong@163.com
 * @date 2018-04-06 01:05:22
 */
@TableName("sys_config")
@Data
public class ConfigDO extends Model<ConfigDO> implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    @TableId
    private Long id;
    private String k;
    private String v;
    private String remark;
    private Date createTime;
    private Integer kvType;

    @Override
    protected Serializable pkVal() {
        return id;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getKvType() {
		return kvType;
	}

	public void setKvType(Integer kvType) {
		this.kvType = kvType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
