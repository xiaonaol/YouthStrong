package xyz.zrxjuly.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.zrxjuly.dao.ITaskDao;
import xyz.zrxjuly.pojo.Book;
import xyz.zrxjuly.pojo.InteractTask;
import xyz.zrxjuly.pojo.LearningTask;
import xyz.zrxjuly.pojo.User;
import xyz.zrxjuly.utils.UUIDUtil;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller("taskController")
@RequestMapping("/admin")
public class TaskController {
    @Resource
    private ITaskDao taskService;
    @RequestMapping("learningTaskList")
    public String learningTaskList(Model model) {
        List<LearningTask> learningTaskList = taskService.getAllLearningTask();
        model.addAttribute("learningTaskList", learningTaskList);
        return "admin/learningTask_list";
    }
    @RequestMapping("interactTaskList")
    public String interactTaskList(Model model) {
        List<InteractTask> interactTaskList = taskService.getAllInteractTask();
        model.addAttribute("interactTaskList", interactTaskList);
        return "admin/interactTask_list";
    }
    @RequestMapping("toAdminEditLearningTask")
    public String toAdminEditLearningTask(String id, Model model) {
        LearningTask learningTask = taskService.adminGetLearningTaskById(id);
        model.addAttribute("learningTask", learningTask);
        return "admin/edit_learningTask";
    }
    @RequestMapping("toAdminEditInteractTask")
    public String toAdminEditInteractTask(String id, Model model) {
        InteractTask interactTask = taskService.adminGetInteractTaskById(id);
        model.addAttribute("interactTask", interactTask);
        return "admin/edit_interactTask";
    }

    @RequestMapping("adminEditLearningTaskInfo")
    @ResponseBody
    public JSONObject adminEditLearningTaskInfo(LearningTask learningTask) {
        JSONObject json = new JSONObject();
        if (learningTask != null) {
            taskService.editLearningTaskInfo(learningTask);
            json.put("msg", "success");
        } else {
            json.put("msg", "error");
        }
        return json;
    }

    @RequestMapping("adminEditInteractTaskInfo")
    @ResponseBody
    public JSONObject adminEditInteractTaskInfo(InteractTask interactTask) {
        JSONObject json = new JSONObject();
        System.out.println(interactTask);
        if (interactTask != null) {
            taskService.editInteractTaskInfo(interactTask);
            json.put("msg", "success");
        } else {
            json.put("msg", "error");
        }
        return json;
    }

    @RequestMapping("adminDelLearningTaskById")
    @ResponseBody
    public JSONObject adminDelLearningTaskById(String id, HttpSession session) {
        JSONObject json = new JSONObject();
        int delUser = taskService.adminDelLearningTaskById(id);
        if (delUser > 0) {
            json.put("msg", "success");
        } else {
            json.put("msg", "error");
        }
        return json;
    }

    @RequestMapping("adminDelInteractTaskById")
    @ResponseBody
    public JSONObject adminDelInteractTaskById(String id, HttpSession session) {
        JSONObject json = new JSONObject();
        int delUser = taskService.adminDelInteractTaskById(id);
        if (delUser > 0) {
            json.put("msg", "success");
        } else {
            json.put("msg", "error");
        }
        return json;
    }

    @RequestMapping("toAdminCreateLearningTask")
    public String toAdminCreateLearningTask(Model model) {
        LearningTask learningTask = new LearningTask();
        learningTask.setId(UUIDUtil.getOneUUID());
        model.addAttribute("learningTask", learningTask);
        return "admin/createLearningTask";
    }

    @RequestMapping("toAdminCreateInteractTask")
    public String toAdminCreateInteractTask(Model model) {
        InteractTask interactTask = new InteractTask();
        interactTask.setId(UUIDUtil.getOneUUID());
        model.addAttribute("interactTask", interactTask);
        return "admin/createInteractTask";
    }

    @RequestMapping("createLearningTask")
    @ResponseBody
    public JSONObject createLearningTask(LearningTask learningTask) {
        JSONObject json = new JSONObject();
        System.out.println(learningTask);
        if(taskService.createLearningTask(learningTask)) {
            json.put("msg", "success");
        } else {
            json.put("msg", "fail");
        }
        return json;
    }

    @RequestMapping("CreateInteractTask")
    @ResponseBody
    public JSONObject CreateInteractTask(InteractTask interactTask) {
        JSONObject json = new JSONObject();
        System.out.println(interactTask);
        if(taskService.createInteractTask(interactTask)) {
            json.put("msg", "success");
        } else {
            json.put("msg", "fail");
        }
        return json;
    }

    @RequestMapping("findLearningTask")
    public void findLearningTask(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String key=request.getParameter("key");
        List<LearningTask> learningTaskList = taskService.findLearningTask(key);
        request.setAttribute("learningTaskList", learningTaskList);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/learningTask_list.jsp").forward(request, response);
    }

    @RequestMapping("findInteractTask")
    public void findInteractTask(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String key=request.getParameter("key");
        List<InteractTask> interactTaskList = taskService.findInteractTask(key);
        request.setAttribute("interactTaskList", interactTaskList);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/interactTask_list.jsp").forward(request, response);
    }
}
