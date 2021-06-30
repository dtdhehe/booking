package com.dtdhehe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dtdhehe.entity.SysRole;

import java.util.List;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/3/19 15:44
 * @description
 **/
public interface RoleService extends IService<SysRole> {

    /**
     * 根据userId获取用户所有角色
     * @param userId
     * @return
     */
    List<SysRole> getRoleListByUserId(Long userId);

}
