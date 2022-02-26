package simbot.xiaoU.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import simbot.xiaoU.entity.Task;

import java.util.List;

/**
 * @author: Tisox
 * @date: 2021/12/31 17:09
 * @description:
 * @blog:www.waer.ltd
 */
@Mapper
@Repository
public interface TaskDao {
    List<Task> getTasks();
}
