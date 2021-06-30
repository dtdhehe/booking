package com.dtdhehe.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dtdhehe.entity.SysUser;
import com.dtdhehe.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, SysUser> implements IService<SysUser> {
}
