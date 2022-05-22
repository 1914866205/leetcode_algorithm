package com.datastruct.gui;


import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @ClassName IndexPage
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/22 10:32
 * @Version 1.0
 **/
public class IndexPage {
    //窗体对象
    private JFrame jframe;
    //主页 页面窗口容器
    private Container index;
    //多行文本输入框  显示文件内容
    private JTextArea mulEditArea;
    //单行文本输入框  显示文件路径
    private JTextField singEditArea;
    //文件选择框
    private JFileChooser fileChooser;
    //操作按钮_打开
    private JButton openBtn;
    //操作按钮_创建
    private JButton creaBtn;
    //操作按钮_保存
    private JButton saveBtn;
    //操作按钮_清除内容
    private JButton clsBtn;
    //操作按钮_删除文件
    private JButton delBtn;

    //标签
    private JLabel label;

    public JFrame getFrame() {


        //实例化窗体对象
        jframe = new JFrame();


        //实例化界面容器
        index = jframe.getContentPane();
        //实例化标签对象
        label = new JLabel("文件：");
        //实例化文件选择器
        fileChooser = new JFileChooser();
        /**
         * FileFilter 的一个实现，它使用指定的扩展名集合进行过滤。
         * 文件的扩展名是指文件名最后一个“.”后面的部分。名称不包含“.”的文件没有文件扩展名。文件扩展名的比较不区分大小写。
         * 下例创建了一个 FileNameExtensionFilter，它将显示 jpg 文件：
         * FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
         * JFileChooser fileChooser = ...;
         * fileChooser.addChoosableFileFilter(filter);
         */
        //文件过滤
        FileFilter filter = new FileNameExtensionFilter("文本文件", "txt");
        fileChooser.setFileFilter(filter);
        //多行文本输入框
        mulEditArea = new JTextArea();
        //设置文本域自动换行
        mulEditArea.setLineWrap(true);
        //单行文本输入框
        singEditArea = new JTextField();
        //操作按钮
        openBtn = new JButton("打开");
        creaBtn = new JButton("创建");
        saveBtn = new JButton("保存");
        clsBtn = new JButton("清除");
        delBtn = new JButton("删除");


        //设置为绝对布局
        index.setLayout(null);
        // 添加窗体的容器 此处不需要，会报Exception in thread "main" java.lang.IllegalArgumentException: adding container's parent to itself
        //因为  index = jframe.getContentPane();
        //jframe.add(index);

        // 设置容器的位置和大小
        jframe.setBounds(650, 200, 600, 380);
        label.setBounds(10, 10, 50, 20);
        singEditArea.setBounds(60, 10, 350, 20);
        mulEditArea.setBounds(60, 50, 450, 200);
        openBtn.setBounds(420, 10, 70, 20);
        creaBtn.setBounds(500, 10, 70, 20);
        saveBtn.setBounds(400, 280, 70, 20);
        clsBtn.setBounds(90, 280, 70, 20);
        delBtn.setBounds(240, 280, 70, 20);

        index.add(mulEditArea);
        index.add(singEditArea);
        index.add(openBtn);
        index.add(saveBtn);
        index.add(creaBtn);
        index.add(clsBtn);
        index.add(delBtn);
        index.add(label);
        index.add(fileChooser);

        //添加按钮事件
        openBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openFile(e);
            }
        });

        //保存按钮事件
        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile(e);
            }
        });
        //清除按钮事件
        clsBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //内容置空
                mulEditArea.setText("");
                //获取焦点
                mulEditArea.requestFocus();
            }
        });

        //创建按钮事件
        creaBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (singEditArea.getText() != null) {

                    //如果文件不存在，就创建该文件
                    try {
                        new File(singEditArea.getText() + ".txt").createNewFile();
                        //内容区
                        String content = mulEditArea.getText();
                        content = content.replace("\n", "\r\n");
                        try (BufferedWriter out = new BufferedWriter(new FileWriter(singEditArea.getText() + ".txt"))) {
                            //把内容输出到文件中
                            out.write(content);
                            JOptionPane.showMessageDialog(jframe, "文件保存成功");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(jframe, ex.getMessage());
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    //获取焦点
                    mulEditArea.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(jframe,"请输入文件名（无需添加后缀）");
                }
            }
        });

        //删除文件
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //删除文件
                if (singEditArea.getText() != null) {
                    new File(singEditArea.getText()).delete();
                    JOptionPane.showMessageDialog(jframe,"已删除："+singEditArea.getText());
                    //内容置空
                    mulEditArea.setText("");
                    singEditArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(jframe,"请输入文件全路径（包括后缀）");
                }
            }
        });


        // 给窗体设置标题
        jframe.setTitle("可视化界面的文本文件操作");
        // 设置窗体的位置和大小
        jframe.setBounds(650, 200, 600, 380);
        // 设置窗体可见
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 返回一个窗体
        return jframe;
    }

    /**
     * 打开文件的操作
     *
     * @param e
     */
    public void openFile(ActionEvent e) {
        if (fileChooser.showOpenDialog(jframe) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String fileName = fileChooser.getSelectedFile().getAbsolutePath();
        //显示当前文件路径
        singEditArea.setText(fileName);
        //把数据读入内存
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            //显示数据
            String content = "";
            String readLine;
            //如果还有下一行
            while ((readLine = fileReader.readLine()) != null) {
                content += readLine + "\n";
            }
            //文件名称显示
            singEditArea.setText(fileName);
            //文件名称显示
            mulEditArea.setText(content);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(jframe, ex.getMessage());
        }
    }

    /**
     * 保存文件的操作
     *
     * @param e
     */
    public void saveFile(ActionEvent e) {
        //获取文件信息
        String fileName = singEditArea.getText();
        if (fileName.equals("")) {
            //如果没有打开文件的路径，判断是否选择了文件
            if (fileChooser.showOpenDialog(jframe) == JFileChooser.APPROVE_OPTION) {
                return;
            }
            //把选择文件的路径放置在单行文本输入框中
            fileName = fileChooser.getSelectedFile().getAbsolutePath();
            singEditArea.setText(fileName);
        }
        //内容区
        String content = mulEditArea.getText();
        content = content.replace("\n", "\r\n");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
            //把内容输出到文件中
            out.write(content);
            JOptionPane.showMessageDialog(jframe, "文件保存成功");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(jframe, ex.getMessage());
        }
    }

}
