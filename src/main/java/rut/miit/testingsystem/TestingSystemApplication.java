package rut.miit.testingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.awt.*;
import java.io.StringReader;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
public class TestingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestingSystemApplication.class, args);
    }
}

