package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame  implements ActionListener {

    JButton deposite, withdrwal,exit, ministatement,pinchange,balanceenquiry,fastcash;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(218,200,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposite = new JButton("Rs 100");
        deposite.setBounds(170,320,150,30);
        deposite.addActionListener(this);
        image.add(deposite);

        withdrwal = new JButton("Rs 500");
        withdrwal.setBounds(355,320,150,30);
        withdrwal.addActionListener(this);
        image.add(withdrwal);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,350,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355,350,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,380,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(355,380,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Back");
        exit.setBounds(355,410,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance =0;
                while (rs.next()){
                   if (rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   }else {
                       balance-= Integer.parseInt(rs.getString("amount"));
                   }
                }
                if (ae.getSource() != exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank Values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+ amount+ " Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash("");

    }
}
