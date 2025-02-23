package tree;

import lista.Nodo;

import java.util.ArrayList;
import java.util.List;

public class TreePrinter<T> {

    public void printFullTree(Nodo<T> root, String delim, List<String> idnt, Boolean left) {
        if (root != null) {
            idnt.add(delim);
            String[] delims = setDelims(left);
            printFullTree(root.getRight(), delims[0], idnt, false);
            indent2(root.getValue(), idnt, 6);
            printFullTree(root.getLeft(), delims[1], idnt, true);
            idnt.remove(idnt.size() - 1);
        }
    }

    public static String[] setDelims(Boolean left) {
        String x = " ";
        String y = "|";
        return (left == null) ? new String[]{x, x} : (left ? new String[]{y, x} : new String[]{x, y});
    }

    public void indent2(T x, List<String> idnt, int width) {
        for (String delim : idnt) {
            System.out.print(delim + " ".repeat(width - 1));
        }
        System.out.println("|-> " + x);
    }


}
