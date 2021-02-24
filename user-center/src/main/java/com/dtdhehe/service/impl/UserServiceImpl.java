package com.dtdhehe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dtdhehe.entity.TbUser;
import com.dtdhehe.mapper.UserMapper;
import com.dtdhehe.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/24 16:15
 * @description
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TbUser> implements UserService {
    @Override
    public TbUser findByUsername(String username) {
        QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
        wrapper.eq("LOGIN_NAME",username);
        return baseMapper.selectOne(wrapper);
    }
}
