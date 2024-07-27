package hot100.图论;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class _207_课程表 {
    /*
    有向图的拓扑序列
    ● 一个有向图，如果图中有入度为 0 的点，就把这个点删掉，同时也删掉这个点所连的边
    ● 一直进行上面出处理，如果所有点都能被删掉，则这个图可以进行拓扑排序
    ● 能进行拓扑排序的一个实例
    思路：
    •	使用队列进行广度优先搜索。
	•	首先把所有入度为 0 的课程放入队列中。
	•	每次从队列中取出一个课程，代表这个课程已经完成，对于这个课程指向的每一个课程，将其入度减 1。
	•	如果某个课程的入度减为 0，表示它的所有先决条件都已满足，因此将其加入队列。
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建一个入度数组，记录每个课程有多少个先修课程
        int[] inDegrees = new int[numCourses];
        // 创建邻接表，表示课程之间的依赖关系
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>()); // add的是空，有了课程对应的序号 list里的值指的是他的next学习课程
        }
        // 填充邻接表和入度数组
        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);        // pre[1]对应的课程 -> pre[0]对应的课程
            inDegrees[pre[0]]++;
        }

        // 使用队列进行拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        // 将所有入度为0的课程加入队列  入度为0的课程可以直接学
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        // 已经可以完成的课程数量
        int finishedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            finishedCourses++;
            // 对于每个出队的课程，减少它指向的课程的入度
            for (int nextCourse : adjList.get(course)) {
                inDegrees[nextCourse]--;
                // 如果某课程的入度变为0，加入队列
                if (inDegrees[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 如果完成的课程数量等于总课程数，返回true，否则返回false
        return finishedCourses == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
