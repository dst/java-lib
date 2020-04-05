package io.github.dst.bit;

import java.util.ArrayList;
import java.util.List;

public class BitUtil {

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> subsets = new ArrayList<>();
        for (int bitmask = 0; bitmask < Math.pow(2, n); bitmask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (((bitmask >> i) & 1) == 1) {
                    subset.add(nums[i]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }

    public static List<String> generateAllBitmasks(int n) {
        List<String> bitmasks = new ArrayList<>();
        int nthBit = 1 << n;
        for (int i = 0; i < Math.pow(2, n); i++) {
            String bitmask = Integer.toBinaryString(nthBit | i).substring(1);
            bitmasks.add(bitmask);
        }
        return bitmasks;
    }
}
