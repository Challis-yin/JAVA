package ͼ�ν�����ϰ;  
  
import java.util.ArrayList;  
import java.util.Random;  
  
public class MyDataBase {  
      
    //���������  
    private static Random  r = new Random();  
      
    //�µ����ݿ⣬װҪ�µ���Ϣ  
    private static ArrayList<String> list = new ArrayList<String>();  
      
    //���ݿ�  
    static{  
        list.add("�ڹ�#һ�����ж��������");  
        list.add("����#һ��ˮ����������");  
        list.add("���ܲ�#һ���߲ˣ�������");  
        list.add("����#һ�ֶ��������");  
        list.add("����#һ��ֲ�������");  
        list.add("��#һ�ֶ��һ����");  
        list.add("����#һ��ˮ����������");  
        list.add("����#һ��ʳƷ��������");  
        list.add("ƻ��#һ��ˮ����������");  
        list.add("�۷�#һ�ֶ��������");  
        list.add("���#һ����ӣ�������");  
        list.add("���Ž���#�����������ĸ���");  
        list.add("����Ա#һ��ְҵ��������");  
        list.add("�ʼǱ�����#һ�ֵ����豸�������");  
        list.add("���#�����������");  
        list.add("��ֻ����#��ʳƷ�ƣ��ĸ���");  
        list.add("������#һ���˶����ƣ�������");  
        list.add("��Զ#һ���˶���������");  
        list.add("����#һ�ֶ��������");  
        list.add("���#һ�����࣬������");  
    }  
      
    //��������ݿ��л�ȡһ����Ϣ  
    public  String getInfo() {  
        int i=r.nextInt(list.size());  
        System.out.println("suijishu wei "+i);  
        return list.get(i);  
  
    }  
}  