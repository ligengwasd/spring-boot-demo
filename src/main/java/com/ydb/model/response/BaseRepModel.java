package com.ydb.model.response;

import lombok.Data;

/**
 * Created by dev on 16-5-24.
 */
@Data
public class BaseRepModel {
    Integer code;
    String msg;
    Object data;
}
