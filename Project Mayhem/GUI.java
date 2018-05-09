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
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import common.Player;
import javax.swing.JTextPane;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSelectYourCollege;
	private JList list;
	private JLabel lblServerMessages;
	private JPanel panel_1;
	private JButton btnMove;

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
		panel.setBounds(6, 6, 211, 112);
		contentPane.add(panel);
		
		lblSelectYourCollege = new JLabel("Select your College");
		panel.add(lblSelectYourCollege);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Argyros", "Crean", "College of the Arts", "Dodge", "Schmid"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(list);
		
		lblServerMessages = new JLabel("Server Messages");
		lblServerMessages.setBounds(16, 130, 111, 38);
		contentPane.add(lblServerMessages);
		
		panel_1 = new JPanel();
		panel_1.setBounds(240, 6, 204, 137);
		contentPane.add(panel_1);
		
		btnMove = new JButton("Move 1");
		btnMove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("1");
			}
		});
		panel_1.add(btnMove);
		
		JButton btnMove_1 = new JButton("Move 2");
		btnMove_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("2");
			}
		});
		panel_1.add(btnMove_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(6, 160, 438, 112);

		contentPane.add(textPane);
		
	}
}
