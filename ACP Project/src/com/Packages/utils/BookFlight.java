package com.Packages.utils;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class BookFlight {
    public JFrame bookFlight(){
        DefaultStyle Style = new DefaultStyle() ;

        JFrame BookingFrame = new JFrame("Islamic Airlines");
        Style.frameStyle(BookingFrame);

        JPanel Form = new JPanel();
        Form.setLayout(null);
        Form.setBackground(new java.awt.Color(0, 51, 51));
        Form.setBounds(0,100,1400,600);

        //Declaration of Labels and Fields
        JLabel lbl_passengerName = new JLabel();
        JTextField nameField = new JTextField();
        JTextArea box = new JTextArea();
        JLabel lbl_passengerFatherName = new JLabel();
        JTextField FathernameField = new JTextField();
        JLabel lbl_passengerCNIC = new JLabel();
        NumberFormatter formatter = new NumberFormatter();
        formatter.setMinimum(0);
        JTextField pCNIC = new JTextField();

        JLabel lbl_From = new JLabel();

        JLabel lbl_To = new JLabel();

        JLabel lbl_passportNo = new JLabel();
        JTextField pPassPortNO = new JTextField();
        JLabel lbl_Nationality = new JLabel();
        JTextField pNationality = new JTextField();

        JLabel lbl_Bill = new JLabel();
        JTextField pBill= new JTextField();

        // Total
        Form.add(box);
        box.setBounds(800,30,400,400);

        // Passanger
        Form.add(lbl_passengerName);
        lbl_passengerName.setText("Name :");
        lbl_passengerName.setBounds(120,30,150,20);
        lbl_passengerName.setFont(new Font("Serif",Font.PLAIN,18));
        lbl_passengerName.setForeground(Color.white);

        Form.add(nameField);
        nameField.setBounds(250,30,380,20);
        nameField.setFont(new Font("Serif",Font.PLAIN,18));

        // Passanger-Father
        Form.add(lbl_passengerFatherName);
        lbl_passengerFatherName.setText("Father-Name :");
        lbl_passengerFatherName.setBounds(120,80,150,20);
        lbl_passengerFatherName.setFont(new Font("Serif",Font.PLAIN,18));
        lbl_passengerFatherName.setForeground(Color.white);

        Form.add(FathernameField);
        FathernameField.setBounds(250,80,380,20);
        FathernameField.setFont(new Font("Serif",Font.PLAIN,18));
        FathernameField.setForeground(Color.black);

        // Passenger-CNIC
        Form.add(lbl_passengerCNIC);
        lbl_passengerCNIC.setText("CNIC :");
        lbl_passengerCNIC.setBounds(120,130,150,20);
        lbl_passengerCNIC.setFont(new Font("Serif",Font.PLAIN,18));
        lbl_passengerCNIC.setForeground(Color.white);

        Form.add(pCNIC);
        pCNIC.setBounds(250,130,380,20);
        pCNIC.setFont(new Font("Serif",Font.PLAIN,18));
        pCNIC.setForeground(Color.black);

        // From
        // Make drop - down
        String[] option1 = {"SELECT","Islamabad"};
        JComboBox<String> comboBox1 = new JComboBox<>(option1);

        Form.add(comboBox1);
        comboBox1.setBounds(250,180,380,20);
        Form.add(lbl_From);
        lbl_From.setText("From :");
        lbl_From.setBounds(120,180,150,20);
        lbl_From.setFont(new Font("Serif",Font.PLAIN,18));
        lbl_From.setForeground(Color.white);

        // To
        // Make drop - down
        String[] option2 = {"SELECT","Lahore","Karachi"};
        JComboBox<String> comboBox2 = new JComboBox<>(option2);
        Form.add(comboBox2);
        comboBox2.setBounds(250,230,380,20);
        Form.add(lbl_To);
        lbl_To.setText("To :");
        lbl_To.setBounds(120,230,150,20);
        lbl_To.setFont(new Font("Serif",Font.PLAIN,18));
        lbl_To.setForeground(Color.white);

        // Passenger-passport no
        Form.add(lbl_passportNo);
        lbl_passportNo.setText("Passport No :");
        lbl_passportNo.setBounds(120,280,150,20);
        lbl_passportNo.setFont(new Font("Serif",Font.PLAIN,18));
        lbl_passportNo.setForeground(Color.white);

        Form.add(pPassPortNO);
        pPassPortNO.setBounds(250,280,380,20);
        pPassPortNO.setFont(new Font("Serif",Font.PLAIN,18));
        pPassPortNO.setForeground(Color.black);

        // Passenger-Nationality
        Form.add(lbl_Nationality);
        lbl_Nationality.setText("Nationality :");
        lbl_Nationality.setBounds(120,330,150,20);
        lbl_Nationality.setFont(new Font("Serif",Font.PLAIN,18));
        lbl_Nationality.setForeground(Color.white);

        Form.add(pNationality);
        pNationality.setText("Pakistani");
        pNationality.setEditable(false);
        pNationality.setBounds(250,330,380,20);
        pNationality.setFont(new Font("Serif",Font.PLAIN,18));
        pNationality.setForeground(Color.black);

        // Passenger-Bill
        Form.add(lbl_Bill);
        lbl_Bill.setText("Bill :");
        lbl_Bill.setBounds(120,380,150,20);
        lbl_Bill.setFont(new Font("Serif",Font.PLAIN,18));
        lbl_Bill.setForeground(Color.white);

        Form.add(pBill);
        pBill.setBounds(250,380,380,20);
        pBill.setFont(new Font("Serif",Font.PLAIN,18));
        pBill.setForeground(Color.black);
        pBill.setText("0");
        pBill.setEditable(false);

        // -----Buttons----
        // Next Button
        JButton next_btn = new JButton("Next");
        Style.ButtonStyle(next_btn);
        Style.onHover(next_btn);
        next_btn.setBounds(330,430,100,35);
        next_btn.setLayout(null);
        Form.add(next_btn);
        next_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(nameField.getText().isEmpty()|| FathernameField.getText().isEmpty()||pCNIC.getText().isEmpty()||pPassPortNO.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }

                else if(comboBox1.getSelectedItem().toString().equals("SELECT")||comboBox2.getSelectedItem().toString().equals("SELECT"))
                {
                    JOptionPane.showMessageDialog(null,"Select From and Destination");
                } else if (!(nameField.getText().matches("[a-zA-Z]+")))
                {
                    JOptionPane.showMessageDialog(null,"Name must be alphabetic");
                }
                else if (!(FathernameField.getText().matches("[a-zA-z]+")))
                {
                    JOptionPane.showMessageDialog(null,"Father Name must be alphabetic");
                }
                else if (!pCNIC.getText().matches("\\d+") || !pPassPortNO.getText().matches("\\d+"))
                {
                    JOptionPane.showMessageDialog(null,"CNIC and Passport Number must be numeric");
                }
                else if( pCNIC.getText().length()<5||pCNIC.getText().length()>20||pPassPortNO.getText().length()<5||pPassPortNO.getText().length()>20)
                {
                    JOptionPane.showMessageDialog(null,"CNIC or Passport Number Invalid\n\tmust be greater than 5 and less than 20");
                }else
                {

                    if(comboBox2.getSelectedItem().toString().equals("Lahore"))
                    {
                        pBill.setText("15,000Rs");
                    }
                    else
                    {
                        pBill.setText("25,000Rs");
                    }
                    try (Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/islamicairlines", "root", ""
                    );

                         PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO bookedtickets (Name, `Father Name`, CNIC, Source, Destination, `Passport Number`, Nationality, Bill ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"))
                    {

                        preparedStatement.setString(1,nameField.getText());
                        preparedStatement.setString(2,FathernameField.getText());
                        preparedStatement.setString(3,pCNIC.getText());
                        preparedStatement.setString(4,comboBox1.getSelectedItem().toString());
                        preparedStatement.setString(5,comboBox2.getSelectedItem().toString());
                        preparedStatement.setString(6,pPassPortNO.getText());
                        preparedStatement.setString(7,pNationality.getText());
                        preparedStatement.setString(8,pBill.getText());
                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Registered Successfully");

                        box.setText(" \n \n\t     YOUR INFORMATION"+"\n \n \n             Name: "+"\t\t     "+nameField.getText()+"\n\n            Fathername: "+"\t     "+FathernameField.getText()+"\n\n            CNIC: "+"\t\t     "+pCNIC.getText()+"\n\n            From :"+"\t\t     "+comboBox1.getSelectedItem().toString()+"\n\n            TO :"+"\t\t     "+comboBox2.getSelectedItem().toString()+"\n\n            Passport NO: "+"\t     "+pPassPortNO.getText()+"\n\n            Nationality: "+"\t     "+pNationality.getText()+"\n\n            Bill: "+"\t\t     "+pBill.getText());
                        box.setEditable(false);
                        box.setFont(new Font("Sherif",Font.BOLD,14));
                    } catch (SQLIntegrityConstraintViolationException ex)
                    {
                        JOptionPane.showMessageDialog(null,"(CNIC or Passport number) already registered !\nEnter Unique CNIC and Passport number");
                    }
                    catch (SQLException e1)
                    {
                        System.out.println(e1);
                        JOptionPane.showMessageDialog(null,"Error connecting to Database");
                    }
                }
            }


        });

        // Back Button
        JButton back_btn = new JButton("Back");
        Style.ButtonStyle(back_btn);
        Style.onHover(back_btn);
        back_btn.setBounds(450,430,100,35);
        back_btn.setLayout(null);
        Form.add(back_btn);

        back_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                BookingFrame.setVisible(false);
                WelcomePage welcomePage  = new WelcomePage();
                welcomePage.welcomePage();


            }
        });
        BookingFrame.setVisible(true);
        BookingFrame.add(Form);
        return BookingFrame;
    }
}
