package com.sguama.book_trip.domain.common;

import java.util.Objects;
import java.util.function.Predicate;

public class Util {

    public static Predicate<Object> isNull = Objects::isNull;
}
