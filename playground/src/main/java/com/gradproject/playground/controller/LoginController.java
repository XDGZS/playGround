package com.gradproject.playground.controller;

import com.gradproject.playground.entity.LoginForm;
import com.gradproject.playground.entity.MIMA;
import com.gradproject.playground.entity.RegisterForm;
import com.gradproject.playground.entity.User;
import com.gradproject.playground.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 登录注册控制器
 * 2022/3/10
 * */
@RestController
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    private MIMA mima;
    @Value("${spring.mail.username}")
    private String sender;// 发送者
    @Autowired
    private JavaMailSender javaMailSender;
    private Map<String, Object> resultMap = new HashMap<>();

    /*
     * 登录模块
     * 2022/3/10
     * */
    @RequestMapping("/login")
    @ResponseBody
    public String login(@Valid LoginForm form, BindingResult result) {
        if (result.hasErrors()) {
            if (result.hasErrors()) {
                for (ObjectError error : result.getAllErrors())
                    return error.getDefaultMessage();
            }
        }
        if (userService.login(form.getEmail(), MIMA.encryptBasedDes(form.getPassword())))
            return "登录成功";
        else
            return "用户名或密码错误";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(@Valid RegisterForm form, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors())
                return error.getDefaultMessage();
        }
        if (form.getCode().equals(resultMap.get("code"))) {
            User user = new User(form.getEmail(), form.getPassword());
            boolean flag = userService.register(user);
            if (flag) return "注册成功";
            else return "注册失败";
        } else {
            return "验证码错误,请从新输入";
        }
    }

    /*
     * 邮件发送器
     * 2022/3/10
     * */
    @RequestMapping("/sendEmail")
    //转换json数据  @ResponseBody
    @ResponseBody
    public String sendEmail(String email) {
        String mailRegex = "^[0-9a-z]+\\w*@([0-9a-z]+\\.)+[0-9a-z]+$";          //邮箱正则表达式      ^[0-9a-z]+\w*@([0-9a-z]+\.)+[0-9a-z]+$
        Pattern pattern = Pattern.compile(mailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return "邮箱格式不对";
        }
        SimpleMailMessage message = new SimpleMailMessage();
        String code = MIMA.VerifyCode(6);    //随机数生成6位验证码
        message.setFrom(sender);
        message.setTo(email);
        message.setSubject("邮件验证系统");// 标题
        message.setText("【邮件验证系统】你的验证码为：" + code + "，有效时间为60秒(若不是本人操作，可忽略该条邮件)");// 内容
        try {
            javaMailSender.send(message);
            logger.info("文本邮件发送成功！");
            saveCode(code);
            return "success";
        } catch (MailSendException e) {
            logger.error("目标邮箱不存在");
            return "false";
        } catch (Exception e) {
            logger.error("文本邮件发送异常！", e);
            return "failure";
        }
    }


    //保存验证码和时间
    private void saveCode(String code) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, 1);
        String currentTime = sf.format(c.getTime());// 生成1分钟后时间，用户校验是否过期

        resultMap.put("hash", code);
        resultMap.put("tamp", currentTime);
    }
}

