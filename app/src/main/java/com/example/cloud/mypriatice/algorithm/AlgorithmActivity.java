package com.example.cloud.mypriatice.algorithm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.cloud.mypriatice.R;

public class AlgorithmActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    int a[] = {12, 451, 543, 13, 12, 35, 26, 7678, 123, 4, 5, 34, 23, 5, 6, 7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm);

        quickSort(a, 0, a.length - 1);
        printArry();

    }


    private void printArry() {
        for (int i = 0; i < a.length - 1; i++) {
            Log.e(TAG, "----------" + a[i]);
        }
    }

    /**
     * 冒泡排序
     * 依次比较相邻的两个元素大小，如果第一个大于第二个，就交换位置 直到循环结束
     *
     * @param arrays
     */
    private void bubbleSort(int[] arrays) {
        int temp;
        int size = arrays.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arrays[i] < arrays[j]) {
                    temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
    }

    /**
     * * 快速排序<br/>
     * <ul>
     * <li>从数列中挑出一个元素，称为“基准”</li>
     * <li>重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，
     * 该基准是它的最后位置。这个称为分割（partition）操作。</li>
     * <li>递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。</li>
     *
     * @param numbers
     * @param start
     * @param end
     */
    private void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }
    }
}
