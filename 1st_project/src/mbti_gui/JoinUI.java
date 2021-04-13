package mbti_gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class JoinUI {
	//Field
	MainUI main;
	JFrame f;
	Panel label_panel, tf_panel, btn_panel;
	JButton join, cancel;
	Label textlabel, fieldlabel;
	String namelist[] = {"아이디","비밀번호","비밀번호확인","MBTI"};
	String namelist2[] = {"아이디","비밀번호","비밀번호확인","MBTI"};
	ArrayList<Object> list = new ArrayList<Object>();
	
	//Constructor
	public JoinUI() {
		init();
	}
	
	public JoinUI(MainUI main) {
		this.main = main;
		init();
	}
	//Method
	public void init() {
		f = new JFrame("회원가입");
		label_panel = new Panel(new GridLayout(4,1));
		tf_panel = new Panel(new GridLayout(4,1));
		btn_panel = new Panel();
		join = new JButton("회원가입");
		join.setFont(Commons.getFont());
		cancel = new JButton("입력취소");
		cancel.setFont(Commons.getFont());
		btn_panel.add(join);	btn_panel.add(cancel);
		
		for(String name : namelist) {
			Panel l_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
			Label textlabel = new Label(name); 
			l_panel.add(textlabel);
			label_panel.add(l_panel);
			
			Panel t_panel = new Panel(new FlowLayout(FlowLayout.LEFT));

			if(name.equals("비밀번호") || name.equals("비밀번호확인")) {
				JPasswordField tf = new JPasswordField(24);
				t_panel.add(tf);
				tf_panel.add(t_panel);
				list.add(tf);
				
			}else {
				JTextField tf = new JTextField(24);
				t_panel.add(tf);
				tf_panel.add(t_panel);
				list.add(tf);
			}
		}
		
		f.add(BorderLayout.WEST,label_panel);
		f.add(BorderLayout.CENTER,tf_panel);
		f.add(BorderLayout.SOUTH,btn_panel);
		
		f.setSize(400, 550);
		f.setLocation(650, 300);
		f.setVisible(true);
		
		f.addWindowListener(new JoinUIEvent());
		join.addActionListener(new JoinUIEvent(this,main));
		cancel.addActionListener(new JoinUIEvent(this));
	}
	
}
