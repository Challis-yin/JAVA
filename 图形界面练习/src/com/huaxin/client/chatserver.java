package com.huaxin.client;
import java.net.*;
import java.io.*;
public class chatserver {
			public static void main (String[] arg)throws Exception { 
		    // �Ƿ�ɹ���������� 
		    boolean isStart = false; 
		    // �����socket 
		    ServerSocket ss = null; 
		    // �ͻ���socket 
		    Socket socket = null; 
		    // ����˶�ȡ�ͻ������������� 
		    DataInputStream dataInputStream = null; 
		    try { 
		      // ���������� 
		      ss = new ServerSocket(6667); 
		    } catch (BindException e) { 
		      System.out.println("�˿�����ʹ����"); 
		      // �رճ��� 
		      System.exit(0); 
		    } catch (Exception e) { 
		      e.printStackTrace(); 
		    } 
		    try { 
		      isStart = true; 
		      while (isStart) { 
		        boolean isConnect = false; 
		        // �������� 
		        socket = ss.accept(); 
		        System.out.println("one client connect"); 
		        isConnect = true; 
		        while (isConnect) { 
		          // ��ȡ�ͻ��������� 
		          dataInputStream = new DataInputStream( 
		              socket.getInputStream()); 
		          // ��ȡ�ͻ��˴��ݵ����� 
		          String message = dataInputStream.readUTF(); 
		          System.out.println("�ͻ���˵��" + message); 
		        } 
		      } 
		    } catch (EOFException e) { 
		      System.out.println("client closed!"); 
		    } catch (Exception e) { 
		      e.printStackTrace(); 
		    } finally { 
		      // �ر������Դ 
		      try { 
		        dataInputStream.close(); 
		        socket.close(); 
		      } catch (IOException e) { 
		        e.printStackTrace(); 
		      } 
		    } 
		  } 
		
}
