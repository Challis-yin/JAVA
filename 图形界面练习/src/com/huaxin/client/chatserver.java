package com.huaxin.client;
import java.net.*;
import java.io.*;
public class chatserver {
			public static void main (String[] arg)throws Exception { 
		    // 是否成功启动服务端 
		    boolean isStart = false; 
		    // 服务端socket 
		    ServerSocket ss = null; 
		    // 客户端socket 
		    Socket socket = null; 
		    // 服务端读取客户端数据输入流 
		    DataInputStream dataInputStream = null; 
		    try { 
		      // 启动服务器 
		      ss = new ServerSocket(6667); 
		    } catch (BindException e) { 
		      System.out.println("端口已在使用中"); 
		      // 关闭程序 
		      System.exit(0); 
		    } catch (Exception e) { 
		      e.printStackTrace(); 
		    } 
		    try { 
		      isStart = true; 
		      while (isStart) { 
		        boolean isConnect = false; 
		        // 启动监听 
		        socket = ss.accept(); 
		        System.out.println("one client connect"); 
		        isConnect = true; 
		        while (isConnect) { 
		          // 获取客户端输入流 
		          dataInputStream = new DataInputStream( 
		              socket.getInputStream()); 
		          // 读取客户端传递的数据 
		          String message = dataInputStream.readUTF(); 
		          System.out.println("客户端说：" + message); 
		        } 
		      } 
		    } catch (EOFException e) { 
		      System.out.println("client closed!"); 
		    } catch (Exception e) { 
		      e.printStackTrace(); 
		    } finally { 
		      // 关闭相关资源 
		      try { 
		        dataInputStream.close(); 
		        socket.close(); 
		      } catch (IOException e) { 
		        e.printStackTrace(); 
		      } 
		    } 
		  } 
		
}
