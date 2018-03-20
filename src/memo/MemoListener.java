package memo;

import java.awt.Container;
import java.awt.event.InputEvent;

import javax.swing.KeyStroke;

public class MemoListener extends MemoFrame{
	
		Container con = frame.getContentPane();//�������� ����???//Ǯ�ٿ�޴� �������ΰ�?
		//���ϸ޴��� ������ �߰�
		mFile.add(f1);
		mFile.add(f2);
		mFile.add(f3);
		mFile.add(f4);
		mFile.addSeparator();//���м� �߰�
		mFile.add(f5);
		//�����޴��� ������ �߰�
		mEdit.add(e1);
		mEdit.add(e2);
		mEdit.add(e3);
		mEdit.add(e4);
		//���ĸ޴��� ������ �߰�
		mFormat.add(o1);
		//���򸻸޴� ������ �߰�
		mHelp.add(h1);
		mHelp.add(h2);
		mHelp.addSeparator();//���м� �߰�
		mHelp.add(h3);
		
		//�޴��ٿ� �޴� �߰�
		menuBar.add(mFile);
		menuBar.add(mEdit);
		menuBar.add(mFormat);
		menuBar.add(mHelp);
		
		//ActionListener �̺�Ʈ ���� ����
//		f1.addActionListener(this);
//		f2.addActionListener(this);
//		f3.addActionListener(this);
//		f5.addActionListener(this);
		
		frame.add(scroll,"Center");//�ؽ�Ʈ�ڽ� ���� ��ũ�ѹڽ��� ��ü�����ӿ� �ֱ�//�ٵ� �� �����ھȿ���?
		
		//�޴� ����Ű �߰�!!!????!!!!
		mFile.setMnemonic('F');//Alt+F
		mEdit.setMnemonic('E');//Alt+E
		mFormat.setMnemonic('T');//Alt+T
		//���ϸ޴������� ����Ű �߰�
		f1.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
		f2.setAccelerator(KeyStroke.getKeyStroke('O',InputEvent.CTRL_MASK));
		f3.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK));
		f4.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK^InputEvent.SHIFT_MASK));
		f5.setAccelerator(KeyStroke.getKeyStroke('Q',InputEvent.CTRL_MASK^InputEvent.SHIFT_MASK));
		//�����޴������� ����Ű �߰�
		e1.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.CTRL_MASK));
		e2.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.CTRL_MASK));
		e3.setAccelerator(KeyStroke.getKeyStroke('V',InputEvent.CTRL_MASK));
		e4.setAccelerator(KeyStroke.getKeyStroke('Z',InputEvent.CTRL_MASK));
		//���ĸ޴������� ����Ű �߰�
		o1.setAccelerator(KeyStroke.getKeyStroke('T',InputEvent.CTRL_MASK^InputEvent.ALT_MASK));
						
		frame.setJMenuBar(menuBar);//�޴��ٸ� �����ӿ� �ֱ�
		
		//������ �⺻����
		frame.setSize(500,500);
		frame.setVisible(true);//true�� �ֳִ°ɱ�?
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);//��� �ִ���?
	
	public static void main(String args[]) {
		new MemoListener();
	}
}
