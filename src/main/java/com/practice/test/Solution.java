package com.practice.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();

        //为空或者元素个数小于3，直接返回
        if(nums==null||nums.length< 3){
            return result;
        }
        //排序
        Arrays.sort(nums);

        //遍历到倒数第三个，因为是三个数总和
        for(int i=0;i<nums.length-2;i++){
            //大于0可以直接跳出循环了
            if(nums[i]>0){
                break;
            }
            //过滤重复
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            //左指针
            int left = i+1;
            //右指针
            int right = nums.length-1;
            //目标总和，是第i个的取反，也就是a+b+c=0,则b+c=-a即可
            int target = - nums[i];

            while(left<right){
                //b+c=-a,满足a+b+c=0
                if(nums[left]+ nums[right]==target){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //左指针右移
                    left++;
                    //右指针左移
                    right--;
                    //继续左边过滤重复
                    while(left<right&&nums[left]==nums[left-1]) {
                        left++;
                    }
                    //继续右边过滤重复
                    while(left<right&&nums[right]==nums[right+1]) {
                        right--;
                    }
                }else if(nums[left]+ nums[right]<target){
                    //小于目标值，需要右移，因为排好序是从小到大的
                    left++;
                }else{
                    right--;
                }

            }
        }
        return result;
    }
}
