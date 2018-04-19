package io.github.dst.pattern;

import java.util.regex.Pattern;

class IpPatterns {

    // Allows leading zeros, for example 127.0.00.001
    static Pattern IP_V4_PATTERN = Pattern.compile("((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}");
}
