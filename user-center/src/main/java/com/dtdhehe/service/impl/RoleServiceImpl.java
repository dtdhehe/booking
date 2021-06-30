package com.dtdhehe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dtdhehe.entity.SysRole;
import com.dtdhehe.mapper.RoleMapper;
import com.dtdhehe.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/3/19 15:45
 * @description
 **/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, SysRole> implements RoleService {
    @Override
    public List<SysRole> getRoleListByUserId(Long userId) {
        return baseMapper.getByUserId(userId);
    }
}
