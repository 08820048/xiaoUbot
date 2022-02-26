package simbot.xiaoU.service;

import simbot.xiaoU.entity.Problems;

import java.util.List;
import java.util.Map;

/**
 * @author: Tisox
 * @date: 2021/12/30 23:53
 * @description:
 * @blog:www.waer.ltd
 */
public interface ProblemsDaoService {
List<String> selectProblems(int code);

    Map<Integer,String> getProTitles();
}
