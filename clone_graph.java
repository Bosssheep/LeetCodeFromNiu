import entity.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Clone an undirected graph. Each node in the graph contains alabeland a list of itsneighbors.
 * 使用广度遍历 DFS：
 *    DFS需要用到栈
 *    map存储旧节点到新节点的映射
 */
public class clone_graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;

        //map存储旧节点到新节点的映射
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        //新头节点
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node,head);

        //DFS需要用到栈
        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            UndirectedGraphNode root = stack.pop();
            ArrayList<UndirectedGraphNode> neighbors = new ArrayList<>();
            for(UndirectedGraphNode n : root.neighbors){
                if (map.containsKey(n)) {
                    neighbors.add(map.get(n));
                }else{
                    UndirectedGraphNode n1 = new UndirectedGraphNode(n.label);
                    stack.push(n);
                    map.put(n,n1);
                    neighbors.add(n1);
                }
            }
            map.get(root).neighbors = neighbors;
        }
        return head;
    }
}
