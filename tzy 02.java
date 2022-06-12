import java.util.Random;
import java.util.Scanner;

class polynomial{
    private int num;
    private int count = 1;
    public void setnum(){
        System.out.println("请输入需要生成的四则运算题目数量");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        sc.close();
    }//设置四则运算题目数量
    public void getpolynomial(){
        int x,y,z;
        System.out.println("总计需生成"+num+"道四则运算题目");
        Random r = new Random();
        while(count<=num){
            x=r.nextInt(100)+1;
            y=r.nextInt(100)+1;
            z=r.nextInt(100)+1;
            char operator1=getoperator();
            char operator2=getoperator();
            double result1=getresult(x,y,operator1);
            double result2=getresult(result1,z,operator2);
            if (result2<0) {
                continue;
            }
            String str = String.format("%.2f",result2);//保留两位小数
            System.out.println("第"+count+"道题:("+x+operator1+y+")"+operator2+z+"="+str);
            count+=1;
        }
    }//四则运算题目及答案
    //姜徵岑编写部分
    private double getresult(double x,double y,char operator){
        double result=0;
        switch(operator){
            case '+':
                result=x+y;
                break;
            case '-':
                result=x-y;
                break;
            case '*':
                result=x*y;
                break;
            case '/':
                result=x/y;
                break;
            default:
                break;
        }
        return result;
    }//获取结果方法
    private char getoperator(){
        char operator=' ';
        Random r = new Random();
        int i;
        i=r.nextInt(4)+1;
        switch (i) {
            case 1:
                operator='+';
                break;
            case 2:
                operator='-';
                break;
            case 3:
                operator='*';
                break;
            case 4:
                operator='/';
                break;
            default:
                break;
        }
        return operator;
    }//获取运算符方法
}
public class JZC02 {
    public static void main(String[] args) {
        polynomial poly = new polynomial();
        poly.setnum();
        poly.getpolynomial();
    }
}
//熊雄编写部分