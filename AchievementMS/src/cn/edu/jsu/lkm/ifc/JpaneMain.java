package cn.edu.jsu.lkm.ifc;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * �Զ��������ñ���ͼƬ
 * @author mycom
 *
 */
public class JpaneMain extends JPanel{

	/**
	 * �������
	 */
 public JpaneMain() {}
 @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int n=getWidth();
		int m=getHeight();
		setLayout(null);
		    g.drawImage(new ImageIcon("C:\\Users\\mycom\\Pictures\\Saved Pictures\\Main5.png").getImage(),0,0,n,m,this);
	}
}