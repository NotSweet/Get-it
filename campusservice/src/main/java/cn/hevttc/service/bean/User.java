package cn.hevttc.service.bean;

import com.blade.ioc.annotation.Bean;

@Bean
public class User {
    private int user_id;
    private String user_name;
    private String password;
    private String phone_number;
    private int sch_no; //school no
    private int score; //user score need pay
    private long createAt;
    private long updateAt;
    private boolean is_certify; //is certify that user is or not real-name
    private float user_score; // user star the that other user give
    private float score_number; //the other give star number



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getSch_no() {
        return sch_no;
    }

    public void setSch_no(int sch_no) {
        this.sch_no = sch_no;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isIs_certify() {
        return is_certify;
    }

    public void setIs_certify(boolean is_certify) {
        this.is_certify = is_certify;
    }

    public float getUser_score() {
        return user_score;
    }

    public void setUser_score(float user_score) {
        this.user_score = user_score;
    }

    public float getScore_number() {
        return score_number;
    }

    public void setScore_number(float score_number) {
        this.score_number = score_number;
    }
}
