package com.dtdhehe.dto;

import lombok.Data;

/**
 * @author Xie_东
 * @version 1.0
 * @date 2021/2/24 20:45
 * @description
 **/
@Data
public class UserDto {

    /** 用户登录名 */
    private String loginName ;
    /** 登录密码 */
    private String password ;
    /** 手机号 */
    private String mobileNum ;
    /** 昵称 */
    private String nickname ;
    /** 性别;(0：未设置；1：男；2：女) */
    private String sex ;

}
