package xyz.zrxjuly.service.impl;

import org.springframework.stereotype.Service;
import xyz.zrxjuly.dao.IBookDao;
import xyz.zrxjuly.dao.IChildrenDao;
import xyz.zrxjuly.pojo.Book;
import xyz.zrxjuly.pojo.Children;
import xyz.zrxjuly.service.IChildrenService;

import javax.annotation.Resource;
import java.util.List;

@Service("childrenService")
public class ChildrenServiceImpl implements IChildrenService {
    @Resource
    private IChildrenDao childrenDao;

    @Override
    public List<Children> adminGetChildren() {
        return childrenDao.adminGetChildren();
    }
}
