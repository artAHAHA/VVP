package Task12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeNode {
    public String vertex;
    public List<TreeNode> children = new ArrayList<>();

    public TreeNode(String vertex) {
        this.vertex = vertex;
    }

    public TreeNode(String vertex, List<TreeNode> children) {
        this.vertex = vertex;
        this.children = children;
    }

    public String getVertex() {
        return vertex;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public static void printTreeNode(TreeNode node, int globalDepth, Set<Integer> supportSet) {

        // Вывод
        if (globalDepth == 0) {
            System.out.println(node.getVertex());
        } else {
            StringBuilder stringBuilder = new StringBuilder();

            if (!supportSet.isEmpty()) {
                for (int i = 0; i < globalDepth - 1; i++) {
                    if (supportSet.contains(i)) {
                        stringBuilder.append("| ");
                    } else {
                        stringBuilder.append("  ");
                    }
                }
            }
            stringBuilder.append("+-");
            stringBuilder.append(node.getVertex());


            System.out.println(stringBuilder);
        }

        globalDepth++;

        //Рекурсия
        List<TreeNode> childrenList = node.getChildren();

        int supportIndex = 0;
        for (TreeNode childNode : childrenList) {
            if (childNode.getChildren().isEmpty()) {
                //Если у узла нет потомков, то...
                printTreeNode(childNode, globalDepth, supportSet);
            } else {
                //Если у узла есть потомки, то проверяем на наличие siblings после себя.
                //Переменная, указывающая на наличие братьев/сестёр после текущего узла в очереди на обработку

                Set<Integer> newSet = new HashSet<>(supportSet);

                if (supportIndex < childrenList.size() - 1) {
                    newSet.add(globalDepth - 1);
                }

                printTreeNode(childNode, globalDepth, newSet);
            }
            supportIndex++;
        }

    }
}