package com.Packages.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontFrame {
    public JFrame frontFrame()
    {
        DefaultStyle Style =new DefaultStyle();
        JFrame frontFrame=new JFrame("Islamic Airlines");

        Style.frameStyle(frontFrame);


        // declaration of all the panels and labels

        JPanel pnl_mainHeading=new JPanel();
        JLabel lbl_mainHeading =new JLabel();
        JLabel lbl_helpLine=new JLabel();
        JLabel lbl_helpNumber =new JLabel();

        // Main Heading
        // Panel + label

        pnl_mainHeading.add(lbl_mainHeading);
        pnl_mainHeading.setLayout(null);
        pnl_mainHeading.setBackground(new java.awt.Color(0, 51, 51));
        pnl_mainHeading.setBounds(0,100,1400,600);
        lbl_mainHeading.setText("Welcome To Online Booking System");
        lbl_mainHeading.setForeground(Color.WHITE);
        lbl_mainHeading.setFont(new Font("Serif",Font.BOLD,35));
        lbl_mainHeading.setBounds(370,90,800,50);

        // Main Menu Button

        JButton btn_BookTicket=new JButton("Islamic Airlines");

        btn_BookTicket.setBounds(490,250,250,45);
        pnl_mainHeading.add(btn_BookTicket);
        //Set default Style for buttons


        Style.ButtonStyle(btn_BookTicket);
        Style.onHover(btn_BookTicket);

        btn_BookTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage=new LoginPage();
                loginPage.loginPage(frontFrame);


            }
        });
        // Help line

        pnl_mainHeading.add(lbl_helpLine);
        lbl_helpLine.setText(" کسی بھی ہنگامی صورتحال یا مسلے کی صورت میں دے گیے نمبر پر رابطہ کریں۔ ");
        lbl_helpLine.setFont(new Font("Serif", Font.BOLD, 22));
        lbl_helpLine.setBounds(50,390,750,45);
        lbl_helpLine.setForeground(Color.WHITE);

        // HelpLine Number
        pnl_mainHeading.add(lbl_helpNumber);
        lbl_helpNumber.setText(" 000-111-000 ");
        lbl_helpNumber.setForeground(Color.WHITE);
        lbl_helpNumber.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_helpNumber.setBounds(50,425,250,45);

        // Front page frame

        frontFrame.add(pnl_mainHeading);
        frontFrame.setVisible(true);

        return frontFrame;
    }
}
