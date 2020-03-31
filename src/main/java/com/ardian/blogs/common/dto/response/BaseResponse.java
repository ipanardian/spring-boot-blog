package com.ardian.blogs.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private boolean status;
    private String code;
    private String message;
    private T data;

    public static BaseResponse error(String code, String message) {
        return new BaseResponse<>(false, code, message, null);
    }

    public static BaseResponse ok() {
        return new BaseResponse<>(true, "200", "success", null);
    }

    public static <I> BaseResponse<I> ok(I body) {
        return new BaseResponse<I>(true, "200", "success", body);
    }

    public static BaseResponse created() {
        return new BaseResponse<>(true, "201", "created", null);
    }

    public static BaseResponse created(String uri) {
        BaseResponse<Map> baseResponse = new BaseResponse<>();
        baseResponse.setStatus(true);
        baseResponse.setCode("201");
        baseResponse.setMessage("created");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("uri", uri);
        baseResponse.setData(map);
        return baseResponse;
    }

}
