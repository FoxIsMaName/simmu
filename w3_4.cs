using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace w3_4
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] result = new long[100000];
            Console.WriteLine("array");
            for (int time = 0; time < 100000; time++)
            {
                Stopwatch sw = new Stopwatch();
                sw.Start();
                int size = 2000;
                int[] re = new int[size - 1];
                for (int i = 2; i <= size; i++)
                    re[i - 2] = i;
                foreach (int i in re)
                {
                    if (i > Math.Sqrt(size)) break;
                    if (i == 0) continue;
                    for (int j = i+i; j <= size; j+=i)
                        if (j % i == 0)
                            re[j - 2] = 0;
                }
                sw.Stop();
                result[time] = sw.ElapsedTicks / (Stopwatch.Frequency / (1000L * 1000L));
                // Console.WriteLine(((result[time])/1E3) + "mS");
            }
            long sum = 0;
            foreach (long d in result) sum += d;
            double average = sum / result.Length;
            Console.WriteLine("Total time = " + string.Format("{0:0.##E+0}", (result.Sum()/1E6)) + " S exc " + result.Length.ToString() + "time");
            Console.WriteLine("avg = " + string.Format("{0:0.##E+0}",(average/1E6 )) + " S");
            Console.WriteLine("min = " + string.Format("{0:0.##E+0}", (result).Min()/1E6 ) + " S");
            Console.WriteLine("max = " + string.Format("{0:0.##E+0}", (result).Max()/1E6 ) + " S");
        }
    }
}