package Workspace;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

// https://javaguide.cn/java/concurrent/java-concurrent-questions-01.html#%E4%BD%95%E4%B8%BA%E7%BA%BF%E7%A8%8B

/** Progress, Thread test */

public class workspace3 {
    public static void main(String[] args) {

//        // 获取 Java 线程管理 MXBean
//        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
//        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
//        // 遍历线程信息，仅打印线程 ID 和线程名称信息
//        for (ThreadInfo threadInfo : threadInfos) {
//            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
//        }

        Solution s = new Solution();

        // test 1
        //int[] nums = new int[]{1,2,3};

        // test 2
        String[] nums = new String[]{"A", "B", "C"};

        List<List<String>> res = s.permute(nums);

        res.forEach(System.out::println);

    }
}


// https://leetcode.com/problems/permutations/
class Solution {
    public List<List<String>> permute(String[] nums) {

        if (nums == null || nums.length == 0){
            return null;
        }

        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        int start_idx = 0;
        backTrack(nums, start_idx, tmp, res);
        return res;
    }

    private void backTrack(String[] nums, int start_idx, List<String> tmp, List<List<String>> res){

        if (tmp.size() == nums.length){
            if (!res.contains(tmp)){
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        for (int i = start_idx; i < nums.length; i++){
            String cur = nums[i];
            tmp.add(cur);
            backTrack(nums, start_idx, tmp, res);
            // undo
            tmp.remove(tmp.size()-1);
        }
    }

}
