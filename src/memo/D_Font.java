package memo;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class D_Font
{
class MyFrame implements ListSelectionListener, ItemListener
{
    private JFrame frm;
    private JButton btn;
    private JLabel showFontLabel;
    private JList<String> fontList;
    private JPanel panel;
    private JCheckBox boldCheck;
    private JCheckBox italicCheck;
    private JList<Integer> sizeList;
    
    MyFrame() 
    {
        //��� ����
        frm = new JFrame();
        btn = new JButton("�� ��ȯ");
        showFontLabel = new JLabel("abc ABC ������ English �ȳ��ϼ��� Hi~", SwingConstants.HORIZONTAL);
        fontList = new JList<String>();
        panel = new JPanel();
        boldCheck = new JCheckBox("����");
        italicCheck = new JCheckBox("����");
        sizeList = new JList<Integer>();
        
        //��Ʈ������ ����Ʈ ����
        Integer[] font_size = new Integer[100];
        for(int i = 0 ; i < 100 ; ++i)
        {
            font_size[i] = i+1;
        }
        sizeList.setListData(font_size);
        sizeList.addListSelectionListener(this);
        
        //�ý��۳� �����ϴ� ��Ʈ ��� ����Ʈ ����
        GraphicsEnvironment g;
        g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] font_list = g.getAvailableFontFamilyNames();
        fontList.setListData(font_list);
        fontList.addListSelectionListener(this);
        
        //üũ�ڽ� �̺�Ʈ �ڵ鷯 ����
        boldCheck.addItemListener(this);
        italicCheck.addItemListener(this);
        
        //�гο� ������Ʈ ����
        panel.add(new JScrollPane(fontList));
        panel.add(new JScrollPane(sizeList));
        panel.add(boldCheck);
        panel.add(italicCheck);
        
        //�����ӿ� �г� ����
        frm.add(showFontLabel, BorderLayout.CENTER);
        frm.add(panel, BorderLayout.SOUTH);
        
        //������ �⺻����
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setBounds(120, 120, 410, 300);
        frm.setVisible(true);
    }
 
    @Override
    public void valueChanged(ListSelectionEvent e) 
    {
        if(e.getSource() == fontList)
        {
            String fontName = fontList.getSelectedValue();
            String styleStr;
            int size = showFontLabel.getFont().getSize();
            int styleNum = showFontLabel.getFont().getStyle();
            
            if((Font.BOLD | Font.ITALIC)  == styleNum)
            {
                styleStr = "BOLDITALIC";
            }
            else if(Font.BOLD == styleNum)
            {
                styleStr = "BOLD";
            }
            else if(Font.ITALIC == styleNum)
            {
                styleStr = "ITALIC";
            }
            else if(Font.PLAIN == styleNum)
            {
                styleStr = "PLAIN";
            }
            else
            {
                styleStr = "PLAIN";
            }
           
            String font_style_size = fontName + "-" + styleStr + "-" + size;
            Font font = Font.decode(font_style_size);
            showFontLabel.setFont(font);
        }
        else if(e.getSource() == sizeList)
        {
            Integer fontSize = sizeList.getSelectedValue();
            Font font = showFontLabel.getFont().deriveFont((float)fontSize);
            showFontLabel.setFont(font);    
        }
    }
 
    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if((e.getSource() == boldCheck) || (e.getSource() == italicCheck))
        {
            //�Ѵ� üũ�Ǿ� ���� ��
            if(boldCheck.isSelected() && italicCheck.isSelected()) 
            {
                Font font = showFontLabel.getFont().deriveFont(Font.BOLD | Font.ITALIC);
                showFontLabel.setFont(font);
                return;
            }
            //���Կ��� üũ �Ǿ� ���� ��
            else if(boldCheck.isSelected() == true)
            {
                Font font = showFontLabel.getFont().deriveFont(Font.BOLD);
                showFontLabel.setFont(font);
            }
            //���Կ��� üũ �Ǿ� ���� ��
            else if(italicCheck.isSelected() == true)
            {
                Font font = showFontLabel.getFont().deriveFont(Font.ITALIC);
                showFontLabel.setFont(font);
            }
            //�Ѵ� üũ �ȵǾ� ���� ��
            else
            {
                Font font = showFontLabel.getFont().deriveFont(Font.PLAIN);
                showFontLabel.setFont(font);
            }
        }
    }
}
 
    
}