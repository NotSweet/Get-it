package cn.hevttc.service.controller;

import cn.hevttc.service.bean.Task;
import cn.hevttc.service.bean.User;
import cn.hevttc.service.dao.*;
import cn.hevttc.service.response.JsonResponse;
import com.blade.mvc.annotation.BodyParam;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import jnr.ffi.annotations.In;

import java.util.HashMap;
import java.util.Map;

@Path
public class Tasks {
    @PostRoute("task")
    public void postTask(Request request,Response response, @BodyParam Task task){
        System.out.println(task.getTask_title());
        TokenDao tokenDao = new TokenImp();
        String token=request.header("Authentication");
        if(token.length()>40) {
            String user_id = tokenDao.tokenAuth(token);
            if (!user_id.equals("Error")) {
                UserDao userDao = new UserImp();
                User user = userDao.selectUser(Integer.parseInt(user_id));
                TaskDao taskDao = new TaskImp();
                String code = taskDao.insertTask(user, task);
                if (code.equals("0011"))
                    response.text(new JsonResponse().outPutError("0011", "score less").toJSONString());
                else {
                    response.text(new JsonResponse().outPutSuccess().toJSONString());
                }
            } else {
                response.text(new JsonResponse().outPutError("0021", "authError").toJSONString());
            }
        }else {
                response.text(new JsonResponse().outPutError("0021","authError").toJSONString());
        }
    }
    @GetRoute("task")
    public void selectTask(Request request,Response response){
        TokenDao tokenDao = new TokenImp();
        String token=request.header("Authentication");
        if(token.length()>40) {
            String user_id = tokenDao.tokenAuth(token);
            if (!user_id.equals("Error")) {
                UserDao userDao = new UserImp();
                User user = userDao.selectUser(Integer.parseInt(user_id));
                TaskDao taskDao = new TaskImp();
                String json = taskDao.selectTasks(user.getSch_no());
                response.text(json);

            } else {
                response.text(new JsonResponse().outPutError("0021", "authError").toJSONString());
            }
        }else {
            response.text(new JsonResponse().outPutError("0021", "authError").toJSONString());
        }
    }
    @GetRoute("task/:admin_id")
    public void allTask(Request request,Response response){
        TaskDao taskDao = new TaskImp();
        response.text(taskDao.allTasks(2));
    }

}
