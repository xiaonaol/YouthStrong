package xyz.zrxjuly.dao;

import org.springframework.stereotype.Component;
import xyz.zrxjuly.pojo.InteractTask;
import xyz.zrxjuly.pojo.LearningTask;

import java.util.List;

@Component
public interface ITaskDao {
    List<LearningTask> getAllLearningTask();

    List<InteractTask> getAllInteractTask();

    LearningTask adminGetLearningTaskById(String id);

    InteractTask adminGetInteractTaskById(String id);

    void editLearningTaskInfo(LearningTask learningTask);

    void editInteractTaskInfo(InteractTask interactTask);

    int adminDelLearningTaskById(String id);

    int adminDelInteractTaskById(String id);

    boolean createLearningTask(LearningTask learningTask);

    boolean createInteractTask(InteractTask interactTask);

    List<LearningTask> findLearningTask(String key);

    List<InteractTask> findInteractTask(String key);
}
