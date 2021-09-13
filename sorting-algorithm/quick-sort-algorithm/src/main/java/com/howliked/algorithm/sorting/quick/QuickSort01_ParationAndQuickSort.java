package com.howliked.algorithm.sorting.quick;

public class QuickSort01_ParationAndQuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 4, 3, 6, 5, 7, 0};
        quickSort1(array);
        quickSort2(array);
        printArray(array);
    }

    public static void quickSort2(int[] arr) {
        process2(arr, 0, arr.length - 1);
    }

    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }

    /**
     * arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
     * <arr[R] ==arr[R]  > arr[R]
     * <p>
     * 1.如果当前index小于目标值: 交换当前index与初始区域next位置
     * 2.如果当前index等于目标值: 不动,index向右移
     * 3.如果当前index大于目标值: >区向左扩,并且与<区下一个值替换
     *
     * @param arr
     * @param L
     * @param R
     * @return 返回等于目标值的索引位置
     */
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) { // L...R L>R
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1; // < 区 右边界
        int more = R; // > 区 左边界
        int index = L;
        while (index < more) { // 当前位置，不能和 >区的左边界撞上
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else { // >
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R); // <[R]   =[R]   >[R]
        return new int[]{less + 1, more};
    }


    /**
     * 目标值:(此逻辑为 数组中最右边的数)
     * 1.如果当前index小于等于目标值,<=区向右扩,index++
     * 2.如果当前index大于目标值,<=区右边的值与目标值交换
     *
     * @param arr
     */
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // L..R partition arr[R] [ <=arr[R] arr[R] >arr[R] ]
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);
    }

    // arr[L..R]上，以arr[R]位置的数做划分值
    // <= X > X
    // <= X X
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        //   <=区
        int lessEqual = L - 1;
        //指针
        int index = L;
        //当指针小于最右边的值时,才进行操作
        while (index < R) {
            //如果比目标值小(符合<=区)
            if (arr[index] <= arr[R]) {
                //<=区 向右扩
                lessEqual++;
            }
            index++;
        }
        //最后一个值和<=区的后一个位置交换
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }


    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    private static void swap(int[] array, int L, int R) {
        int tmp = array[L];
        array[L] = array[R];
        array[R] = tmp;
    }
}
