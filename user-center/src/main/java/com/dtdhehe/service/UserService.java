package com.dtdhehe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dtdhehe.dto.UserDto;
import com.dtdhehe.entity.TbUser;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/24 16:15
 * @description
 **/
public interface UserService extends IService<TbUser> {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    TbUser findByUsername(String username);

    /**
     * 保存用户
     * @param userDto
     * @return
     */
    void saveUser(UserDto userDto) throws Exception;
}
