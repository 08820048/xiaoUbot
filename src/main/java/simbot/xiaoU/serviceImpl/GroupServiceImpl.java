package simbot.xiaoU.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbot.xiaoU.dao.GroupDao;
import simbot.xiaoU.entity.Group;
import simbot.xiaoU.service.GroupService;

import java.util.List;

/**
 * @author: Tisox
 * @date: 2021/12/30 22:26
 * @description:
 * @blog:www.waer.ltd
 */
@Service
public class GroupServiceImpl implements GroupService {
@Autowired
private GroupDao grouDao;
    @Override
    public List<Group> selectAll() {
        List<Group> groups = grouDao.selectAll();
        for (Group group : groups) {
            System.out.println("service::>"+group.getId()+group.getNumber()+group.getAuthorization());
        }
        return grouDao.selectAll();
    }
}
