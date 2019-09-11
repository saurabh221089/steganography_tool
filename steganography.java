import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

class steganography extends JFrame implements ActionListener
{
	JButton b1,b2,b3;
	JLabel label1,label2;
	JTextField tf1,tf2;
	JFileChooser fc1;
	File file1,file2,file3;
	Process process;
	String filename,path1,part1,path2;
	static Icon icon;
		
	public steganography()
	{	
		Container con =getContentPane();
		con.setLayout(null);
		con.setBackground(Color.cyan);
		b1= new JButton("Image file");
		b2= new JButton("Text file");
		b3= new JButton("Hide it!!");
		label1= new JLabel("Image Path");
		label2= new JLabel("Text file path");
		tf1=new JTextField("",20);
		tf2=new JTextField("",20);
		tf1.setEditable(false);
		tf2.setEditable(false);
		b1.setBounds(140, 10, 120, 30);
		label1.setBounds(10, 50, 80, 30);
		tf1.setBounds(90, 50, 290, 30);
		b2.setBounds(140, 90, 120, 30);
		label2.setBounds(10, 130, 80, 30);
		tf2.setBounds(90, 130, 290, 30);
		b3.setBounds(140, 170, 120, 30);
		con.add(b1);
		con.add(label1);
		con.add(tf1);
		con.add(b2);
		con.add(label2);
		con.add(tf2);
		con.add(b3);
		
		addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent we)
		{
		System.exit(0);
		}
		}
		);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			fc1 = new JFileChooser();
			int returnVal = fc1.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) 
			{
				file1 = fc1.getSelectedFile();
				path1=file1.getPath();
				tf1.setText(path1);
			}
			
			
		}
		if(ae.getSource()==b2)
		{
			fc1 = new JFileChooser();
			int returnVal = fc1.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) 
			{
				file2 = fc1.getSelectedFile();
				path2=file2.getPath();
				tf2.setText(path2);
			}
		}
		if(ae.getSource()==b3)
		{
			path1=file1.getPath();
			part1 = path1.replace(".","_new.");
			file3= new File(part1);
			try {
				process = Runtime.getRuntime().exec("cmd /c copy /b "+file1+" + "+file2+" "+file3);
				JOptionPane.showMessageDialog(null,"Successfully Save :"+file3);
				}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String ar[])
	{
		steganography m1=new steganography();
		m1.setSize(500,250);
		m1.setVisible(true);
		m1.setTitle("Steganography Tool -- By Saurabh");
	}
}
