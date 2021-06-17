package GUI;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Enumeration;

public class MyFrame {
  static MessageChat client = new MessageChat();
  static  String localname="public";
 static  String globalmessage="$public$";
 static  String activeNumber="1";



    public static void init() {
      JFrame frameClient = new JFrame("ChatClient");
      Container container1 = frameClient.getContentPane();
      container1.add(client.interfacePanel, BorderLayout.CENTER);
      frameClient.setSize(new Dimension(600, 600));
      frameClient.setLocation(600,300);

    // 增加注册用户的监听器
    client.registButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // 创建 弹出菜单 对象
            JDialog jDialog = new JDialog();
            Container container = jDialog.getContentPane();

            JTextField username = new JTextField(20);
            username.setBounds(50, 50, 200, 30);

            JLabel jLabel = new JLabel("输入你的名字:");
            jLabel.setBounds(70, 0, 150, 50);

            JButton jButton = new JButton("确定");
            jButton.setBounds(100, 100, 100, 30);

            jButton.addActionListener(
                new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    String usernameText = username.getText();

                        client.userSet.add(usernameText);
                        localname = usernameText;
                        client.userComboBox.addItem(usernameText); // 添加到下拉列表
                        frameClient.setTitle(localname);


                    jDialog.dispose();
                  }
                });

            container.setLayout(null);
            container.add(jLabel);
            container.add(username);
            container.add(jButton);

            jDialog.setResizable(false);
            jDialog.setVisible(true);
            jDialog.setBounds(650, 350, 300, 200);
            jDialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
          }
        });

    // 刷新在线列表和在线人数
    client.refreshButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

            client.userComboBox.removeAllItems();
            updateVector(globalmessage);
              Object[] array = client.userSet.toArray();

              for (int i = 0; i <array.length; i++) {
                client.userComboBox.addItem(array[i]);
            }

            client.num.setText(activeNumber);
          }
        });

    //选择要发消息的对象
    client.userComboBox.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
               if("public".equals(client.userComboBox.getSelectedItem())){
                 client.ch=0;
               }
                else{//私聊
                  client.ch=1;
               }
              }
            });

    client.sendButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

            if (client.ch == 0) {
              client.choose = client.publicTextPane;
            }else  {
              client.choose = client.privateTextPane;
            }
            SimpleAttributeSet attrset = new SimpleAttributeSet();
            StyleConstants.setFontSize(attrset, 24);

            StyleConstants.setBackground(attrset, Color.LIGHT_GRAY);
            Document docsc = client.choose.getDocument(); // 获得文本
            String text = client.messageText.getText();

            sendmessage(text);
            if(text!=null&&!"".equals(text)){
                try {
                    docsc.insertString(
                            docsc.getLength(),
                            localname + ":" + text+ "\n",//本机说：
                            attrset); // 对文本进行追加
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }finally{
                    client.messageText.setText("");
                }
            }



          }
        });

    frameClient.setVisible(true);
    frameClient.setResizable(false);
    frameClient.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

  }
  static  Client1 client1 = new Client1();


  public static void main(String[] args) {
      InitGlobalFont(new Font("宋体",0,22));

    init();
    new Thread() { // 开启一个接受数据的线程
      @Override
      public void run() {
        super.run();
        String message = "";
        try {
          InputStream in = client1.getSocket().getInputStream();
          DataInputStream stream = new DataInputStream(in);
          while (true) {
            message = stream.readUTF();
            globalmessage = message;
            int index = message.indexOf("name");

            SimpleAttributeSet attrset = new SimpleAttributeSet();
            StyleConstants.setFontSize(attrset, 24);

            StyleConstants.setBackground(attrset, Color.LIGHT_GRAY);
            Document document = client.publicTextPane.getDocument();

            String submessage = message;
            String name = "";
            int index1 = message.indexOf("*");
            int index2 = message.indexOf("$");
            String accept = message.substring(index1 + 1, index2);
            name = message.substring(index + 4, index1); // 截取发送人
            int identy = message.indexOf("#");
            submessage = message.substring(identy + 1, index); // 截取消息

            activeNumber = message.substring(0, identy); // 获取在线人数

            if (accept.equals(localname) && !accept.equals("public")) { // 接收者 和本机匹配，发给本机的
              document = client.privateTextPane.getDocument();
              try {
                document.insertString( // 私聊面板
                    document.getLength(), name + ":" + submessage + "\n", attrset); // 对文本进行追加
              } catch (BadLocationException e) {
                e.printStackTrace();
              }
            } else if (!localname.equals(name)) {
              try {
                document.insertString( // 公共面板
                    document.getLength(), name + ":" + submessage + "\n", attrset); // 对文本进行追加
              } catch (BadLocationException e) {
                e.printStackTrace();
              }
            }
          }

        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }.start();
  }


  /**
   * 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
   */
  private static void InitGlobalFont(Font font) {
    FontUIResource fontRes = new FontUIResource(font);
    for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
      Object key = keys.nextElement();
      Object value = UIManager.get(key);
      if (value instanceof FontUIResource) {
        UIManager.put(key, fontRes);
      }
    }
  }


  public static  void sendmessage(String str){
    try {
      OutputStream  out = client1.getSocket().getOutputStream(); // 向服务端发送
      DataOutputStream outputStream = new DataOutputStream(out);

      str += ("name" + localname+"*"+client.userComboBox.getSelectedItem());

      int size = client.userSet.size();
        Object[] array = client.userSet.toArray();
        for (int i = 0; i < size;i++) {
        str+="$"+array[i];
      }
      str+="$";
      outputStream.writeUTF(str);

    } catch (IOException e) {
    e.printStackTrace();
  }
  }

  /**
   * 根据客户端返回的数据 更新userSet
   */
  public  static  void  updateVector(String str){

    int index1 = str.indexOf("$");
    str=str.replaceFirst("[$]","&");
    while (true){
      int index2 = str.indexOf("$");
      String substring = str.substring(index1+1, index2);
      client.userSet.add(substring);
      index1 = str.indexOf("$");
     str= str.replaceFirst("[$]","&");
      if(index1==str.length()-1)  break;
    }

  }
}
