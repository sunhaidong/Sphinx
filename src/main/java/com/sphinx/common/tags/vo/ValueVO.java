package com.sphinx.common.tags.vo;

import lombok.Data;

/**
 * 控件数值vo
 *
 * @author: zet
 * @date:2018/8/22
 */
@Data
public class ValueVO {
    /**
     * value值
     */
    private String vlaue;

    /**
     * 显示名称
     */
    private String name;

    /**
     * 是否选中
     */
    private Boolean selected;

	public String getVlaue() {
		return vlaue;
	}

	public void setVlaue(String vlaue) {
		this.vlaue = vlaue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
    
    
    
}
