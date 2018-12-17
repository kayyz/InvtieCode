
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName CodeUtils
 * @Description TODO
 * @Author linyi
 * @Date 2018/12/17 
 **/
public class CodeUtils {

    private static final char[] r = new char[] { 'Q', 'W', 'E', '8', 'A', 'S', '2', 'D', 'Z', 'X', '9', 'C', '7', 'P', 'O', '5', 'I', 'K', '3', 'M', 'J', 'U', 'f', 'R', '4', 'V', 'Y', 'L', 'T', 'N', '6', 'B', 'G', 'H' };
    /**自动补全组(不能与自定义进制有重复)*/
    private static final char[] b = new char[] { 'Q', 'W', 'E', 'A', 'S', 'D', 'Z', 'X', 'C', 'P', 'O', 'I', 'K', 'M', 'J', 'U', 'F', 'R', 'V', 'Y', 'T', 'N', 'B', 'G', 'H','9','8','6','1','4','2','5','3','0','7' };
    /**进制长度*/
    private static final int l = r.length;
    /**序列最小长度*/
    private static final int s = 6;

    /**
     * 根据ID生成六位随机码
     * @param num ID
     * @return 随机码
     */
    public static String toSerialNumber(long num) {
        char[] buf = new char[32];
        int charPos = 32;

        while ((num / l) > 0) {
            buf[--charPos] = r[(int) (num % l)];
            num /= l;
        }
        buf[--charPos] = r[(int) (num % l)];
        String str = new String(buf, charPos, (32 - charPos));
        //不够长度的自动随机补全
        if (str.length() < s) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s - str.length(); i++) {
                sb.append(b[ThreadLocalRandom.current().nextInt(34)]);
            }
            str += sb.toString();
        }
        return str;
    }

    public static  void main(String args[]){
        System.out.println("邀请码:"+toSerialNumber(666));
    }
}
