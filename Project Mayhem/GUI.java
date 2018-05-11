import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Scanner;
import java.io.*;

public class GUI extends JFrame {

	private JPanel contentPane; //contains everything
	private JPanel panel; //top left panel, contains two labels, a text field, and a list (Name and College)
	private JLabel lblSelectYourCollege;//Label before the next list
	private JLabel lblServerMessages;//label above window where terminal messages are printed
	private JPanel panel_1; //top right panel, contains 4 move buttons
	private JButton btnMove_1;
	private JButton btnArgyros;
	private JButton btnCrean;
	private JButton btnCOPA;
	private JButton btnDodge;
	private JButton btnSchmid;
	private String tempMove3;
	private String tempMove4;
	private int move3Out = 3;
	private int move4Out = 4;
	private Scanner keyboard = new Scanner(System.in);

	public int moveNum;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public void setMoveNum(int m) {
		this.moveNum = m;
	}

	public int getMoveNum(){
		return this.moveNum;
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setBounds(6, 6, 211, 124);
		contentPane.add(panel);



		lblServerMessages = new JLabel("Server Messages");
		lblServerMessages.setBounds(16, 130, 111, 38);
		contentPane.add(lblServerMessages);

		panel_1 = new JPanel();
		panel_1.setBounds(240, 6, 204, 137);
		contentPane.add(panel_1);


		//Move buttons below


		btnMove_1 = new JButton("Basic Attack 1");//move1
		btnMove_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					File fout = new File("Text.txt");
					FileOutputStream fos = new FileOutputStream(fout);

					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
					try {
						bw.write("1");
						bw.close();
					}
					catch(IOException ex){
        		System.out.println (ex.toString());
        		System.out.println("Could not find file ");
    			}
					moveNum = 1;
					System.out.println(moveNum);
				}
					catch (FileNotFoundException n) {
      		n.printStackTrace();
				}
			}


		});
		panel_1.add(btnMove_1);//move 1

		JButton btnMove_2 = new JButton("Basic Attack 2");
		btnMove_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					File fout = new File("Text.txt");
					FileOutputStream fos = new FileOutputStream(fout);

					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
					try {
						bw.write("2");
						bw.close();
					}
					catch(IOException ex){
						System.out.println (ex.toString());
						System.out.println("Could not find file ");
					}
					moveNum = 2;
					System.out.println(moveNum);
				}
					catch (FileNotFoundException n) {
					n.printStackTrace();
				}
			}
		});
		panel_1.add(btnMove_2);//move2

		String tempMove3 = "Move 3";
		JButton btnMove_3 = new JButton(tempMove3);//move3
		btnMove_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					File fout = new File("Text.txt");
					FileOutputStream fos = new FileOutputStream(fout);

					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
					try {
						String m = Integer.toString(move3Out);
						bw.write(m);
						bw.close();
					}
					catch(IOException ex){
						System.out.println (ex.toString());
						System.out.println("Could not find file ");
					}
					moveNum = move3Out;
					System.out.println(move3Out);
				}
					catch (FileNotFoundException n) {
					n.printStackTrace();
				}
			}
		});
		panel_1.add(btnMove_3);

		String tempMove4 = "Move 4";
		JButton btnMove_4 = new JButton(tempMove4);//move4
		btnMove_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					File fout = new File("Text.txt");
					FileOutputStream fos = new FileOutputStream(fout);

					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
					try {
						String m = Integer.toString(move4Out);
						bw.write(m);
						bw.close();
					}
					catch(IOException ex){
						System.out.println (ex.toString());
						System.out.println("Could not find file ");
					}
					moveNum = move4Out;
					System.out.println(move4Out);
				}
					catch (FileNotFoundException n) {
					n.printStackTrace();
				}
			}
		});
		panel_1.add(btnMove_4);


		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(6, 160, 438, 112);

		contentPane.add(textPane);


		//Here you select your college by clicking one of the college buttons in the top left side of the GUI.
		//After clicking one of the college buttons, the move 3 and move 4 button on the right side of the gui
		//changes name and output, based on the college you selected.
		lblSelectYourCollege = new JLabel("Select your College");
		panel.add(lblSelectYourCollege);

		btnArgyros = new JButton("Argyros");
		btnArgyros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMove_3.setText("Argyros Move 3");
				btnMove_4.setText("Argyros Move 4");
				move3Out = 7; //argyros move 3
				move4Out = 12; //argyros move 4
			}
		});
		panel.add(btnArgyros);

		btnCOPA = new JButton("COPA");
		btnCOPA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnCOPA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMove_3.setText("COPA Move 3");
				btnMove_4.setText("COPA Move 4");
				move3Out = 4; //move 3 COPA
				move4Out = 9; //move 4 COPA
			}
		});
		panel.add(btnCOPA);

		btnCrean = new JButton("Crean");
		btnCrean.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMove_3.setText("Crean Move 3");
				btnMove_4.setText("Crean Move 4");
				move3Out = 6;//move 3 CREAN
				move4Out = 11;//move 4 CREAN
			}
		});
		panel.add(btnCrean);

		btnDodge = new JButton("Dodge");
		btnDodge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMove_3.setText("Dodge Move 3");
				btnMove_4.setText("Dodge Move 4");
				move3Out = 5; //move 3 Dodge
				move4Out = 10; //move 4 Dodge
			}
		});
		panel.add(btnDodge);

		btnSchmid = new JButton("Schmid");
		btnSchmid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMove_3.setText("Schmid Move 3");
				btnMove_4.setText("Schmid Move 4");
				move3Out = 3; //move 3 Schmid
				move4Out = 8; //move 4 Schmid
			}
		});
		panel.add(btnSchmid);

	}
}
