package com.sphinx.api.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sphinx.api.util.JWTUtil;
import com.sphinx.common.exception.IFastException;
import com.sphinx.common.type.EnumErrorCode;
import com.sphinx.sys.service.MenuService;
import com.sphinx.sys.service.RoleService;

import java.util.HashSet;


/**
 * <pre>
 * </pre>
 * <small> 2018年4月22日 | Aron</small>
 */
@Component
public class JWTAuthorizingRealm extends AuthorizingRealm {

    private  Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    @Override
    public String getName() {
        return "apiRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTAuthenticationTokenToken;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authz = new SimpleAuthorizationInfo();
        if(!(principals.getPrimaryPrincipal() instanceof  String)){
            return authz;
        }
        String jwt = (String) principals.getPrimaryPrincipal();
        if(log.isDebugEnabled()){
            log.debug("jwt:" + jwt);
        }
        String userId = JWTUtil.getUserId(jwt);
        if(StringUtils.isBlank(userId)){
            throw new IFastException(EnumErrorCode.apiAuthorizationFailed.getCodeStr());
        }
        authz.setStringPermissions(menuService.listPerms(Long.parseLong(userId)));

        HashSet<String> roles = new HashSet<>();
        roleService.findListByUserId(userId).stream().forEach(bean -> roles.add(bean.getRoleSign()));
        authz.setRoles(roles);
        return authz;
    }

    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authc) throws AuthenticationException {
        if(log.isDebugEnabled()){
            log.debug("authc:" + authc.getCredentials() + ", " + authc.getPrincipal());
        }
        String token = (String) authc.getCredentials();
        return new SimpleAuthenticationInfo(token, token, getName());
    }
}
