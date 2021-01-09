package cn.edu.jsu.lkm.ifc;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 自定义类设置背景图片
 * @author mycom
 *
 */
public class Jpane extends JPanel{
	
	/**
	 * 背景面板
	 */
 public Jpane() {}
 @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int n=getWidth();
		int m=getHeight();
		setLayout(null);
		    g.drawImage(new ImageIcon("C:\\Users\\mycom\\Pictures\\Saved Pictures\\Login.png").getImage(),0,0,n,m,this);
	}
}
