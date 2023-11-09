package xyz.zrxjuly.dao;

import xyz.zrxjuly.pojo.Children;

import java.util.List;

public interface IChildrenDao {
    /**获得所有可分配物资孩子的信息**/
    List<Children> adminGetChildren();
}
