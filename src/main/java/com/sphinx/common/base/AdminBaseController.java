package com.sphinx.common.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.plugins.Page;
import com.sphinx.common.utils.HttpContextUtils;
import com.sphinx.common.utils.ShiroUtils;
import com.sphinx.sys.domain.UserDO;

/**
 * 
 * <pre>
 * </pre>
 * 
 * <small> 2018年2月25日 | Aron</small>
 */
public abstract class AdminBaseController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    public UserDO getUser() {
        return ShiroUtils.getSysUser();
    }

    public Long getUserId() {
        return getUser().getId();
    }

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }

    public String getUsername() {
        return getUser().getUsername();
    }

    /**
     * <pre>
     * 自动获取分页参数，返回分页对象page
     * </pre>
     * 
     * <small> 2018年4月15日 | Aron</small>
     * 
     * @param e
     * @return
     */
    public <E> Page<E> getPage(Class<E> e) {
        int pageNumber = getParaToInt("pageNumber", 1);
        int pageSize = getParaToInt("pageSize", 10);
        Page<E> page = new Page<>(pageNumber, pageSize);
        //支持sort、order参数
        String sort = HttpContextUtils.getHttpServletRequest().getParameter("sort");
        if(StringUtils.isNotBlank(sort)) {
        	page.setOrderByField(sort);
        	String order = HttpContextUtils.getHttpServletRequest().getParameter("order");
        	if(StringUtils.isNotBlank(order)) page.setAsc("asc".equalsIgnoreCase(order));
        }
        return page;
    }

    private int getParaToInt(String key, int defalut) {
        String pageNumber = HttpContextUtils.getHttpServletRequest().getParameter(key);
        if (StringUtils.isBlank(pageNumber)) {
            return defalut;
        }
        return Integer.parseInt(pageNumber);
    }
}