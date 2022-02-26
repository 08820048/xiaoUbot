//package simbot.xiaoU.listener;
//import love.forte.simbot.annotation.*;
//import love.forte.simbot.api.message.MessageContent;
//import love.forte.simbot.api.message.events.MsgGet;
//import love.forte.simbot.api.message.events.PrivateMsg;
//import love.forte.simbot.api.sender.BotSender;
//import love.forte.simbot.api.sender.Getter;
//import love.forte.simbot.api.sender.MsgSender;
//import love.forte.simbot.api.sender.Sender;
//import love.forte.simbot.bot.Bot;
//import love.forte.simbot.bot.BotManager;
//import love.forte.simbot.filter.MatchType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import simbot.xiaoU.entity.Group;
//import simbot.xiaoU.service.GroupService;
//import simbot.xiaoU.service.ProblemsDaoService;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//
///**
// * @author: Tisox
// * @date: 2021/12/29 20:33
// * @description:
// * @blog:tisox.waer.ltd
// */
//@Component
//@Configuration
//@EnableScheduling
//public class Listener {
//    @Autowired
//    private BotManager manager;
//    @Autowired
//    private GroupService groupService;
//    @Autowired
//    private ProblemsDaoService problemsDaoService;
//
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//
//
//    /**
//     * 让默认的bot给一个账号发送消息。
//     */
//    public void sendByDefault() {
//        // 一般如果你只注册了一个bot，那么可以直接使用此方法。
//        Bot defaultBot = manager.getDefaultBot();
//        BotSender sender = defaultBot.getSender();
//
//    }
//
//
//    @OnGroup
//    @Filter(value = "q{{q,[1-9]([0-9]*)}}",matchType = MatchType.REGEX_MATCHES)
//    public void selectGroup(Sender sender, MsgGet msgGet, Getter getter,@FilterValue("q") int q){
//        System.out.println("题目编号："+q);
//        List<String> problems = problemsDaoService.selectProblems(q);
//        long accountCodeNumber = msgGet.getAccountInfo().getAccountCodeNumber();
//        sender.sendGroupMsg("657212221", "@"+accountCodeNumber+"("+msgGet.getAccountInfo().getAccountNickname()+")"+
//                "题目正在来的路上....稍安勿躁!!");
//        if(!problems.isEmpty()){
//            for (String problem : problems) {
//              sender.sendGroupMsg("657212221",problem);
//            }
//        }else{
//            sender.sendGroupMsg("657212221","哦豁!)[指令q"+q+"]"+"【题库未收录,请检查发题指令是否正确!】");
//        }
//    }
//
//    public void sendGD() {
//        Bot defaultBot = manager.getDefaultBot();
//        BotSender sender = defaultBot.getSender();
//        System.out.println("所有机器人："+manager.getBots());
//        sender.SENDER.sendGroupMsg( "657212221", "定时消息测试" );
//        //sender.SENDER.sendPrivateMsg("2217021563", "你好！我是" + defaultBot.getBotInfo().getBotName());
//        //sender.SENDER.sendGroupMsg("657212221", "执行定时任务:发布群公告!!");
//        sender.SENDER.sendGroupNotice("657212221","定时任务：发布公告",
//                "定时任务公告测试定时任务公告测试定时任务公告测试定时任务公告测试定时任务公告测试定时任务公告测试定时任务公告测试定时任务公告测试",true,true,false,true);
//
//    }
//
//    @Scheduled(cron = "0 09/5 * * * ?")
//    public void send15() {
//        sendGD();
//        System.out.println("发送成功"+new Date());
//        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
//    }
//}
