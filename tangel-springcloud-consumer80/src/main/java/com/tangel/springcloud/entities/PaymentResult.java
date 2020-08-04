package com.tangel.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResult<T> {

    //code
    private Integer code;

    //信息
    private String message;

    private T Data;

    public PaymentResult(Integer code, String message) {
        this(code, message, null);
    }

}
