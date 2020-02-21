package medium;

/**
 * SimplifyPath
 *
 * @author black
 * @date 2020-02-21
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }

    private static final String currentPath = ".";
    private static final String lastPath = "..";
    private static final String rootPath = "/";

    public static String simplifyPath(String path) {
        String current = rootPath;
        if (path == null || path.length() <= 1) {
            return rootPath;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (builder.length() > 0) {
                    current = calcPath(current, builder.toString());
                    builder = new StringBuilder();
                }
            } else {
                builder.append(path.charAt(i));
            }
        }
        if (builder.length() > 0) {
            current = calcPath(current, builder.toString());
        }
        return current;
    }

    private static String calcPath(String current, String option) {
        switch (option) {
            case currentPath : return current;
            case lastPath : if (current.lastIndexOf(rootPath) <= 0) {
                return rootPath;
            } else {
                return current.substring(0, current.lastIndexOf(rootPath));
            }
            default: if (rootPath.equals(current)) {
                return current + option;
            } else {
                return current + rootPath + option;
            }
        }
    }
}
