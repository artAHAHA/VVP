package Task12;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws MyException {
        //TreeNode a = Logic.solution("(a, b, (c), d)");
        //TreeNode a = Logic.solution("(a, second, (abc, y, (x, 7), uuu, (8, 9, (10, 1))), abcddcdba)");
        TreeNode tree = Logic.solution(InputHandler.getInputString());

        Set<Integer> supportSet = new HashSet<>();
        TreeNode.printTreeNode(tree, 0, supportSet);
    }
}