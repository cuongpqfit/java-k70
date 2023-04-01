public class Sorting {
    public static void main(String[] args) {
        int[] input = {1,3,5,2,20,6};
        int length = 6;
        insertSort(input, length);

    }

    public static void insertSort(int[] input, int length) {
        int i, j, last;
        int tmp;

        for (i=1; i<length; i++) {
            last = input[i];
            j = i;
            while (j>0 && input[j-1] > last) {
                //Swap: đảo vị trí
                tmp = input[j];
                input[j] = input[j-1];
                input[j-1] = tmp;

                j--;
            }

            input[j] = last;
        }

        for (i=0; i<length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
