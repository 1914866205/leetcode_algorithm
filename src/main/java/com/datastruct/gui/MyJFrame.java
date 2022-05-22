package com.datastruct.gui;

/**
 * @ClassName MyJFrame
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/22 10:49
 * @Version 1.0
 **/

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
public class MyJFrame extends JFrame{

    private JFileChooser jfcFile;//文件选择框
    private JLabel jl;
    private JTextArea jta;
    private JButton jbopen;
    private JButton jbsave;
    private JButton eliminate;
    private JTextField jtf;

    public MyJFrame() {
        setTitle("文本文件操作");
        Container c = getContentPane();//创建一个容器
        jfcFile = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("文本文件","txt","ini");//文件过滤
        jfcFile.setFileFilter(filter);//设置当前文件过滤器。文件选择器使用文件过滤器从用户的视图中过滤文件。
        jl = new JLabel("文件:");
        jtf = new JTextField();
        jbopen = new JButton("打开");
        jta = new JTextArea();
        jbsave = new JButton("保存");
        eliminate = new JButton("清除");
        c.add(jl);
        c.add(jtf);
        c.add(jbopen);
        c.add(jbsave);
        c.add(jta);
        c.add(eliminate);
        jl.setBounds(10, 10, 50, 20);
        jtf.setBounds(60, 10, 250, 20);
        jta.setBounds(60, 40, 300, 200);
        jbopen.setBounds(320, 10, 70, 20);
        jbsave.setBounds(290, 280, 70, 20);
        eliminate.setBounds(10, 280, 70, 20);
        jta.setLineWrap(true);//文本域自动换行
        c.setLayout(null);
        setBounds(0, 0, 500, 400);

        jbopen.addActionListener(new ActionListener() {//‘打开’按钮事件

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jbopenAcionPerformed(e);
            }
        });
        jbsave.addActionListener(new ActionListener() {//‘保存’按钮事件

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jbsaveActionPerformed(e);

            }
        });
        eliminate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {//‘清空’按钮事件
                // TODO Auto-generated method stub
                jta.setText("");
                jta.requestFocus();
            }
        });
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void jbopenAcionPerformed(ActionEvent e){
        try {
            if(jfcFile.showOpenDialog(this)!=JFileChooser.APPROVE_OPTION)
            {
                return;
            }
            String strFileName=jfcFile.getSelectedFile().getAbsolutePath();
            BufferedReader in = new BufferedReader(new FileReader(strFileName));
            String strLine = in.readLine();   //读取一行内容
            String strContent="";
            boolean IsFirst=true;
            while(strLine != null ) {
                if(!IsFirst)
                {
                    strContent+="\n";
                }
                strContent+=strLine;
                IsFirst=false;
                strLine = in.readLine();
            }
            in.close();
            jtf.setText(strFileName);
            jta.setText(strContent);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    public void jbsaveActionPerformed(ActionEvent e) {
        try{
            String strFileName=jtf.getText();
            if(strFileName.equals(""))
            {
                if(jfcFile.showSaveDialog(this)!=JFileChooser.APPROVE_OPTION)
                {
                    return;
                }
                strFileName=jfcFile.getSelectedFile().getAbsolutePath();
                jtf.setText(strFileName);
            }
            String strContent=jta.getText();
            strContent=strContent.replace("\n", "\r\n");
            BufferedWriter out = new BufferedWriter(new  FileWriter(strFileName));
            out.write(strContent);
            out.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MyJFrame();
    }

}

