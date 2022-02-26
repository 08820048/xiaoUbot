package simbot.xiaoU.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import simbot.xiaoU.entity.Answer;

import java.util.List;

/**
 * @author: Tisox
 * @date: 2021/12/31 15:51
 * @description:
 * @blog:www.waer.ltd
 */
@Repository
@Mapper
public interface AnswerDao {
    List<Answer> getAnswerList(int code);
}
