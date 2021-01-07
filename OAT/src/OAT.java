/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1506085
 */
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OAT extends JFrame implements ActionListener  
{
  private JFrame f=new JFrame("OAT");	
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    
	OAT(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
    
    for(int i=0;i<5;i++)  
        {  
    	jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  

        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  

        b1.addActionListener(this);  
        b2.addActionListener(this);  

        add(b1);
		add(b2);  
        
		set();  
        
		l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        
		b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		 f.setVisible(true);  
        f.setSize(800,500);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(800,500);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(600,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
            if(current==0)
	  {

		  l.setText("Q1: According to Animal Planet which animal has strongest biteforce?");
		  jb[0].setText("Tiger");
		  jb[1].setText("Crocodile");
		  jb[2].setText("Shark");
		  jb[3].setText("Lynx");
		  
	  }
	  
	  if(current==1)
	  {
		  l.setText("Q2: According to animal planet which snake is the most dangerous in the world?");
		  
			  jb[0].setText("Black Mamba");
			  jb[1].setText("Rattle Snake");
			  jb[2].setText("Russel Viper");
			  jb[3].setText("King Cobra");
		  }
		  

		   if(current==2)
	  {
		  l.setText("Q3: Whih is the fastest bird in the world?");
		  
			  jb[0].setText("Golden Eagle");
			  jb[1].setText("Falcon");
			  jb[2].setText("Gyrfalcon");
			  jb[3].setText("Albatros");
		  }
		  

		   if(current==3)
	  {
		  l.setText("Q4: which is considered to be the most dangerous animal in the world ?");
		  
			  jb[0].setText("Box Jellyfish");
			  jb[1].setText("Rattle Snake");
			  jb[2].setText("Lynx");
			  jb[3].setText("RedBacks");
		  }
		  

		   if(current==4)
	  {
		  l.setText("Q5:Which is the most dangerous fish in the world according to research ?");
		  
			  jb[0].setText("Puffer fish");
			  jb[1].setText("Stone Fish");
			  jb[2].setText("Electri Ray");
			  jb[3].setText("Piranha");
		  }
		  

		   if(current==5)
	  {
		  l.setText("Q6: Which is the biggest animal in the world?");
		  
			  jb[0].setText("White Shark");
			  jb[1].setText("Bull Shark");
			  jb[2].setText("Blue Whale");
			  jb[3].setText("African Elephant");
		  }
		  

		   if(current==6)
	  {
		  l.setText("Q7: Which is the national animal of Austrailia?");
		  
			  jb[0].setText("Kangaroo");
			  jb[1].setText("Eastern Brown Snake");
			  jb[2].setText("Eagle");
			  jb[3].setText("Zebra");
		  }
		  

		   if(current==7)
	  {
		  l.setText("Q8: Which is the most dangerous bird in the world?");
		 
			  jb[0].setText("Cassowary");
			  jb[1].setText("Golsen Eagle");
			  jb[2].setText("Vulture");
			  jb[3].setText("Albatros");
		  }
		  

		   if(current==8)
	  {
		  l.setText("Q9:Which is the oldest animal in the world among these?");
		  
			  jb[0].setText("Sponge");
			  jb[1].setText("Jellyfish");
			  jb[2].setText("Nautilus");
			  jb[3].setText("Sturgeon");
		  }
		  
		  

	   if(current==9)
	  {
		  l.setText("Q10: According to animal planet which snake is the most dangerous in the world?");
		  
			  jb[0].setText("Marbel cone snail");
			  jb[1].setText("Box jellyfish");
			  jb[2].setText("Blue Ringed octopus");
			  jb[3].setText("King Cobra");
		
		}

        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  

        if(current==1)  
            return(jb[0].isSelected());  

        if(current==2)  
            return(jb[1].isSelected());  

        if(current==3)  
            return(jb[0].isSelected());  

        if(current==4)  
            return(jb[0].isSelected());  

        if(current==5)  
            return(jb[2].isSelected());  

        if(current==6)  
            return(jb[0].isSelected());  

        if(current==7)  
            return(jb[0].isSelected());  

        if(current==8)  
            return(jb[0].isSelected());  

        if(current==9)  
            return(jb[1].isSelected());  

        return false;  
    }  
    public static void main(String s[])  
    {  
        new OAT("Blaze's question paper-EXAM");  
    }  
}  
