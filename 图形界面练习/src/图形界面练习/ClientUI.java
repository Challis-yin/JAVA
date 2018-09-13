package 图形界面练习;  
  
import java.awt.BasicStroke;  
import java.awt.BorderLayout;  
import java.awt.Color;  
import java.awt.Dimension;  
import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.Label;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;  
import java.awt.event.MouseMotionListener;  
import java.io.IOException;  
import java.net.Socket;  
import java.net.UnknownHostException;  
  
import javax.swing.ButtonGroup;  
import javax.swing.JButton;  
import javax.swing.JComboBox;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JOptionPane;  
import javax.swing.JPanel;  
import javax.swing.JScrollPane;  
import javax.swing.JTextArea;  
import javax.swing.JTextField;  
  
public class ClientUI extends JFrame {  
    public static ClientUI iii;
    static int i = 0;
    public JButton sendBtn;  
    public JLabel contant;  
    public JPanel drawPanel;  
    public JPanel colorPanel;  
    public JPanel waitPanel;  
    public JPanel drawLeftPanel;  
    public JPanel centerPanel;  
    public JTextField jtf;  
    public JTextArea jta;  
    public Graphics2D g;
    public Color color;  
    public ClientCtroller control;  
    public static Socket socket;  
    public int x1, y1;  
    public BasicStroke strock;  
    public JComboBox<Integer> box;
    public JButton qingkong;
  
