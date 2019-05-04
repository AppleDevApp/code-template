package com.codebox.codetemplate.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer userId;

    private String userName;

    private String password;

    private String phone;

    private String chars;

    private Integer ints;

    private Float floats;

    private Long longs;

    private Byte shorts;

    private Date createdate;

    private BigDecimal decimals;

    private Date dates;

    private byte[] bytes;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("userId", userId)
                .add("userName", userName)
                .add("password", password)
                .add("phone", phone)
                .add("chars", chars)
                .add("ints", ints)
                .add("floats", floats)
                .add("longs", longs)
                .add("shorts", shorts)
                .add("createdate", createdate)
                .add("decimals", decimals)
                .add("dates", dates)
                .add("bytes", bytes)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(userId, user.userId) &&
                Objects.equal(userName, user.userName) &&
                Objects.equal(password, user.password) &&
                Objects.equal(phone, user.phone) &&
                Objects.equal(chars, user.chars) &&
                Objects.equal(ints, user.ints) &&
                Objects.equal(floats, user.floats) &&
                Objects.equal(longs, user.longs) &&
                Objects.equal(shorts, user.shorts) &&
                Objects.equal(createdate, user.createdate) &&
                Objects.equal(decimals, user.decimals) &&
                Objects.equal(dates, user.dates) &&
                Objects.equal(bytes, user.bytes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId, userName, password, phone, chars, ints, floats, longs, shorts, createdate, decimals, dates, bytes);
    }
}