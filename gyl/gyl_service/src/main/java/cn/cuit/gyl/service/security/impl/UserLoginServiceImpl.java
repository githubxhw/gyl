package cn.cuit.gyl.service.security.impl;

import cn.cuit.gyl.dao.database.IUserDao;
import cn.cuit.gyl.domain.database.UserInfo;
import cn.cuit.gyl.domain.privilege.Permission;
import cn.cuit.gyl.domain.privilege.Role;
import cn.cuit.gyl.service.security.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//登录验证的service
@Service("userLoginService")
public class UserLoginServiceImpl implements IUserLoginService {

    @Autowired
    @Qualifier("iUserDao")
    private IUserDao iUserDao = null;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = iUserDao.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus() == 0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    private Collection<? extends GrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role:roles) {
            for (Permission permission:role.getPermissions()) {
                String role_name = permission.getPermission_name();
                //System.out.println(role_name);
                list.add(new SimpleGrantedAuthority("ROLE_" + role_name));
            }
        }
        return list;
    }
}
