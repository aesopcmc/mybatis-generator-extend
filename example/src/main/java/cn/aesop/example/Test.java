package cn.aesop.example;

import cn.aesop.example.generator.model.AdminUser;

import java.io.ObjectStreamClass;

public class Test {
    public static void main(String[] args) {
        ObjectStreamClass c = ObjectStreamClass.lookup(AdminUser.class);
        long serialID = c.getSerialVersionUID();
        System.out.println(serialID);
    }
}
