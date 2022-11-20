import java.util.*;

public class best {
    // Method to allocate memory to blocks as per Best fit
    // algorithm
    static void bestFit(int blockSize[], int m, int processSize[], int n) {
        // Stores block id of the block allocated to a
        // process
        int allocation[] = new int[n];

        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++) {
            // Find the best fit block for current process
            int bestIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (bestIdx == -1)
                        bestIdx = j;
                    else if (blockSize[bestIdx] > blockSize[j])
                        bestIdx = j;
                }
            }

            // If we could find a block for current process
            if (bestIdx != -1) {
                // allocate block j to p[i] process
                allocation[i] = bestIdx;
                // Reduce available memory in this block.
                blockSize[bestIdx] -= processSize[i];
            }
        }

        System.out.println("P No. \tP Size \tBlock No.");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1) {
                System.out.println(allocation[i] + 1);
            } else {
                System.out.print("Not Allocated");
            }
            System.out.println();
        }
    }

    // Driver Method
    public static void main(String[] args) {
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

        bestFit(memoryArr, m, processArr, n);

        sc.close();
    }
}
