package com.codebox.codetemplate.api.dto;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderDto implements Serializable {

    private String no;
    private String title;
    private Float totalAmount;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("no", no)
                .add("title", title)
                .add("totalAmount", totalAmount)
                .toString();
    }
}
