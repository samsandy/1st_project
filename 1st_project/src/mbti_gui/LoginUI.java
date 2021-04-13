package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI implements ActionListener{
	//Field
	MainUI main;
	JButton btn_login, btn_join;
	JTextField id_tf;
	JPasswordField pw_tf;
	
	//Constructor
	public LoginUI() {}
	public LoginUI(MainUI main) {
		this.main = main;
	}
	
	//Method
	public void init() {
		main.firstFrame = new JFrame("Login");
		JPanel main_panel = new JPanel(new BorderLayout());
		
		ImageIcon icon = new ImageIcon("images/mainlogo.png");
		JLabel title_label = new JLabel(icon);
		
		JPanel main_label_panel = new JPanel();
		JPanel label_panel = new JPanel(new GridLayout(2,1,10,10));
		JPanel tf_panel = new JPanel(new GridLayout(2,1,10,10));
		JPanel btn_panel = new JPanel();
		
		main_label_panel.add(title_label);
		
		JLabel id = new JLabel("ID");
		JLabel pw = new JLabel("PW");
		JTextField tf_id = new JTextField(10);
		JPasswordField pf_pw = new JPasswordField(10);
		
		id.setFont(Commons.getFont());
		pw.setFont(Commons.getFont());
		tf_id.setFont(Commons.getFont());
		pf_pw.setFont(Commons.getFont());
		
		label_panel.add(id);	label_panel.add(pw);	
		tf_panel.add(tf_id);	tf_panel.add(pf_pw);
		
		btn_login = new JButton("Login");
		btn_join = new JButton("Join");
		btn_login.setFont(Commons.getFont());
		btn_join.setFont(Commons.getFont());
		btn_panel.add(btn_login);		btn_panel.add(btn_join);
		
		JPanel login_panel = new JPanel();
		login_panel.add(label_panel);
		login_panel.add(tf_panel);
		
		main_panel.add(BorderLayout.NORTH,main_label_panel);
		main_panel.add(BorderLayout.CENTER,login_panel);
		main_panel.add(BorderLayout.SOUTH,btn_panel);
		
		main_label_panel.setBackground(Color.white);
		login_panel.setBackground(Color.white);
		btn_panel.setBackground(Color.white);
		label_panel.setBackground(Color.white);
		tf_panel.setBackground(Color.white);
		
		main.firstFrame.add(main_panel);
		
		main.firstFrame.setSize(600,500);
	
		Dimension fsize = main.firstFrame.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		main.firstFrame.setLocation(width, height);
		
		main.firstFrame.setVisible(true);
		
		main.firstFrame.addWindowListener(new WindowAdapter() {
			public void	windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		main.firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		btn_login.addActionListener(this);
		id_tf.addActionListener(this);
		pw_tf.addActionListener(this);
		btn_join.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_login/* || obj == main.id_tf || obj == main.pw_tf*/) {
			btn_login.addActionListener(this);
		}else if(obj == btn_join) {
			new JoinUI(main);
		}
	}
	
	
}
