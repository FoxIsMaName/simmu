import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class w3_2
{
    public static void main (String [] args) throws FileNotFoundException
    {      
        long x,y;
        long [] result = new long[100000];
        System.out.println("array");
        for(int time = 0 ; time < 100000;time++)
        {
            x = System.nanoTime();
            int size = 2_000;
            int [] re = new int[size - 1]; 
            for(int i = 2; i <= size; i++)
                re[i - 2] = i;
            for (int i : re)
            {
                if(i > Math.sqrt(size)) break;
                if(i == 0)  continue;
                for(int j = i+i; j <= size;j+=i)
                {
                    if(j%i == 0) 
                    {
                        re[j-2] = 0;
                    }
                }
            }
            y = System.nanoTime();
            result[time] = y - x;
            // System.out.println(((y - x) / 1E6));
        }
        long sum = 0;
        for (long d : result) sum += d;
        double average = sum / result.length;
        System.out.println("Total time = " + String.format("%e",sum/1E9) + "mS  exc " + result.length + " time");
        System.out.println("avg = " + (average/ 1E6) + "mS");
        System.out.println("min = " + Arrays.stream(result).min() + "nS");
        System.out.println("max = " + Arrays.stream(result).max() + "nS");

        // PrintWriter pw = new PrintWriter(new File("test.csv"));
        // StringBuilder sb = new StringBuilder();
        // sb.append("Size of number \t  \n");
        // sb.append("Number of time to exc \t \n");
        // sb.append("avg = " + (average/ 1E6) + "mS\n");
        // sb.append("min = " + Arrays.stream(result).min() + "nS\n");
        // sb.append("max = " + Arrays.stream(result).max() + "nS\n");
        // for (long d : result) sb.append(d+"\n");
        // pw.write(sb.toString());
        // pw.close();
        // System.out.println("done!");
    }
}
