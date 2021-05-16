package com.tusk.search;

/**
 * @author tusk
 * @desc 二分查找
 * ========================================
 * 时间复杂度:O(logN)
 * ========================================
 * @date 2021/5/15 11:34
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] data = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        int idx = bs.search_last_less(data, 8);
//        int idx = bs.search_recursive(data, 9, 0, data.length - 1);
        System.out.println(idx);
    }

    /**
     * 二分查找标准实现
     *
     * @param data
     * @param key
     * @return
     */
    public int search(int[] data, int key) {
        if (data == null) {
            return -1;
        }

        int len = data.length;

        int low = 0;
        int high = len - 1;


        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (data[mid] == key) {
                return mid;
            } else if (data[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }

    /**
     * 递归实现
     *
     * @param data
     * @param key
     * @return
     */
    public int search_recursive(int[] data, int key, int low, int high) {
        if (low <= high) {
            int mid = (high - low) / 2 + low;
            if (key == data[mid]) {
                return mid;
            } else if (key < data[mid]) {
                return search_recursive(data, key, low, mid - 1);
            } else {
                return search_recursive(data, key, mid + 1, high);
            }
        }
        return -1;
    }

    /**
     * 二分查找变种 1,数组包含重复元素，查找第一个等于给定元素
     *
     * @param data
     * @param key
     * @return
     */
    public int search_first(int[] data, int key) {
        int len = data.length;

        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = ((high - low) >> 1) + low;

            if (data[mid] < key) {
                low = mid + 1;
            } else if (data[mid] > key) {
                high = mid - 1;
            } else {
                //如果 mid = 0,那么一定是对应元素的第一个
                if (mid == 0 || data[mid - 1] != key) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找变种2,数组包含重复元素，查找最后一个等于给定元素
     *
     * @param data
     * @param key
     * @return
     */
    public int search_last(int[] data, int key) {
        int len = data.length;

        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = ((high - low) >> 1) + low;

            if (data[mid] < key) {
                low = mid + 1;
            } else if (data[mid] > key) {
                high = mid - 1;
            } else {
                //如果 mid = 0,那么一定是对应元素的第一个
                if (mid == len - 1 || data[mid + 1] != key) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找变种3，找到第一个大于等于 key 的元素
     *
     * @param data
     * @param key
     * @return
     */
    public int search_first_greater(int[] data, int key) {
        int len = data.length;

        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = ((high - low) >> 1) + low;

            if (data[mid] < key) {
                low = mid + 1;
            } else {
                if (mid == 0 || data[mid - 1] < key) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 二分查找变种4,找到第一个小于等于指定元素的值
     *
     * @param data
     * @param key
     * @return
     */
    public int search_last_less(int[] data, int key) {
        int len = data.length;

        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (data[mid] > key) {
                low = mid + 1;
            } else {
                if (mid == len - 1 || data[mid + 1] > key) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

}
