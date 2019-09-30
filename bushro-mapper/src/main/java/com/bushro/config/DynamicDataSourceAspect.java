package com.bushro.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
// 该切面应当先于 @Transactional 执行
@Order(-1)
@Component
public class DynamicDataSourceAspect {
    /** * Switch DataSource * * @param point * @param targetDataSource */
    @Before("@annotation(targetDataSource))")
    public void switchDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        if (!DynamicDataSourceContextHolder.containDataSourceKey(targetDataSource.value())) {
            System.out.println("DataSource [{}] doesn't exist, use default DataSource [{}] " + targetDataSource.value());
        } else {
            // 切换数据源
            DynamicDataSourceContextHolder.setDataSourceKey(targetDataSource.value());
            System.out.println("Switch DataSource to [{}] in Method [{}] " +
                    DynamicDataSourceContextHolder.getDataSourceKey() + point.getSignature());
        }
    }

    /** * Restore DataSource * * @param point * @param targetDataSource */
    @After("@annotation(targetDataSource))")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        // 将数据源置为默认数据源
        DynamicDataSourceContextHolder.clearDataSourceKey();
        System.out.println("Restore DataSource to [{}] in Method [{}] " +
                DynamicDataSourceContextHolder.getDataSourceKey() + point.getSignature());
    }
}
