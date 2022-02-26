package simbot.xiaoU.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbot.xiaoU.dao.AnswerDao;
import simbot.xiaoU.entity.Answer;
import simbot.xiaoU.entity.Problems;
import simbot.xiaoU.service.AnswerService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Tisox
 * @date: 2021/12/31 16:18
 * @description:
 * @blog:www.waer.ltd
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    @Autowired
    private AnswerDao answerDao;

    @Override
    public List<String> getAnswers(int code) {
        List<Answer> answerList = answerDao.getAnswerList(code);
        List<String> answers = new ArrayList<>();
        for (Answer ans : answerList) {
            System.out.println("服务层答案：："+ans.getAnswer());
            answers.add("【答案指令】:"
                    +code+"\n【题目标题】:"+ans.getTitle()
                    +"\n【获取时间】:"+dateFormat.format(new Date())
                    +"\n|-----start-----|"
                    +"\n"+ans.getAnswer()
                    +"\n|-----end-----|"
                    +"\n【小U哔哔】:请在思索片刻后再考虑看答案哦"
                    +"\n^-^刷题愉快^-^"
                    +"\n");

        }
        return answers;
    }
}
