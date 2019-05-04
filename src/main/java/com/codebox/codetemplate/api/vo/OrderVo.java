package com.codebox.codetemplate.api.vo;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderVo implements Serializable {

    private Long id;
    private String no;
    private String title;
    private Float totalAmount;
    private String status;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("no", no)
                .add("title", title)
                .add("totalAmount", totalAmount)
                .add("status", status)
                .toString();
    }
}
