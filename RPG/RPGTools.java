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

public class RPGTools{
  
  //==========Main Menu=========
  public static void mainmenu(Console con){
     Font myfont;
     myfont = con.loadFont("STARWARS.ttf", 100);
     con.setDrawFont(myfont);
     con.setDrawColor(Color.BLACK);
     con.fillRect(0,0,1280,800);
     con.setDrawColor(new Color(229, 177, 58));
     con.drawString("Star Wars", 360, 120);
     con.drawString("Pre Sequel: HOPE", 150, 199);
     con.repaint();
     pause(1500/60); 
     con.drawString("Play", 520, 375);
     con.drawString("Help", 520, 500);
     con.drawString("Quit", 520, 625);  
     con.repaint();
   }  
  
  //==========Intro Beginning===========
  public static void introcrawl(Console con){
  Font myfont;
    
    myfont = con.loadFont("FranklinGothicBookRegular.ttf", 60);
    con.setTextFont(myfont); 
    con.setTextColor(new Color(75, 213, 238));
     
    con.println("");
    con.println("");
    con.println("");
    con.println("");
    con.println("                 A long time ago, in a galaxy far,");
    con.println("                 far away...");
    
    pause(3500);
    con.clear();
    
    myfont = con.loadFont("STARWARS.ttf", 150);
    con.setTextFont(myfont);
    con.setTextColor(new Color(255, 235, 31));
    
    pause(2500);
    
    con.println("");
    con.println("");
    con.println("  STAR WARS");
    
    pause(4500);
    con.clear();
    
    //==========Intro End============
    
    pause(1500);
    
    myfont = con.loadFont("STARWARS.ttf", 100);
    con.setDrawFont(myfont);
    con.setDrawColor(new Color(229, 177, 58));  
  }
  
  //===========Prologue Crawl===========
  public static void introprologue(Console con){
    
    Font myfont;
    int intTitle1 = 900;
    int intTitle2 = 980;
    int intSentence1 = 1060;
    int intSentence2 = 1100;
    int intSentence3 = 1140;
    int intSentence4 = 1180;
    int intSentence5 = 1220;
    int intSentence6 = 1310;
    int intSentence7 = 1350;
    int intSentence8 = 1390;
    int intContinue = 1580;
    
    while(intTitle1 != 100){
      
     con.setDrawColor(Color.BLACK);
     con.fillRect(0,0,1280,800);
     
     myfont = con.loadFont("STARWARS.ttf", 80);
     con.setDrawFont(myfont);
     con.setDrawColor(new Color(229, 177, 58));
          
     con.drawString("Pre-Sequel:", 400, intTitle1);
     con.drawString("Hope", 510, intTitle2);
    
     myfont = con.loadFont("STARWARS.ttf", 35);
     con.setDrawFont(myfont);
    
     con.drawString("(3,600 years before the Clone Wars) There has been a war", 50, intSentence1); 
     con.drawString("between the re-emergent Sith Empire and the Galactic Republic,", 20, intSentence2);
     con.drawString("that has been going on for 28 years now. This caused the jedi", 20, intSentence3);
     con.drawString("to relocate from Corasant to Tython, where the jedi order had", 20, intSentence4);
     con.drawString("been initially founded, to seek guidance from the force.", 20, intSentence5);
     con.drawString("A Sith Lord by the name of Darth Malagus, has attacked the", 20, intSentence6);
     con.drawString("Jedi Temple on Courasant with a party of Sith Acolytes, killing", 20, intSentence7);
     con.drawString("many jedi, padawans, and younglings", 20, intSentence8);
     con.drawString("Press 'M' to continue", 20, intContinue); 
     con.repaint();
     
     intTitle1 = intTitle1 - 2;
     intTitle2 = intTitle2 - 2;
     intSentence1 = intSentence1 - 2;
     intSentence2 = intSentence2 - 2;
     intSentence3 = intSentence3 - 2;
     intSentence4 = intSentence4 - 2;
     intSentence5 = intSentence5 - 2;
     intSentence6 = intSentence6 - 2;
     intSentence7 = intSentence7 - 2;
     intSentence8 = intSentence8 - 2;
     intContinue = intContinue - 2;
     pause(1500/60);     
  }   
}
    
  //==========Loading the Array=============
  static String[][] strMap = new String[20][20];  
  
