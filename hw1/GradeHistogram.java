import java.util.Scanner;
import java.io.File;

public class GradeHistogram {
    public static void main(String[] args)throws Exception {
        String fileName = args[0];
        System.out.println("Grades loaded!");
        int bucketSize = 0;
        if (args.length == 2) {
            //command line args
            bucketSize = Integer.parseInt(args[1]);
        } else {
            //prompt the user input
            System.out.println("What bucket size would you like?");
            Scanner input = new Scanner(System.in);
            bucketSize = input.nextInt();
        }
        int len = 100 / bucketSize + 1;
        int[] buckets = new int[len];
        //array a fixed size data structure;know ahead of time how big it is.
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        //scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] temp = line.split(",");
            int num = Integer.parseInt(temp[1].trim());
            int index = (100 - num) / bucketSize;
            buckets[index]++;
        }
        scanner.close();
        int higherBound = 100;
        int lowerBound = 100 - bucketSize + 1;
        for (int i = 0; i < len; i++) {
            if (lowerBound < 0) {
                lowerBound = 0;
            }
            System.out.printf(" %3d - %3d | ", higherBound, lowerBound);
            for (int j = 0; j < buckets[i]; j++) {
                System.out.print("[]");
            }
            System.out.println();
            higherBound -= bucketSize;
            lowerBound = higherBound - bucketSize + 1;
        }
    }
}