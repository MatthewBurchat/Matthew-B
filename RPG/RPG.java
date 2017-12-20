import arc.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.*;
import javax.imageio.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RPG{
  public static void main(String[] args){
    Console con = new Console(1280, 800);
    
    //========Variables=======
    Font myfont;      
    int intCrawl = 0;
    int intCrawlY = 340;
    int intCrawlY2 = 419;
    String strMenuSelect = "M";
    
    //=========Game Name & Menu=========
    while((intCrawl != 460)){
     myfont = con.loadFont("STARWARS.ttf", 100);
     con.setDrawFont(myfont);
     con.setDrawColor(Color.BLACK);
     con.fillRect(0,0,1280,720);
     con.setDrawColor(new Color(229, 177, 58));
     con.drawString("Star Wars", 360, intCrawlY);
     con.drawString("Pre Sequel: HOPE", 150, intCrawlY2);
     con.repaint();
     intCrawlY = (intCrawlY - 1);
     intCrawlY2 = (intCrawlY2 - 1);
     intCrawl = (intCrawl + 2);
     //pause(1500/60); 
     if(intCrawl == 460){
     con.drawString("Play", 520, 375);
     con.drawString("Help", 520, 500);
     con.drawString("Quit", 520, 625);  
     con.repaint();
    }
   }  
      
    char chrGet = 'a';
    int intKey;
    int intFlicker = 1;
    int intFlickerY = 300;                        
 
 //=========Menu Selection Flicker Tingy===========    
 // I know it kind of sucks but, in order for you to move the 
 // select tingy, you need to hold the 'w' button to go up and the 's' button to go down 
 // and to select something, hold d
    
      while(intFlicker != 3){
        con.setDrawColor(new Color(229, 177, 58));
        con.fillRect(480, intFlickerY, 30, 80);
        con.repaint();
        pause(500);
      
        con.setDrawColor(Color.BLACK);
        con.fillRect(480, intFlickerY, 30, 80);
        con.repaint();
        pause(500); 
        
        chrGet = con.currentChar();
        
      if((chrGet == 'w') && intFlickerY != 300){
        intFlickerY = intFlickerY - 125;  
      }else if((chrGet == 's') && intFlickerY != 550){
        intFlickerY = intFlickerY + 125;       
      }
       //===========Quit============           
       if((chrGet == 'd') && intFlickerY == 550){
         System.exit(1);
       //===========Help Menu=======
       }else if((chrGet == 'd') && intFlickerY == 425){
         intFlickerY = 1300;
         con.setDrawColor(Color.BLACK);
         con.fillRect(0,0,1280,720);
         con.repaint();
         myfont = con.loadFont("STARWARS.ttf", 40);
         con.setDrawFont(myfont);
         con.setDrawColor(new Color(229, 177, 58));
         con.drawString("How to Play:", 20, 50);
         con.drawString("W to move up", 20, 150);
         con.drawString("S to move down", 40, 220);
         con.drawString("A to move left", 20, 290);
         con.drawString("D to move right", 30, 360);
         con.drawString("Battle Mode:", 530, 50);
         con.drawString("During a battle, you will see a", 530, 150);
         con.drawString("bar at the bottom of the screen.", 530, 220);
         con.drawString("Press 'E' to attack", 530, 290);
         con.drawString("If it lands on white,", 530, 360);
         con.drawString("You perform a light attack", 530, 430);
         con.drawString("If it lands on green,", 530, 500);
         con.drawString("You perform a heavy attack,", 530, 570);
         con.drawString("Press M to go back to the Main Menu", 20, 700);
         con.repaint(); 
       //=========Return to Main Menu=========
       }else if(chrGet == 'm'){
          RPGTools.mainmenu(con);
          intFlickerY = 300; 
       //=========Play============
       }else if(chrGet == 'd' && intFlickerY == 300){
         con.setDrawColor(Color.BLACK);
         con.fillRect(0,0,1280,720);
         con.repaint();
         intFlickerY = 1400;
         pause(2500);
         RPGTools.introcrawl(con);
         pause(1000);
         RPGTools.introprologue(con); 
         chrGet = con.getChar();
       if(chrGet == 'm'){
      
          con.setDrawColor(Color.BLACK);
          con.fillRect(0,0,1280,800);
          con.repaint();
          
          boolean inGame = true;
          char chrMove;

          RPGTools.readyimages();
          RPGTools.loadMap();
          RPGTools.drawBackground(con);
          con.drawImage(RPGTools.jedi,RPGTools.Xpos,RPGTools.Ypos);
          
          
          //=========Testing to see where the player is walking=============
          while(inGame == true){
            chrMove = con.getChar();
            if(chrMove == 'w'){
              if(!RPGTools.strMap[(RPGTools.Ypos/40)-1][(RPGTools.Xpos/40)].equalsIgnoreCase("w") || !RPGTools.strMap[(RPGTools.Ypos/40)-1][(RPGTools.Xpos/40)].equalsIgnoreCase("c1") || !RPGTools.strMap[(RPGTools.Ypos/40)-1][(RPGTools.Xpos/40)].equalsIgnoreCase("f1"))
              RPGTools.moveW(con);
            }else{
            }if(chrMove == 's'){
              if(!RPGTools.strMap[(RPGTools.Ypos/40)+1][(RPGTools.Xpos/40)].equalsIgnoreCase("w") || !RPGTools.strMap[(RPGTools.Ypos/40)+1][(RPGTools.Xpos/40)].equalsIgnoreCase("c1") || !RPGTools.strMap[(RPGTools.Ypos/40)+1][(RPGTools.Xpos/40)].equalsIgnoreCase("f1"))
              RPGTools.moveS(con);
            }else{
            }if(chrMove == 'a'){
              if(!RPGTools.strMap[(RPGTools.Ypos/40)][(RPGTools.Xpos/40)-1].equalsIgnoreCase("w") || !RPGTools.strMap[(RPGTools.Ypos/40)][(RPGTools.Xpos/40)-1].equalsIgnoreCase("c1") || !RPGTools.strMap[(RPGTools.Ypos/40)][(RPGTools.Xpos/40)-1].equalsIgnoreCase("f1"))
              RPGTools.moveA(con);
            }else{
            }if(chrMove == 'd'){
              if(!RPGTools.strMap[(RPGTools.Ypos/40)][(RPGTools.Xpos/40)+1].equalsIgnoreCase("w") || !RPGTools.strMap[(RPGTools.Ypos/40)][(RPGTools.Xpos/40)+1].equalsIgnoreCase("c1") || !RPGTools.strMap[(RPGTools.Ypos/40)][(RPGTools.Xpos/40)+1].equalsIgnoreCase("f1"))
              RPGTools.moveD(con);
            }else{
            }
          }
        }    
      }
    }
  }




   public static void pause(int intMS){
    try{
      Thread.sleep(intMS);
    }catch(InterruptedException e){
    }
   } 
   
}