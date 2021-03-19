package com.dtdhehe.config;

import com.dtdhehe.entity.TbRole;
import com.dtdhehe.entity.TbUser;
import com.dtdhehe.security.JwtUserFactory;
import com.dtdhehe.service.RoleService;
import com.dtdhehe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/24 16:03
 * @description
 **/
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser tbUser = userService.findByUsername(username);
        if (tbUser == null){
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        List<TbRole> roleList = roleService.getRoleListByUserId(tbUser.getId());
        return JwtUserFactory.createJwtUser(tbUser,roleList);
    }
}
