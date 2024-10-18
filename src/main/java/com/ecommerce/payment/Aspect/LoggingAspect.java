package com.ecommerce.payment.Aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Logging before the controller method
    @Before("execution(* com.ecommerce.payment.controller.PaymentController.makePayment(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        logger.info("Received payment request: {}", joinPoint.getArgs()[0]);
    }



    // Logging before the service method
    @Before("execution(* com.ecommerce.payment.service.PaymentService.makePayment(..))")
    public void logBeforeService(JoinPoint joinPoint) {
        logger.info("Processing payment in service: {}", joinPoint.getArgs()[0]);
    }

    // Logging after the service method
    @AfterReturning(pointcut = "execution(* com.ecommerce.payment.service.PaymentService.makePayment(..))", returning = "result")
    public void logAfterReturningService(JoinPoint joinPoint, Object result) {
        logger.info("Payment processed successfully in service, payment ID: {}", result);
    }

    // Logging after the controller method
    @AfterReturning(pointcut = "execution(* com.ecommerce.payment.controller.PaymentController.makePayment(..))", returning = "result")
    public void logAfterController(JoinPoint joinPoint, Object result) {
        logger.info("Payment request processed in controller, response ID: {}", result);
    }
}
