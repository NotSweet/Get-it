package cn.hevttc.service.dao;

import cn.hevttc.service.bean.CampusName;
import com.datastax.driver.core.ResultSet;


public interface CampusDao {
    void insertCampus(CampusName campusName);
    void alterCampus(CampusName campusName);
    void deleteCampus(CampusName campusName);
    String selectCampus();
}
