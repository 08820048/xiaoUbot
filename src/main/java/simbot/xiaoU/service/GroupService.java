package simbot.xiaoU.service;

import org.springframework.stereotype.Service;
import simbot.xiaoU.entity.Group;

import java.util.List;

/**
 * @author: Tisox
 * @date: 2021/12/30 22:25
 * @description:
 * @blog:www.waer.ltd
 */
@Service
public interface GroupService {
    List<Group> selectAll();
}
