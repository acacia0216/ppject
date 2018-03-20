package memo;

import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;


public class MemoFrame extends JFrame implements ActionListener, UndoableEditListener{
	

	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();//�����ӻ���
	JMenuBar menuBar = new JMenuBar();//�޴��� ����
	JMenu mFile = new JMenu("파일");//�޴�1
	JMenu mEdit = new JMenu("편집");//�޴�2
	JMenu mFormat = new JMenu("서식");//�޴�3
	JMenu mHelp = new JMenu("Help");//�޴�4)
	
	//���ϸ޴� ������ ����
	JMenuItem f1 = new JMenuItem("새로만들기");
	JMenuItem f2 = new JMenuItem("불러오기");
	JMenuItem f3 = new JMenuItem("저장");
	JMenuItem f4 = new JMenuItem("다른이름으로 저장");
	JMenuItem f5 = new JMenuItem("종료");

	//�����޴� ������ ����
	JMenuItem e1 = new JMenuItem("복사");
	JMenuItem e2 = new JMenuItem("잘라내기");
	JMenuItem e3 = new JMenuItem("붙여넣기");
	JMenuItem e4 = new JMenuItem("되돌리기");
	JMenuItem e5 = new JMenuItem("재실행");
	
	//���ĸ޴� ������ ����
	JMenuItem o1 = new JMenuItem("글꼴");
	
	//���򸻸޴� ������ ����
	JMenuItem h1 = new JMenuItem("버전정보");
	JMenuItem h2 = new JMenuItem("피드백");
	JMenuItem h3 = new JMenuItem("도움말");
	
	JTextArea textBox = new JTextArea();//�ؽ�Ʈ�ڽ� ����
	JScrollPane scroll = new JScrollPane(textBox);//��ũ�� �����ؼ� �ؽ�Ʈ�ڽ� �ֱ�
	
	@SuppressWarnings("deprecation")
	public MemoFrame() {
	@SuppressWarnings("unused")
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
	mEdit.add(e5);
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
	e5.setAccelerator(KeyStroke.getKeyStroke('Y',InputEvent.CTRL_MASK));
	//���ĸ޴������� ����Ű �߰�
	o1.setAccelerator(KeyStroke.getKeyStroke('T',InputEvent.CTRL_MASK^InputEvent.ALT_MASK));
					
	//���� �̺�Ʈ �߰�
	f1.addActionListener(this);//���θ����
	f2.addActionListener(this);//����
	f3.addActionListener(this);//����
	f4.addActionListener(this);//�ٸ��̸���������
	f5.addActionListener(this);//����
	//���� �̺�Ʈ �߰�
	e1.addActionListener(this);//����
	e2.addActionListener(this);//�߶󳻱�
	e3.addActionListener(this);//�ٿ��ֱ�
	e4.addActionListener(this);//�������
	e5.addActionListener(this);//�ٽý���
	//���� �̺�Ʈ �߰�
	o1.addActionListener(this);//�۲ü���
	//Help �̺�Ʈ �߰�
	h1.addActionListener(this);//����
	h2.addActionListener(this);//�ǵ��
	h3.addActionListener(this);//����
	
	frame.setJMenuBar(menuBar);//�޴��ٸ� �����ӿ� �ֱ�
	
	//������ �⺻����
	frame.setSize(500,500);
	frame.setVisible(true);//true�� �ֳִ°ɱ�?
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//��� �ִ���?
	
//	JTextArea txtBox = new JTextArea();//�ؽ�Ʈ�ڽ� ����
//	@SuppressWarnings("unused")
//	JScrollPane scroll = new JScrollPane(txtBox);//��ũ�� �����ؼ� �ؽ�Ʈ�ڽ� �ֱ�
//	
	}
	
	public static void main(String args[]) {
		
		new MemoFrame();//������� ��Ű��
	}
//�׼Ǹ����� ����
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		//���θ����f
		if(ae.getSource()==f1)
		{
			if(textBox != null)
				{
					JFileChooser jc=new JFileChooser(); 
					int r= JOptionPane.showConfirmDialog(this,"새로만들기",JOptionPane.YES_NO_OPTION); //Ȯ��â ����
					if(r==0)// �� ���� ��� ����
						{  
						jc.showSaveDialog(this); //����Dialogâ ����
						textBox.setText("");
						}
				}
			else//����������� ���̾�α�â ��;;;;
				{
					textBox.setText("");
				}
		}
		
