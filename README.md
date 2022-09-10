# VxMessage
微信公众号模板消息推送。
只需要修改`MessageService`和`VxUtil`中用中文写的内容，替换成你自己从[微信公众号测试平台](https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index)
获取的内容。

修改的具体如下：
MessageService
```java

    @Scheduled(cron = "0 0 9 * * ?") //可以修改成你要的时间
    public void sendMessage(){
        VxMessageDto dto = new VxMessageDto();
        dto.setTemplate_id("你的模板ID");  //修改成你的模板ID
        dto.setTouser("用户ID"); //修改成你的用户ID
        HashMap<String, DataInfo> map = new HashMap<>();
        setMap(map,"userName","名字","#FFCCCC"); //改成她的名字
        setMap(map,"holdDay", DateUtil.passDay(2020,7,8),"#FFCCCC"); //改成你在一起的时间
        setMap(map,"yourBirthDay",DateUtil.getNextBirthDay(8,11),"#FFCCCC"); //改成她的生日
        setMap(map,"myBirthDay", DateUtil.getNextChineseBirthDay(2,15),"#FFCCCC"); //改成你的生日
        setMap(map,"loveDay",DateUtil.getNextBirthDay(7,8),"#FFCCCC"); //改成你在一起的时间
        dto.setData(map);
        String message = JSONUtil.toJsonStr(dto);
        VxUtil.sendMessage(message);
    }
```

VxUtil
```java
public class VxUtil {

    private static final String AppID = "你的APPID";

    private static final String appsecret= "你的密钥";
```




可以通过我博客的文章来进一步了解
[JAVA如何创建公众号推送消息的服务？](http://sqdpt.top/#/blog?id=150)

