import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

public class Chatbot extends JFrame implements KeyListener
{

    
    JPanel p=new JPanel();
    JTextArea dialog=new JTextArea(20,50);
    JTextArea input=new JTextArea(4,50);
    
    JScrollPane scroll=new JScrollPane(
    
    dialog,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
    
    
    );
    
    String[][] chatbot=
            {
                
                
                
                
                {"hi","Hi","hello","Hello","hey","Hey"},
                {"hello","hey"},
                 
                {"how are you","how are you?","How are you","How are you?"},
                {"doing well","quite nice"},
             
                {"Can we be friends?","can we be friends?","can we be friends","Can we be friends?"},
                {"Yes!!!of course!!!","sure,why not!"},
                
                {"What are you doing","what are you doing"},
                {"Nothing special","well!really nothing!!!"},
              
                {"Blaze is unavailable right now.Your string is saved"}
                    
                
            };
    
    
    
    public static void main(String args[])
    {
        new Chatbot();
    }
    public Chatbot()
    {
        
        super("Chat of Blaze");
        setSize(600,400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        dialog.setEditable(false);
        input.addKeyListener(this);
        p.add(scroll);
        p.add(input);
        p.setBackground(new Color(0,0,0));
        add(p);
        setVisible(true);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
     
       
        if(e.getKeyCode()==KeyEvent.VK_ENTER) //Enter key pressed VK_ENTER KEY CODE
        {
            input.setEditable(false);
            String quote=input.getText();
            input.setText("");
            addText("-->You:\t"+quote);
            quote.trim();
            while(quote.charAt(quote.length()-1)=='!'||
                    quote.charAt(quote.length()-1)=='.'||
                    quote.charAt(quote.length()-1)=='?'
                    
                    
                    )
            {
               quote=quote.substring(0,quote.length()-1); 
            }
            
            quote.trim();
            byte response=0;
            //we are searching chatbot for matches
            //we did not find anything in chatbot[][]
            //we did find something in chatbot
            
            int j=0;
            while(response==0)
            {
                if(inArray(quote.toLowerCase(),chatbot[j*2]))
                {
                    response=2;
                    int r=(int)Math.floor(Math.random()*chatbot[(j*2)+1].length);
                    
                    addText("\n--->Blaze\t"+chatbot[(j*2)+1][r]);
                }
                
                j++;
                if(j*2==chatbot.length-1 && response==0)
                {
                    response=1;
                }
            }
            if(response==1)
            {
                 int r=(int)Math.floor(Math.random()*chatbot[chatbot.length-1].length);
                    
                    addText("\n--->Blaze\t"+chatbot[chatbot.length-1][r]);
            }
            addText("\n");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    if(e.getKeyCode()==KeyEvent.VK_ENTER)
    {
        input.setEditable(true);
    }
    
    }
    
   public void addText(String str)
   {
       dialog.setText(dialog.getText()+str);
   }

    private boolean inArray(String in, String[] str) {
        
        boolean match=false;
        for(int i=0;i<str.length;i++)
        {
            if(str[i].equals(in))
            {
                match=true;
            }
            
        }
        return match;
        
    }
    
    
}