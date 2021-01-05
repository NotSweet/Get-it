package cn.hevttc.service.controller;

import cn.hevttc.service.bean.CampusName;
import cn.hevttc.service.bean.User;
import cn.hevttc.service.dao.TokenDao;
import cn.hevttc.service.dao.TokenImp;
import cn.hevttc.service.dao.UserDao;
import cn.hevttc.service.dao.UserImp;
import cn.hevttc.service.response.JsonResponse;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * user
 */
@Path
public class Users {
    @PostRoute("user")
    public void register(Response response, @BodyParam User user){
        System.out.println(user.getUser_name());
        UserDao userDao=new UserImp();
        userDao.insertUser(user);
        if("".equals(user.getUser_name()))
            user.setUser_name(null);
        else
            user.setPhone_number(null);
        TokenDao tokenDao = new TokenImp();
        int id = userDao.userId(user);
        String token = ""+id+tokenDao.newToken(id);
        response.text(new JsonResponse().outPutSuccess(token).toJSONString());
    }
    @PutRoute("user/:id")
    public void alterPassword(Response response, @BodyParam User user){
        UserDao userDao=new UserImp();
        userDao.alterPassword(user);
        response.text(new JsonResponse().outPutSuccess().toJSONString());
    }

    @GetRoute("user/:id")
    public void getUser(Response response, @PathParam int id){
        UserDao userDao=new UserImp();
        userDao.selectUser(id);
        response.text(new JsonResponse().outPutSuccess().toJSONString());
    }
    @GetRoute("user")
    public void login(Response response, @Param String username,@Param String password){
        Pattern pattern = Pattern.compile("[1][0-9]{10}");
        Matcher matcher = pattern.matcher(username);
        User user = new User();
        if (matcher.matches()) {//phone
            user.setPhone_number(username);
            user.setPassword(password);
        } else {//username
            user.setUser_name(username);
            user.setPassword(password);
        }
        UserDao userDao=new UserImp();
        if(userDao.login(user)) {
            TokenDao tokenDao = new TokenImp();
            int id = userDao.userId(user);
            String token = ""+id+tokenDao.newToken(id);
            response.text(new JsonResponse().outPutSuccess(token).toJSONString());
        }else {
            response.text(new JsonResponse().outPutError("0003","username or password error").toJSONString());
        }
    }

}
