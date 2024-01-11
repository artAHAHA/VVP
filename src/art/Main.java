package art;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, -1, -3, 7, 0, 4, -5};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));

        System.out.println(solve(list));
    }

    public static List<Integer> solve(List<Integer> list) {
        List<Integer> glist = new ArrayList<>();
        int k = 0;
        int m = 0;
        for (int arg : list) {
            if (k == 0) {
                k += 1;
                m = arg;
            } else {
                if (m > arg) {
                    glist.add(arg);
                } else {
                    glist.add(m);
                }
                k = 0;
            }
        }
        if (list.size()%2 != 0){
            glist.add(list.get(list.size()-1));
        }
        return glist;
    }
}

