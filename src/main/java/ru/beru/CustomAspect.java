package ru.beru;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CustomAspect {
    @After("execution(@ru.yandex.qatools.allure.annotations.Step * ru.beru..*.*(..))")
    public void takeScreenshotAfterStep(final JoinPoint joinPoint) {
//        AttachScreenshot a = new AttachScreenshot(joinPoint);
//        joinPoint.getSignature()
//TODO: implement this feature
    }
}
