package com.Packages.utils;
import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Objects;

public class DefaultStyle {

    // Default Style For Buttons

    public void ButtonStyle(JButton b){
        b.setFont(new Font("Serif", Font.BOLD, 20));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBorderPainted(true);
        b.setFocusPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));


    }
    // onHover

    public void onHover(JButton b)
    {

        b.addMouseListener(new java.awt.event.MouseAdapter()

        {
            @Override
            public void mouseEntered (MouseEvent e){
                b.setBackground(Color.WHITE);
                b.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited (MouseEvent e){
                b.setBackground(Color.BLACK);
                b.setForeground(Color.WHITE);
            }

        });

    }
    
    // Default Frame Style

    public void frameStyle(JFrame F)
    {
        JPanel pnl_navBar=new JPanel();
        JLabel lbl_navBar=new JLabel();
        pnl_navBar.setLayout(null);
        pnl_navBar.setBackground(Color.BLACK);
        pnl_navBar.add(lbl_navBar);
        pnl_navBar.setBounds(0,0,1400,110);
        lbl_navBar.setForeground(Color.WHITE);

        lbl_navBar.setText("Islamic Airlines System");
        lbl_navBar.setFont(new Font("Serif",Font.BOLD,50));
        lbl_navBar.setBounds(390,30,800,60);
        F.setLayout(null);
        F.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        F.setSize(1500,1400);
        F.setBounds(0,0,1350,700);
        F.add(pnl_navBar);
        F.setResizable(false);

    }
    public JPanel pnl_checkReservation (JFrame checkFlightFrame)

    {
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

        Object[] header = {"Name", "Father", "CNIC", "DOB", "From", "To", "Passport", "Nationality", "SEAT", "Bill"};

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

        JButton btn_serach=new JButton();
        btn_serach.setText("Search");
        ButtonStyle(btn_serach);
        btn_serach.setBounds(750,70,120,35);

        btn_serach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cnicFeild.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Enter Cnic number");
                } else
                {
                    try (Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/islamicairlines", "root", ""
                    );

                         PreparedStatement preparedStatement = connection.prepareStatement("SELECT `Name`, `Father Name`, `CNIC`,`Source`, `Destination`, `Passport Number`, `Nationality`, `Bill` FROM bookedtickets WHERE CNIC=?")) {
                        preparedStatement.setString(1, cnicFeild.getText());

                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            model.addRow(new Object[]{resultSet.getString("Name"), resultSet.getString("Father Name"), resultSet.getString("CNIC"), resultSet.getString("Source"), resultSet.getString("Destination"), resultSet.getString("Passport Number"), resultSet.getString("Nationality"), resultSet.getString("Bill"),});
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Cnic Not found");
                        }

                    }catch (SQLException e2)
                    {
                        System.out.println(e2);
                        JOptionPane.showMessageDialog(null,"Can not connect to Database");
                    }

                }
            }

        });
        pnl_reservation.add(lbl_cnic);
        pnl_reservation.add(cnicFeild);
        pnl_reservation.add(btn_serach);
        // Table setup


       // model.addRow(new Object[]{"John Doe", "Mr. Doe", "12345-6789012-3", "1990-01-01", "New York", "London", "P12345", "American", "12A", "$500"});
       // model.addRow(new Object[]{"Jane Smith", "Mr. Smith", "98765-4321098-7", "1985-05-15", "Tokyo", "Paris", "P67890", "Japanese", "5B", "$700"});
        JTable table = new JTable(model);
        table.setFont(new Font("Serif", Font.BOLD, 18));
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(0, 51, 51));
        table.setRowHeight(60);
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
        ButtonStyle(btn_Back);
        btn_Back.setBounds(520,400,150,35);
        onHover(btn_Back);
        btn_Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFlightFrame.setVisible(false);
                WelcomePage welcomePage =new WelcomePage();
                welcomePage.welcomePage();
            }
        });
        checkFlightFrame.add(pnl_reservation);
        pnl_reservation.add(btn_Back);
        return pnl_reservation;

    }
}





