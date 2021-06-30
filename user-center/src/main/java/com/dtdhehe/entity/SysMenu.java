package com.dtdhehe.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/23 17:52
 * @description
 **/
@TableName(value="sys_menu")
@Data
public class SysMenu {

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
    /** 菜单名称 */
    private String menuName ;
    /** 菜单编码;(3位为一级菜单) */
    private String menuCode ;
    /** 父菜单名称 */
    private String menuParentName ;
    /** 父菜单编码;一级菜单默认为空 */
    private String menuParentCode ;
    /** 菜单图表;font-awesome */
    private String menuIcon ;
    /** 备注 */
    private String remark ;

}
