package com.sphinx.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sphinx.common.base.CoreService;
import com.sphinx.common.domain.Tree;
import com.sphinx.sys.domain.DeptDO;
import com.sphinx.sys.domain.UserDO;
import com.sphinx.sys.vo.UserVO;

import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年3月23日 | Aron</small>
 */
@Service
public interface UserService extends CoreService<UserDO> {

    boolean exist(Map<String, Object> params);

    Set<String> listRoles(Long userId);

    int resetPwd(UserVO userVO, UserDO userDO);

    int adminResetPwd(UserVO userVO);

    Tree<DeptDO> getTree();

    /**
     * 更新个人信息
     * 
     * @param userDO
     * @return
     */
    int updatePersonal(UserDO userDO);

    /**
     * 更新个人图片
     * 
     * @param file
     *            图片
     * @param avatar_data
     *            裁剪信息
     * @param userId
     *            用户ID
     * @throws Exception
     */
    Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception;
}
