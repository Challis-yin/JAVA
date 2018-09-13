package 文件传输;

import java.net.*;
import java.io.*;

public class FileSentS extends ServerSocket {
	private static final int Port = 8899;
	public FileSentS ()throws Exception {
		super(Port);
	}
	public void load() throws Exception{
		while(true) {
			Socket socket = this.accept();
			new Thread(new Task(socket)).start();
		}
	}
	class Task implements Runnable{
		private Socket socket;
		private DataInputStream dis;
		private FileOutputStream fos;
		public Task(Socket s) {
			socket = s;
		}
		public void run() {
			try {
				dis = new DataInputStream(socket.
						getInputStream());
				String fileName = dis.readUTF();
				long fileLength = dis.readLong();
				File directory = new File("F:\\触不可及");
				if(!directory.exists()) {
					directory.mkdirs();
				}
				File file = new File(directory.getAbsolutePath()
						+File.separatorChar+fileName);
				fos = new FileOutputStream(file);
				
				byte[] bytes = new byte[1024];
				int length = 0;
				while((length = dis.read(bytes,0,
						bytes.length))!=-1) {
					fos.write(bytes, 0, length);
					fos.flush();
				}
				System.out.println("文件接收成功");
			}
			catch(Exception e){
				System.out.println(e.getStackTrace());
			}
			finally {
				try {
					if(fos != null) {
						fos.close();
					}
					if(dis !=null) {
						dis.close();
					}
					socket.close();
				}
				catch(Exception e) {
					System.out.println("ERROR !");
				}
			}
		}
		
	}
	public static void main(String[] args) {
		try {
			System.out.println("start");
			FileSentS server = new FileSentS();
			server.load();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}







