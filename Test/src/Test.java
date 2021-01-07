/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1506085
 */
import javax.swing.*;


import java.awt.*;


import java.awt.event.*;


import java.util.Scanner;


import java.io.*;
import javax.swing.text.DefaultEditorKit;

	  //This is the set of things needed by a text component to be a reasonably functioning editor for some type of text document. This implementation provides a default implementation which treats text as plain text and provides a minimal set of actions for a simple editor.




public class Test extends JFrame implements ActionListener{





        private JTextArea textArea = new JTextArea();
      

  private JScrollPane areaScrollPane;      //ScrollPane for area.

   

     private JMenuBar menuBar=new JMenuBar();
	

private JMenu file=new JMenu();


	private JMenu edit=new JMenu();
	

private JMenu format=new JMenu();   //It creates Menubar and contents of menubar


	private JMenu view=new JMenu();
	

private JMenu help=new JMenu();


	private JMenu color=new JMenu();


	

private JMenuItem newFile=new JMenuItem();


	private JMenuItem openFile=new JMenuItem();


	private JMenuItem saveFile=new JMenuItem();
	

private JMenuItem saveAsFile=new JMenuItem();//JMenuItem for file
	

private JMenuItem close=new JMenuItem();
	
	private JMenuItem undo=new JMenuItem();
	private JMenuItem cut=new JMenuItem(new DefaultEditorKit.CutAction());    //JMenuItem for edit
	private JMenuItem copy=new JMenuItem(new DefaultEditorKit.CopyAction());  //Editor operation on cut , copy and paste.
	private JMenuItem paste=new JMenuItem(new DefaultEditorKit.PasteAction());


	private JMenuItem colorpage=new JMenuItem();	//JMenuItem for color
	private JMenuItem colorfont=new JMenuItem();
	

	private JMenuItem fontfamily=new JMenuItem();
	private JMenuItem fontstyle=new JMenuItem(); //JMenuItem for format
	private JMenuItem fontsize=new JMenuItem();

	private JMenuItem wordcount=new JMenuItem();
	private JMenuItem charcount=new JMenuItem(); //JMenuitem for view
	
	private JMenuItem status=new JMenuItem(); //JMenuItem for View

	private JMenuItem delete=new JMenuItem();
	private JMenuItem wordwrap=new JMenuItem();

	private JMenuItem about=new JMenuItem();//JMenuItem for Help

	JList familylist, stylelist, sizelist;


String familyvalue[]={"Agency FB","Antiqua","Architect","Arial","Calibri","Comic Sans","Courier","Cursive","Impact","Serif"};
 String sizevalue[]={"5","10","15","20","25","30","35","40","45","50","55","60","65","70"};
 int [] stylevalue={ Font.PLAIN, Font.BOLD, Font.ITALIC };
 String [] stylevalues={ "PLAIN", "BOLD", "ITALIC" };


 Font font1;
 JPanel bottom;
 JLabel details, pastecopydoc;String ffamily, fsize, fstyle;
 
 JScrollPane sb;
 
