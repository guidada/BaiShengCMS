package com.laycoding.cms.shiro;

import com.laycoding.cms.pojo.User;
import com.laycoding.cms.service.PermissionService;
import com.laycoding.cms.service.RoleService;
import com.laycoding.cms.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户认证
 * Created by fuxiaoj on 2018/03/27 11:14
 */
public class ShiroRealm extends AuthorizingRealm {
    private User user;
    @Resource
    private UserService uService;
    @Resource
    private RoleService rService;
    @Resource
    private PermissionService pService;
    /**
     * 授权用户权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       String username = (String) principalCollection.getPrimaryPrincipal();
        List<String> permissions=new ArrayList<>();
        List<String> roles=new ArrayList<>();
        if ("admin".equals(user.getSys_user())){
            System.out.println("all---");
            roles=rService.getAllRoles();
            permissions.add("*:*");
        }else {
            //根据用户查角色
            System.out.println(user.getId());
            roles=rService.getRoleByUserId(user.getId());
            System.out.println(" --------"+roles);
            //根据用户查权限
            permissions=pService.getPermissionResourceByUseId(user.getId());
            System.out.println(" --------"+permissions);
        }
        SimpleAuthorizationInfo info=  new SimpleAuthorizationInfo();
       System.out.println("permissions: "+permissions);
        System.out.println("roles: "+roles);
        info.addStringPermissions(permissions);
        info.addRoles(roles);
        return info;

    }
    /**
     * 验证用户身份
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName= (String) authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        user=uService.getByUserName(userName);
        if(user!=null){
            AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getSys_user(), user.getSys_password(),getName());
            System.out.println(authcInfo);
            return authcInfo;
        }
        return null;
    }
}
