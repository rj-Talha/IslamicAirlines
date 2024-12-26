package com.Packages.utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage {
    public JFrame welcomePage()
    {
        DefaultStyle Style=new DefaultStyle();
        FrontFrame frontFrame = new FrontFrame();
        JFrame welcomeFrame =new JFrame("Islamic Airlines");

        Style.frameStyle(welcomeFrame);
        JPanel pnl_mainHeading=new JPanel();


        // panel
        // main Headings


        pnl_mainHeading.setLayout(null);
        pnl_mainHeading.setBackground(new java.awt.Color(0, 51, 51));
        pnl_mainHeading.setBounds(0,100,1400,600);

        //buttons
        // Book Flight button
        JButton bookFlightButton=new JButton();
        Style.onHover(bookFlightButton);
        Style.ButtonStyle(bookFlightButton);
        bookFlightButton.setText("Book Flight");
        bookFlightButton.setBounds(500,100,200,50);
        bookFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.setVisible(false);
                BookFlight bookFlight=new BookFlight();
                bookFlight.bookFlight();
            }
        });

        //search flight button
        JButton searchFlightButton=new JButton();
        Style.ButtonStyle(searchFlightButton);
        Style.onHover(searchFlightButton);
        searchFlightButton.setText("Check Reservation");
        searchFlightButton.setBounds(500,200,200,50);
        searchFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.setVisible(false);
                CheckReservation checkReservation=new CheckReservation();
                checkReservation.checkReservation();
            }
        });
        //Back button
        JButton backButton=new JButton();
        Style.ButtonStyle(backButton);
        Style.onHover(backButton);
        backButton.setText("Back");
        backButton.setBounds(500,300,200,50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.setVisible(false);
                frontFrame.frontFrame();


            }
        });

        // Adding buttons to panel

        pnl_mainHeading.add(bookFlightButton);
        pnl_mainHeading.add(searchFlightButton);
        pnl_mainHeading.add(backButton);
        // Adding panel to frame

        welcomeFrame.add(pnl_mainHeading);
        welcomeFrame.setVisible(true);

        return welcomeFrame;

    }
}
