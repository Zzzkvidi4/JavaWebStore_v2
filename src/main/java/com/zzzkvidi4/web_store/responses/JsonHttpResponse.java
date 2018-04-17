package com.zzzkvidi4.web_store.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreType
public class JsonHttpResponse<T> {
    private List<String> errors = new ArrayList<>();
    private T data;
    private boolean isSuccessful;

    public JsonHttpResponse(){
        isSuccessful = true;
    }

    public JsonHttpResponse(T data, boolean isSuccessful){
        this.data = data;
        this.isSuccessful = isSuccessful;
    }

    public void addError(String error){
        isSuccessful = false;
        errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public void addErrors(Throwable e){
        isSuccessful = false;
        Throwable cur = e;
        while (cur != null){
            addError(cur.getMessage());
            cur = cur.getCause();
        }
    }

    public void addErrors(List<String> errors){
        this.errors.addAll(errors);
    }
}
