package com.gradproject.playground;

import com.gradproject.playground.entity.Scenic;
import com.gradproject.playground.entity.Ticket;
import com.gradproject.playground.mapper.ScenicMapper;
import com.gradproject.playground.mapper.TicketMapper;
import com.gradproject.playground.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Date;

@SpringBootTest
class PlaygroundApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ScenicMapper scenicMapper;
    @Autowired
    private TicketMapper ticketMapper;



    @Test
    void contextLoads() {
        Ticket ticket = new Ticket(1, 1, new Date());
        System.out.println(ticketMapper.addTicket(ticket));
    }

    @Test
    void test01() {
        //        User user=new User();
//        user.setEmail("2438747008@qq.com");
//        user.setPassword(encryptBasedDes("2438747520D"));
//        userMapper.addUser(user);
//        User user=userMapper.findByEmail("2438747008@qq.com");
//        System.out.println(decryptBasedDes(user.getPassword()));
    }

    @Test
    void test02() {
        Scenic scenic = new Scenic("重庆欢乐谷", "重庆欢乐谷是一个重庆市最大的游乐场，里面设施齐全，玩法众多并且价格实惠。",
                "摩天轮,大摆锤,跳楼机,海盗船,鬼屋,大风车,过山车,旋转木马", 150, 128, "重庆");
//        int i = scenicMapper.addScenic(scenic);
//        if (i > 0) System.out.println("添加成功");
//        else System.out.println("添加失败");
        System.out.println(scenicMapper.findById(1));
        String facilities = scenicMapper.findById(1).getScenicFacilities();
        String[] split = facilities.split(",");
        for (String str : split) {
            System.out.println(str);
        }
    }
}
