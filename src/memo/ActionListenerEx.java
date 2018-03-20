package memo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;

public class ActionListenerEx implements ActionListener {
	M_Frame mf = new M_Frame();//M_Frame ������ ȣ��, mf�� ����
	
	public void actionPerformed(ActionEvent ae )
		{
		 if(ae.getSource()==mf.f1) //���θ����
	        { 
	            mf.txtBox.setText(""); 
	        } 
	     else if(ae.getSource()==mf.f2) //����
	        { 
    	 		JFileChooser jc=new JFileChooser(); 
		 if(jc.showOpenDialog(mf.f1)==jc.APPROVE_OPTION) // ���� ���̾�α� ���
            { 
                try 
                	{ 
                		File f=jc.getSelectedFile(); // ���õ� ���� �ҷ��� 
                		FileReader fis = new FileReader(f); // 2byte�� �о��(�ѱ� �ȱ���) 
                		int i=0; 
	                    /* 
	                     * read() : ���� �Ѱ� ���� 
	                     * read(byte[],int,int) : byte ���� 
	                     */ 
                		mf.txtBox.setText("");
	                    	while((i=fis.read())!=-1) 
		                    { 
		                        mf.txtBox.append(String.valueOf((char)i)); // ��� 
		                    } 
	                     
                	}catch(Exception ex){} 
	            } 
	        } 
	     else if(ae.getSource()==mf.f3) //����
	        { 
	    	 	JFileChooser jc=new JFileChooser(); 
	            if(jc.showSaveDialog(mf.f2)==jc.APPROVE_OPTION) 
	            	{ 
	                	try 
	                	{ 
		                    String str = mf.txtBox.getText().trim(); 
		                    if(str.length()<1) 
		                        return; 
		                    File f=jc.getSelectedFile(); 
		                    FileWriter fw=new FileWriter(f); 
		                     
		                    fw.write(str); 
		                    fw.close(); 
		                     
		                }catch(Exception ex){} 
	            	} 
	        } 
	        else if(ae.getSource()==mf.f5) //����
	        { 
//	            dispose(); 
	            System.exit(0); 
	        } 
		}
}
