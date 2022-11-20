import java.util.Scanner;

public class first {

    static void first_fit(int m, int[] memory, int n, int process[]) {
        int allocation[] = new int[n];
        for (int i = 0; i < n; i++) {
            allocation[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (process[i] <= memory[j]) {
                    allocation[i] = j;
                    memory[j] = memory[j] - process[i];
                    break;
                }
            }
        }
        System.out.println("P No. \tP Size \tBlock No.");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "\t\t" + process[i] + "\t\t");
            if (allocation[i] != -1) {
                System.out.println(allocation[i] + 1);
            } else {
                System.out.print("Not Allocated");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int m;
        System.out.println("Enter number of memory partitions: ");
        m = sc.nextInt();
        int memoryArr[] = new int[m];
        System.out.println("Enter size of each memory partition: ");
        for (int i = 0; i < m; i++) {
            memoryArr[i] = sc.nextInt();
        }
        
        int n;
        System.out.println("Enter number of processes: ");
        n = sc.nextInt();
        int processArr[] = new int[n];
        System.out.println("Enter size of each process: ");
        for (int i = 0; i < n; i++) {
            processArr[i] = sc.nextInt();
        }

        first_fit(m, memoryArr, n, processArr);

        sc.close();
    }
}
