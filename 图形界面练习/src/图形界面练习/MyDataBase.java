package 图形界面练习;  
  
import java.util.ArrayList;  
import java.util.Random;  
  
public class MyDataBase {  
      
    //随机产生数  
    private static Random  r = new Random();  
      
    //猜的数据库，装要猜的信息  
    private static ArrayList<String> list = new ArrayList<String>();  
      
    //数据库  
    static{  
        list.add("乌龟#一种爬行动物，两个字");  
        list.add("梨子#一种水果，两个字");  
        list.add("胡萝卜#一种蔬菜，三个字");  
        list.add("菜鸟#一种动物，两个字");  
        list.add("大树#一种植物，两个字");  
        list.add("猪#一种动物，一个字");  
        list.add("葡萄#一种水果，两个字");  
        list.add("辣条#一种食品，两个字");  
        list.add("苹果#一种水果，两个字");  
        list.add("蜜蜂#一种动物，两个字");  
        list.add("岑祚江#一条大河，三个字");  
        list.add("华信教育#教育机构，四个字");  
        list.add("程序员#一种职业，三个字");  
        list.add("笔记本电脑#一种电子设备，五个字");  
        list.add("鼠标#配件，两个字");  
        list.add("三只松鼠#零食品牌，四个字");  
        list.add("马拉松#一项运动名称，三个字");  
        list.add("跳远#一项运动，两个字");  
        list.add("兔子#一种动物，两个字");  
        list.add("凤凰#一种鸟类，两个字");  
    }  
      
    //随机从数据库中获取一条消息  
    public  String getInfo() {  
        int i=r.nextInt(list.size());  
        System.out.println("suijishu wei "+i);  
        return list.get(i);  
  
    }  
}  