package com.dtdhehe.security;

import com.dtdhehe.entity.SysRole;
import com.dtdhehe.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/3/19 15:30
 * @description
 **/
public class JwtUserFactory {

    private JwtUserFactory(){}

    public static JwtUser createJwtUser(SysUser user, List<SysRole> roleList){
        return JwtUser.builder()
                .id(user.getId())
                .username(user.getLoginName())
                .password(user.getPassword())
                .mobileNum(user.getMobileNum())
                .nickname(user.getNickname())
                .authorities(mapToGrantedAuthorities(roleList.stream().map(SysRole :: getRoleName).collect(Collectors.toList())))
                .build();
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities){
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
