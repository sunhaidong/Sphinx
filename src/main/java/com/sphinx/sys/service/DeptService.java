package com.sphinx.sys.service;

import com.sphinx.common.base.CoreService;
import com.sphinx.common.domain.Tree;
import com.sphinx.sys.domain.DeptDO;

/**
 * <pre>
 * 部门管理
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
public interface DeptService extends CoreService<DeptDO> {
    
	Tree<DeptDO> getTree();
	
	boolean checkDeptHasUser(Long deptId);
}
