package Frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.ClassDao;


public class AdminFrame extends JFrame{
	private JPanel contentPane,p;
	
	public AdminFrame(String user) {
		setTitle("�ҵĹ���ҽ����");								//���ô������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//�����رհ�ť�ǹر�
		setSize(1000, 600);
		contentPane = new JPanel();								//�������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		//���ñ߿�
		setContentPane(contentPane); 							//Ӧ�����
		p = new JPanel();
		p.setBorder(new EmptyBorder(20, 0, 0, 0));
		
		String name = null;
		
		for (int i = 0; i < ClassDao.getAllClass.size(); i++) {
	           if (DoctorDao.getAllDoctor().get(i).getdno().equals(dno)) {
				name = DoctorDao.getAllDoctor().get(i).getdname();
			}
		}
		System.out.println(name);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 800, 0, 0));
		JLabel label14 = new JLabel(name);
		panel.add(label14);
		
		JButton exit  = new JButton("�˳�");
		panel.add(exit);
		
		JLabel label1 =new JLabel();
		icon=new ImageIcon("D:\\031602636\\hospital\\hospital\\image\\doctor.png");     //�ڴ�ֱ�Ӵ�������,ע��Ŀ¼֮��ķָ�����˫б��
		label1.setIcon(icon);
		label1.setBounds(10, 10, icon.getIconWidth(),icon.getIconHeight());
		p.add(label1,new Integer(Integer.MIN_VALUE));
		
		JLabel label3 =new JLabel();
		icon=new ImageIcon("D:\\031602636\\hospital\\hospital\\image\\patient.png");     //�ڴ�ֱ�Ӵ�������,ע��Ŀ¼֮��ķָ�����˫б��
		label3.setIcon(icon);
		label3.setBounds(10, 10, icon.getIconWidth(),icon.getIconHeight());
		p.add(label3,new Integer(Integer.MIN_VALUE));
		
		JLabel label7 =new JLabel();
		icon=new ImageIcon("D:\\031602636\\hospital\\hospital\\image\\shoushu.png");     //�ڴ�ֱ�Ӵ�������,ע��Ŀ¼֮��ķָ�����˫б��
		label7.setIcon(icon);
		label7.setBounds(10, 10, icon.getIconWidth(),icon.getIconHeight());
		p.add(label7,new Integer(Integer.MIN_VALUE));
		
		JLabel label9 =new JLabel();
		icon=new ImageIcon("D:\\031602636\\hospital\\hospital\\image\\psd.png");     //�ڴ�ֱ�Ӵ�������,ע��Ŀ¼֮��ķָ�����˫б��
		label9.setIcon(icon);
		label9.setBounds(10, 10, icon.getIconWidth(),icon.getIconHeight());
		p.add(label9,new Integer(Integer.MIN_VALUE));
		p.setBorder(new EmptyBorder(100, 0, 0, 0));
		
		JPanel panel4 = new JPanel();
		panel4.setBorder(new EmptyBorder(0, 0, 0, 28));
		JButton doctor = new JButton("�ҵ���Ϣ");
		//panel3.add(doctor);
		panel4.add(doctor);
		
		JButton patient = new JButton("�ҵĲ���");
		//panel3.add(patient);
		JPanel panel6 = new JPanel();
		panel6.setBorder(new EmptyBorder(0, 28, 0, 28));
		panel6.add(patient);
		
		JButton shoushu = new JButton("�ҵ�����");
		JPanel panel10 = new JPanel();
		panel10.setBorder(new EmptyBorder(0, 28, 0, 28));
		panel10.add(shoushu);
		
		JButton psd = new JButton("�޸�����");
		JPanel panel12 = new JPanel();
		panel12.setBorder(new EmptyBorder(0, 28, 0, 0));
		panel12.add(psd);
		
		JPanel panel1 = new JPanel();
		
		panel1.add(panel4);
		panel1.add(panel6);
		panel1.add(panel10);
		panel1.add(panel12);
		
		contentPane.add(panel);
		contentPane.add(p);
		contentPane.add(panel1);
		
		doctor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DoctorDetail doctorDetail = new DoctorDetail(dno);
				doctorDetail.setVisible(true);
				Toolkit toolkit = doctorDetail.getToolkit();	//���Toolkit����
				Dimension dm = toolkit.getScreenSize();		//�����Ļ�Ĵ�С
				//ʹ����Ļ����
				doctorDetail.setLocation((dm.width - doctorDetail.getWidth())/2, (dm.height - doctorDetail.getHeight())/2);
			}
		});
		
		patient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Mypatient mypatient = new Mypatient(dno);
				mypatient.setVisible(true);
				Toolkit toolkit = mypatient.getToolkit();	//���Toolkit����
				Dimension dm = toolkit.getScreenSize();		//�����Ļ�Ĵ�С
				//ʹ����Ļ����
				mypatient.setLocation((dm.width - mypatient.getWidth())/2, (dm.height - mypatient.getHeight())/2);
			
			}
		});
		
		shoushu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DocShoushuDetail docShoushuDetail = new DocShoushuDetail(dno);
				docShoushuDetail.setVisible(true);
				Toolkit toolkit = docShoushuDetail.getToolkit();	//���Toolkit����
				Dimension dm = toolkit.getScreenSize();		//�����Ļ�Ĵ�С
				//ʹ����Ļ����
				docShoushuDetail.setLocation((dm.width - docShoushuDetail.getWidth())/2, (dm.height - docShoushuDetail.getHeight())/2);
			
			}
		});
		
		psd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DocPsd docPsd = new DocPsd(dno);
				docPsd.setVisible(true);
				Toolkit toolkit = docPsd.getToolkit();	//���Toolkit����
				Dimension dm = toolkit.getScreenSize();		//�����Ļ�Ĵ�С
				//ʹ����Ļ����
				docPsd.setLocation((dm.width - docPsd.getWidth())/2, (dm.height - docPsd.getHeight())/2);
			
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
				Toolkit toolkit = loginFrame.getToolkit();	//���Toolkit����
				Dimension dm = toolkit.getScreenSize();		//�����Ļ�Ĵ�С
				//ʹ����Ļ����
				loginFrame.setLocation((dm.width - loginFrame.getWidth())/2, (dm.height - loginFrame.getHeight())/2);
				dispose();
			}
		});
		
	}
	
}
