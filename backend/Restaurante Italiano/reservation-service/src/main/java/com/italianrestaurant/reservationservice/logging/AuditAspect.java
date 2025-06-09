package com.italianrestaurant.reservationservice.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    private static final Logger logger = LoggerFactory.getLogger(AuditAspect.class);

    @After("@annotation(adminAudit)")
    public void auditAction(JoinPoint joinPoint, AdminAudit adminAudit) {
        String methodName = joinPoint.getSignature().getName();
        String action = adminAudit.action().isEmpty() ? methodName : adminAudit.action();

        logger.info("🛡️ Auditoria: ação administrativa registrada: " + action);
    }
}