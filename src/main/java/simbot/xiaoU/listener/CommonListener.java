package simbot.xiaoU.listener;

import love.forte.common.ioc.annotation.Depend;
import love.forte.simbot.annotation.*;
import love.forte.simbot.api.message.MessageContent;
import love.forte.simbot.api.message.MessageContentBuilder;
import love.forte.simbot.api.message.MessageContentBuilderFactory;
import love.forte.simbot.api.message.containers.GroupInfo;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.message.events.MsgGet;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.Getter;
import love.forte.simbot.api.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Tisox
 * @date: 2021/12/31 14:03
 * @description: 处理群信息和成员相关业务
 * @blog:www.waer.ltd
 */
@Component
public class CommonListener {
    @Autowired
    @Depend
    private MessageContentBuilderFactory messageContentBuilderFactory;


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
//            sender.sendPrivateMsg(privateMsg, msgContent+"啊！"+msgGet.getAccountInfo().getAccountRemark()+
//                    ",我主人说不能和陌生人撩天!");
        // 向 privateMsg 的账号发送消息，消息为当前接收到的消息。
        sender.sendPrivateMsg(privateMsg, msgContent);
    }

    @OnGroup
    @Filter(atBot = true)
    public void GroupMsg1(Sender sender, MsgGet msgGet, Getter getter){
//        GroupInfo groupInfo = groupMsg.getGroupInfo();
        /*群号*/
//        String groupCode = groupInfo.getGroupCode();
        sender.sendGroupMsg(541130313,"@"+msgGet.getAccountInfo().getAccountCode()+"爱你呦！！");
    }


    @OnGroupMemberIncrease
    public void increase(Sender sender, MsgGet msgGet, Getter getter){
//        GroupInfo groupInfo = groupMsg.getGroupInfo();
//        /*群号*/
//        String groupCode = groupInfo.getGroupCode();
        MessageContentBuilder msgBuilder = messageContentBuilderFactory.getMessageContentBuilder();
        MessageContent up = msgBuilder.image("https://images.waer.ltd/img/up.jpg").build();
        sender.sendGroupMsg(541130313,up);
    }

    @OnGroupReduce
    public void reduce(Sender sender, MsgGet msgGet, Getter getter){
//        GroupInfo groupInfo = groupMsg.getGroupInfo();
//        /*群号*/
//        String groupCode = groupInfo.getGroupCode();
        sender.sendGroupMsg(541130313,"【检测到有人退群】");
    }

    @OnGroupAddRequest
    public void addRequest(Sender sender, MsgGet msgGet, Getter getter){
//        GroupInfo groupInfo = groupMsg.getGroupInfo();
//        /*群号*/
//        String groupCode = groupInfo.getGroupCode();
        sender.sendGroupMsg(541130313,"【检测到入群申请,请处理。】");
    }
//
//    @OnGroupMsgRecall
//    public void recall(Sender sender, MsgGet msgGet,  Getter getter){
////        GroupInfo groupInfo = groupMsg.getGroupInfo();
////        /*群号*/
////        String groupCode = groupInfo.getGroupCode();
//        sender.sendGroupMsg(541130313,"【检测到有消息撤回行为,已记录！】");
//    }


    @OnGroupMemberPermissionChanged
    public void permisChange(Sender sender, MsgGet msgGet, Getter getter){
//        GroupInfo groupInfo = groupMsg.getGroupInfo();
//        /*群号*/
//        String groupCode = groupInfo.getGroupCode();
        sender.sendGroupMsg(541130313,"【检测到群成员权限变动！】");
    }

    @OnGroupNameChanged
    public void NameChange(Sender sender, Getter getter){
//        GroupInfo groupInfo = groupMsg.getGroupInfo();
//        /*群号*/
//        String groupCode = groupInfo.getGroupCode();
        sender.sendGroupMsg(541130313,"【检测到群名称变动！】");
    }

    @OnGroupMemberRemarkChanged
    public void RemarkChanged(Sender sender, MsgGet msgGet, Getter getter){
//        GroupInfo groupInfo = groupMsg.getGroupInfo();
//        /*群号*/
//        String groupCode = groupInfo.getGroupCode();
        sender.sendGroupMsg(541130313,"【检测到群成员群名片变动！】");
    }

    @OnGroupMemberSpecialChanged
    public void SpecialChanged(Sender sender, MsgGet msgGet, Getter getter){
//        GroupInfo groupInfo = groupMsg.getGroupInfo();
//        /*群号*/
//        String groupCode = groupInfo.getGroupCode();
        sender.sendGroupMsg(541130313,"【检测到群成员头衔变动！】");
    }
}
