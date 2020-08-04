package medium;

import java.util.*;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/8/4 14:24
 * @Description:
 * 207. 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 */
public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> integerLinkedListMap = makeTu(prerequisites,numCourses);
        boolean can = true;
        List<Integer> list = new LinkedList<>();
        while (!integerLinkedListMap.isEmpty()){
            Integer tmp = null;
            int i=0;
            int c = integerLinkedListMap.entrySet().size();
            boolean find = false;
            for (Map.Entry<Integer,Set<Integer>> entry : integerLinkedListMap.entrySet()){
                if (entry.getValue().size() == 0){
                    find = true;
                    tmp = entry.getKey();
                    list.add(tmp);
                    for (Map.Entry<Integer,Set<Integer>> tmpEn : integerLinkedListMap.entrySet()){
                        if (tmpEn.getValue().size() != 0){
                            tmpEn.getValue().remove(tmp);
                        }
                    }
                    break;
                }
                i++;
            }
            if (i == c && !find){
                can = false;
            }
            if (!can){
                break;
            }
            integerLinkedListMap.remove(tmp);
        }
        return can;
    }

    Map<Integer, Set<Integer>> makeTu(int[][] prerequisites,int numCourse){
        Map<Integer,Set<Integer>> res = new HashMap<>(numCourse);
        for (int[] tmp : prerequisites){
            Integer t0 = tmp[0];
            Integer t1 = tmp[1];
            Set<Integer> integers = res.get(t0);
            if (null == integers){
                integers = new HashSet<>();
                res.put(t0,integers);
            }
            Set<Integer> integers1 = res.get(t1);
            if (null == integers1){
                integers1 = new HashSet<>();
                integers1.add(t0);
                res.put(t1,integers1);
            }
            integers1.add(t0);
        }
        return res;
    }

    public static void main(String[] args) {
        Q207 q207 = new Q207();
        int[][] c= new  int[][]{{1,0}};
        boolean b = q207.canFinish(2, c);
        System.out.println(b);
    }

}
