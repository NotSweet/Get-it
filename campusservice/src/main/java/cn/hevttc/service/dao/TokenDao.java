package cn.hevttc.service.dao;

public interface TokenDao {
    String newToken(int id);
    String reToken(int id,String token);
    String tokenAuth(String tokens);
}
