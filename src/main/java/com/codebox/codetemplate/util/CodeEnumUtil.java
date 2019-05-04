package com.codebox.codetemplate.util;

import com.codebox.codetemplate.domain.enums.CodeBaseEnum;

public class CodeEnumUtil {

    public static <E extends Enum<?> & CodeBaseEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.code() == code) {
                return e;
            }
        }

        return null;
    }
}
