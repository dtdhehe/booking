package com.dtdhehe.system.controller;

import com.dtdhehe.common.exception.ParamException;
import com.dtdhehe.dto.UserDto;
import com.dtdhehe.service.UserService;
import com.dtdhehe.system.data.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xie_东
 * @version 1.0
 * @date 2021/2/24 20:40
 * @description
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String saveUser(@RequestBody UserVO userVO){
        if (StringUtils.isEmpty(userVO.getLoginName()) || StringUtils.isEmpty(userVO.getPassword())){
            throw new ParamException("用户名或密码不能为空!");
        }
        try {
//            userService.saveUser(userDto);
            return "保存成功";
        }catch (Exception e){
            e.printStackTrace();
            return "保存失败";
        }
    }

}
