package cn.hevttc.service.controller;

/**
 * check class
 * have is register phone name ...
 */

import cn.hevttc.service.authentication.HttpRequest;
import cn.hevttc.service.bean.CampusName;
import cn.hevttc.service.dao.UserDao;
import cn.hevttc.service.dao.UserImp;
import cn.hevttc.service.response.JsonResponse;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Response;

@Path
public class Checks {
    @GetRoute("name/:name")
    public void checkName(Response response, @PathParam String name ) {
        UserDao userDao=new UserImp();
        //System.out.println(userDao.hasName(name));
        if(userDao.hasName(name))
            response.text(new JsonResponse().outPutSuccess().toJSONString());
        else
            response.text(new JsonResponse().outPutError("0001","UserName is used").toJSONString());
    }
    @GetRoute("phone/:phone")
    public void checkPhone(Response response, @PathParam String phone) {
        System.out.println("phone"+phone);
        UserDao userDao=new UserImp();
        //System.out.println(userDao.hasPhone(phone));
        if(userDao.hasPhone(phone))
            response.text(new JsonResponse().outPutSuccess().toJSONString());
        else
            response.text(new JsonResponse().outPutError("0001","PhoneNumber is used").toJSONString());
    }
    @PostRoute("name")
    public void userAuthen(Response response, @Param String username,@Param String password) {
        String result = new HttpRequest().authen(username,password);

        if(result.equals("302"))
            response.text(new JsonResponse().outPutSuccess().toJSONString());
        else
            response.text(new JsonResponse().outPutError("0002","login error").toJSONString());
    }
}
