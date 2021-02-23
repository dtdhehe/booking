package com.dtdhehe.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/23 17:02
 * @description
 **/
@TableName(value="tb_user")
@Data
public class TbUser {

    /** 主键 */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private LocalDateTime createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private LocalDateTime updatedTime ;
    /** 有效标志;(0:无效；1:有效) */
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
    /** 身份标识;(0:超级管理员;1:普通用户;2:加盟店家) */
    private String userType ;

}
