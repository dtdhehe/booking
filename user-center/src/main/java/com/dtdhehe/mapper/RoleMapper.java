package com.dtdhehe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dtdhehe.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/3/19 15:50
 * @description
 **/
public interface RoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户id查询所有角色
     * @param userId
     * @return
     */
    List<SysRole> getByUserId(@Param("userId") Long userId);

}
