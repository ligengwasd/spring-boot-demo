package com.ydb.model.response;

import lombok.Data;

/**
 * Created by dev on 16-5-24.
 */
@Data
public class BaseResModel {
    Integer code;
    String msg;
    Object data;
    public BaseResModel(){
        this.code = 1001;
    }
    public BaseResModel(Integer code){
        this.code = code;
    }
}
