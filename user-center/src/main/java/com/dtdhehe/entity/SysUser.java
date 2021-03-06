package com.dtdhehe.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/23 17:02
 * @description
 **/
@TableName(value="sys_user")
@Data
@Builder
public class SysUser {

    /** 主键 */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime ;
    /** 有效标志;(0:无效；1:有效) */
    @TableField(fill = FieldFill.INSERT)
    private String validFlag ;
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
    /** 身份标识;(0:超级管理员;1:普通用户;) */
    private String userType ;

}
