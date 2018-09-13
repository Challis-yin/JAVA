package ͼ�ν�����ϰ;
import javax.imageio.ImageIO;  
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.awt.image.*;  
import java.io.*;  
public class jieping {
	public static void main(String[] args)   
    {  
        new NewFrame();  
    }  
}  
class NewFrame extends JFrame  
{  
	ScreenFrame sf;
	public static int i = 0;
    private static final long serialVersionUID = 1L;  
    /* 
     * ����һ��С�Ĵ��ڡ������ť�������� 
     */  
    JButton button;  
    NewFrame()  
    {  
        setVisible(true);  
        setLayout(new FlowLayout());  
        setBounds(1000, 600, 100, 100);  
        setResizable(false);  
        button = new JButton("��ͼ");  
        add(button);  
        button.addActionListener(new ActionListener()  
                {//�������ť��new һ��ScreenFrame�����ÿɼ���  
                    public void actionPerformed(ActionEvent e)   
                    {  
                        sf = new ScreenFrame("kkkk");  
//                        sf.setAlwaysOnTop(true);  
//                        sf.setUndecorated(true);  
                        sf.setVisible(true); 
                        if(i>0) {
                        	sf.setUndecorated(false); 
                        	sf.setAlwaysOnTop(false);
                        	sf.setVisible(false);
                        }
                    }  
                });  
        addWindowListener(new WindowAdapter()  
                {  
                    public void windowClosing(WindowEvent e)  
                    {  
                    	
                    	setVisible(false);
                    }  
                }); 
        sf.setVisible(false);
    }  
}  
class ScreenFrame extends JFrame  
{  
    private static final long serialVersionUID = 2L;  
    /* 
     * ����һ��ȫ���Ĵ��ڣ���ȫ����ͼ�����JFrame�Ĵ����ϣ��Թ��������� 
     */  
    Dimension di = Toolkit.getDefaultToolkit().getScreenSize();  
    ScreenFrame(String k)  
    {  
        //���ô�С����ȫ��  
    	setTitle(k);
        setSize(di);  
        //���ش˴���� contentPane����   
        getContentPane().add(new DrawRect());  
        if(NewFrame.i>0) this.setVisible(false);
    }  
  
    class DrawRect extends JPanel implements MouseMotionListener, MouseListener  
    {  
        private static final long serialVersionUID = 3L;  
        /* 
         * ��ȫ����ͼ�����JPanel �ϣ� ����ͨ��new DrawRect�����JPanel������JPanel����ȫ��ͼ�� 
         */  
        int sx, sy, ex, ey;  
        int count = 1;  
        File file = null;  
        BufferedImage image, getImage;  
        boolean flag = true;  
        public DrawRect()  
        {  
            try  
            {//��ȡȫ��ͼ�����ݣ����ظ�image  
                Robot robot = new Robot();  
                image = robot.createScreenCapture(new Rectangle(0, 0, di.width, di.height));  
            }  
            catch(Exception e)  
            {  
                throw new RuntimeException("��ͼʧ��");  
            }  
            //��� ����¼�  
            addMouseListener(this);  
            addMouseMotionListener(this);  
        }  
        //��дpaintComponent��ͨ��repaint ��ʾ���������ķ�Χ  
        public void paintComponent(Graphics g)  
        {  
            g.drawImage(image, 0, 0, di.width, di.height, this);  
            g.setColor(Color.blue);  
            if(sx < ex && sy < ey)//���½�  
                g.drawRect(sx, sy, ex - sx, ey - sy);  
            else                 //���Ͻ�  
                g.drawRect(ex, ey, sx - ex, sy - ey);  
        }  
        //���¶�������¼�  
        public void mouseClicked(MouseEvent e)  
        {  
            if(e.getButton() == MouseEvent.BUTTON3)//�Ҽ��˳�����  
                System.exit(0);  
            else if(e.getClickCount() == 2)   //˫������  
            {  
                try  
                {  
                    cutScreens(); 
                    if(NewFrame.i>0) this.setVisible(false);
                }  
                catch(Exception ex)  
                {  
                    ex.printStackTrace();  
                }  
            }  
        }  
        //�Զ����������  
        private void cutScreens() throws Exception  
        {  
            Robot ro = new Robot();  
            if(sx < ex && sy < ey)//���½�  
                getImage = ro.createScreenCapture(new Rectangle(sx, sy, ex - sx, ey - sy));  
            else                  //���Ͻ�  
                getImage = ro.createScreenCapture(new Rectangle(ex, ey, sx - ex, sy - ey));  
            String name = "jietu" + count + ".bmp";  
            file = new File("f:\\�����ɼ�", name);  
            while(file.exists())  
            {  
                String na = "jietu" + (count++) + ".bmp";  
                file = new File("f:\\�����ɼ�", na);  
            }  
            ImageIO.write(getImage, "bmp", file);  
//            this.getParent().setVisible(false);
            
           NewFrame.i++;
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }  
        public void mousePressed(MouseEvent e)  
        {  
            if(flag)  
            {  
                sx = e.getX();  
                sy = e.getY();  
            }  
        }  
        public void mouseReleased(MouseEvent e)   
        {  
            flag = false;  
        }  
        public void mouseEntered(MouseEvent e) {}  
        public void mouseExited(MouseEvent e)   {}  
        //����ƶ��У�ͨ��repaint ����Ҫ�����ķ�Χ  
        public void mouseDragged(MouseEvent e)   
        {  
            ex = e.getX();  
            ey = e.getY();  
            repaint();  
        }  
        public void mouseMoved(MouseEvent e) {}  
    }  
}