    //初始化界面的时候开始创建客户端对象  
    public ClientUI() {  
        try { 
            socket = new Socket("127.0.0.1", 9090);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static void main(String[] args) {  
        ClientUI ui = new ClientUI();  
        ui.initFrame();  
    }  
  
    public void initFrame() {  
  
        this.setTitle("你画我猜");  
        this.setSize(700, 500); 
        this.setLocationRelativeTo(null);  
        // 总的面板  
        // 等待面板  
        waitPanel = new JPanel();  
        waitPanel.setBackground(Color.yellow);  
        JLabel label = new JLabel("正在等待加入》》》》》》》》");  
        waitPanel.add(label);  
        this.add(waitPanel);  
        // 画的面板  
//      addDrawPanel();  
//      addGuessPanel();  
        this.setVisible(true);  
        /*
         * ************创建客户端控制器对象  
         */
        control = new ClientCtroller(socket, this);  
        control.dealwith();
    }  
  
   
    
    //添加画面板的函数  
    public void addDrawPanel() {  
        drawPanel = new JPanel();  
        drawPanel.setLayout(new BorderLayout());  
        // 画面板的左右子面板  
        drawLeftPanel = new JPanel();  
        drawLeftPanel.setLayout(new BorderLayout());  
          
        //左边板的中间面板  
        centerPanel = new JPanel();  
        centerPanel.setBackground(Color.WHITE);  
        //左面板下的颜色面板  
        colorPanel = new JPanel();  
          
        //给颜色面板设置空布局  
        colorPanel.setLayout(null);  
        colorPanel.setBackground(Color.gray);  
        colorPanel.setPreferredSize(new Dimension(0,60));  
          
        //颜色面板的颜色按钮  
        Color [] colors={Color.red,Color.black,Color.orange,Color.green,  
                Color.white,Color.blue,Color.cyan,Color.magenta,Color.YELLOW};  
          
        //清空按钮的添加
        qingkong = new JButton("清空");
        
        
        /**
         * 颜色按钮添加  
         */
        ActionListener btnlistener = new ActionListener() {  
              
            public void actionPerformed(ActionEvent e) {  
                  if(e.getActionCommand()=="清空") {
                	  repaint();  
                	  i++;
                	  int width=(int)box.getSelectedItem();  
                      strock = new BasicStroke(width);  
                      g.setStroke(strock);  
                        
                      int x2 = 0;  
                      int y2 = 0;  
                      g.drawLine(x1, y1, x2, y2);  
//                    x1 = x2;  
//                    y1 = y2;  
                      try {  
                            
                          control.sendMsg1(socket.getOutputStream(), x1, y1, x2, y2,g.getColor().getRGB(),width,i);  
                          x1 = x2;  
                          y1 = y2;  
                      } catch (IOException e1) {  
                      }  
                  }
                  else {
                JButton bt =(JButton)e.getSource();  
                color =bt.getBackground();  }
            }  
        };  
        for (int i = 0; i < colors.length; i++) {  
            JButton btn = new JButton();  
            btn.setBackground(colors[i]);  
            btn.addActionListener(btnlistener);  
            btn.setBounds(40+i*30, 15, 30, 30);  
            colorPanel.add(btn);  
        }  
          qingkong.setBounds(315, 15, 60, 30);
          qingkong.addActionListener(btnlistener);
        //添加画笔粗细  
        box =new JComboBox<Integer>();  
        box.setBounds(380, 15, 80, 30);  
        for (int i = 0; i < 10; i++) {  
            Integer intdata = new Integer(i+1);  
            box.addItem(intdata);  
        }  colorPanel.add(qingkong);
        colorPanel.add(box); 
        
          
        JPanel drawRightPanel = new JPanel();  
  
        drawRightPanel.setLayout(new BorderLayout());  
        drawRightPanel.setPreferredSize(new Dimension(200, 0));  
        // 右面板的的下面板  
        JPanel buttonPanel = new JPanel();  
        buttonPanel.setPreferredSize(new Dimension(0, 50));  
        jta = new JTextArea();  
        jta.setLineWrap(true);  
        JScrollPane jsp = new JScrollPane(jta);  
        jtf = new JTextField(11);  
        contant = new JLabel();  
        sendBtn = new JButton();  
        sendBtn.setText("发送");
        sendBtn.setEnabled(true);
        sendBtn.addActionListener(al);  
        buttonPanel.add(jtf);  
        buttonPanel.add(sendBtn);  
  
        drawRightPanel.add(jsp);  
        drawRightPanel.add(buttonPanel, BorderLayout.SOUTH);  
  
        contant.setPreferredSize(new Dimension(0, 20));  
        drawLeftPanel.add(contant, BorderLayout.NORTH);  
        drawLeftPanel.add(centerPanel, BorderLayout.CENTER);  
        drawLeftPanel.add(colorPanel, BorderLayout.SOUTH);  
        drawPanel.add(drawLeftPanel);  
        drawPanel.add(drawRightPanel, BorderLayout.EAST);  
        this.add(drawPanel);  
        centerPanel.addMouseListener(ma);  
        centerPanel.addMouseMotionListener(ma);  
        this.setVisible(true);  
        g = (Graphics2D)centerPanel.getGraphics();  
    }  
      
    //添加猜面板的函数  
    public void addGuessPanel() {  
 //       sendBtn.setEnabled(false);  
        drawLeftPanel.remove(colorPanel);  
        drawLeftPanel.repaint();  
        this.setVisible(true);  
    }  
  
    
    MouseAdapter ma = new MouseAdapter() {  
          
        public void mousePressed(MouseEvent e) {  
            x1 = e.getX();  
            y1 = e.getY();  
        };  
          
        public void mouseEntered(MouseEvent e) {  
            if(color==null){  
                color=Color.black;  
            }  
              
//          System.out.println(i);  
            g.setColor(color);  
              
        };  
  
        public void mouseDragged(MouseEvent e) {  
            int width=(int)box.getSelectedItem();  
            strock = new BasicStroke(width);  
            g.setStroke(strock);  
              
            int x2 = e.getX();  
            int y2 = e.getY();  
            g.drawLine(x1, y1, x2, y2);  
//          x1 = x2;  
//          y1 = y2;  
            try {  
                  
                control.sendMsg1(socket.getOutputStream(), x1, y1, x2, y2,g.getColor().getRGB(),width,i);  
                x1 = x2;  
                y1 = y2;  
            } catch (IOException e1) {  
            }  
        };  
          
    };  
      
    //发送监听器  
    ActionListener al =new ActionListener() {  
          
        public void actionPerformed(ActionEvent e) {  
            //获取发送框的内容  
            String str = jtf.getText();  
            if(str==null || str.equals("")){  
                JOptionPane.showMessageDialog(null, "发送内容不能为空！");  
            }else{  
                try {  
                control.dos.writeUTF(str);  
                jtf.setText("");  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
                  
        }  
    };  
  
}  