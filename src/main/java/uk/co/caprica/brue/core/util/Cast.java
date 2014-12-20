package uk.co.caprica.brue.core.util;

public final class Cast {

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object value) {
        return (T) value;
    }
}
