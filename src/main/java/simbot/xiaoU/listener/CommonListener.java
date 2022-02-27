package simbot.xiaoU.listener;

import love.forte.common.ioc.annotation.Depend;
import love.forte.simbot.annotation.*;
import love.forte.simbot.api.message.MessageContent;
import love.forte.simbot.api.message.MessageContentBuilder;
import love.forte.simbot.api.message.MessageContentBuilderFactory;
import love.forte.simbot.api.message.events.MsgGet;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.BotSender;
import love.forte.simbot.api.sender.Getter;
import love.forte.simbot.api.sender.Sender;
import love.forte.simbot.api.sender.Setter;
import love.forte.simbot.bot.Bot;
import love.forte.simbot.bot.BotManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import simbot.xiaoU.service.GroupService;
import simbot.xiaoU.service.ProblemsDaoService;
import simbot.xiaoU.utils.BotConstant;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Tisox
 * @date: 2021/12/31 14:03
 * @description: 处理群信息和成员相关业务
 * @blog:www.waer.ltd
 */
@Component
@Configuration
@EnableScheduling
public class CommonListener implements BotConstant {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    @Depend
    private MessageContentBuilderFactory messageContentBuilderFactory;
    @Autowired
    private BotManager manager;
    @Autowired
    private GroupService groupService;
    @Autowired
    private ProblemsDaoService problemsDaoService;

    /**
     * 监听私聊消息
     * @param sender sender
     * @param privateMsg pmsg
     * @param msgGet mget
     */
    @OnPrivate
    public void PrivateMsg(Sender sender, PrivateMsg privateMsg, MsgGet msgGet){

        // 获取消息正文。
        MessageContent msgContent = privateMsg.getMsgContent();
        sender.sendPrivateMsg(privateMsg, msgContent);
    }

    @OnGroup
    @Filter(atBot = true)
    public void GroupMsg1(Sender sender, MsgGet msgGet, Getter getter){
        sender.sendGroupMsg(QQ_GROUP_MAIN,"@"+msgGet.getAccountInfo().getAccountCode()+"爱你呦！！");
    }


    @OnGroupMemberIncrease
    public void increase(Sender sender, MsgGet msgGet, Getter getter){
        MessageContentBuilder msgBuilder = messageContentBuilderFactory.getMessageContentBuilder();
        MessageContent up = msgBuilder.image("https://images.waer.ltd/img/up.jpg").build();
        sender.sendGroupMsg(QQ_GROUP_MAIN,up);
    }

    @OnGroupReduce
    public void reduce(Sender sender, MsgGet msgGet, Getter getter){
        sender.sendGroupMsg(QQ_GROUP_MAIN,"【检测到有人退群】");
    }

    @OnGroupAddRequest
    public void addRequest(Sender sender, MsgGet msgGet, Getter getter){
        sender.sendGroupMsg(QQ_GROUP_MAIN,"【检测到入群申请,请处理。】");
    }
//
    @OnGroupMsgRecall
    public void recall(Sender sender, MsgGet msgGet, Getter getter, Setter setter){
        sender.sendGroupMsg(QQ_GROUP_MAIN,
                "【检测到有消息撤回行为,已记录！】撤回者:");
    }


    @OnGroupMemberPermissionChanged
    public void permisChange(Sender sender, MsgGet msgGet, Getter getter){
        sender.sendGroupMsg(QQ_GROUP_MAIN,"【检测到群成员权限变动！】");
    }

    @OnGroupNameChanged
    public void NameChange(Sender sender, Getter getter){
        sender.sendGroupMsg(QQ_GROUP_MAIN,"【检测到群名称变动！】");
    }

    @OnGroupMemberRemarkChanged
    public void RemarkChanged(Sender sender, MsgGet msgGet, Getter getter){
        sender.sendGroupMsg(QQ_GROUP_MAIN,"【检测到群成员群名片变动！】");
    }

    @OnGroupMemberSpecialChanged
    public void SpecialChanged(Sender sender, MsgGet msgGet, Getter getter){
        sender.sendGroupMsg(QQ_GROUP_MAIN,"【检测到群成员头衔变动！】");
    }

    public void sendGD() {
        Bot defaultBot = manager.getDefaultBot();
        BotSender sender = defaultBot.getSender();
        System.out.println("所有机器人："+manager.getBots());
        sender.SENDER.sendGroupMsg( QQ_GROUP_MAIN, "定时消息测试" );
        sender.SENDER.sendGroupNotice(QQ_GROUP_MAIN,"定时任务：发布公告",
                "定时任务公告测试定时任务公告测试定时任务公告测试定时任务公告测试定时任务公告测试定时任务公告测试定时任务公告测试定时任务公告测试",true,true,false,true);

    }

    @Scheduled(cron = "0 09/5 * * * ?")
    public void send15() {
        sendGD();
       // send15();
        System.out.println("发送成功"+new Date());
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
    }
}
