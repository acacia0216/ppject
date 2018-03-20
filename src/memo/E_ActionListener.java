package memo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;

public class E_ActionListener implements ActionListener, UndoableEditListener{
	
		JFileChooser fc = new JFileChooser();
		File f = fc.getSelectedFile();
		UndoManager um = new UndoManager();
		
		
	public void actionPerformed(ActionEvent ae) {
		M_JFrame jf = new M_JFrame();
		
		
//		//ActionListener �߰�
//		jf.newPage.addActionListener(this);
//		jf.open.addActionListener(this);
//		jf.save.addActionListener(this);
//		jf.saveAs.addActionListener(this);
//		jf.quit.addActionListener(this);
//		jf.unDo.addActionListener(this);
//		jf.reDo.addActionListener(this);
//		jf.copy.addActionListener(this);
//		jf.cut.addActionListener(this);
//		jf.paste.addActionListener(this);
//		jf.font.addActionListener(this);
//		jf.version.addActionListener(this);
//		jf.feedBack.addActionListener(this);
//		jf.helpAid.addActionListener(this);
		
		
		
		//���θ����
		if(ae.getSource()==jf.newPage)
		{
			jf.newPage.setText("");
		}
		
		//�ҷ�����
		else if(ae.getSource()==jf.open)
		{
			if(fc.showOpenDialog(jf.open)==JFileChooser.APPROVE_OPTION)
			{
				try
				{
					f =fc.getSelectedFile();
					FileReader fr = new FileReader(f);
					int i = 0;
					jf.jTextArea.setText("");
					while((i=fr.read())!=-1)
					{
						jf.jTextArea.append(String.valueOf((char)i));
					}
				}
				catch(Exception e)
				{
					
				}
			
			}
		}
		
		//����
		else if(ae.getSource()==jf.save)
		{
			if(fc.showSaveDialog(jf.save)==JFileChooser.APPROVE_OPTION)
				try
			{
					String str = jf.jTextArea.getText().trim();
					if(str.length()<1)
					{
						return;
					}
					f = fc.getSelectedFile();
					FileWriter fw = new FileWriter(f);
					
					fw.write(str);
			}
			catch(Exception e)
			{
				
			}
		}
		
		//�ٸ��̸����� ����
		else if(ae.getSource()==jf.saveAs)
		{
			if(fc.showSaveDialog(jf.saveAs)==JFileChooser.APPROVE_OPTION)
				try
			{
					String str = jf.jTextArea.getText().trim();
					if(str.length()<1)
					{
						return;
					}
					f = fc.getSelectedFile();
					FileWriter fw = new FileWriter(f);
					
					fw.write(str);
			}
			catch(Exception e)
			{
				
			}
		}
		
		//����
		else if(ae.getSource()==jf.quit)
		{
			System.exit(0);
		}
		
		//�������
		else if(ae.getSource()==jf.unDo)
		{
			um.undo();
		}
		
		//�ٽý���
		//����
		else if(ae.getSource()==jf.copy)
		{
			jf.copy = new JMenuItem(new DefaultEditorKit.CopyAction());
		}
		//�߶󳻱�
		else if(ae.getSource()==jf.cut)
		{
			jf.cut = new JMenuItem(new DefaultEditorKit.CutAction());
		}
		//�ٿ��ֱ�
		else if(ae.getSource()==jf.paste)
		{
			jf.paste = new JMenuItem(new DefaultEditorKit.PasteAction());
		}
		//��Ʈ
		else if(ae.getSource()==jf.font)
		{
			new D_Font();
		}
		
		//����
		else if(ae.getSource()==jf.version)
		{
			JOptionPane.showMessageDialog(null, "������ ����", "���� ����",1);
		}
		
		//�ǵ��
		else if(ae.getSource()==jf.feedBack)
		{
			JOptionPane.showMessageDialog(null, "���� �� ����, ���� �Ʒ��� �����ּ���"
									+'\n'+"acacia0216@naver.com"+'\n'+"�����մϴ�.","�ǵ�� �ּ���",1);
		}
		
		//����
		else if(ae.getSource()==jf.helpAid)
		{
			JOptionPane.showMessageDialog(null, "�����𸥴�","����",3);//0 = Xǥ��, 1 = ����ǥ, 2 = ���, 3 = ����ǥ
		}
	}

	
	@Override
	public void undoableEditHappened(UndoableEditEvent ue) {
		// TODO Auto-generated method stub
		if(um != null)
			   um.addEdit(ue.getEdit());
	}
}
