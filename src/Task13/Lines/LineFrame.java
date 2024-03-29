
package Task13.Lines;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class LineFrame extends JFrame{

	public Lineball a = new Lineball();
	public JFrame GameOver = new JFrame(" GameOver !");

	public Icon icon[] = new Icon[22];
	public JButton button[][] = new JButton[9][9];
	public JMenuItem nextball[] = new JMenuItem[3];
	public JMenuItem score = new JMenuItem("0  ");
	public int x = -1, y = -1;

	//khoi tao
  	public LineFrame(){

    	icon[1] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\big1.png");
    	icon[2] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\big2.png");
    	icon[3] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\big3.png");
    	icon[4] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\big4.png");
    	icon[5] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\big5.png");
    	icon[6] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\big6.png");
    	icon[7] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\big7.png");

    	icon[8] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\small1.png");
    	icon[9] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\small2.png");
    	icon[10] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\small3.png");
    	icon[11] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\small4.png");
    	icon[12] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\small5.png");
    	icon[13] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\small6.png");
    	icon[14] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\small7.png");

    	icon[15] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\d1.gif");
		icon[16] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\d2.gif");
		icon[17] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\d3.gif");
		icon[18] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\d4.gif");
		icon[19] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\d5.gif");
		icon[20] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\d6.gif");
		icon[21] = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\d7.gif");

		for (int i=0;i<9;i++)
    	   for(int j=0;j<9;j++){
       		   button[i][j]=new JButton(icon[0]);
      	  	}

		for (int i=0;i<9;i++)
       		for(int j=0;j<9;j++)
        		add(button[i][j]);

		x=y=-1;

		setMenu();
		setButton();
		setTitle(" Lines ");
		setLayout(new GridLayout(9,9));
		setSize(520,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
        setVisible(true);
	 }
 //----------------------------------------------------------------------------------------
	//tao menu
	public void setMenu(){

		JMenuBar menu=new JMenuBar();
		menu.setLayout(new GridLayout(1,7));
		setJMenuBar(menu);
		JMenu gameMenu=new JMenu("Game");//them menu Game vao menu
		gameMenu.setMnemonic('g');
		menu.add(gameMenu);

		JMenuItem newItem=new JMenuItem("NewGame"); //them vao muc New
		newItem.setToolTipText(" NewGame selected ");
		newItem.setMnemonic('n');
		newItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				startGame();
		}
		});
	    gameMenu.add(newItem);

	    JMenuItem exitItem=new JMenuItem("Exit");//them vao muc exit
		exitItem.setToolTipText(" Exit selected ");
		exitItem.setMnemonic('e');
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
		}
		});
		gameMenu.add(exitItem);


		JMenu gameUtilities=new JMenu("Utilities");
		gameUtilities.setMnemonic('U');
		menu.add(gameUtilities);

		JMenuItem undoItem=new JMenuItem("StepBack");
		undoItem.setToolTipText("  StepBack selected ");
		undoItem.setMnemonic('b');
		undoItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
			     StepBack();

		}
		});
	    gameUtilities.add(undoItem);

	    for(int i=0;i<3;i++){
	    	nextball[i]= new JMenuItem();
	    	menu.add(nextball[i]);
	    }

	    Icon scoreIcon = new ImageIcon("E:\\Idea\\IdeaProjects\\VVP\\src\\Task13\\Images\\score.png");
	    score.setIcon(scoreIcon);
		menu.add(score);

	}
//----------------------------------------------------------------------------------------

    public void StepBack(){
    	a.Undo();
    	displayNextBall();
		score.setText((int)a.MarkResult+" ");
    	drawBall();

    }
//----------------------------------------------------------------------------------------

	public void drawBall(){
        for (int i=0;i<9;i++)
           	for (int j=0;j<9;j++){
           		 button[i][j].setIcon(icon[a.ball[i][j]]);

       }
	}
 //----------------------------------------------------------------------------------------
	public void displayNextBall(){
		for(int i=0;i<3;i++){
	    	nextball[i].setIcon(icon[a.nextcolor[i]]);
	    }
	}
 //----------------------------------------------------------------------------------------

	public void bounceBall(){
		for(int i=0;i<9;i++)
		  for(int j=0;j<9;j++)
				if(a.ball[i][j]>14)a.ball[i][j]-=14;

		if(x>=0&&y>=0)a.ball[x][y]+=14;

		drawBall();
	}
 //----------------------------------------------------------------------------------------

	public void setButton(){
	   for (int i=0;i<9;i++)
        for (int j=0;j<9;j++)
        	button[i][j].addActionListener( new ActionListener(){
			   public void actionPerformed(ActionEvent ae)
			   {
		      		for (int i=0;i<9;i++)
                 	   for(int j=0;j<9;j++)
           	       		if(ae.getSource()==button[i][j]){
           	       			Icon n = button[i][j].getIcon();

						 if(x!=i&&y!=j&&(n==icon[1]||n==icon[2]||n==icon[3]
							 ||n==icon[4]||n==icon[5]||n==icon[6]||n==icon[7]))
							{
								x=i;
								y=j;

							}
							else if(x==i&&y==j){
										x=y=-1;

									}
							   else if(x>-1&&y>-1&&(n==icon[0]||n==icon[8]||n==icon[9]||n==icon[10]
								        ||n==icon[11]||n==icon[12]||n==icon[13]||n==icon[14])){

								        	if(a.Loang(x,y,i,j)==true){
								        		a.saveUndo();
								        		try{moveBall(x,y,i,j);}catch(Exception e){}
								        		drawBall();
								        		if(a.cutBall()==false)a.new3Balls();
								        		a.cutBall();
								        		displayNextBall();
								        		drawBall();
												x=y=-1;
								        	}
								        }

							bounceBall();
							score.setText((int)a.MarkResult+" ");
							try{
								stopGame();
							}catch(IOException e){}

           	            }

			     }

		  });

	}
 //----------------------------------------------------------------------------------------

	public void moveBall(int i,int j,int ii,int jj)throws Exception{

		   a.ball[ii][jj] = a.ball[i][j]-14;
		   a.ball[i][j] = 0;
		   for(int k=0;k<22;k++)
		   	  if(button[i][j].getIcon()==icon[k])
		   	  	button[ii][jj].setIcon(icon[k-14]);
		   	  button[i][j].setIcon(icon[0]);
	}

 //----------------------------------------------------------------------------------------

	public void startGame(){
		a.StartGame();
		score.setText("0 ");
		displayNextBall();
		drawBall();
		x=y=-1;

	}
 //----------------------------------------------------------------------------------------

	public void stopGame()    throws IOException{
		if(a.gameover==true){
			JOptionPane.showMessageDialog(this, "Game over! Your score: " + (int) a.MarkResult);
			startGame();
		}
	}
 //----------------------------------------------------------------------------------------

}
