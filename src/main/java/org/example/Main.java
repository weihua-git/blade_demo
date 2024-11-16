package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.hellokaton.anima.Anima;
import com.hellokaton.blade.Blade;
import org.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.hellokaton.anima.Anima.select;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        Blade blade = Blade.create().start();

        // MySQL
//        Anima.open("jdbc:mysql://127.0.0.1:3306/yupi", "root", "admin");


// SELECT COUNT(*) FROM users

// SELECT * FROM users WHERE user_name LIKE ?

        // DataSource
        DruidDataSource dataSource = new DruidDataSource();
        // 使用最新的驱动类
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(blade.environment().getOrNull("jdbc.url"));
        dataSource.setUsername(blade.environment().getOrNull("jdbc.username"));
        dataSource.setPassword(blade.environment().getOrNull("jdbc.password"));


        Anima open = Anima.open(dataSource);


        // 根据主键查询一条数据
        User user = select().from(User.class).byId(1);
        List<User> users = select().from(User.class).byIds(1, 2, 3);

        long count = select().from(User.class).count();
        // SELECT COUNT(*) FROM users



//        long count = select().from(User.class).count();
//        System.out.println("count = " + count);
        // SELECT COUNT(*) FROM users


//        long count = select().from(User.class).where("age > ?", 15).notNull("user_name").count();
//        long count1 = select().from(User.class).notNull("age").useSQL().count();
//        System.out.println("count1 = " + count1);


//        System.out.println("count = " + count);
//        // SELECT COUNT(*) FROM users WHERE age > ? AND user_name IS NOT NULL


//        log.info("Hello Info, {}", "2017");
//        log.warn("Hello Warn");
//        log.debug("Hello Debug");
//        log.error("Hello Error");

        // 使用 Blade 实例创建多种路由 GET、POST、PUT、DELETE

    }
}