		//����
		else if(ae.getSource()==f2)
		{
			JFileChooser jc=new JFileChooser(); 
			if(jc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) // ���� ���̾�α� ���
            { 
                try 
                { 
                    File f=jc.getSelectedFile(); // ���õ� ���� �ҷ��� 
                    @SuppressWarnings("resource")
					FileReader fr = new FileReader(f); // 2byte�� �о��(�ѱ� �ȱ���) 
                    int i=0; 
                    /* 
                     * read() : ���� �Ѱ� ���� 
                     * read(byte[],int,int) : byte ���� 
                     */ 
                    textBox.setText(""); 
                    while((i=fr.read())!=-1) 
                    { 
                        textBox.append(String.valueOf((char)i)); // ��� 
                    } 
                     
                }catch(Exception ex){} 
            } 
        } 
		
		//����
        else if(ae.getSource()==f3) 
        { 
            JFileChooser jc=new JFileChooser(); 
//            int userSelection = jc.showSaveDialog(this);
//            
//            if (userSelection == JFileChooser.APPROVE_OPTION) {
//                File fileToSave = jc.getSelectedFile();
//                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
//            }
            if(jc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) 
            { 
                try 
                { 
                    String str = textBox.getText().trim(); 
                    if(str.length()<1) 
                        return; 
                    File f=jc.getSelectedFile(); 
                    FileWriter fw=new FileWriter(f); 
                     
                    fw.write(str); 
                    fw.close(); 
                     
                }catch(Exception ex){} 
            } 
        }
		
		//�ٸ��̸����� ����//////////////////////////////////////////
        else if(ae.getSource()==f4)
        {
        	
        }

		//����
        else if(ae.getSource()==f5) 
        { 
            dispose(); 
            System.exit(0); 
        }
		
//		//����e
//        else if(ae.getSource()==e1)
//        {
//        	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        	String copyString = textBox.getSelectedText();
//        	if(copyString != null)
//        	{
//        		StringSelection stringSelection = new StringSelection(copyString);
//        		clipboard.setContents(stringSelection, null);
//        	}
//        }
//		
//		//�߶󳻱�////////////////////////////////////////////�̱���//�����ϱ�� ��ü
//        else if(ae.getSource()==e2)
//        {
//        	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        	String copyString = textBox.getSelectedText();
//        	if(copyString != null)
//        	{
//        		StringBuffer sb = new StringBuffer(copyString);
//        		StringSelection stringSelection = new StringSelection(copyString);
//        		clipboard.setContents(stringSelection, null);
//        		sb.delete(0,10);
//        		
//        	}
//        }
//		
//		//�ٿ��ֱ�
//        else if(ae.getSource()==e3)
//        {
//        	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        	Transferable contents = clipboard.getContents(clipboard);
//
//        	if(contents != null)
//        	{
//
//        	     try {
//        	          String pasteString = (String)(contents.getTransferData(
//        	DataFlavor.stringFlavor));
//        	          textBox.insert(pasteString, textBox.getCaretPosition());
//        	     } catch (Exception e) {}
//
//        	}
//        }
		
		//�������//////////////////////////////////////////�̱���
        else if(ae.getSource()==e4)
        {
        	doc.addUndoableEditListener(this);
        }
		
		//�ٽý���//////////////////////////////////////////�̱���
        else if(ae.getSource()==e5)
        {
        	
        }
		//�۲ü���o//////////////////////////////////////////�̱���
        else if(ae.getSource()==o1)
        {

        }        
		//����h
        else if(ae.getSource()==h1)
        {
        	 JOptionPane.showMessageDialog(null, "버전"+'\n'+"정보","자리였나", JOptionPane.WARNING_MESSAGE);
        }
		
		//�ǵ��
        else if(ae.getSource()==h2)
        {
        	JOptionPane.showMessageDialog(null,"피드백은 아래로"+'\n'+"acacia0216@naver.com"+'\n'+"보내주세요", JOptionPane.WARNING_MESSAGE);
        }
		
		//����
        else if(ae.getSource()==h3)
        {
        	 JOptionPane.showMessageDialog(null, "도움말"+'\n'+"이었나?", "모르겠네", JOptionPane.WARNING_MESSAGE);
        }
	}
	
UndoManager um = new UndoManager();
Document doc = textBox.getDocument();

//Redo,Undo ����
	@Override
	public void undoableEditHappened(UndoableEditEvent uee) {
		// TODO Auto-generated method stub
		 um.addEdit(uee.getEdit()); 
		 if(uee.getSource() == e4)
		 	{
		      if(um.canUndo())
		        um.undo();
		    }
		      
		    if(uee.getSource() == e5)
		    {
		      if(um.canRedo())
		        um.redo();
		    }
	}
}
