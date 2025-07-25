package org.example.library_management.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {

    private static final Logger logger = LoggerFactory.getLogger(BookAspect.class);

    private int visitCount = 0;

    @Pointcut("execution(* org.example..*Controller.*(..))")
    public void allControllerMethods() {}

    @After("allControllerMethods()")
    public void countVisitor(JoinPoint joinPoint) {
        visitCount++;
        System.out.println("Số lượng khách truy cập: " + visitCount);
    }

    @Pointcut("execution(* org.example..*Service.borrowBook(..)) || execution(* org.example..*Service.returnBook(..))")
    public void bookStateChange() {}

    @AfterReturning("bookStateChange()")
    public void logBookChange(JoinPoint joinPoint) {
        logger.info("Phương thức '{}' đã được gọi thành công", joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "bookStateChange()", throwing = "ex")
    public void logError(Throwable ex) {
        logger.error("Đã xảy ra lỗi khi thay đổi trạng thái sách: {}", ex.getMessage());
    }
}