package cn.hevttc.service.bean;

import com.blade.ioc.annotation.Bean;

import java.sql.Timestamp;
import java.util.Date;

@Bean
public class Task {
    private int task_id;
    private String task_title;
    private int task_score;
    private String task_context;
    private String task_phone;
    private String task_address;
    private int sch_no;
    private boolean task_type;
    private int task_author;
    private int task_other;
    private long receive_time;
    private long createAt;
    private long updateAt;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title;
    }

    public int getTask_score() {
        return task_score;
    }

    public void setTask_score(int task_score) {
        this.task_score = task_score;
    }

    public String getTask_context() {
        return task_context;
    }

    public void setTask_context(String task_context) {
        this.task_context = task_context;
    }

    public String getTask_phone() {
        return task_phone;
    }

    public void setTask_phone(String task_phone) {
        this.task_phone = task_phone;
    }

    public String getTask_address() {
        return task_address;
    }

    public void setTask_address(String task_address) {
        this.task_address = task_address;
    }

    public int getSch_no() {
        return sch_no;
    }

    public void setSch_no(int sch_no) {
        this.sch_no = sch_no;
    }

    public boolean isTask_type() {
        return task_type;
    }

    public void setTask_type(boolean task_type) {
        this.task_type = task_type;
    }

    public int getTask_author() {
        return task_author;
    }

    public void setTask_author(int task_author) {
        this.task_author = task_author;
    }

    public int getTask_other() {
        return task_other;
    }

    public void setTask_other(int task_other) {
        this.task_other = task_other;
    }

    public long getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(long receive_time) {
        this.receive_time = receive_time;
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
}
