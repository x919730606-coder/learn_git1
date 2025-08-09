package com.bjpowernode.aop;

import com.bjpowernode.annotation.DataScope;
import com.bjpowernode.entity.TRole;
import com.bjpowernode.entity.TUser;
import com.bjpowernode.query.BaseQuery;
import com.bjpowernode.util.LoginInfoUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.List;

@Component
@Aspect
public class DataScopeAspect {
    @Around("@annotation(com.bjpowernode.annotation.DataScope)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature)point.getSignature();
        DataScope dataScope = methodSignature.getMethod().getAnnotation(DataScope.class);
        String tableAlias = dataScope.tableAlias();
        String columnName = dataScope.columnName();
        TUser loginUser = LoginInfoUtil.getCurrentLoginUser();
        List<TRole> tRoleList = loginUser.getTRoleList();
        Boolean isAdmin = tRoleList.stream().anyMatch(tRole -> tRole.getRole().equals("admin"));
        if (!isAdmin){
            Object params = point.getArgs()[0];
            if (params instanceof BaseQuery){
                BaseQuery baseQuery = (BaseQuery)params;
                baseQuery.setFilterSQL(tableAlias + "." + columnName + " =" + loginUser.getId() );
            }
        }
        Object result = point.proceed();
        return result;
    }
}
