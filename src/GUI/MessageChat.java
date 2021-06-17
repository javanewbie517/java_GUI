package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Describe
 * Created by sxf on 2021/5/18$
 */
public class MessageChat extends JPanel {
      JPanel interfacePanel;

      JPanel userPanel;

     JLabel userLable;

      JComboBox userComboBox;

     JPanel messagePanel;

     JLabel sendJlabel;

      JLabel messageJlabel;

     JButton sendButton;

     JTextField messageText;

     JTabbedPane textTabbedPane;

      JScrollPane publicScrollPane;

      JTextPane   publicTextPane;
     String publicText;
     JScrollPane privateScrollPane;
      JTextPane privateTextPane;
      String privateText;
      JButton registButton;
    JButton refreshButton;  //刷新
    JLabel active;
    JTextField num;//显示在线人数


      JTextPane choose=new JTextPane();
      int ch=0;

    Set userSet=new HashSet();

    public MessageChat() {
        interfacePanel=new JPanel();
        interfacePanel.setLayout(null);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu[] menus = { new JMenu("File"), new JMenu( "Action") };//主菜单
        JMenuItem[] items = { new JMenuItem( "Save"), new JMenuItem("Exit") };

        //菜单
        menus[0].add(items[0]);
        menus[0].add(items[1]);
        jMenuBar.add(menus[0]);
        jMenuBar.add(menus[1]);
        //聊天记录显示
        publicTextPane = new JTextPane();
        privateTextPane = new JTextPane();

        publicScrollPane = new JScrollPane( publicTextPane);
        privateScrollPane = new JScrollPane(privateTextPane);

        publicTextPane . setEditable(false);
        privateTextPane. setEditable(false);




        registButton=new JButton("注册");

        active = new JLabel("当前在线人数:");
        num= new JTextField(10);//输入框
        num.setBackground(Color.white);
        num.setText("1");
        num.setHorizontalAlignment(JTextField.CENTER);

         refreshButton = new JButton("刷新");

        //2p窗口
        textTabbedPane = new JTabbedPane();
        textTabbedPane. addTab(" public", publicScrollPane);
        textTabbedPane . addTab(" private", privateScrollPane);
        textTabbedPane.setTabPlacement(JTabbedPane. BOTTOM);



        sendJlabel=new JLabel("Send to");


        userComboBox = new JComboBox();
        userSet.add("public");

        //初始化只有一个public
        userComboBox . addItem("public");


        messageJlabel = new JLabel( "Message:");

        messageText = new JTextField(39);//输入框

        sendButton = new JButton( "Send");


        jMenuBar.setBounds(0,0,140,50);
        registButton.setBounds(150,10,105,30);
        active.setBounds(330,10,200,40);
        num.setBounds(450,15,40,30);
        num.setEditable(false);
        textTabbedPane.setBounds(0,50,600,400);
        sendJlabel.setBounds(0,450,100,50);
        userComboBox.setBounds(100,450,400,50);

        refreshButton.setBounds(500,450,100,50);

        messageJlabel.setBounds(0,500,100,50);
        messageText.setBounds(100,500,400,50);
        sendButton.setBounds(500,500,100,50);

        //字体
        menus[0].setFont(new Font("宋体",0,22));
        menus[1].setFont(new Font("宋体",0,22));
        items[0].setFont(new Font("宋体",0,22));
        items[1].setFont(new Font("宋体",0,22));
        active.setFont(new Font("宋体",0,17));
        textTabbedPane.setFont(new Font("宋体",0,22));
        sendJlabel.setFont(new Font("宋体",0,22));
        userComboBox.setFont(new Font("宋体",0,22));
        registButton.setFont(new Font("宋体",0,22));
        refreshButton.setFont(new Font("宋体",0,22));
        messageJlabel.setFont(new Font("宋体",0,22));
        sendButton.setFont(new Font("宋体",0,22));

        interfacePanel.add(jMenuBar);
        interfacePanel.add(registButton);
        interfacePanel.add(active);
        interfacePanel.add(num);
        interfacePanel. add( textTabbedPane, BorderLayout.CENTER) ;
        interfacePanel.add(sendJlabel);
        interfacePanel.add(userComboBox);
        interfacePanel.add(refreshButton);
        interfacePanel.add(messageJlabel);
        interfacePanel.add(messageText);
        interfacePanel.add(sendButton);


    }

}
