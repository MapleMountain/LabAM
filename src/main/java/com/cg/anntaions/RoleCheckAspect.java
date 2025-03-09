package com.cg.anntaions;

import com.cg.anntaions.RequiresRole;
import com.cg.utils.ThreadLocalUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;

import java.util.Map;

@Aspect
@Component
public class RoleCheckAspect {
    @Before("@annotation(requiresRole)")
    public void checkRole(JoinPoint joinPoint, RequiresRole requiresRole) throws Throwable {
        Map<Object, Object> map = ThreadLocalUtil.get();
        String role = (String) map.get("role");
        if (!role.equals(requiresRole.value())) {
            throw new IllegalAccessException("你没有权限");
        }
    }
}
