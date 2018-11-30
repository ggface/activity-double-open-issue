package io.github.ggface.activitydoubleopenissue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Класс для работы со строками.
 *
 * @author Ivan Novikov on 2018-11-30.
 */
public final class StringUtils {

    private StringUtils() {
    }

    /**
     * Возвращает строку, которая не может быть null
     *
     * @param string строка, которая может быть null
     * @return {@code string} или пустая строка
     */
    @NonNull
    public static String nonNull(@Nullable String string) {
        if (string == null) {
            return "";
        }

        return string;
    }
}