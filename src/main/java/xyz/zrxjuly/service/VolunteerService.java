package xyz.zrxjuly.service;

import xyz.zrxjuly.utils.DateUtil;
import xyz.zrxjuly.dao.VolunteerEntityMapper;
import xyz.zrxjuly.dao.entity.VolunteerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class VolunteerService {

    @Autowired
    private VolunteerEntityMapper volunteerEntityMapper;
    /**
     * 添加志愿者
     * @param volunteerEntity
     * @return
     */
    public int addVolunteerInfo(VolunteerEntity volunteerEntity) {
        Date date = DateUtil.getCreateTime();
        volunteerEntity.setVolunteer_creation_date(date);
        volunteerEntity.setVolunteer_identity("Volunteer");
        volunteerEntityMapper.insertSelective(volunteerEntity);
        return 0;
    }
    /**
     * 修改志愿者信息
     * @param volunteerEntity
     * @return
     */

    public int modifyVolunteerInfo(VolunteerEntity volunteerEntity) {
        int result = volunteerEntityMapper.updateByPrimaryKeySelective(volunteerEntity);
        return result;
    }

    /**
     * 删除志愿者
     * @param volunteerEntity
     * @return
     */
    public int deleteVolunteerByAccount(VolunteerEntity volunteerEntity) {
        int count = volunteerEntityMapper.deleteVolunteerByAccount(volunteerEntity.getVolunteer_account());
        return count;
    }

    /**
     * 查询志愿者列表
     * @param volunteerEntity
     * @return
     */
    public List<Map<String, Object>> queryVolunteerList(VolunteerEntity volunteerEntity) {
        List<Map<String, Object>> resultList = volunteerEntityMapper.queryVolunteerList(volunteerEntity);

        return resultList;
    }

    /**
     * 查询全部志愿者的名字接口
     * @return
     */
    public List<Map<String,Object>> queryAllProjectName() {
        return null;
    }

    /**
     * 根据志愿者用户名精准查询是否存在
     * @author Youcf
     */
    public boolean queryVolunteerEntityIsExit(VolunteerEntity volunteerEntity) {
        VolunteerEntity volunteerEntity2 = volunteerEntityMapper.queryVolunteerEntity(volunteerEntity);
        if(volunteerEntity2==null) {
            return false;
        }
        else {
            return true;
        }
    }
    /**
     * 根据用户名查询志愿者
     * @author Youcf
     */
    public VolunteerEntity queryVolunteerEntity(VolunteerEntity volunteerEntity) {
        return volunteerEntityMapper.queryVolunteerEntity(volunteerEntity);
    }

    /**
     * 根据志愿者用户名修改志愿者信息
     * @author Youcf
     */
    public int updateVolunteerByAccount(VolunteerEntity volunteerEntity) {
        int count = volunteerEntityMapper.updateVolunteerByAccount(volunteerEntity);
        return count;
    }

}
