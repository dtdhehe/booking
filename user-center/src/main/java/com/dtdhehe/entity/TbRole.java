package com.dtdhehe.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/23 17:50
 * @description
 **/
@TableName(value="tb_role")
@Data
public class TbRole {

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
    /** 有效标志;(0:无效;1:有效) */
    private String validFlag ;
    /** 角色名称 */
    private String roleName ;

}
