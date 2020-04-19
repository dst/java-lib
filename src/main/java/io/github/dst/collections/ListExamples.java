package io.github.dst.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListExamples {

    public static void nCopies() {
        // Note that this copies the reference to the given object, not
        // the object itself. If you're working with strings, it won't matter
        // because they're immutable anyway.
        List<String> zeros = Collections.nCopies(5, "0");
        assert zeros.equals(Arrays.asList("0", "0", "0", "0", "0"));
    }
}
