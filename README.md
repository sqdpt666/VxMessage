# VxMessageWeatherActions SpringBoot
**请仔细阅读本文档哦~**
只能说究极无敌详细，成功了给我一个**三连或关注**吧！！！！！！！！！！！！！！！！！！！！！！！！

微信消息推送Gitub Actions版本日期+天气预报+其他，**究极简单版2.4.2**

(2022/9/20)究极简单版2.1更新了更多的内置消息模板

(2022/9/22)究极简单版2.2更新了更多的内置消息模板

(2022/9/22 22:58)究极简单版2.3 换了几个不能用的API，并增加了几个内置模板

(2022/9/23 12:01)究极简单版2.3.1 修复了世界新闻出错的BUG

(2022/9/23 13:40)究极简单2.3.2 模板内容超过一百字的会在后面加上序号延续（1、2、3、4......每100字一个，如tianGou超过了一百个字的话：{{tianGou.DATA}}{{tianGou1.DATA}}） 最好紧贴在一起，不然内容会分开

(2022/10/1) 究极简单2.4.0 支持更多方便的自定义操作，删除了小说模块

(2022/10/5) 究极简单2.4.1 优化了一下超时处理，避免了运行卡住的情况


![image](https://user-images.githubusercontent.com/56298636/191155129-eacde564-3a6d-4d95-9ea0-7a075d30a469.png)


## 食用步骤

### 第一步：复制本项目到你的仓库，设置为私有项目
点击复制项目地址

![点击复制项目地址](https://user-images.githubusercontent.com/56298636/190580174-32b7c197-866f-4e94-b886-36b817e40b03.png)

右上角导入按钮

![image](https://user-images.githubusercontent.com/56298636/190580243-f0b4b8ef-9eb3-4ac2-ab5b-d48aa435e0e7.png)

完成导入

![image](https://user-images.githubusercontent.com/56298636/190580561-fb0cc938-6999-4430-aee2-1616362f6857.png)


### 第二步：修改`AllConfig`中的配置
1. 修改`AllConfig`中对应的地方替换成你自己从[微信公众号测试平台](https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index)
获取的内容即可
2. 修改`AllConfig`中对应的地方替换成你从[高德地图开发者平台](https://lbs.amap.com/api/webservice/guide/create-project/get-key)获取的KEY。（这个链接直通获取key的教程）
3. 修改`AllConfig`中对应的地方,替换成你或者你对象的个人信息,如生日，纪念日，地址等

#### 关于要修改的内容具体位置说明:
`AllConfig`要改的部分，如下：
```java
public class AllConfig {
    public static final String VxAppId = "微信的APPID";
    public static final String VxAppSecret = "微信的密钥";
    public static final String WeatherKey = "高德地图key";
    private static void init(){
        //如果要多个人的话，就复制这个一遍，然后填写里面的内容。这里默认两个人,大伙应该是两个人吧（笑）
        userList.add(getUser(
                "这个人扫码后的微信号",//扫码关注你的测试号以后，测试平台会出现TA的微信号
                "这个人的称呼",//咋称呼这个人
                new BirthDay(1999,8,11,false),  //这个人的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                new BirthDay(1999,2,15,true), //这个人对象的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                LocalDate.of(2020,7,8),//这个人的纪念日
                "江苏省南京市玄武区",//这个人的详细地址
                "南京",//这个人在的城市
                "微信消息模板ID"));//要给这个人发送的模板ID

        userList.add(getUser(
                "这个人扫码后的微信号",
                "这个人的名字",
                new BirthDay(1999,2,15,true),  //这个人的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                new BirthDay(1999,8,11,false), //这个人对象的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                LocalDate.of(2020,7,8),//这个人的纪念日
                "江苏省南京市玄武区",//这个人的详细地址
                "南京",//这个人在的城市
                "微信消息模板ID"));//要给这个人发送的模板ID

    }

```
#### 关于微信公众号测试平台的内容的说明：
  1. AppID和appSecret在微信公众号测试平台网站最上方
  
  ![image](https://user-images.githubusercontent.com/56298636/190580833-949247b1-2ac0-4399-8ec4-b94abbbed0ce.png)

  2. 模板ID在添加模板后生成
  
  ![image](https://user-images.githubusercontent.com/56298636/190581136-d03d102c-b668-47af-96f6-89e0a79e88c1.png)

  3. 用户ID在扫码关注后生产
  
  ![image](https://user-images.githubusercontent.com/56298636/190581072-9b14c1b3-6564-498e-8546-3b0b93bdeaed.png)

#### 关于高德地图的内容说明：
1. 创建一个新应用

![image](https://user-images.githubusercontent.com/56298636/190583327-dfae0cd2-9450-4b2b-8f3c-dbd0999959f0.png)

2.给应用起个名字

![image](https://user-images.githubusercontent.com/56298636/190583508-09e3c4d6-0063-4dab-9097-a167a594be38.png)

3. 新增一个key
![image](https://user-images.githubusercontent.com/56298636/190583577-0d804449-6cba-41f1-a169-f9c5af4c6bfd.png)

4. 配置一下
![image](https://user-images.githubusercontent.com/56298636/190583666-ab4fefa1-e560-46cf-acaa-addabbc748ea.png)

5. 获得key

![image](https://user-images.githubusercontent.com/56298636/190584096-2e34f62c-b4d5-4263-bc3e-24727422586d.png)






## 消息模板
微信消息模板，复制到[微信公众号测试平台](https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index)的模板里面
友情提示：复制到微信平台里面后，格式可能会乱哦，记得整理一下^_^

内置的模板有：

在微信模板里添加{{xxx.DATA}}
```java
/**
 *内容超过一百字的会在后面加上序号延续（1、2、3、4......每100字一个，如tianGou超过了一百个字的话：{{tianGou.DATA}}{{tianGou1.DATA}}）
 * 
 * 个人信息相关：
 * userName 昵称
 * holdDay 距离某天的天数
 * yourBirthDay 生日
 * myBirthDay 对象生日
 * loveDay 纪念日倒计时
 * 
 *
 * 天气相关：
 * date 日期
 * week 星期
 * weatherDay（1，2，3，4） 白天天气
 * temperatureDay（1，2，3，4）白天温度
 * windDay（1，2，3，4）白天风向
 * powerDay（1，2，3，4）白天风力
 * weatherNight（1，2，3，4） 晚上天气
 * temperatureNight（1，2，3，4） 晚上温度
 * windNight（1，2，3，4） 晚上风向
 * powerNight（1，2，3，4） 晚上风力
 * weatherNow 现在天气
 * temperatureNow 现在温度
 * windNow 现在风向
 * powerNow 现在风力
 * humidityNow 现在湿度
 * 
 * 特殊：
 * otherInfo 额外提示
 * story
 *
 * 额外类型：
 * randomRead 精彩短句
 * worldRead 世界新闻
 * tianGou 舔狗日记
 * qingHua 情话
 * english 励志英语
 * historyToday 历史的今天
 * horoscope 星座解析
 * randomInfo 随机额外类型消息
 * wozairenjian 我在人间凑日子散文
 * miyu 谜语
 * poetry 诗句
 * dongman 动漫
 */
```

2.0模板：
```
{{userName.DATA}}， 
今天是我们在一起的{{holdDay.DATA}}天 
你的生日还有{{yourBirthDay.DATA}}天 
我的生日还有{{myBirthDay.DATA}}天 
距离我们下一次纪念还有{{loveDay.DATA}}天 
今天白天{{weatherDay.DATA}}，温度{{temperatureDay.DATA}}℃ 
今天晚上{{weatherNight.DATA}}，温度{{temperatureNight.DATA}}℃ 


最后，开心每一天！
```
2.1模板：
```
{{userName.DATA}}， 
{{date.DATA}} 周{{week.DATA}} 
今天是我们在一起的{{holdDay.DATA}}天 
你的生日还有{{yourBirthDay.DATA}}天 
我的生日还有{{myBirthDay.DATA}}天 
距离我们下一次纪念还有{{loveDay.DATA}}天 
今天白天{{weatherDay.DATA}}，温度{{temperatureDay.DATA}}℃ 
今天晚上{{weatherNight.DATA}}，温度{{temperatureNight.DATA}}℃ 
明天白天{{weatherDay1.DATA}}，温度{{temperatureDay1.DATA}}℃ 
明天晚上{{weatherNight1.DATA}}，温度{{temperatureNight1.DATA}}℃ 
{{otherInfo.DATA}} 

最后，开心每一天！
```

2.2模板：
```
{{userName.DATA}}， 
{{date.DATA}} 周{{week.DATA}} 
今天是我们在一起的{{holdDay.DATA}}天 
你的生日还有{{yourBirthDay.DATA}}天 
我的生日还有{{myBirthDay.DATA}}天 
距离我们下一次纪念还有{{loveDay.DATA}}天 
今天白天{{weatherDay.DATA}}，温度{{temperatureDay.DATA}}℃ 
今天晚上{{weatherNight.DATA}}，温度{{temperatureNight.DATA}}℃ 
明天白天{{weatherDay1.DATA}}，温度{{temperatureDay1.DATA}}℃ 
明天晚上{{weatherNight1.DATA}}，温度{{temperatureNight1.DATA}}℃ 
{{otherInfo.DATA}} 

{{randomInfo.DATA}}

最后，开心每一天！
```

2.3.4模板
```
{{userName.DATA}}， 
{{date.DATA}} 周{{week.DATA}} 
今天是我们在一起的{{holdDay.DATA}}天 
你的生日还有{{yourBirthDay.DATA}}天 
我的生日还有{{myBirthDay.DATA}}天 
距离我们下一次纪念还有{{loveDay.DATA}}天 
今天白天{{weatherDay.DATA}}，温度{{temperatureDay.DATA}}℃ 
今天晚上{{weatherNight.DATA}}，温度{{temperatureNight.DATA}}℃ 
明天白天{{weatherDay1.DATA}}，温度{{temperatureDay1.DATA}}℃ 
明天晚上{{weatherNight1.DATA}}，温度{{temperatureNight1.DATA}}℃ 
{{otherInfo.DATA}} 

{{randomInfo.DATA}}{{randomInfo1.DATA}}

最后，开心每一天！
```

2.4.0模板
```
{{userName.DATA}}， 
{{date.DATA}} 周{{week.DATA}} 
今天是我们在一起的{{birthDay3.DATA}}天 
你的生日还有{{birthDay.DATA}}天 
我的生日还有{{birthDay1.DATA}}天 
距离我们下一次纪念还有{{birthDay2.DATA}}天 
今天白天{{weatherDay.DATA}}，温度{{temperatureDay.DATA}}℃ 
今天晚上{{weatherNight.DATA}}，温度{{temperatureNight.DATA}}℃ 
明天白天{{weatherDay1.DATA}}，温度{{temperatureDay1.DATA}}℃ 
明天晚上{{weatherNight1.DATA}}，温度{{temperatureNight1.DATA}}℃ 
{{otherInfo.DATA}} 

{{randomInfo.DATA}}{{randomInfo1.DATA}}

最后，开心每一天！
```


### 更多天气

想要展示更多的天气，只需要在模板中加上更多的{{xxx.DATA}}，具体如下：

如果你的获取天气类型为`WeatherUtil.TYPE_ALL` （默认就是这种），那么内置的天气相关模板有：

| 名称             | 意思     |
| ---------------- | -------- |
| weatherDay       | 白天天气 |
| temperatureDay   | 白天温度 |
| weatherNight     | 晚上天气 |
| temperatureNight | 晚上温度 |
| windDay          | 白天风向 |
| windNight        | 晚上风向 |
| powerDay         | 白天风力 |
| windNight        | 晚上风力 |
| date             | 日期     |
| week             | 星期几   |

以上是当天的天气预报，前面说了还有明天的、后天的等等。那么只需要在后面加上一个数字即可(**可以加的数字为1，2，3，4**)。如：

- 明天的白天天气为：`weatherDay1`
- 明天的晚上温度为：`temperatureNight1`
- 后天的白天风力为:`powerDay2`
- 大后天是星期几：`week3`

因此你只需要修改你的模板：

```
{{userName.DATA}}，
今天是我们在一起的{{holdDay.DATA}}天
你的生日还有{{yourBirthDay.DATA}}天
我的生日还有{{myBirthDay.DATA}}天
距离我们的下一次纪念还有{{loveDay.DATA}}天
今天白天{{weatherDay.DATA}}，温度{{temperatureDay.DATA}}℃
今天晚上{{weatherNight.DATA}}，温度{{temperatureNight.DATA}}℃
明天白天{{weatherDay1.DATA}}
后天晚上温度{{temperatureDay2.DATA}}℃
大后天是星期{{week3.DATA}}

最后，开心每一天！
```

如果你的获取天气类型为`WeatherUtil.TYPE_LIVE` ，那么内置的天气相关模板有：

| 名称           | 意思     |
| -------------- | -------- |
| weatherNow     | 现在天气 |
| temperatureNow | 现在温度 |
| windNow        | 现在风向 |
| powerNow       | 现在风力 |
| humidityNow    | 现在湿度 |
| date           | 现在日期 |

因此你只需要修改你的模板：

```
{{userName.DATA}}，
今天是我们在一起的{{holdDay.DATA}}天
你的生日还有{{yourBirthDay.DATA}}天
我的生日还有{{myBirthDay.DATA}}天
距离我们的下一次纪念还有{{loveDay.DATA}}天
现在{{weatherNow.DATA}}
温度{{temperatureNow.DATA}}℃
风向{{windNow.DATA}}
风力{{powerNow.DATA}}
湿度{{humidityNow.DATA}}

最后，开心每一天！
```

**那么如何切换获取天气的类型呢？**

只需要到`com/pt/vx/service/MessageService.java`中修改`sendMessage`方法中的`setWeather(map,user.getAddress(), user.getCity(), WeatherUtil.TYPE_ALL);`

将后面的` WeatherUtil.TYPE_ALL`改为` WeatherUtil.TYPE_LIVE`

` WeatherUtil.TYPE_ALL`为5天天气预报。

` WeatherUtil.TYPE_LIVE`为现在实时天气情况


![image](https://user-images.githubusercontent.com/56298636/191173311-95e9ba0d-611b-4ffc-a484-d6e6b2e99635.png)



### 自定义模板

如果你要自定义模板的动态内容，那么你就需要修改`MessageService`中的`sendMessage`方法

在里面加一个`setMap(map,"命名","值","颜色十六进制")`，**这个命名写英文**
这个命名就是上面消息模板的 {{命名.DATA}}
```java
public class MessageService {
    public void sendMessage(User user){
        //省略前面的内容
      
        //加一个setMap，比如：
        setMap(map,"myself", "hi! 我是自定义的内容","#FFCCCC");
        
       
        //省略后面的内容
    }
```
然后你就把模板改成
```
{{userName.DATA}}，
今天是我们在一起的{{holdDay.DATA}}天
你的生日还有{{yourBirthDay.DATA}}天
我的生日还有{{myBirthDay.DATA}}天
距离我们的下一次纪念还有{{loveDay.DATA}}天
今天白天{{weatherDay.DATA}}，温度{{temperatureDay.DATA}}℃
今天晚上{{weatherNight.DATA}}，温度{{temperatureNight.DATA}}℃
我自定义的内容是{{myself.DATA}}

最后，开心每一天！
```

## 发送时间

在AllConfig中有cron，修改为你想要的时间即可
```java
public static final String cron = "0 0 8 * * ?"; //秒，分、时、天、月、星期
```
如：
```java
public static final String cron = "0 0 6 * * ?"; //每天6点

```
如：
```java
public static final String cron = "0 0 6,8 * * ?"; //每天6点

```
```
如：
```java
public static final String cron = "0 30 6 * * ?"; //每天6点半

```
```
如：
```java
public static final String cron = "30 6 * * * ?"; //每天6点半

```


对你有帮助的话，记得一健三连支持一下哦~
