import java.text.SimpleDateFormat;
import java.util.Date;

public class your
{
    public static int testDteCompare(String s, String s1)  {
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = sf.parse(s);
            Date date2 = sf.parse(s1);
            return date1.compareTo(date2);
            }catch (Exception exception)
        {
            return 0;
        }
    }
    public static void main(String[] args)
    {
        System.out.println(testDteCompare("2009-12-31 09:31:21","2009-10-30 10:13:30"));
    }

}