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
	String namelist[] = {"���̵�","��й�ȣ","��й�ȣȮ��","MBTI"};
	String namelist2[] = {"���̵�","��й�ȣ","��й�ȣȮ��","MBTI"};
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
		f = new JFrame("ȸ������");
		label_panel = new Panel(new GridLayout(4,1));
		tf_panel = new Panel(new GridLayout(4,1));
		btn_panel = new Panel();
		join = new JButton("ȸ������");
		join.setFont(Commons.getFont());
		cancel = new JButton("�Է����");
		cancel.setFont(Commons.getFont());
		btn_panel.add(join);	btn_panel.add(cancel);
		
		for(String name : namelist) {
			Panel l_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
			Label textlabel = new Label(name); 
			l_panel.add(textlabel);
			label_panel.add(l_panel);
			
			Panel t_panel = new Panel(new FlowLayout(FlowLayout.LEFT));

			if(name.equals("��й�ȣ") || name.equals("��й�ȣȮ��")) {
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
