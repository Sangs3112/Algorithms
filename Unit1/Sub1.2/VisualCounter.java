import edu.princeton.cs.algs4.StdDraw;

/**
 * Author: Sangs Date:2020.12.22 Function:《算法》P71 1.2.10
 * Questiion:编写一个类VisualCounter，支持加一和减一操作。它的构造函数接收两个参数N和max
 * 其中N指定了最大操作次数，max指定了计数器的最大绝对值。 作为副作用，用图像显示每次计数器变化后的值
 */
public class VisualCounter{
    private final int maxOpt;
    private final int maxCount;
    private int opt;
    private int count;

    public VisualCounter(int N, int max){
        maxOpt = N;
        maxCount = max;
    }

    public void increment(){
        if(opt < maxOpt && Math.abs(count) < maxCount){
            opt++;
            count++;
        }
    }

    public void decreament(){
        if(opt < maxOpt && Math.abs(count) < maxCount){
            opt++;
            count--;
        }
    }

    public int tally()
    {return count;}

    public int optTimes()
    {return opt;}

    public boolean isEnd()
    {return opt>=maxOpt || Math.abs(count) >= maxCount;}

    public void Draw(){
        StdDraw.setXscale(0,maxOpt);
        StdDraw.setYscale(-1.0*maxCount, maxCount);
        StdDraw.setPenRadius(0.01);
        StdDraw.point(opt, count);
    }
}
