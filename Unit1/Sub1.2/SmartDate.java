/**
 * Author: Sangs
 * Date:2020.12.22
 * Function:《算法》P71 1.2.11
 * Questiion:根据Date的API实现一个SmartDate类型，在日期非法时抛出一个异常
 */
public class SmartDate {
    private final int value;

    public SmartDate(int y, int m, int d){
        if(y < 0 || m < 1 || m > 12 || d < 1 || d > 31) throw new IllegalArgumentException("date err");

        if((m == 4 || m == 6 || m == 9 || m == 11) && d > 30)
            throw new IllegalArgumentException("day err");
        if(m == 2 && d > 29) throw new IllegalArgumentException("day err");
        if((y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) && d > 28)
            throw new IllegalArgumentException("day err");
        value = y * 512 + m * 32 + d;
    }
    
    public int year()
    {return value / 512;}
    
    public int month()
    {return (value / 32) % 16;}

    public int day()
    {return value % 32;}

    public String toString(){
        return year() + "/" + month() + "/" + day();
    }

}
