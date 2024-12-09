import java.util.Scanner;
import java.util.Random;
public class Arizobal_SortingAlgorithm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int[] dataset1 = new int[10];
        int[] dataset2 = new int[100];
        int[] dataset3 = new int[1000];

        for(int i = 0; i < dataset1.length; i++){
            dataset1[i] = random.nextInt(100);
        }

        for(int i = 0; i < dataset2.length; i++){
            dataset2[i] = random.nextInt(100);
        }

        for(int i = 0; i < dataset3.length; i++){
            dataset3[i] = random.nextInt(100);
        }

        System.out.println("[1] Bubble\n[2] Selection\n[3] Insertion");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                long startTime1 = System.nanoTime();
                Bubble(dataset1,dataset2,dataset3);
                long endTime1 = System.nanoTime();
                long duration1 = (endTime1 - startTime1);
                System.out.println("Sorted: ");
                printArray(dataset1, dataset2, dataset3);
                System.out.println(duration1);
                break;

            case 2:
                long startTime2 = System.nanoTime();
                Selection(dataset1,dataset2,dataset3);
                long endTime2 = System.nanoTime();
                long duration2 = (endTime2 - startTime2);
                System.out.println("Sorted: ");
                printArray(dataset1, dataset2, dataset3);
                System.out.println(duration2);
                break;

            case 3:
                long startTime3 = System.nanoTime();
                Insertion(dataset1,dataset2,dataset3);
                long endTime3 = System.nanoTime();
                long duration3 = (endTime3 - startTime3);
                System.out.println("Sorted: ");
                printArray(dataset1, dataset2, dataset3);
                System.out.println(duration3);
                break;
        
            default:
                break;
        }
        scan.close();
    }

    public static void printArray(int[] data1, int data2[], int[] data3){
        int n1 = data1.length;
        int n2 = data2.length;
        int n3 = data3.length;
        for (int i = 0; i < n1; i++){
            System.out.print(data1[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n2; i++){
            System.out.print(data2[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n3; i++){
            System.out.print(data3[i] + " ");
        }
        System.out.println();
    }
    public static void Bubble(int[] data1, int[] data2, int[] data3){
        int n1 = data1.length;
        int n2 = data2.length;
        int n3 = data3.length;
        int temp1,temp2,temp3;
        boolean swapped1,swapped2,swapped3;
        for(int i = 0; i < n1 - 1; i++){
            swapped1 = false;
            for (int j = 0; j < n1 - 1; j++){
                if(data1[j] > data1[j+1]){
                    temp1 = data1[j];
                    data1[j] = data1[j+1];
                    data1[j+1] =temp1;
                    swapped1 = true;
                }
            }
            if(swapped1 == false){
                break;
            }
        }

        for(int i = 0; i < n2 - 1; i++){
            swapped2 = false;
            for (int j = 0; j < n2 - 1; j++){
                if(data2[j] > data2[j+1]){
                    temp2 = data2[j];
                    data2[j] = data2[j+1];
                    data2[j+1] =temp2;
                    swapped2 = true;
                }
            }
            if(swapped2 == false){
                break;
            }
        }

        for(int i = 0; i < n3 - 1; i++){
            swapped3 = false;
            for (int j = 0; j < n3 - 1; j++){
                if(data3[j] > data3[j+1]){
                    temp3 = data3[j];
                    data3[j] = data3[j+1];
                    data3[j+1] =temp3;
                    swapped3 = true;
                }
            }
            if(swapped3 == false){
                break;
            }
        }
    }

    public static void Selection(int[] data1, int[] data2, int[] data3){
        int n1 = data1.length;
        int n2 = data2.length;
        int n3 = data3.length;
        int temp1,temp2,temp3;
        for(int i = 0; i < n1-1; i++){
            int min_idx = i;
            for(int j = i + 1; j < n1 ; j++){
                if(data1[j] < data1[min_idx]){
                    min_idx = j;
                }
            }

            temp1 = data1[i];
            data1[i] = data1[min_idx];
            data1[min_idx] = temp1;
        }

        for(int i = 0; i < n2-1; i++){
            int min_idx = i;
            for(int j = i + 1; j < n2 ; j++){
                if(data2[j] < data2[min_idx]){
                    min_idx = j;
                }
            }

            temp2 = data2[i];
            data2[i] = data2[min_idx];
            data2[min_idx] = temp2;
        }

        for(int i = 0; i < n3-1; i++){
            int min_idx = i;
            for(int j = i + 1; j < n3 ; j++){
                if(data3[j] < data3[min_idx]){
                    min_idx = j;
                }
            }

            temp3 = data3[i];
            data3[i] = data3[min_idx];
            data3[min_idx] = temp3;
        }
    }

    public static void Insertion(int[] data1, int[] data2, int[] data3){
        int n1 = data1.length;
        int n2 = data2.length;
        int n3 = data3.length;
        for(int i = 1; i < n1; i++){
            int key = data1[i];
            int j = i - 1;

            while (j >= 0 && data1[j] > key) {
                data1[j + 1] = data1[j];
                j = j - 1;
            }
            data1[j + 1] = key;
        }

        for(int i = 1; i < n2; i++){
            int key = data2[i];
            int j = i - 1;

            while (j >= 0 && data2[j] > key) {
                data2[j + 1] = data2[j];
                j = j - 1;
            }
            data2[j + 1] = key;
        }

        for(int i = 1; i < n3; i++){
            int key = data3[i];
            int j = i - 1;

            while (j >= 0 && data3[j] > key) {
                data3[j + 1] = data3[j];
                j = j - 1;
            }
            data3[j + 1] = key;
        }
    }
}