  public static void loadMap(){ 
    
    TextInputFile map = new TextInputFile("RPGmap.txt"); 
    
    String strLine;     
    String strSplit[];
    int intRow;
    int intColumn;
    
    for(intRow =0;intRow <20;intRow++){
      strLine = map.readLine();
      strSplit = strLine.split(",");
      for(intColumn =0;intColumn <20;intColumn++){
        strMap[intRow][intColumn] = strSplit[intColumn]; 
      }
    }
  }
  
  //========Background Images========
  static BufferedImage carpet;
  static BufferedImage enemy;
  static BufferedImage jedi;
  static BufferedImage pathway;
  static BufferedImage pillar1;
  static BufferedImage pillar2;
  static BufferedImage wall;
  
 //=========Load Image==============
 public static BufferedImage loadimage(String strSource){
   
    File image;
    BufferedImage bufferedimage;
    image = null;
    bufferedimage = null; 
    
    try{
      image = new File(strSource);
      bufferedimage = ImageIO.read(image);
    }catch(IOException e){
    } 
    return bufferedimage;
  }
 
  //==========Putting loaded images into variables============
  public static void readyimages(){
   carpet = RPGTools.loadimage("StarWarsRPGCarpet1Enlarged.png");
   enemy = RPGTools.loadimage("StarWarsRPGEnemy3Enlarged.png");
   jedi = RPGTools.loadimage("StarWarsRPGJediOoC2Enlarged.png");
   pathway = RPGTools.loadimage("StarWarsRPGPathwayEnlarged.png");
   pillar1 = RPGTools.loadimage("StarWarsRPGPillar1Enlarged.png");
   pillar2 = RPGTools.loadimage("StarWarsRPGPillar2Enlarged.png");
   wall = RPGTools.loadimage("StarWarsRPGWallEnlarged.png"); 
  }
    
  //======Variables======
  static int Xpos;
  static int Ypos;
  
  //===========Drawing the Background============
   public static void drawBackground(Console con){
     
    int intColumn;
    int intRow;
    
    for(intColumn = 0;intColumn<20;intColumn++){
      for(intRow = 0;intRow<20;intRow++){    
        if(RPGTools.strMap[intColumn][intRow].equals("c") || RPGTools.strMap[intColumn][intRow].equals("c1") || RPGTools.strMap[intColumn][intRow].equals("e") || RPGTools.strMap[intColumn][intRow].equals("p1") || RPGTools.strMap[intColumn][intRow].equals("p2")){
          con.drawImage(carpet, intRow*40, intColumn*40); 
        }
        if(RPGTools.strMap[intColumn][intRow].equals("f") || RPGTools.strMap[intColumn][intRow].equals("f1") || RPGTools.strMap[intColumn][intRow].equals("j")){
          con.drawImage(pathway, intRow*40, intColumn*40); 
        }
        if(RPGTools.strMap[intColumn][intRow].equals("w")){
          con.drawImage(wall, intRow*40, intColumn*40); 
        }
        if(RPGTools.strMap[intColumn][intRow].equals("e")){
          con.drawImage(enemy, intRow*40, intColumn*40);
        }        
        if(RPGTools.strMap[intColumn][intRow].equals("j")){
          Xpos = intRow*40;
          Ypos = intColumn*40;
        }
        con.repaint();
      }
    }
    for(intColumn = 0;intColumn<20;intColumn++){
      for(intRow = 0;intRow<20;intRow++){
       if(RPGTools.strMap[intColumn][intRow].equals("p1")){
          con.drawImage(pillar1, intRow*40, intColumn*40); 
        }
        if(RPGTools.strMap[intColumn][intRow].equals("p2")){
          con.drawImage(pillar2, intRow*40, intColumn*40); 
        }
      }
      con.repaint();
    }
    for(intColumn = 0;intColumn<20;intColumn++){
      for(intRow = 0;intRow<20;intRow++){
       if(RPGTools.strMap[intColumn][intRow].equals("e")){
          con.drawImage(enemy, intRow*40, intColumn*40); 
      }
      con.repaint();
    }
  }  
}    
   
