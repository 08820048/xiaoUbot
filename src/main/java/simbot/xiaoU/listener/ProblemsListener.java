package simbot.xiaoU.listener;

import com.google.gson.Gson;
import love.forte.simbot.annotation.Filter;
import love.forte.simbot.annotation.FilterValue;
import love.forte.simbot.annotation.OnGroup;
import love.forte.simbot.api.message.MessageContent;
import love.forte.simbot.api.message.MessageContentBuilder;
import love.forte.simbot.api.message.MessageContentBuilderFactory;
import love.forte.simbot.api.message.containers.GroupInfo;
import love.forte.simbot.api.message.containers.PermissionContainer;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.message.events.MsgGet;
import love.forte.simbot.api.sender.Getter;
import love.forte.simbot.api.sender.Sender;
import love.forte.simbot.filter.MatchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simbot.xiaoU.service.AnswerService;
import simbot.xiaoU.service.GroupService;
import simbot.xiaoU.service.ProblemsDaoService;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @author: Tisox
 * @date: 2021/12/31 14:05
 * @description: 处理核心业务：发题功能
 * @blog:www.waer.ltd
 */

@Component
public class ProblemsListener {
    @Autowired
    private GroupService groupService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private ProblemsDaoService problemsDaoService;
    @Autowired
    private MessageContentBuilderFactory messageContentBuilderFactory;

    private static final String SpAdmin = "帅比群主";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @OnGroup
    @Filter(value = "刷题",matchType = MatchType.EQUALS)
    @Filter(value = "菜单",matchType = MatchType.EQUALS)
    public void menu(Sender sender, MsgGet msgGet, Getter getter, GroupMsg groupMsg,
                     PermissionContainer permissionContainer){
        GroupInfo groupInfo = groupMsg.getGroupInfo();
        /*群号*/
        String groupCode = groupInfo.getGroupCode();
        MessageContentBuilder msgBuilder = messageContentBuilderFactory.getMessageContentBuilder();
        MessageContent up = msgBuilder.image("https://images.waer.ltd/img/menu.png").build();
        sender.sendGroupMsg(groupCode,"@"+msgGet.getAccountInfo().getAccountCode()+"欢迎使用发题功能:)请按照如下说明进行操作【请勿频繁操作】");
        sender.sendGroupMsg(groupCode,"|>题目请求格式：【qn】其中q为前缀n(1<=n<=1000)为题号(如：q153)<|");
        sender.sendGroupMsg(groupCode,up);
    }


    /**
     * 发题功能
     * @param sender senders
     * @param msgGet MsgGet
     * @param getter get
     * @param q 题目指令
     */
    @OnGroup
    @Filter(value = "q{{q,[1-9]([0-9]*)}}",matchType = MatchType.REGEX_MATCHES)
    public void pushQuestion(Sender sender, MsgGet msgGet, Getter getter, GroupMsg groupMsg,
                             PermissionContainer permissionContainer, @FilterValue("q") int q){
        System.out.println("题目编号："+q);
        GroupInfo groupInfo = groupMsg.getGroupInfo();
        boolean admin = permissionContainer.getPermission().isAdmin();
        System.out.println("permissionContainer"+permissionContainer.getPermission());
        List<String> problems = problemsDaoService.selectProblems(q);
        long accountCodeNumber = msgGet.getAccountInfo().getAccountCodeNumber();
        sender.sendGroupMsg(groupInfo.getGroupCode(), "@"+accountCodeNumber+"("+msgGet.getAccountInfo().getAccountNickname()+")"+
                "题目正在来的路上....不如去给"+SpAdmin+"点个赞先^o^");
        if(!problems.isEmpty()){
            for (String problem : problems) {
                sender.sendGroupMsg(groupInfo.getGroupCode(),problem);
            }
        }else{
            sender.sendGroupMsg(groupInfo.getGroupCode(),"哦豁!)[指令q"+q+"]"+"【题库未收录,请检查发题指令是否正确!】");
        }
    }


