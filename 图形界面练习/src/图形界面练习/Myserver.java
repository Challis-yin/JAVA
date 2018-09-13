package 图形界面练习;  
  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.ArrayList;  
  
public class Myserver {  
      
    //线程容器  
    public static ArrayList<ServerThread> list =new ArrayList<ServerThread>();  
    //从数据库中获取猜的信息  
    public static String []infos;  
  
    public void initServer() {  
        try {  
            /*
             * 创建服务器对象  
             */
            ServerSocket server=new ServerSocket(9090);  
            System.out.println("服务器已经启动.......");  
            while(true){  
                //循环接收客户端的连入  
                Socket socket=server.accept();  
                System.out.println("客户端已连入......");  
                //创建一个新的线程处理  
                ServerThread st = new ServerThread(socket);  
                list.add(st);  
                //当有两个客户端连入进来时，开始游戏  
                if(list.size()==2){  
                    
                    //从数据库中获取一条记录  
                    String guessinfo=" "  ;
                    infos=guessinfo.split("#");  
                    //第一个连入的是画  
                    list.get(0).name="draw";  
                    //第二个连入进来的是猜  
                    list.get(1).name="guess";  
                    //第三个连入进来的是猜  
//                    list.get(2).name="guess";  
                      
                    list.get(0).start();  
                    list.get(1).start();  
//                    list.get(2).start();  
                    System.out.println("启动线程......");  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  