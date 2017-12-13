package TypingSpeedTest;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.io.*;

@SuppressWarnings("serial")
public class SpeedTyping extends JFrame {
	int highScore, lastScore, cpm, wpm, fails, timeLeft;
	long time;
	JTextField typingField;
	JTextArea wordsArea;
	JButton reset;
	JLabel hScore, lScore, timer;
	boolean gameOn = false;
	Queue<String> words = new ArrayQueue<String>(10);
	
	public static void main(String[] args) {
		new SpeedTyping();
	}
	
	public SpeedTyping() { 
		this.setSize(400, 400); // frame size
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos); // locating the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Typing Speed Test");
		JPanel thePanel = new JPanel();
		ListenForButton lForButton = new ListenForButton();
		ListenForKey lForKey = new ListenForKey();
		ListenForMouse lForMouse = new ListenForMouse();
		typingField = new JTextField("Press any key to start", 15);
		typingField.addKeyListener(lForKey);
		typingField.addMouseListener(lForMouse);
		wordsArea = new JTextArea(8, 30);
		wordsArea.setLineWrap(true);
		wordsArea.setWrapStyleWord(true);
		wordsArea.setText(getFirst10()); // displays 10 words in the Text Area
		timer = new JLabel("Time Left: ");
		hScore = new JLabel("HighScore: ");
		lScore = new JLabel("LastScore: ");
		reset = new JButton("Reset");
		reset.addActionListener(lForButton);
		thePanel.add(hScore);
		thePanel.add(lScore);
		thePanel.add(timer);
		thePanel.add(reset);
		thePanel.add(wordsArea);
		thePanel.add(typingField);
		this.add(thePanel);	
		this.setVisible(true);
	}
	
	// returns 10 words
	private String getFirst10() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10; i++) 
			sb.append(randomWord() + " ");
		return sb.toString();
	}
	
	// returns a random word
	private String randomWord() {
		String word = "";
		try {
			File f = new File("/JavaProjectsOT/src/words.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			int rnd = (int) (Math.random() * 1749) + 1;
			int i=0;
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				i++;
				if(rnd == i)
					word += line;
			}
			br.close();
			
		}catch (IOException e){
			e.printStackTrace();
		}
		words.enqueue(word);
		return word + " ";
	}
	
	// return true if input equals expected otherwise false
	private boolean isCorrect(String input, String expected) {
		return input.equals(expected);
	}
	
	// starts the game
	private void startGame() {
		gameOn = true;
		if(words.isEmpty())
			wordsArea.setText(getFirst10());
		time = System.currentTimeMillis() / 1000L + 60;
		timeLeft = 60;
		timer.setText("Time Left: " + Integer.toString(timeLeft));		
	}
	
	// dequeues and then enqueues new word, increments wpm and cpm if isCorrect() resets typingField updates timer
	private void updateWords() {
		String input = typingField.getText();
		String expected = words.dequeue();
		typingField.setText("");
		randomWord();
		wordsArea.setText(getWords());
		if(isCorrect(input, expected)) {
			wpm++;
			cpm += input.length();
		}else
			fails++;
		updateTimer();
		
	}
	
	// Returns the ArrayQueue as a String
	private String getWords() {
		String wordsToShow = "";
		try {
			ArrayQueue<String> temp = (ArrayQueue<String>) words.clone();
			while(temp.first() != null) {
				wordsToShow += temp.dequeue();
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return wordsToShow;
	}
	
	// updates time until the end of the game
	private void updateTimer() {
		timeLeft = (int) (time - System.currentTimeMillis() / 1000L);
		if(timeLeft <= 0)
			endGame();
		timer.setText("Time Left: " + Integer.toString(timeLeft));
		
	}
	
	// ends the game
	private void endGame() {
		gameOn = false;
		if(cpm > highScore) {
			highScore = cpm;
			hScore.setText("HighScore: " + highScore);
		}
		lastScore = cpm;
		lScore.setText("LastScore: " + lScore);
		wordsArea.setText(results());
		while(words.first() != null)
			words.dequeue();
	}
	
	// returns results of the game
	private String results() {
		return " GOOD GAME!\n You scored " + cpm + " CPM, " + wpm + " WPM and you missed " + fails + " words";
	}
	
	public class ListenForKey implements KeyListener {

		public void keyPressed(KeyEvent arg0) {
			if(!gameOn && typingField.getText() == "")
				startGame();
			else if(gameOn && arg0.getKeyChar() == KeyEvent.VK_SPACE)
				updateWords();
		}
		public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}	
	}
	
	public class ListenForButton implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == reset)
				endGame();
		}

	}
	
	public class ListenForMouse implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			typingField.setText("");
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}