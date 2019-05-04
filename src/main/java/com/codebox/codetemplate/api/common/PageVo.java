package com.codebox.codetemplate.api.common;

import com.google.common.base.MoreObjects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageVo<T> {

    private Integer pageNum;
    private Integer pageSize;
    private Long total;
    private Integer pages;
    private List<T> list;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("pageNum", pageNum)
                .add("pageSize", pageSize)
                .add("total", total)
                .add("pages", pages)
                .add("list", list)
                .toString();
    }
}