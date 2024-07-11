package Workspace;

import java.util.ArrayList;
import java.util.List;

// https://javaguide.cn/java/concurrent/java-concurrent-questions-01.html#%E4%BD%95%E4%B8%BA%E7%BA%BF%E7%A8%8B

/** Progress, Thread test */
public class workspace3 {
  public static void main(String[] args) {

    Solution s = new Solution();

    // test 1
    // int[] nums = new int[]{1,2,3};

    // test 2
    String[] nums = new String[] {"A", "B", "C"};

    List<List<String>> res = s.permute(nums);

    res.forEach(System.out::println);
  }
}

// https://leetcode.com/problems/permutations/
class Solution {
  public List<List<String>> permute(String[] nums) {

    if (nums == null || nums.length == 0) {
      return null;
    }

    List<List<String>> res = new ArrayList<>();
    List<String> tmp = new ArrayList<>();
    int start_idx = 0;
    backTrack(nums, start_idx, tmp, res);
    return res;
  }

  private void backTrack(String[] nums, int start_idx, List<String> tmp, List<List<String>> res) {

    if (tmp.size() == nums.length) {
      if (!res.contains(tmp)) {
        res.add(new ArrayList<>(tmp));
      }
      return;
    }

    for (int i = start_idx; i < nums.length; i++) {
      String cur = nums[i];
      tmp.add(cur);
      backTrack(nums, start_idx, tmp, res);
      // undo
      tmp.remove(tmp.size() - 1);
    }
  }
}
