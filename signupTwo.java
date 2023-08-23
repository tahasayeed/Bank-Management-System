package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class signupTwo extends JFrame implements ActionListener{
    JTextField pan,adhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;

    JComboBox religion, category, occupation, education,income;
    String formno;
    signupTwo(String formno){
        this.formno= formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");


        JLabel addtionalDetails = new JLabel("Page 2: Additional  Details");
        addtionalDetails.setFont(new Font("Raleway,",Font.BOLD,22));
        addtionalDetails.setBounds(290,80,400,40);
        add(addtionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway,",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway,",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        String valcategory[]={"General","OBC","SC","ST","Others"};
        category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway,",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomecategory[]={"null","< 1,50,000","<2,20,000","<5,00,000","upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway,",Font.BOLD,20));
        gender.setBounds(100,310,200,30);
        add(gender);



        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway,",Font.BOLD,20));
        email.setBounds(100,335,200,30);
        add(email);

        String educationvalues[]={"Non-Graduate","Graduate","Post-Graduation","Doctrate","Others"};
        education = new JComboBox(educationvalues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway,",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String occupatiovalues[]={"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupation = new JComboBox(occupatiovalues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);



        JLabel address = new JLabel("PAN NO:");
        address.setFont(new Font("Raleway,",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city = new JLabel("Adhar Number:");
        city.setFont(new Font("Raleway,",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        adhar= new JTextField();
        adhar.setFont(new Font("Raleway",Font.BOLD,14));
        adhar.setBounds(300,490,400,30);
        add(adhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway,",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        syes= new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);


        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);


        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway,",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes= new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);


        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);



        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String)religion.getSelectedItem();
        String scategory =(String)category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String sseniorcitizen = null;
        if(syes.isSelected()){
            sseniorcitizen = "Yes";
        }else if (sno.isSelected()){
            sseniorcitizen = "No";
        }
        String sexisitingaccount = null;
        if (eyes.isSelected()){
            sexisitingaccount ="Yes";
        } else if (eno.isSelected()) {
            sexisitingaccount = "No";
        }
        String span= pan.getText();
        String saadhar = adhar.getText();

        try{
                Conn c= new Conn();
                String query = "insert into signuptwo values ('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+sseniorcitizen+"','"+sexisitingaccount+"')";
                c.s.executeUpdate(query);
                //signup 3 object
            setVisible(false);
            new signupthree(formno).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new signupTwo("");
    }
}

