package 文件传输;
import java.net.*;
import java.io.*;
import java.util.*;
public class FileSentC extends Socket{
	private static final String IP = "127.0.0.1";
	private static final int Port = 8899;
	private Socket client;
	private FileInputStream fis;
	private DataOutputStream dos;
	private String dirctory;
	
	public FileSentC(String g) throws Exception{
		super(IP,Port);
		this.client = this;
		dirctory = g;
		System.out.println("连接成功！");
	}
	public void sendFile() throws Exception {  
        try {  
            File file = new File(dirctory);  
            if(file.exists()) {  
                fis = new FileInputStream(file);  
                dos = new DataOutputStream(client.getOutputStream());  
  
                // 文件名和长度  
                dos.writeUTF(file.getName());  
                dos.flush();  
                dos.writeLong(file.length());  
                dos.flush();  
  
                // 开始传输文件  
                System.out.println("======== 开始传输文件 ========");  
                byte[] bytes = new byte[1024];  
                int length = 0;  
                long progress = 0;  
                while((length = fis.read(bytes, 0, bytes.length)) != -1) {  
                    dos.write(bytes, 0, length);  
                    dos.flush();  
                    progress += length;  
                    System.out.print("| " + (100*progress/file.length()) + "% |");  
                }  
                System.out.println();  
                System.out.println("======== 文件传输成功 ========");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if(fis != null)  
                fis.close();  
            if(dos != null)  
                dos.close();  
            client.close();  
        }  
    }
	public static void main(String[] args) {
		try {
			System.out.println("输入文件地址");
			Scanner in = new Scanner(System.in);
			FileSentC cli = new FileSentC(in.next());
			cli.sendFile();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}












