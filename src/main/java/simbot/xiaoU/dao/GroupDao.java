package simbot.xiaoU.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import simbot.xiaoU.entity.Group;

import java.util.List;

/**
 * @author: Tisox
 * @date: 2021/12/30 22:24
 * @description:
 * @blog:www.waer.ltd
 */
@Mapper
@Repository
public interface GroupDao {
    List<Group> selectAll();
}
