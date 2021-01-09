package cn.edu.jsu.lkm.ifc;

import java.awt.*;

import javax.swing.*;

import cn.edu.jsu.lkm.test.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 主界面
 * @author mycom
 *
 */
public class MainInterface {
	
	/**
	 * 主界面
	 */
	public MainInterface() {
	}

	private JFrame frame;
	private Container cont;
	private JTabbedPane tabPane;//选择窗格
	private JPanel panA;
	private JPanel panB;
	private JPanel panC;
	
	/**
	 * 自定义类实现主界面的布局
	 */
	public void init() {
		frame=new JFrame("水资源管理主界面");
		cont=frame.getContentPane();
		tabPane=new JTabbedPane(JTabbedPane.TOP);
		tabPane.setBackground(Color.LIGHT_GRAY);
		panA=new JpaneMain();
		panA.setToolTipText("");
		panB=new JpaneMain();
		panC=new JpaneMain();
		
		frame.setSize(548,492);
		frame.setLocation(450,300);
		
		cont.add(tabPane);
		tabPane.addTab("管理", panA);
		panA.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 554, 23);
		panA.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u6C34\u6E90\u4FE1\u606F");
		mnNewMenu.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u67E5\u770B\u6240\u6709\u6C34\u6E90\u4FE1\u606F");
		mntmNewMenuItem.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTable f = new FrmTable();
				f.setLocationRelativeTo(null);
				f.setVisible(true);		
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u589E\u52A0\u6C34\u6E90\u6570\u636E");
		mntmNewMenuItem_1.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTable f = new FrmTable();
				f.setLocationRelativeTo(null);
				f.setVisible(true);	
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5220\u9664\u6C34\u6E90\u4FE1\u606F");
		mntmNewMenuItem_2.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTable f = new FrmTable();
				f.setLocationRelativeTo(null);
				f.setVisible(true);	
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u4FEE\u6539\u6C34\u6E90\u4FE1\u606F");
		mntmNewMenuItem_3.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTable f = new FrmTable();
				f.setLocationRelativeTo(null);
				f.setVisible(true);	
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u67E5\u8BE2\u6307\u5B9A\u6C34\u6E90\u4FE1\u606F");
		mntmNewMenuItem_8.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTable f = new FrmTable();
				f.setLocationRelativeTo(null);
				f.setVisible(true);	
			}
		});
		mnNewMenu.add(mntmNewMenuItem_8);
		tabPane.addTab("治理",panB);
		panB.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBackground(Color.LIGHT_GRAY);
		menuBar_1.setBounds(0, 0, 554, 23);
		panB.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u65B9\u6848");
		mnNewMenu_1.setBackground(Color.LIGHT_GRAY);
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u6CBB\u7406\u6C61\u67D3\u6C34\u6E90");
		mntmNewMenuItem_4.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage frame = new Manage();// 实例化窗体
				frame.setVisible(true);// 窗体可见
				frame.setLocationRelativeTo(null);// 窗体居中
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		tabPane.addTab("个人中心", panC);
		panC.setLayout(null);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBackground(Color.LIGHT_GRAY);
		menuBar_2.setBounds(0, 0, 554, 23);
		panC.add(menuBar_2);
		
		JMenu mnNewMenu_2 = new JMenu("\u8D26\u53F7\u8BBE\u7F6E");
		mnNewMenu_2.setBackground(Color.LIGHT_GRAY);
		menuBar_2.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_9.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update frame = new Update();
				frame.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JPanel panD = new JpaneMain();
		tabPane.addTab("退出系统", null, panD, null);		
		panD.setLayout(null);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBackground(Color.LIGHT_GRAY);
		menuBar_3.setBounds(0, 0, 554, 23);
		panD.add(menuBar_3);
		
		JMenu mnNewMenu_4 = new JMenu("\u9000\u51FA");
		mnNewMenu_4.setBackground(Color.PINK);
		menuBar_3.add(mnNewMenu_4);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JOptionPane.showMessageDialog(null, "退出成功");
			}
		});
		mnNewMenu_4.add(btnNewButton);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
//	public static void main(String[] args) {
//		new MainInterface().init();
//	}
}
