package com.dtdhehe.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.dtdhehe.util.DateUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/24 16:03
 * @description
 **/
@Component
public class MybatisObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("validFlag","1",metaObject);
        this.setFieldValByName("createdTime", LocalDateTime.now(),metaObject);
        this.setFieldValByName("updatedTime",LocalDateTime.now(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatedTime",LocalDateTime.now(),metaObject);
    }
}
