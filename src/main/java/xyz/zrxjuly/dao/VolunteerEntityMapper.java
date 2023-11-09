package xyz.zrxjuly.dao;

import xyz.zrxjuly.dao.entity.VolunteerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VolunteerEntityMapper {

    int insert(VolunteerEntity record);
    int insertSelective(VolunteerEntity record);
    int updateByPrimaryKeySelective(VolunteerEntity record);
    int deleteVolunteerByAccount(String volunteer_account);
    List<Map<String,Object>> queryVolunteerList(VolunteerEntity volunteerEntity);

    List<Map<String,Object>> queryAllVolunteerName();
    VolunteerEntity queryVolunteerEntity(VolunteerEntity volunteerEntity);
    int updateVolunteerByAccount(VolunteerEntity volunteerEntity);
    String queryVolunteerName(String volunteer_account);

}