package com.cq.springbootdata;

import org.junit.Test;

/**
 * @description:
 * @Time: 2019/6/16 19:28
 */
public class m3 {
    public int[] swap(int begin, int end, int[] arrn) {
        int temp = arrn[begin];
        arrn[begin] = arrn[end];
        arrn[end] = temp;
        return arrn;
    }

    public int[] insertSort(int[] arrn) {
        int[] a = arrn;
        int temp;
        int j;
        for (int i = 1; i < arrn.length; i++) {
            temp = arrn[i];
            for (j = i; j > 0 && temp <= arrn[j - 1]; j--) {
                arrn[j] = arrn[j - 1];
            }
            arrn[j] = temp;
        }
        return a;
    }

    public int[] BubSort(int[] arrn) {
        int[] a = arrn;
        boolean flag = true;
        for (int i = 0; i < arrn.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < arrn.length - i - 1; j++) {
                if (arrn[j] > arrn[j + 1]) {
                    swap(j, j + 1, a);
                    flag = true;
                }
            }
            if (!flag) {
                continue;
            }

        }

        return a;
    }

    public int[] selSort(int[] arrn) {
        int temp;
        for (int i = 0; i < arrn.length; i++) {
            temp = i;
            for (int j = i + 1; j < arrn.length; j++) {
                if (arrn[temp] > arrn[j]) {
                    temp = j;
                }
            }
            swap(i, temp, arrn);

        }
        return arrn;
    }

    public void qSort(int p, int r,int[] arrn) {
        if (p < r) {
            int q = partition(p, r,arrn);
            qSort(p, q - 1,arrn);
            qSort(q + 1, r,arrn);
        }
    }

    public int partition(int p, int r,int[] arrn) {
//        i为开头,j为结尾。其中p是不变的
        int i = p, j = r + 1;
//        获取开头值
        int x=arrn[p];
//        这个while循环用来保证有多个值(大于两个值)的时候,还能继续寻找值
        while (true){
//            找到一个小于中间值的值
            while (arrn[++i]<x&&i<r);
//            找到一个大于中间值的值
            while(arrn[--j]>x);
//            如果两个相同就跳出
            if(i>=j)
                break;
//            交换了之后，j存的就是小于x的值
            swap(i,j,arrn);
        }
//        保证头和中间值一定会交换。
//        小于x的值放在第一个
        arrn[p]=arrn[j];
//        存放大于x的值
        arrn[j]=x;
        return j;
    }


    public void display(int[] arrn) {
        for (int i = 0; i < arrn.length; i++) {
            System.out.print(arrn[i] + ",");
        }
    }

    @Test
    public void m2() {
        int[] a = {7, 32, 4, 2, 155, 24, 5};
        qSort(0,a.length-1,a);
        display(a);
    }
}
