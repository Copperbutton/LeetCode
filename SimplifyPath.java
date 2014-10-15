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
        Stack<String> stack = new Stack<String> ();
        for (String str : tokens) {
            if (str.equals(".") || str.equals(""))
                continue;
            if (str.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(str);
        }
        StringBuilder builder = new StringBuilder();
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            builder.append("/");
            builder.append(iterator.next());
        }
        return builder.length() == 0 ? "/" : builder.toString();
    }
}