package cn.hevttc.service.controller;

import cn.hevttc.service.bean.Admin;
import cn.hevttc.service.dao.AdminDao;
import cn.hevttc.service.dao.AdminImp;
import cn.hevttc.service.dao.TokenDao;
import cn.hevttc.service.dao.TokenImp;
import cn.hevttc.service.response.JsonResponse;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.http.Response;

@Path
public class Admins {
    @GetRoute("login")
    public String login() {
        return "login.html";
    }
    @GetRoute("register")
    public String register() {
        return "register.html";
    }
    @GetRoute("test")
    public String test() {
        return "test.html";
    }
    @PostRoute("register")
    public void postRegister()
    {
//        Admin admin = new Admin();
//        admin.setAdmin_id(1);
//        admin.setName("admin");
//        admin.setPassword("admin");
//        admin.setPower(1);
//        AdminDao adminDao = new AdminImp();
//        adminDao.insertAdmins(admin);
    }

    @GetRoute("admin")
    public String login(Response response, @Param String username, @Param String password){

        Admin admin = new Admin();
        admin.setName(username);
        admin.setPassword(password);
        AdminDao adminDao=new AdminImp();
        if(adminDao.login(admin)) {
            TokenDao tokenDao = new TokenImp();
            int id = adminDao.adminId(admin);
            String token = ""+id+tokenDao.newToken(id);
            //response.text(new JsonResponse().outPutSuccess(token).toJSONString());
            return "main.html";
        }else {
            //response.text(new JsonResponse().outPutError("0003","name or password error").toJSONString());
            return "error.html";
        }
    }
}
