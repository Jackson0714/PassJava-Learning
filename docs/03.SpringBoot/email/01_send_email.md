SpringBoot 发送邮件的三种方式

你好，我是悟空。

## 背景

最近在做一个关于邮件的专栏：`《SpringBoot 邮件打怪升级》`。

**旨在从 0 开始，带你搭建一个完整的基于 SpringBoot 技术栈 Email 邮件服务。**

整个专栏目录如下，后续会加更。

![](http://cdn.jayh.club/uPic/image-20231223144739143OUNBLO.png)

第一篇是通过 SpringBoot 发送邮件的三种方式，项目代码如下。代码获取方式拉到文末。

![](http://cdn.jayh.club/uPic/image-20231223143123272ZFeC2Q.png)

接口如下：

![](http://cdn.jayh.club/uPic/image-20231223151402442sF189J.png)

### SpringBoot 发送邮件的三种方式

- Spring Framework提供的`JavaMailSender`(与 Spring 集成，推荐👍🏻)
- 使用JavaMail API来发送邮件（灵活🐒，支持发送日程提醒）
- Apache Commons Email 库（简便）

### 选择哪一种方案

- 如果你的项目已经使用了Spring框架，并且只需进行基本的邮件发送，那么使用`JavaMailSender`可能是一个方便的选择。
- 如果你对邮件发送有较高的控制要求，或者需要满足一些特殊场景的需求，那么直接使用JavaMail API可能更为合适。
- 如果你希望在简洁的API和灵活性之间取得平衡，并且不介意引入外部库，那么Apache Commons Email库可能是一个中间的选择。



这里对比一下Spring Framework提供的`JavaMailSender`、使用JavaMail API、以及Apache Commons Email库的优缺点：

### 1. JavaMailSender (Spring Framework)

#### 优点：

- **集成性高：** `JavaMailSender`是 Spring 的一部分，与Spring框架的其他部分紧密集成，可以方便地与Spring的其他功能一起使用。
- **配置简单：** Spring Boot 提供了自动配置，减少了配置的繁琐性。
- **简化API：** Spring 提供了更高层次的抽象，简化了发送邮件的过程，使得代码更加清晰和简洁。

#### 缺点：

- **灵活性较低：** 对于一些特定和高级的需求，可能需要更直接地使用JavaMail API或其他库，因为Spring的抽象可能无法满足所有场景。
- **较大的依赖：** 如果你只是需要发送邮件，引入整个Spring框架可能会显得过于庞大，特别是对于一些小型项目。

### 2. JavaMail API

#### 优点：

- **灵活性高：** JavaMail API 提供了更底层、更直接的控制，可以满足各种邮件发送需求。
- **标准化：** JavaMail API 是Java标准库的一部分，可移植性好，与Java平台集成度高。

#### 缺点：

- **繁琐：** 使用JavaMail API编写代码可能较为繁琐，需要更多的代码量，尤其是对于一些简单的邮件发送场景。
- **学习曲线：** 对于新手来说，学习JavaMail API可能需要一些时间。

### 3. Apache Commons Email库

#### 优点：

- **简化API：** Apache Commons Email 库提供了更简单的API，相比JavaMail API，可以更容易地发送各种类型的电子邮件，包括HTML邮件等。
- **减少样板代码：** 相比JavaMail API，Apache Commons Email库可以减少一些样板代码，使得代码更加简洁。

#### 缺点：

- **不如 JavaMail API灵活：** 虽然简化了API，但相比JavaMail API，Apache Commons Email 库可能在某些高级场景下的灵活性有所减弱。
- **依赖：** 引入外部库可能增加项目的依赖。

## JavaMailSender 示例

以下是一个简单的Spring Boot邮件发送的示例代码：

首先，确保你的Spring Boot项目中包含了Spring Boot Starter Mail库。在`pom.xml`中添加以下依赖：

``` XML
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>

```

然后，创建一个服务类来处理邮件发送：

``` java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }
}

```

接下来，在你的应用程序中，你可以使用`EmailService`类来发送电子邮件。以下是一个简单的示例控制器：

``` java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) {
        emailService.sendEmail(to, subject, text);
        return "Email sent successfully!";
    }
}

```

在上述代码中，通过调用`sendEmail`方法，你可以发送一封包含指定主题和文本内容的电子邮件。

确保在`application.properties`或`application.yml`文件中配置SMTP服务器的相关信息，例如：

``` YAML
  mail:
    host: smtp.163.com
    username: 邮箱名字
    password: 邮箱密码或者密钥
    port: 465
    protocol: smtp
    default-encoding: utf-8
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
            required: true
          ssl:
            enable: true
          socketFactory:
            port: 465
            class: javax.net.ssl.SSLSocketFactory
```

可以用 swagger 测试请求，也可以用 postman 工具测试。

![](http://cdn.jayh.club/uPic/image-20231223153227450FUoEBO.png)

测试结果如下：

![](http://cdn.jayh.club/uPic/image-202312231547363683x5fs1.png)

## 使用JavaMail API来发送邮件

在Spring Boot应用程序中使用JavaMail API发送电子邮件。

### 添加依赖

在你的`pom.xml`文件中，添加以下依赖：

``` XML
<dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>javax.mail</artifactId>
    <version>1.6.2</version>
</dependency>
```

### 邮箱配置

确保在`application.properties`或`application.yml`文件中配置SMTP服务器的相关信息，例如：

``` YAML
  mail:
    host: smtp.163.com
    username: 邮箱名字
    password: 邮箱密码或者密钥
    port: 465
    protocol: smtp
    default-encoding: utf-8
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
            required: true
          ssl:
            enable: true
          socketFactory:
            port: 465
            class: javax.net.ssl.SSLSocketFactory
```

### 编写发送邮件的代码

1. 使用JavaMail API发送电子邮件。以下是一个简单的例子：

```java
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleEmail(String to, String subject, String text) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "your_smtp_host");
        properties.put("mail.smtp.port", "your_smtp_port");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "your_email_password");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(text);

        Transport.send(message);
    }
}

```

使用服务类发送邮件：

``` JAVA
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) {
        try {
            emailService.sendSimpleEmail(to, subject, text);
            return "Email sent successfully!";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Failed to send email.";
        }
    }
}

```



## Apache Commons Email 库

### 添加依赖：

在你的`pom.xml`文件中，添加 Apache Commons Email库的依赖：

```
xmlCopy code
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-email</artifactId>
    <version>1.5</version> <!-- 替换为最新版本 -->
</dependency>
```

确保这个依赖被正确地添加到你的项目中。

### 配置SMTP服务器：

在你的`application.properties`或`application.yml`文件中配置SMTP服务器的相关信息，例如：

```
propertiesCopy code
spring.mail.host=your_smtp_host
spring.mail.port=your_smtp_port
spring.mail.username=your_email@gmail.com
spring.mail.password=your_email_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### 编写发送邮件的代码

创建一个服务类，使用Apache Commons Email库发送电子邮件。以下是一个简单的例子：

```JAVA
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String from;

    public void sendSimpleEmail(String to, String subject, String text) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        email.setHostName("your_smtp_host");
        email.setSmtpPort(Integer.parseInt("your_smtp_port"));
        email.setAuthenticator(new DefaultAuthenticator(from, "your_email_password"));
        email.setStartTLSEnabled(true);

        email.setFrom(from);
        email.addTo(to);
        email.setSubject(subject);
        email.setMsg(text);

        email.send();
    }
}
```

### 使用服务类发送邮件

在你的控制器或其他地方调用`EmailService`发送邮件：

```
javaCopy code
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) {
        try {
            emailService.sendSimpleEmail(to, subject, text);
            return "Email sent successfully!";
        } catch (EmailException e) {
            e.printStackTrace();
            return "Failed to send email.";
        }
    }
}
```

这样，你就可以使用Apache Commons Email库发送邮件了。确保替换配置中的实际值，并根据你的需求进行定制。

《Java 发送邮件专栏》更新中，项目代码获取方式：扫码加入悟空的知识星球，开通最新的项目代码。

![](http://cdn.jayh.club/uPic/xingqiu-100_2025ajS9l9.png)



