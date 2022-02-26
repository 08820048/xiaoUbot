package simbot.xiaoU.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbot.xiaoU.dao.ProblemsDao;
import simbot.xiaoU.entity.Problems;
import simbot.xiaoU.service.ProblemsDaoService;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: Tisox
 * @date: 2021/12/30 23:53
 * @description:
 * @blog:www.waer.ltd
 */

@Service
public class ProblemsDaoServiceImpl implements ProblemsDaoService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
@Autowired
private ProblemsDao problemsDao;
    @Override
    public List<String> selectProblems(int code) {
        List<Problems> problems = problemsDao.selectProblems(code);
        List<String> contents = new ArrayList<>();
        for (Problems problem : problems) {
            contents.add("【题目指令】:q"
                    +code+"\n【题目标题】:"+problem.getTitle()
                    +"\n【发题时间】:"+dateFormat.format(new Date())
                    +"\n【来源/作者】:"+problem.getFrom()
                    +"\n-----start-----"
                    +"\n"+problem.getContent()
                    +"\n-----end-----"
                    +"\n【答案指令】:"+"a"+code
                    +"\n^-^刷题愉快^-^"
                    +"\n");
        }
        return contents;
    }

    /**
     * 题目标题列表获取
     * @return string
     */
    @Override
    public Map<Integer,String> getProTitles() {
        List<Problems> Titlelist = problemsDao.selectProtitles();
        List<String> title = new ArrayList<>();
        Map<Integer,String> tit = new HashMap<>();

        for (Problems s : Titlelist) {
            tit.put(s.getCode(),s.getTitle());

//            title.add("【当前题库题目列表】:"
//                    +"\n【编号】:"+s.getCode()
//                    +"\n【标题】:"+s.getTitle()
//                    +"\n^-^题目很少？更多题目正在陆续增加中....^-^"
//                    +"\n");
        }
        return  tit;
    }
}
