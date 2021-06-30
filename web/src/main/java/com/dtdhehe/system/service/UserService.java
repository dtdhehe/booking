package com.dtdhehe.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dtdhehe.common.exception.ServiceException;
import com.dtdhehe.entity.SysRole;
import com.dtdhehe.entity.SysUser;
import com.dtdhehe.entity.SysUserRole;
import com.dtdhehe.mapper.RoleMapper;
import com.dtdhehe.mapper.UserMapper;
import com.dtdhehe.mapper.UserRoleMapper;
import com.dtdhehe.system.constants.RoleConstants;
import com.dtdhehe.system.data.dto.UserDto;
import com.dtdhehe.system.data.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends ServiceImpl<UserMapper, SysUser> implements IService<SysUser> {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public Optional<UserVO> saveUser(UserVO userVO){
        SysUser user = SysUser.builder()
                .loginName(userVO.getLoginName())
                .password(new BCryptPasswordEncoder().encode(userVO.getPassword()))
                .mobileNum(userVO.getMobileNum())
                .nickname(userVO.getNickname())
                .sex(StringUtils.isEmpty(userVO.getSex()) ? "0" : userVO.getSex())
                .userType("1")
                .build();
        // 查询是否保存过相同用户名的用户
        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("login_name",user.getLoginName());
        SysUser sysUser = baseMapper.selectOne(userQueryWrapper);
        if (sysUser != null) throw new ServiceException("该用户已存在");
        if (baseMapper.insert(user) > 0){
            // 用户保存成功，保存角色关联表
            String role = StringUtils.isEmpty(userVO.getRoleKey()) ? RoleConstants.ROLE_NORMAL : userVO.getRoleKey();
            QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("role_key",role);
            SysRole sysRole = roleMapper.selectOne(queryWrapper);
            user = baseMapper.selectOne(userQueryWrapper);
            SysUserRole userRole = SysUserRole.builder()
                    .userId(user.getId())
                    .roleId(sysRole.getId()).build();
            userRoleMapper.insert(userRole);
            userVO.setRoleKey(role);
            userVO.setPassword("");
            return Optional.of(userVO);
        }
        return Optional.empty();
    }

}
