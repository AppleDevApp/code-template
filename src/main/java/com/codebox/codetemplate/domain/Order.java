package com.codebox.codetemplate.domain;

import com.codebox.codetemplate.domain.enums.OrderStatus;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Order implements Serializable {

    private Long id;
    private String no;
    private String title;
    private Float totalAmount;
    private OrderStatus status;
    private Date createTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equal(id, order.id) &&
                Objects.equal(no, order.no) &&
                Objects.equal(title, order.title) &&
                Objects.equal(totalAmount, order.totalAmount) &&
                status == order.status &&
                Objects.equal(createTime, order.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, no, title, totalAmount, status, createTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("no", no)
                .add("title", title)
                .add("totalAmount", totalAmount)
                .add("status", status)
                .add("createTime", createTime)
                .toString();
    }
}
