package com.dtdhehe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dtdhehe.dto.UserDto;
import com.dtdhehe.entity.SysUser;
import com.dtdhehe.mapper.UserMapper;
import com.dtdhehe.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/24 16:15
 * @description
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {
    @Override
    public SysUser findByUsername(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("LOGIN_NAME",username);
        return baseMapper.selectOne(wrapper);
    }

}
