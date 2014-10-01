package arraysAndStrings.arrays.programCreek;

/*
 * here are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 */
public class FindMedianSorted {

    public static double findMedian(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int mid = (m + n) / 2;
        // if total number of elements is odd
        if ((m + n) % 2 != 0) {
            return (double) findKth(A, B, mid, 0, m - 1, 0, n - 1);
        }
        // if total number of elements is even, median is avg of mid and mid-1
        else {
            return (findKth(A, B, mid, 0, m - 1, 0, n - 1) + findKth(A, B,
                    mid - 1, 0, m - 1, 0, n - 1)) * .5;
        }

    }

    public static int findKth(int A[], int B[], int k, int aStart, int aEnd,
            int bStart, int bEnd) {

        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

        int aMid = aLen * k / (aLen + bLen); // a's middle count
        int bMid = k - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }

    public static void main(String[] args) {
        int[] A = { -5, -2, 0, 2, 5 };
        int[] B = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(findMedian(A, B));
    }

}
