package 回溯算法;

import java.util.*;

/**
 * https://leetcode.cn/problems/reconstruct-itinerary/description/
 *
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 */
public class _332_重新安排行程 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        // 构建图：每个节点对应一个优先队列
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", graph, result);
        return result;
    }

    private void dfs(String node, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {
        PriorityQueue<String> neighbors = graph.get(node);
        while (neighbors != null && !neighbors.isEmpty()) {
            String next = neighbors.poll();
            dfs(next, graph, result);
        }
        result.addFirst(node); // 将节点添加到路径的开头
    }



}