 int cl;
 int linecount;
 String tle ;
 String topicstitle = "";
 JScrollPane sp;
 
JButton b;    
Container c;  

public Test(){


 
	      
   

	textArea.setBackground(Color.cyan);
 	 setForeground(Color.black);
 	add(textArea);
	setLayout(new FlowLayout());


 	familylist = new JList(familyvalue);
	 stylelist = new JList(stylevalues);
	 sizelist = new JList(sizevalue);


 	familylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 	sizelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 	stylelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


//set frame operation------at first give size and title then set default close oeration then set font in textarea and set drag in textarea in contentpane set layout and add textarea in JScrollPane add textarea then under areascrollpane set vertical and horizontal scrollbar policy then set dimension size and add areascrollpane under getcontentpane().

	this.setSize(1000,800);
	this.setTitle("Soumyajit's Notepad");

	setDefaultCloseOperation(EXIT_ON_CLOSE);  //By deafult close operation.

	this.textArea.setFont(new Font("Calibri",Font.BOLD,27));//set up unique fontfamily,size and style.
	this.textArea.setDragEnabled(true);  //it enables dragging.
	this.getContentPane().setLayout(new BorderLayout());// Layout in getContentPane().
	this.getContentPane().add(textArea);
	this.areaScrollPane=new JScrollPane(textArea);
        this.areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //It sets scrollBar policy

        this.areaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.areaScrollPane.setPreferredSize(new Dimension(250, 250));

        this.getContentPane().add(areaScrollPane);



	
	this.setJMenuBar(this.menuBar);
	this.menuBar.add(this.file);
	this.menuBar.add(this.edit);
	this.menuBar.add(this.format);   //add all items in menubar as object
	this.menuBar.add(this.view);
	this.menuBar.add(this.help);
	this.menuBar.add(this.color);


	
	this.file.setText("File");
	this.edit.setText("Edit");
	this.format.setText("Format");//through object set the name
	this.view.setText("View");
	this.help.setText("Help");
	this.color.setText("Color");

	
	this.newFile.setText("New");
	this.newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));//under key accelerator and under key stroke creating shortcut key
        this.newFile.addActionListener(this);
	this.newFile.setMnemonic(KeyEvent.VK_N); //under file setname and shortcut then action it and shortcut via mnemonic then add it to file.
	this.file.add(this.newFile);



	this.openFile.setText("Open");  //open operation under file
	this.openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
	this.openFile.addActionListener(this);
	this.openFile.setMnemonic(KeyEvent.VK_O);
	this.file.add(this.openFile);


	this.saveFile.setText("Save");                            //save operation under file
	this.saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
	this.saveFile.addActionListener(this);
	this.saveFile.setMnemonic(KeyEvent.VK_S);
	this.file.add(this.saveFile);	


	this.saveAsFile.setText("SaveAs...");			//save as operation under file
	this.saveAsFile.addActionListener(this);
	this.file.add(this.saveAsFile);


	this.close.setText("Close");                             //close operation under file
	this.close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.CTRL_MASK));
	this.close.addActionListener(this);
	this.close.setMnemonic(KeyEvent.VK_S);
	this.file.add(this.close);

	
	this.undo.setText("Undo");                      //undo operation under edit
	this.undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
	this.undo.addActionListener(this);
	this.undo.setMnemonic(KeyEvent.VK_Z);
	this.edit.add(this.undo);	

		
	
	this.cut.setText("Cut");                     //cut operation under edit
	this.cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
	this.cut.addActionListener(this);
	this.cut.setMnemonic(KeyEvent.VK_X);
	this.edit.add(this.cut);	


	this.copy.setText("Copy");   			//copy operation under edit
	this.copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	this.copy.addActionListener(this);
	this.copy.setMnemonic(KeyEvent.VK_C);
	this.edit.add(this.copy);	


	this.paste.setText("Paste");			//paste operation under edit
	this.paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
	this.paste.addActionListener(this);
	this.paste.setMnemonic(KeyEvent.VK_V);
	this.edit.add(this.paste);	


	this.fontfamily.setText("Font_Type");
								//font-type operation under format
        this.fontfamily.addActionListener(this);
        this.format.add(this.fontfamily);
		
	
	this.fontstyle.setText("Font_Style");			//font-style operation under format
        this.fontstyle.addActionListener(this);
        this.format.add(this.fontstyle);
			
	
	this.fontsize.setText("Font_Size");			//font-size operation under format
        this.fontsize.addActionListener(this);
        this.format.add(this.fontsize);
			
	this.colorpage.setText("ColorPage");
	this.colorpage.addActionListener(this);
	textArea.setLayout(new FlowLayout());			//sdding colorpage under color
	 textArea.add(colorpage);    
	 this.color.add(this.colorpage);
	


	this.colorfont.setText("ColorFont");
	this.colorfont.addActionListener(this);
	textArea.setLayout(new FlowLayout());			//adding colorfont under color
	 textArea.add(colorfont);    
	 this.color.add(this.colorfont);

	this.wordcount.setText("Count Word");
	  this.wordcount.addActionListener(this);
        this.view.add(this.wordcount);


	
	this.charcount.setText("Count Character");
	  this.charcount.addActionListener(this);
        this.view.add(this.charcount);

	

	this.about.setText("Authors");	               		//about operation under help
        this.about.addActionListener(this);
        this.help.add(this.about);

}


