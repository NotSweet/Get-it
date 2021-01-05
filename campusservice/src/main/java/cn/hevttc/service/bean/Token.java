package cn.hevttc.service.bean;

public class Token {
    private int token_id;
    private int user_id;
    private long usedAt;
    private String user_token;

    public int getToken_id() {
        return token_id;
    }

    public void setToken_id(int token_id) {
        this.token_id = token_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public long getUsedAt() {
        return usedAt;
    }

    public void setUsedAt(long usedAt) {
        this.usedAt = usedAt;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }
}
