package com.dtdhehe.system.data.vo;

import lombok.Data;

@Data
public class UserVO {

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
    /** 角色key */
    private String roleKey;

}
