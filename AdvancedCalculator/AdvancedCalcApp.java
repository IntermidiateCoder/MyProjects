package AdvancedCalculator;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdvancedCalcApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private Calculator c;
	JButton sqrt, calc, switcher;
	JTextField typingField;
	JPanel thePanel;
	
	public static void main(String[] args) {
		new AdvancedCalcApp();
	}
	
	public AdvancedCalcApp() {
		c = new Calculator();
		this.setSize(400, 400); // frame size
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos); // locating the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Advanced Calculator");
		thePanel = new JPanel();
		// Listeners
		ListenForButton lForButton = new ListenForButton();
		ListenForSwitch lForSwitch = new ListenForSwitch();
		ListenForKey lForKey = new ListenForKey();
		ListenForMouse lForMouse = new ListenForMouse();
		ListenForCalc lForCalc = new ListenForCalc(); 
		// Adding components
		thePanel.setLayout(null);
		typingField = new JTextField("Write the problem here", 15);
		typingField.setLocation(75, 115);
		typingField.setSize(215,30);
		typingField.addKeyListener(lForKey);
		typingField.addMouseListener(lForMouse);
		sqrt = new JButton("√");
		sqrt.setSize(45, 30);
		sqrt.setLocation(75, 86);
		sqrt.addActionListener(lForButton);
		calc = new JButton("Calculate");
		calc.setSize(90, 29);
		calc.setLocation(289, 115);
		calc.addActionListener(lForCalc);
		switcher = new JButton("Switch");
		switcher.setSize(75,30);
		switcher.setLocation(0, 0);
		switcher.addActionListener(lForSwitch);
		thePanel.add(switcher);
		thePanel.add(calc);
		thePanel.add(sqrt);
		thePanel.add(typingField);
		this.add(thePanel);	
		this.setVisible(true);
	}
	// Closes the JFrame
	private void close() {
		this.setVisible(false);
		this.dispose();
	}
	private class ListenForButton implements ActionListener {
		// when the √ button is pressed print √ 
		public void actionPerformed(ActionEvent arg0) { 
			if (typingField.getText().equals("Write the problem here"))
				typingField.setText("√");
			else
				typingField.setText(typingField.getText()+"√");
			typingField.grabFocus();
		}
		
	}
	
	private class ListenForSwitch implements ActionListener {
		// Switch between the calculators.
		public void actionPerformed(ActionEvent e) {
			close();
			new SimpleCalcApp();
		}
		
	}
	
	private class ListenForCalc implements ActionListener {
		// when the solve button is pressed solve the expression is typingField.
		public void actionPerformed(ActionEvent e) {
			try {
				double[] answers = c.findX(typingField.getText());
				JOptionPane.showMessageDialog(null, "The answer is: " + printResults(answers));
			}catch(Exception ee) {
				JOptionPane.showMessageDialog(null, "Invalid Expression");
			}finally {
				typingField.setText("");
			}
		}
		// Prints answers.
		private String printResults(double[] answers) {
			String answer = "";
			for(double d : answers) {
				answer += Double.toString(d) + ", ";
			}
			
			return answer;
		}
		
	}
	
	private class ListenForKey implements KeyListener {
		// when the solve button is pressed solve the expression is typingField.
		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyChar() == KeyEvent.VK_ENTER) {
				try {
					double[] answers = c.findX(typingField.getText());
					JOptionPane.showMessageDialog(null, "The answer is: " + printResults(answers));
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Expression");
				}finally {
					typingField.setText("");
				}
			}
		}
		// Prints answers.
		private String printResults(double[] answers) {
			String answer = "";
			for(double d : answers) {
				answer += Double.toString(d) + ", ";
			}
			
			return answer;
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class ListenForMouse implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (typingField.getText().equals("Write the problem here"))
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

