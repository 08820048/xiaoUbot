package simbot.xiaoU.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import simbot.xiaoU.entity.Problems;

import java.util.List;

/**
 * @author: Tisox
 * @date: 2021/12/30 23:53
 * @description:
 * @blog:www.waer.ltd
 */
@Mapper
@Repository
public interface ProblemsDao {
    List<Problems> selectProblems(int id);

    List<Problems> selectProtitles();
}
