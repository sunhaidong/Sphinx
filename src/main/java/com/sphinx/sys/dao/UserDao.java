package com.sphinx.sys.dao;

import com.sphinx.common.base.BaseDao;
import com.sphinx.sys.domain.UserDO;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
public interface UserDao extends BaseDao<UserDO> {
	
	Long[] listAllDept();

}