   //========Drawing Squares Around Character==========
   public static void drawSquare(int intRow,int intColumn, Console con){
    if(RPGTools.strMap[intColumn][intRow].equals("c") || RPGTools.strMap[intColumn][intRow].equals("e") || RPGTools.strMap[intColumn][intRow].equals("p1") || strMap[intColumn][intRow].equals("p2")){
      con.drawImage(carpet,intRow*40,intColumn*40); 
    }
    if(RPGTools.strMap[intColumn][intRow].equals("f") || RPGTools.strMap[intColumn][intRow].equals("j")){
      con.drawImage(pathway,intRow*40,intColumn*40); 
    }
    if(RPGTools.strMap[intColumn][intRow].equals("p1")){
      con.drawImage(pillar1,intRow*40,intColumn*40); 
    }
    if(RPGTools.strMap[intColumn][intRow].equals("p2")){
      con.drawImage(pillar2,intRow*40,intColumn*40); 
    }
    if(RPGTools.strMap[intColumn][intRow].equals("w")){
      con.drawImage(wall,intRow*40,intColumn*40); 
    }
    con.repaint();
  }
   
 //========Moving==========
   //======Moving Up=======
    public static void moveW(Console con){
      
      for(int intCount=0;intCount<5;intCount++){
      drawSquare(Xpos/40,((Ypos+39)/40),con);
      drawSquare(Xpos/40,((Ypos+39)/40)-1,con);
      drawSquare(Xpos/40-1,((Ypos+39)/40)-1,con);
      drawSquare(Xpos/40-1,((Ypos+39)/40),con);
      drawSquare(Xpos/40+1,((Ypos+39)/40),con);
      Ypos -=40/5;
      if(intCount == 0){
        con.drawImage(jedi,Xpos,Ypos);  
      }else if(intCount == 1){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 2){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 3){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 4){
        con.drawImage(jedi,Xpos,Ypos); 
      }
      con.repaint();
      pause(60);
    }
  }      
   
    //=========Moving Down=========
     public static void moveS(Console con){
      
      for(int intCount=0;intCount<5;intCount++){
      drawSquare(Xpos/40,((Ypos+39)/40),con);
      drawSquare(Xpos/40,((Ypos+39)/40)-1,con);
      drawSquare(Xpos/40-1,((Ypos+39)/40)-1,con);
      drawSquare(Xpos/40+1,((Ypos+39)/40)-1,con);
      drawSquare(Xpos/40-1,((Ypos+39)/40),con);
      drawSquare(Xpos/40+1,((Ypos+39)/40),con);
      Ypos +=40/5;
      if(intCount == 0){
        con.drawImage(jedi,Xpos,Ypos);  
      }else if(intCount == 1){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 2){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 3){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 4){
        con.drawImage(jedi,Xpos,Ypos); 
      }
      con.repaint();
      pause(60);
    }   
   }
     
     //===========Moving Left==========
      public static void moveA(Console con){
      
      for(int intCount=0;intCount<5;intCount++){
      drawSquare((Xpos+39)/40,(Ypos/40),con);
      drawSquare(((Xpos+39)/40)-1,(Ypos/40),con);
      drawSquare(((Xpos+39)/40)+1,(Ypos/40),con);
      Xpos -=40/5;
      if(intCount == 0){
        con.drawImage(jedi,Xpos,Ypos);  
      }else if(intCount == 1){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 2){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 3){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 4){
        con.drawImage(jedi,Xpos,Ypos); 
      }
      con.repaint();
      pause(60);
    }  
   }
      
      //===========Moving Right=========
      public static void moveD(Console con){
      
      for(int intCount=0;intCount<5;intCount++){
      drawSquare((Xpos+39)/40,(Ypos/40),con);
      drawSquare(((Xpos+39)/40)-1,(Ypos/40),con);
      drawSquare(((Xpos+39)/40)-2,(Ypos/40),con);
      Xpos +=40/5;
      if(intCount == 0){
        con.drawImage(jedi,Xpos,Ypos);  
      }else if(intCount == 1){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 2){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 3){
        con.drawImage(jedi,Xpos,Ypos); 
      }else if(intCount == 4){
        con.drawImage(jedi,Xpos,Ypos); 
      }
      con.repaint();
      pause(60);
    }      
   }

  //========Pause==========
  public static void pause(int intMS){
    try{
      Thread.sleep(intMS);
    }catch(InterruptedException e){
    }
   } 
  
 } 