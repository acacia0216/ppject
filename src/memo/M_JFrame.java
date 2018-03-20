package memo;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class M_JFrame extends E_ActionListener implements ActionListener{
JFrame jFrame = new JFrame();//�����ӻ���
JMenuBar jMenuBar = new JMenuBar();//�޴��ٻ���
JTextArea jTextArea = new JTextArea();//�ؽ�Ʈâ����
JScrollPane jScrollPane = new JScrollPane(jTextArea);//��ũ�ѻ���, �ؽ�Ʈâ�ֱ�

//���θ޴� ����
JMenu file = new JMenu("����");
JMenu edit = new JMenu("����");
JMenu format = new JMenu("����");
JMenu help = new JMenu("����");

//�޴� ������ ����
//���� �޴� ������
JMenuItem newPage = new JMenuItem("���θ����");
JMenuItem open = new JMenuItem("�ҷ�����");
JMenuItem save = new JMenuItem("����");
JMenuItem saveAs = new JMenuItem("�ٸ��̸���������");
JMenuItem quit = new JMenuItem("����");
//���� �޴� ������
JMenuItem unDo = new JMenuItem("�������");
JMenuItem reDo = new JMenuItem("�ٽý���");
JMenuItem copy = new JMenuItem("����");
JMenuItem cut = new JMenuItem("�߶󳻱�");
JMenuItem paste = new JMenuItem("�ٿ��ֱ�");
//���� �޴� ������
JMenuItem font = new JMenuItem("�۲�");
//���� �޴� ������
JMenuItem version = new JMenuItem("��������");
JMenuItem feedBack = new JMenuItem("�ǵ��");
JMenuItem helpAid = new JMenuItem("����");


	public M_JFrame(){//������
//		Container ct = jFrame.getContentPane();
//		super.actionPerformed apf = new actionPerformed(ae);
		
		//�޴��ٿ� �޴��ֱ�
		jMenuBar.add(file);
		jMenuBar.add(edit);
		jMenuBar.add(format);
		jMenuBar.add(help);
		//�޴��� ������ �ֱ�
		file.add(newPage);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.addSeparator();//���м��߰�
		file.add(quit);
		edit.add(unDo);
		edit.add(reDo);
		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		format.add(font);
		help.add(version);
		help.add(feedBack);
		help.addSeparator();//���м��߰�
		help.add(helpAid);
		
		//�޴� ����Ű ����
		file.setMnemonic('F');
		edit.setMnemonic('E');
		format.setMnemonic('T');
		help.setMnemonic('H');
		//�޴� ������ ����Ű ����
		newPage.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke('O',InputEvent.CTRL_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK));
		saveAs.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK^InputEvent.SHIFT_MASK));
		quit.setAccelerator(KeyStroke.getKeyStroke('Q',InputEvent.CTRL_MASK^InputEvent.SHIFT_MASK));
		unDo.setAccelerator(KeyStroke.getKeyStroke('Z',InputEvent.CTRL_MASK));
		reDo.setAccelerator(KeyStroke.getKeyStroke('Y',InputEvent.CTRL_MASK));
		copy.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.CTRL_MASK));
		cut.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.CTRL_MASK));
		paste.setAccelerator(KeyStroke.getKeyStroke('V',InputEvent.CTRL_MASK));
		font.setAccelerator(KeyStroke.getKeyStroke('T',InputEvent.CTRL_MASK));
		//help�޴� ����Ű ���� ����
		
		//ActionListener �߰�
//		super(actionPerformed);
			newPage.addActionListener(this);
			open.addActionListener(this);
			save.addActionListener(this);
			saveAs.addActionListener(this);
			quit.addActionListener(this);
			unDo.addActionListener(this);
			reDo.addActionListener(this);
			copy.addActionListener(this);
			cut.addActionListener(this);
			paste.addActionListener(this);
			font.addActionListener(this);
			version.addActionListener(this);
			feedBack.addActionListener(this);
			helpAid.addActionListener(this);
		
///////////////////////////////////////		jScrollPane.add(jTextArea);//��ũ�Ѿȿ� �ؽ�Ʈâ�ֱⰡ �ȸ�����?
		jFrame.add(jScrollPane,"Center");//�����Ӿȿ� ��ũ�ѳֱ�
		jFrame.setJMenuBar(jMenuBar);//�޴��ٸ� �����ӿ� �ֱ�
		
		jFrame.setSize(500,500);
		jFrame.setTitle("�޸��� ����� ����");
		jFrame.setVisible(true);
//		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	public static void main(String args[]) {
		new M_JFrame();
	}
}
