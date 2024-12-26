package com.Packages.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CheckReservation {
    public void checkReservation() {
        DefaultStyle style =new DefaultStyle();
        // Frame setup
        JFrame checkFlightFrame = new JFrame();
        style.frameStyle(checkFlightFrame);


        // Panel setup
        JPanel pnl_reservation = new JPanel();
        pnl_reservation.setLayout(null);
        pnl_reservation.setBackground(new Color(0, 51, 51));
        pnl_reservation.setBounds(0, 100, 1400, 600);

        // CNIC search
        JLabel lbl_cnic= new JLabel("Enter your CNIC");
        lbl_cnic.setForeground(Color.WHITE);
        lbl_cnic.setFont(new Font(Font.SERIF,Font.BOLD,18));
        lbl_cnic.setBounds(300,70,200,25);

        JTextField cnicFeild=new JTextField();
        cnicFeild.setFont(new Font(Font.SERIF,Font.BOLD,18));
        cnicFeild.setBounds(470,70,250,25);
        cnicFeild.setForeground(Color.BLACK);




        JButton btn_search=new JButton();
        btn_search.setText("Search");
        style.ButtonStyle(btn_search);
        btn_search.setBounds(750,70,120,35);
        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cnicFeild.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Enter Cnic number");
                }
                else
                {

                    try {
                        Connection connections = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/islamicairlines", "root", ""
                        );
                        PreparedStatement preparedStatement = connections.prepareStatement("SELECT `Name`, `Father Name`, `CNIC`,`Source`, `Destination`, `Passport Number`, `Nationality`, `Bill` FROM bookedtickets WHERE CNIC=?");
                        {
                            preparedStatement.setString(1, cnicFeild.getText());
                            ResultSet resultSet = preparedStatement.executeQuery();
                            if (resultSet.next()) {

                                pnl_reservation.setVisible(false);
                                checkFlightFrame.add(returnInfo(checkFlightFrame, cnicFeild.getText()));

                            }
                            else {
                                JOptionPane.showMessageDialog(null,"Cnic not found");
                            }
                        }

                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, "Error connecting to Database");
                    }
                }





            }
        });
        pnl_reservation.add(lbl_cnic);
        pnl_reservation.add(cnicFeild);
        pnl_reservation.add(btn_search);
        Object[] header = {"Name", "Father Name", "CNIC",  "From", "To", "Passport", "Nationality", "Bill"};

        // Add sample rows (for demonstration)

        DefaultTableModel model= new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
        };
        model.setColumnIdentifiers(header);
        // Table setup

        model.addRow(new Object[]{" "});
        JTable table = new JTable(model);
        table.setFont(new Font("Serif", Font.BOLD, 18));
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(0, 51, 51));
        table.setRowHeight(70);
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        // Header customization
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Serif", Font.BOLD, 20));
        tableHeader.setForeground(Color.BLACK);
        tableHeader.setBackground(new Color(0, 102, 102));

        // Scroll pane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 200, 1300, 100);
        pnl_reservation.add(pane);

        // Back Button

        JButton btn_Back =new JButton("Back");
        style.ButtonStyle(btn_Back);
        btn_Back.setBounds(520,400,150,35);
        style.onHover(btn_Back);
        btn_Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFlightFrame.setVisible(false);
                WelcomePage welcomePage =new WelcomePage();
                welcomePage.welcomePage();
            }
        });
        pnl_reservation.add(btn_Back);


        // Add panel to frame
        checkFlightFrame.add(pnl_reservation);
        checkFlightFrame.setVisible(true);

    }
    JPanel returnInfo(JFrame checkFlightFrame,String cnic)
    {

        DefaultStyle style =new DefaultStyle();
        JPanel infoPanel=new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBackground(new Color(0, 51, 51));
        infoPanel.setBounds(0, 100, 1400, 600);
        JLabel lbl_cnic= new JLabel("Enter your CNIC");
        lbl_cnic.setForeground(Color.WHITE);
        lbl_cnic.setFont(new Font(Font.SERIF,Font.BOLD,18));
        lbl_cnic.setBounds(300,70,200,25);

        JTextField cnicFeild=new JTextField();
        cnicFeild.setFont(new Font(Font.SERIF,Font.BOLD,18));
        cnicFeild.setBounds(470,70,250,25);
        cnicFeild.setForeground(Color.BLACK);


        JButton btn_search=new JButton();
        btn_search.setText("Search");
        style.ButtonStyle(btn_search);
        btn_search.setBounds(750,70,120,35);
        infoPanel.add(lbl_cnic);
        infoPanel.add(cnicFeild);
        infoPanel.add(btn_search);
        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cnicFeild.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Enter Cnic number");
                }
                else
                {

                    try {
                        Connection connections = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/islamicairlines", "root", ""
                        );
                        PreparedStatement preparedStatement = connections.prepareStatement("SELECT `Name`, `Father Name`, `CNIC`,`Source`, `Destination`, `Passport Number`, `Nationality`, `Bill` FROM bookedtickets WHERE CNIC=?");
                        {
                            preparedStatement.setString(1, cnicFeild.getText());
                            ResultSet resultSet = preparedStatement.executeQuery();
                            if (resultSet.next()) {

                                infoPanel.setVisible(false);
                                checkFlightFrame.add(returnInfo(checkFlightFrame, cnicFeild.getText()));

                            }
                            else {
                                JOptionPane.showMessageDialog(null,"Cnic not found");
                            }
                        }

                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, "Error connecting to Database");
                    }
                }

               }
        });

        Object[] header = {"Name", "Father Name", "CNIC", "From", "To", "Passport", "Nationality", "Bill"};


        // Add sample rows (for demonstration)

        DefaultTableModel model= new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
        };
        model.setColumnIdentifiers(header);
        try
        {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/islamicairlines", "root", ""
            );
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT `Name`, `Father Name`, `CNIC`,`Source`, `Destination`, `Passport Number`, `Nationality`, `Bill` FROM bookedtickets WHERE CNIC=?");
            {
                preparedStatement.setString(1,cnic);
                ResultSet resultSet=preparedStatement.executeQuery();
                if(resultSet.next())
                {
                    model.addRow(new Object[]{resultSet.getString("Name"), resultSet.getString("Father Name"), resultSet.getString("CNIC"), resultSet.getString("Source"), resultSet.getString("Destination"), resultSet.getString("Passport Number"), resultSet.getString("Nationality"), resultSet.getString("Bill"),});

                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error connecting to Database");
        }
        
        JTable table = new JTable(model);
        table.setFont(new Font("Serif", Font.BOLD, 18));
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(0, 51, 51));
        table.setRowHeight(70);

        // Header customization
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Serif", Font.BOLD, 20));
        tableHeader.setForeground(Color.BLACK);
        tableHeader.setBackground(new Color(0, 102, 102));
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);



        // Scroll pane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 200, 1300, 100);

        // Back Button

        JButton btn_Back =new JButton("Back");
        style.ButtonStyle(btn_Back);
        btn_Back.setBounds(520,400,150,35);
        style.onHover(btn_Back);
        btn_Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFlightFrame.setVisible(false);
                WelcomePage welcomePage =new WelcomePage();
                welcomePage.welcomePage();
            }
        });

        infoPanel.add(btn_Back);

        infoPanel.add(pane);

        infoPanel.setVisible(true);


        return infoPanel;
    }



}