    /**
     * 答案发送功能
     * @param sender sender
     * @param msgGet msgGet
     * @param groupMsg GG
     * @param getter get
     * @param a 答案指令
     */
    @OnGroup
    @Filter(value = "a{{a,[1-9]([0-9]*)}}",matchType = MatchType.REGEX_MATCHES)
    public void pushAnswer(Sender sender, MsgGet msgGet,GroupMsg groupMsg, Getter getter,@FilterValue("a") int a){
        System.out.println("答案编号："+a);
        GroupInfo groupInfo = groupMsg.getGroupInfo();
        List<String> ans = answerService.getAnswers(a);

        long accountCodeNumber = msgGet.getAccountInfo().getAccountCodeNumber();
        sender.sendGroupMsg(groupInfo.getGroupCode(), "@"+accountCodeNumber+"("+msgGet.getAccountInfo().getAccountNickname()+")"+
                "答案拉取中....稍安勿躁!!");
        if(!ans.isEmpty()){
            for (String as : ans) {
                sender.sendGroupMsg(groupInfo.getGroupCode(),as);
                System.out.println(as);
            }
        }else{
            sender.sendGroupMsg(groupInfo.getGroupCode(),"哦豁!)[指令a"+a+"]"+"【数据库未收录,请检查发题指令是否正确!】");
        }
    }

    @OnGroup
    @Filter(value = "查看题单",matchType = MatchType.EQUALS)
    public void TitleList(Sender sender, MsgGet msgGet, Getter getter, GroupMsg groupMsg,
                     PermissionContainer permissionContainer) throws IOException {
        GroupInfo groupInfo = groupMsg.getGroupInfo();
        /*群号*/
        String groupCode = groupInfo.getGroupCode();
        MessageContentBuilder msgBuilder = messageContentBuilderFactory.getMessageContentBuilder();
       // MessageContent up = msgBuilder.image("https://images.waer.ltd/img/list.jpg").build();
        //MessageContent up = msgBuilder.image("https://images.waer.ltd/img/list.jpg").build();
     //  sender.sendGroupMsg(groupCode,up);
        sender.sendGroupMsg(groupCode,"@"+msgGet.getAccountInfo().getAccountCode()+"题单获取中.....请稍后。");
        Map<Integer, String> titles = problemsDaoService.getProTitles();
        Gson gson = new Gson();
        String result = gson.toJson(titles);
        System.out.println("result:::"+result);
        sender.sendGroupMsg(groupCode,result);
//        sender.sendGroupMsg(groupInfo.getGroupCode(), (MessageContent) titles);
//        if(!titles.isEmpty()){
//            for (String as : titles) {
//                sender.sendGroupMsg(groupInfo.getGroupCode(),as);
//                System.out.println(as);
//            }
//        }else{
//            sender.sendGroupMsg(groupInfo.getGroupCode(),"哦豁!:)"+"【后台服务异常，请联系群主！】");
//        }
//        String path = "D:\\title.txt";
//        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
//        for (Map.Entry<Integer, String> code : titles.entrySet()) {
//            System.out.println(code.getKey());
//
//           // bw.write(code.getKey());
//            //bw.newLine();
//            bw.write(code.getValue());
//            bw.newLine(); //换行用
//
//           // sender.sendGroupMsg(groupCode,"【编号】"+code.getKey()+"\n【标题】"+code.getValue());
//        }
//        bw.close();
//        System.out.println("写入成功");
//
//        String encoding="UTF-8";
//        File file=new File(path);
//        if(file.isFile() && file.exists()) { //判断文件是否存在
//            InputStreamReader read = new InputStreamReader(
//                    new FileInputStream(file), encoding);//考虑到编码格式
//            BufferedReader bufferedReader = new BufferedReader(read);
//            String lineTxt = null;
//            while ((lineTxt = bufferedReader.readLine()) != null) {
//                System.out.println(lineTxt);
//                //sender.sendGroupMsg(groupCode,"【标题】"+lineTxt);
//            }
//            read.close();
//            System.out.println("读取成功");
//            System.out.println(lineTxt);
//
//        }

        sender.sendGroupMsg(groupCode,"\n^-^【该功能处于测试阶段】请自行格式化数据....^-^");
    }
}
