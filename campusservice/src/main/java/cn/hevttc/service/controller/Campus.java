package cn.hevttc.service.controller;

import cn.hevttc.service.bean.CampusName;
import cn.hevttc.service.dao.CampusDao;
import cn.hevttc.service.dao.CampusImp;
import cn.hevttc.service.response.JsonResponse;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Response;

/**
 * campus some info
 * select
 * alter
 * delete
 */

@Path
public class Campus {

    private CampusDao campusImp = new CampusImp();
    @GetRoute("campus")
    public void campus(Response response) {

        response.text(campusImp.selectCampus());
    }

    @PostRoute("campus")
    public void insertCampus(Response response, @BodyParam  CampusName campusName) {
        System.out.println(campusName.getName());
        campusImp.insertCampus(campusName);
        response.text(new JsonResponse().outPutSuccess().toJSONString());
    }

    @PutRoute("campus")
    public void alterCampus(Response response, @Param CampusName campusName) {
        campusImp.alterCampus(campusName);
        response.text(new JsonResponse().outPutSuccess().toJSONString());
    }

    @DeleteRoute("campus")
    public void deleteCampus(Response response, @Param CampusName campusName) {
        campusImp.deleteCampus(campusName);
        response.text(new JsonResponse().outPutSuccess().toJSONString());
    }
}
