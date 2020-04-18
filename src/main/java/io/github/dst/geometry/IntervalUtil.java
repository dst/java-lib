package io.github.dst.geometry;

public class IntervalUtil {

    // Negating the opposite (do not overlap): [a] [b] or [b] [a]
    public boolean hasOverlap(int[] intervalA, int[] intervalB) {
        return !(intervalA[1] < intervalB[0] || intervalB[1] < intervalA[0]);
    }
}
