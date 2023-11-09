
package xyz.zrxjuly.controller;


import xyz.zrxjuly.beans.HttpResponseEntity;
import xyz.zrxjuly.dao.entity.VolunteerEntity;
import xyz.zrxjuly.service.VolunteerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admin")
public class VolunteerController {

    private final Logger logger = LoggerFactory.getLogger(VolunteerController.class);

    @Autowired
    private VolunteerService volunteerService;


    @RequestMapping(value = "/queryVolunteerList",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryVolunteerList(@RequestBody(required = false) VolunteerEntity volunteerEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode("666");
        List<Map<String, Object>> resultList = volunteerService.queryVolunteerList(volunteerEntity);
        httpResponseEntity.setData(resultList);
        httpResponseEntity.setMessage("查询成功");
        return httpResponseEntity;
    }


/**
     * 根据用户名删除志愿者
     * @param volunteerEntity
     * @return
     */

    @RequestMapping(value = "/deleteVolunteerByAccount",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity deleteVolunteerByAccount(@RequestBody VolunteerEntity volunteerEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try {
            int result = volunteerService.deleteVolunteerByAccount(volunteerEntity);
            if(result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

/**
     * 添加志愿者
     * @param volunteerEntity
     * @return
     */

    @RequestMapping(value = "/addVolunteerInfo",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity addVolunteerInfo(@RequestBody VolunteerEntity volunteerEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        boolean flag = volunteerService.queryVolunteerEntityIsExit(volunteerEntity);
        if(flag) {
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("该用户已存在");
        }
        else {
            volunteerService.addVolunteerInfo(volunteerEntity);
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("创建成功");
        }
        return httpResponseEntity;
    }


/**
     * 根据志愿者用户名修改志愿者信息
     * @param volunteerEntity
     * @return
     */

    @RequestMapping(value = "/modifyVolunteerInfo",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity modifyVolunteerInfo(@RequestBody VolunteerEntity volunteerEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        VolunteerEntity searchProject = volunteerService.queryVolunteerEntity(volunteerEntity);
        if(searchProject == null) {
            volunteerService.updateVolunteerByAccount(volunteerEntity);
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("修改成功");
        }
        else if(searchProject.getVolunteer_account().equals(volunteerEntity.getVolunteer_account())) {
            volunteerService.updateVolunteerByAccount(volunteerEntity);
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("修改成功");
        }
        else {
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("1");
        }
        return httpResponseEntity;
    }
}