public void actionPerformed(ActionEvent e)
{

	String text=textArea.getText();



	if(e.getSource()==this.close)
		this.dispose();                 //dispose() for closing

	

	if(e.getSource()==this.openFile) {                            //openfile function

		JFileChooser open=new JFileChooser();
		int option=open.showOpenDialog(this);
		if(option==JFileChooser.APPROVE_OPTION){              //if option is approved:textarea

			this.textArea.setText("");

	try	{

		Scanner scan=new Scanner(new FileReader(open.getSelectedFile().getPath()));
		while(scan.hasNext())
			this.textArea.append(scan.nextLine()+"\n");//hasNext() method Returns true if this scanner has another token in its    input.      
		}

	catch (Exception ex)  {

		System.out.println(ex.getMessage());
                              }
	}
}


	else if(e.getSource()==this.saveFile) {                  //function for save file

		JFileChooser save=new JFileChooser();
		int option=save.showSaveDialog(this);
		if(option==JFileChooser.APPROVE_OPTION){

	try	{

		BufferedWriter out=new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
		out.write(this.textArea.getText());
		out.close();
		}

	catch (Exception ex)  {

		System.out.println(ex.getMessage());
                              }
	}
}


	else if(e.getSource()==this.saveAsFile) {          //Function for save as file

          	JFileChooser open=new JFileChooser();
		int option=open.showSaveDialog(this);
		if(option==JFileChooser.APPROVE_OPTION){              //if option is approved:textarea

			this.textArea.setText("");


	try	{

		BufferedWriter out=new BufferedWriter(new FileWriter(open.getSelectedFile().getPath()));
		out.write(this.textArea.getText());
		out.close();
		}

	catch (Exception ex)  {

		System.out.println(ex.getMessage());
                              }
	}
}
	

	else if(e.getSource()==this.newFile){                             //Function for new file

		JOptionPane jp=new JOptionPane();
		Object[] options = { "Save", "Don't Save", "Cancel" };

            int button = jp.showOptionDialog(null,

                    "Do you want to save changes to" + getTitle(), "Blaze",

                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,

                    null, options, options[0]);

	if(button==0){

		JFileChooser newFile=new JFileChooser();
		int option=newFile.showSaveDialog(this);
		if(option==JFileChooser.APPROVE_OPTION){              //if option is approved:textarea


	try	{

		BufferedWriter out=new BufferedWriter(new FileWriter(newFile.getSelectedFile().getPath()));
		out.write(this.textArea.getText());
		out.close();
		}

	catch (Exception ex)  {

		System.out.println(ex.getMessage());
                              }
	}
}

	else if(button==1){

		textArea.setText(null);
			  }

	else if(button==2){

			  }


	}


	else if (e.getSource()== fontfamily)

        {

        JOptionPane.showConfirmDialog(null, familylist, "Choose Font Family", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        ffamily=String.valueOf(familylist.getSelectedValue());
 
        textArea.setFont(font1);
       
        }



	else if (e.getSource()== fontstyle)
  
        {

        JOptionPane.showConfirmDialog(null, stylelist, "Choose Font Style", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
  	fstyle=String.valueOf(stylelist.getSelectedIndex());
  	
  	textArea.setFont(font1);
  
        }
 
	else if (e.getSource()== fontsize)

        {

        JOptionPane.showConfirmDialog(null, sizelist, "Choose Font Size", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
  	fsize=String.valueOf(sizelist.getSelectedValue());
  	
 	 textArea.setFont(font1);
    
         }

	else if (e.getSource()== colorpage)

        {
	Color initialcolor=Color.RED;    
	Color color=JColorChooser.showDialog(this,"Select a color",initialcolor);    
	textArea.setBackground(color);   
	}

	else if (e.getSource()== colorfont)

        {
	Color initialcolor=Color.RED;    
	Color color=JColorChooser.showDialog(this,"Select a color",initialcolor);    
	textArea.setForeground(color);   
	}



	
	else if(e.getSource()==wordcount)
	
	{
	  String words[]=text.split("\\s");  
        JOptionPane.showMessageDialog(this,"Total words: "+words.length);  
        }


  	else if(e.getSource()==charcount)

	{
	   JOptionPane.showMessageDialog(this,"Total Characters with space: "+text.length());  
	}
	
	


	else if(e.getSource()==this.about){

	JOptionPane jp=new JOptionPane();
	jp.showMessageDialog(null,"Designed by Soymyajit Choudhury");
	}
	}




	   public static void main(String args[]) {

        Test app = new Test();

        app.setVisible(true);
 

    }

}




		
