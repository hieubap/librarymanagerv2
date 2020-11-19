package spring.com.responceEntity;

import java.sql.Timestamp;

public class EntityResponse<T> {
    private int status;
    private Timestamp time;
    private String message;
    private T data;


    public EntityResponse(int status, Timestamp time, String message, T data) {
        this.status = status;
        this.time = time;
        this.message = message;
        this.data = data;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
