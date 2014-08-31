/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * 
 * Corner Cases: Did you consider the case where path = "/../"? In this case,
 * you should return "/". Another corner case is the path might contain multiple
 * slashes '/' together, such as "/home//foo/". In this case, you should ignore
 * redundant slashes and return "/home/foo".
 */

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        LinkedList<String> list = new LinkedList<String>();
        for (String str : tokens) {
            if (str.length() == 0 || str.equals("."))
                continue;
            else if (str.equals("..")) {
                if (list.size() > 0)
                    list.removeLast();
            } else
                list.add(str);
        }

        StringBuilder builder = new StringBuilder();
        builder.append('/');
        for (String str : list) {
            builder.append(str);
            builder.append('/');
        }
        if (builder.length() > 1)
            builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}