package com.midterm.exam.test;

import java.util.Objects;

public class Test {
    private String test;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test1 = (Test) o;
        return Objects.equals(test, test1.test);
    }

    @Override
    public int hashCode() {
        return Objects.hash(test);
    }
}
