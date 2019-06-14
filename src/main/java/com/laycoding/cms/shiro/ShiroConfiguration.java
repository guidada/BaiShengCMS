package com.laycoding.cms.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by fuxiaoj on 2018/03/27 11:08
 */
@Configuration
public class ShiroConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);


    /**
     * 这是个自定义的认证类，继承自AuthorizingRealm， 负责用户的认证和权限的处理
     * DependsOn 依赖关系
     * @return
     */
    @Bean(name = "shiroRealm")
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return new ShiroRealm();
    }

    /**
     * SecurityManager，权限管理，这个类组合了登陆，登出，权限，session的处理，是个比较重要的类
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }
    /**
     * ShiroFilterFactoryBean，是个factorybean，为了生成ShiroFilter
     * 它主要保持了三项数据，securityManager，filters，filterChainDefinitionManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        Map<String, Filter> filter = shiroFilterFactoryBean.getFilters();
        filter.put("authc", new CustomFormAuthenticationFilter());
        // 配置不会被拦截的链接 顺序判断
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/websocket/*", "anon");
        filterChainDefinitionMap.put("/assets/*", "anon");
        filterChainDefinitionMap.put("/json/*", "anon");
        filterChainDefinitionMap.put("/login.html", "anon");
        filterChainDefinitionMap.put("/admin/*", "authc");
        filterChainDefinitionMap.put("/page/*", "authc");
        filterChainDefinitionMap.put("/file/*", "authc");
        filterChainDefinitionMap.put("/sys/*", "authc");
        filterChainDefinitionMap.put("/api/*", "authc");
        filterChainDefinitionMap.put("/user/*", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //filterChainDefinitionMap.put("/**", "authc");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("../login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/admin/index");
        //未授权界面;
      //  filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了 ）
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(3);
        //散列的次数，比如散列两次，相当于 md5(md5(""));
        System.out.println(hashedCredentialsMatcher);
        return hashedCredentialsMatcher;
    }
    /**
     *  AuthorizationAttributeSourceAdvisor，shiro里实现的Advisor类，
     *  内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }
    //配置默认顾问自动代理,由advisor决定对哪些类的方法进行AOP代理
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
    /**
     * shiro缓存管理器;
     * 需要注入对应的其它的实体类中：
     * 1、安全管理器：securityManager
     * 可见securityManager是整个shiro的核心；
     * @return
     */
   /* @Bean
    public EhCacheManager ehCacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return cacheManager;
    }*/

    /**
     * 自定义全局异常
     * @return
     */
   /* @Bean(name = "exceptionHandler")
    public HandlerExceptionResolver handlerExceptionResolver() {
        return  new MyExceptionHandler();
    }*/
}
