package 图形界面练习;  
  
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.net.Socket;  
  
public class ServerThread extends Thread {  
  
    public Socket socket;  
    //线程名字  
    public String name;  
    //输入输出流  
    public DataInputStream dis;  
    public DataOutputStream dos;  
  
    public ServerThread(Socket socket) {  
        this.socket = socket;  
    }  
  
    public void run() {  
          
        try {  
           /***********************************
            * 获取输入输出流  
            *********************************/
        InputStream ins=socket.getInputStream();  
        OutputStream ous =socket.getOutputStream();  
        /*
         * ******************开启线程以后，从数据库中取一条消息  
         */
        dis =new DataInputStream(ins);  
        dos = new DataOutputStream(ous);  
        /*
         * **********************如果是画的客户端  
         */
        if("draw".equals(name)){  
                /*
                 * *******************发送画的消息给客户端  
                 */
                sendMsg(socket.getOutputStream(), "draw");  
//              System.out.println("已发送draw");  
                /*
                 * *****************发送要画的信息给画的客户端  
                 */
                dos.writeUTF("");  
                /*
                 ******************* 循环收客户端画的消息  
                 */
                while(true){  
                        int x1=dis.readInt();  
                        int y1=dis.readInt();  
                        int x2=dis.readInt();  
                        int y2=dis.readInt();  
                        int color =dis.readInt();  
                        int width=dis.readInt(); 
                        int x = dis.readInt();
                        //将该信息转发给猜的客户端  
                        for (int i = 0; i <Myserver.list.size(); i++) {  
                            ServerThread st =Myserver.list.get(i);  
                            if(st!=this){  
                                //发送头部数据信息  
                                sendMsg(st.socket.getOutputStream(), "data");  
                                //发送坐标信息  
                                sendMsg1(st.socket.getOutputStream(), x1, y1, x2, y2,color,width,x);  
                            }  
                        }  
                }  
            }  
          
          
        if("guess".equals(name)){  
                //发送猜消息给客户端  
                sendMsg(ous, "guess");  
                System.out.println("已发送guess");  
                //将提示信息发送给猜的客户端  
                dos.writeUTF(" ");  
                while(true){  
                    //不断接收猜的客户端发送过来的消息  
                    String msg=dis.readUTF();  
                      
                    System.out.println("服务器端接受的信息为："+msg);  
                      
                    //给每个客户端发送消息头部数据  
                    for (int i = 0; i <Myserver.list.size(); i++) {  
                        ServerThread st =Myserver.list.get(i);  
                        sendMsg(st.socket.getOutputStream(), "msg");  
                    }  
                      
                    //如果某个猜线程猜对了  
                        if(Myserver.infos[0].equals(msg)){  
                              
                            Myserver.list.get(0).dos.writeUTF("yes");  
                              
                            this.dos.writeUTF("yes");  
                              
                            this.dos.writeUTF("我说:"+msg);  
                              
                            System.out.println("已经发送yes");  
                        }else{  
                              
                            for (int i = 0; i <Myserver.list.size(); i++) {  
                                ServerThread st =Myserver.list.get(i);  
                                if(st==this){  
                                    st.dos.writeUTF("我说:"+msg);  
                                }  
                                else{  
                                    st.dos.writeUTF("他说:"+msg);  
                                }  
                            }  
                              
                            System.out.println("服务器端已发送数据"+msg);  
                        }  
                }  
            }  
        }catch (Exception e) {
        	try {
				System.out.println(" ");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            e.printStackTrace();  
        }  
    }  
  
    // 发送消息的函数  
    public void sendMsg(OutputStream os, String s) throws IOException {  
   
        byte[] bytes = s.getBytes();  
        os.write(bytes);  
        os.write(13);  
        os.write(10);  
        os.flush();  
  
    }  
  
    /*
     * ************************** 读取客户端输入数据的函数  
     */
    public String readMsg(InputStream ins) throws Exception {  
        // 读取客户端的信息  
        int value = ins.read();  
        /*
         * ********** 读取整行 读取到回车（13）换行（10）时停止读  
         */
        String str = "";  
        while (value != 10) {  
            /*
             * ************* 点击关闭客户端时会返回-1值  
             */
            if (value == -1) {  
            	Myserver.list.clear();
            	ClientUI.socket.close();
                throw new Exception();  
            }  
            str = str + ((char) value);  
            value = ins.read();  
        }  
        str = str.trim();  
        return str;  
    }  
      
    // 发送坐标的函数  
        public void sendMsg1(OutputStream os, int x1, int y1, int x2, int y2,int color ,int width,int x) throws IOException {  
  
            DataOutputStream dos = new DataOutputStream(os);  
            dos.writeInt(x1);  
            dos.writeInt(y1);  
            dos.writeInt(x2);  
            dos.writeInt(y2);  
            dos.writeInt(color);  
            dos.writeInt(width);  
            dos.writeInt(x);
            dos.flush();  
        }  
}  