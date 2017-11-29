package regular;

import java.util.regex.Pattern;

/**
 * Created by daihuijun on 2017/2/9.
 */
public class RegularExpress {
    // ip地址正则校验
    private static final String IP_REGULAR =
            "((2[0-4]\\d|25[0-5]|[01]?\\d{1,2})\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d{1,2})";
    private static final Pattern IP_REGULAR_PATTERN = Pattern.compile(IP_REGULAR);

    public static void main(String[] args) {
        System.out.println(IP_REGULAR_PATTERN.matcher("190.168.45.3").matches());
    }
}
