package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.hellokaton.anima.Anima;
import com.hellokaton.blade.Blade;
import org.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import static com.hellokaton.anima.Anima.select;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        Blade blade = Blade.create().start();

        // MySQL
//        Anima.open("jdbc:mysql://127.0.0.1:3306/yupi", "root", "admin");



// SELECT COUNT(*) FROM users

// SELECT * FROM users WHERE user_name LIKE ?

        System.out.println("blade.environment().getOrNull(\"jdbc.url\") = " + blade.environment().getOrNull("jdbc.url"));
        // DataSource
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/yupi");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        Anima.open(dataSource);
        long count = select().from(User.class).count();
        System.out.println("count = " + count);

//        log.info("Hello Info, {}", "2017");
//        log.warn("Hello Warn");
//        log.debug("Hello Debug");
//        log.error("Hello Error");

        // 使用 Blade 实例创建多种路由 GET、POST、PUT、DELETE

    }
}