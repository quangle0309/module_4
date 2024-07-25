package com.example.library_app.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @After("execution(* com.example.library_app.services.borrow.impl.BorrowService.borrowBook(..))")
    public void logBorrowAction() {

        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\module_4\\ss9_AOP\\library_app\\src\\main\\java\\com\\example\\library_app\\aspect\\file\\log.csv", true)))
        {
            bw.write("Một cuốn sách đã được mượn vào lúc " +  LocalDateTime.now());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After("execution(* com.example.library_app.services.borrow.impl.BorrowService.returnBook(..))")
    public void logReturnAction() {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\module_4\\ss9_AOP\\library_app\\src\\main\\java\\com\\example\\library_app\\aspect\\file\\log.csv", true)))
        {
            bw.write("Một cuốn sách đã được trả vào lúc" +  LocalDateTime.now());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Before("execution(* com.example.library_app.controllers..*(..))")
    public void logVisitor() {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\module_4\\ss9_AOP\\library_app\\src\\main\\java\\com\\example\\library_app\\aspect\\file\\log.csv", true)))
        {
            bw.write("Một người dùng đã truy cập thư viện vào lúc" +  LocalDateTime.now());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterThrowing("execution(* com.example.library_app..*(..))")
    public void logExceptionAction() {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\module_4\\ss9_AOP\\library_app\\src\\main\\java\\com\\example\\library_app\\aspect\\file\\logException.csv", true)))
        {
            bw.write("Một lỗi đã xảy ra vào lúc" +  LocalDateTime.now());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
