package org.example;

import com.hellokaton.blade.Blade;

public class Main {
    public static void main(String[] args) {
        // 使用 Blade 实例创建多种路由 GET、POST、PUT、DELETE
        Blade.create()
                .start();
    }
}