package com.wxy.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wxy
 * @title: MyMetaObjectHandler
 * @description: TODO
 * @date 2021/9/2416:55
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate",new Date(), metaObject); // Date应该用哪个类?
        this.setFieldValByName("gmtModified", new Date(), metaObject); // 参数fieldName填的是java类的名字?
                                                                                // column 是数据库里的名字？
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified", new Date(), metaObject);

    }
}
