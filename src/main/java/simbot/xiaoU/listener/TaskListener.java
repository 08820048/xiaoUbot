//package simbot.xiaoU.listener;
//
//import love.forte.simbot.api.sender.BotSender;
//import love.forte.simbot.bot.Bot;
//import love.forte.simbot.bot.BotManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import simbot.xiaoU.utils.BotConstant;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @author: Tisox
// * @date: 2021/12/31 14:02
// * @description: 处理定时业务
// * @blog:www.waer.ltd
// */
//@Component
//@Configuration
//@EnableScheduling
//@Deprecated
//public class TaskListener implements BotConstant {
//    @Autowired
//    private BotManager manager;
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//
// public void hello() {
//     Bot defaultBot = manager.getDefaultBot();
//     BotSender sender = defaultBot.getSender();
//     String format = dateFormat.format(new Date());
//     if("07:50:00".equals(format)){
//         sender.SENDER.sendGroupMsg(QQ_GROUP_MAIN, "天亮了，美妙的一天又开端了，起床吧，呼吸清爽，拥抱阳光；浅笑吧，高兴心境，高兴一天。早上好，愿各位有个好意情！");
//     }
//     if("12:00:00".equals(format)){
//         sender.SENDER.sendGroupMsg(QQ_GROUP_MAIN, "中午好！睡个午觉棒棒哒！");
//     }
//     if("10:30:00".equals(format)){
//         sender.SENDER.sendGroupMsg(QQ_GROUP_MAIN, "如果明天再也不能见面,那么提前祝各位早安！午安！晚安！");
//     }
//
//    }
//
//    /**
//     * 执行定时任务
//     */
//    @Scheduled(cron = "0 0 0 1/1 * ? ")
//    public void send15() {
//        //sendGD();
//        hello();
//        System.out.println("发送成功"+new Date());
//        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
//    }
//}
