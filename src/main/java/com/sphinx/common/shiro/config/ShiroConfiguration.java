package com.sphinx.common.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sphinx.sys.config.BDSessionListener;
import com.sphinx.sys.shiro.SysUserAuthorizingRealm;

import javax.servlet.Filter;
import java.util.*;

/**
 * <pre>
 * . cache ehcache
 * . realm(cache)
 * . securityManager（realm）
 * . ShiroFilterFactoryBean 注册
 * 
 * </pre>
 * <small> 2019年4月24日 | Sphinx</small>
 */
@Configuration
public class ShiroConfiguration {
    
    @Bean
    SessionDAO sessionDAO(ShiroProperties config) {
//        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
//        CacheManager cacheManager = enterpriseCacheSessionDAO.getCacheManager();
//        return enterpriseCacheSessionDAO;

//        RedisSessionDAO sessionDAO = new RedisSessionDAO(config.getSessionKeyPrefix());

        SessionDAO sessionDAO = new MemorySessionDAO();
        return sessionDAO;
    }

    @Bean
    public SimpleCookie sessionIdCookie(ShiroProperties shiroConfigProperties) {
        return new SimpleCookie(shiroConfigProperties.getJsessionidKey());
    }



    @Bean
    public SessionManager sessionManager(SessionDAO sessionDAO, SimpleCookie simpleCookie) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionIdCookie(simpleCookie);

        Collection<SessionListener> sessionListeners = new ArrayList<SessionListener>();
        sessionListeners.add(new BDSessionListener());
        sessionManager.setSessionListeners(sessionListeners);
        sessionManager.setSessionDAO(sessionDAO);
        return sessionManager;
    }
    
//    @Bean(name="shiroCacheManager")
//    @DependsOn({"springContextHolder","cacheConfiguration"})
//    public CacheManager cacheManager() {
//    	SpringCacheManagerWrapper springCacheManager = new SpringCacheManagerWrapper();
//    	org.springframework.cache.CacheManager cacheManager = SpringContextHolder.getBean(org.springframework.cache.CacheManager.class);
//    	springCacheManager.setCacheManager(cacheManager);
//        return springCacheManager;
//    }
//    
//    @Bean
//    Authenticator authenticator(SysUserAuthorizingRealm sysUserAuthorizingRealm, JWTAuthorizingRealm jwtAuthorizingRealm) {
//        IFastModularRealm authenticator = new IFastModularRealm();
//        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
//        List<Realm> realms = new ArrayList<>();
//        realms.add(jwtAuthorizingRealm);
//        realms.add(sysUserAuthorizingRealm);
//        authenticator.setRealms(realms);
//        return authenticator;
//    }
  
    
    
    @Bean
    SecurityManager securityManager(SessionManager sessionManager,SysUserAuthorizingRealm sysUserAuthorizingRealm ) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//        manager.setAuthenticator(authenticator);
//        manager.setAuthorizer(authorizer);
//        manager.setCacheManager(cacheManager());
        manager.setSessionManager(sessionManager);
//        return manager;
        manager.setRealm(sysUserAuthorizingRealm);
        return manager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        
        // 添加jwt过滤器
//        Map<String, Filter> filterMap = new HashMap<>();
//        filterMap.put("jwt", new JWTAuthenticationFilter());
//        shiroFilterFactoryBean.setFilters(filterMap);
        
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/shiro/405");
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/api/**", "anon"); // api
        filterChainDefinitionMap.put("/webservice/**", "anon"); // webservice
        filterChainDefinitionMap.put("/emil/**", "anon");
        filterChainDefinitionMap.put("/doc.html**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/shiro/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/layui-v2.4.5/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/docs/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/upload/**", "anon");
        filterChainDefinitionMap.put("/files/**", "anon");
        filterChainDefinitionMap.put("/test/**", "anon");
        filterChainDefinitionMap.put("/qlyl/**", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

//    @Bean
//    public ShiroDialect shiroDialect() {
//        return new ShiroDialect();
//    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
