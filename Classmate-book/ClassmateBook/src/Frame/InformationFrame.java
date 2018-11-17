package Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InformationFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField id = null;
	private JTextField sid = null;
	private JTextField name = null;
	private JTextField address = null;
	private JTextField wchat = null;
	private JTextField psd = null;
	private JTextField email = null;
	private JTextField phone = null;
	private JTextField qq = null;
	private JTextField classid = null;
	private JPanel contentPane;
	private int i = 0;
	private int j = 0;
	private int row = -1;
	private String gid;
	private String gname;
	private String gaddress;
	private String gwchat;
	private String gemail;
	private String gphone;
	private String gqq;
	private String gclassid;
	private String gsid;
	public static DefaultTableModel dtm;
	
	private static int num = 0;
	public static int getnum() {
		return num;
	}
	
	public static void setnum(int num) {
		num += 1;
	}
	
	public InformationFrame() {
		setTitle("ͬѧ¼����");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			//�����رհ�ť�ǹر�
		setSize(800, 600);
		setVisible(true);
		
		JTable table = new JTable();
		String[] tableHeads = new String[]{"ҽ������","����","�Ա�","����","����","���Һ�","�绰","ְ��"};
		dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);
		ArrayList<information> list = (ArrayList<Information>) InformationDao.getAllInformation();
		  
		for(j = 0; j < list.size(); j++) {
			Vector v = new Vector();
			v.add(list.get(j).getid());
			v.add(list.get(j).getname());
			v.add(list.get(j).getaddress());
			v.add(list.get(j).getwchat());
			v.add(list.get(j).getemail());
			v.add(list.get(j).getqq());
			v.add(list.get(j).getphone());
			v.add(list.get(j).getclassid());
			  
			if (Integer.parseInt(list.get(j).getid().trim()) > num) {
				num = Integer.parseInt(list.get(j).getid().trim());
			}
			  
			dtm.addRow(v);
		}
		  
		num += 1; 
		  
		table.setPreferredScrollableViewportSize(new Dimension(760,350));
		  
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);;
		table.getTableHeader().setReorderingAllowed(false);
		  
		  
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(700, 500);
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		
		contentPane = new JPanel();								//�������
		setContentPane(contentPane); 
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("ҽ�����ţ�");
		panel1.add(label1);
		id = new JTextField();
		panel1.add(id);
		id.setColumns(10);
		id.setBackground(Color.LIGHT_GRAY);
		id.setEditable(false);
		JLabel label2 = new JLabel("������");
		panel1.add(label2);
		name = new JTextField();
		panel1.add(name);
		name.setColumns(10);
		JLabel label3 = new JLabel("�Ա�");
		panel1.add(label3);
		address = new JTextField();
		panel1.add(address);
		address.setColumns(10);
		JLabel label4 = new JLabel("���䣺");
		panel1.add(label4);
		wchat = new JTextField();
		panel1.add(wchat);
		wchat.setColumns(10);
		
		JPanel panel2 = new JPanel();
		JLabel label6 = new JLabel("���Һţ�");
		panel2.add(label6);
		qq = new JTextField();
		panel2.add(qq);
		qq.setColumns(10);
		label6.setBorder(new EmptyBorder(0, 13, 0, 0));
		JLabel label5 = new JLabel("���ʣ�");
		panel2.add(label5);
		email = new JTextField();
		panel2.add(email);
		email.setColumns(10);
		JLabel label7 = new JLabel("�绰��");
		panel2.add(label7);
		phone = new JTextField();
		panel2.add(phone);
		phone.setColumns(10);
		JLabel label8 = new JLabel("ְ�ƣ�");
		panel2.add(label8);
		classid = new JTextField();
		panel2.add(classid);
		classid.setColumns(10);
		
		JPanel panel3 = new JPanel();
		JButton update = new JButton("�޸�");
		JPanel panel4 = new JPanel();
		panel4.add(update);
		panel4.setBorder(new EmptyBorder(0, 0, 0, 20));
		panel3.add(panel4);
		JButton add = new JButton("����");
		JPanel panel5 = new JPanel();
		panel5.add(add);
		panel5.setBorder(new EmptyBorder(0, 20, 0, 20));
		panel3.add(panel5);
		JButton delete = new JButton("ɾ��");
		JPanel panel6 = new JPanel();
		panel6.add(delete);
		panel6.setBorder(new EmptyBorder(0, 20, 0, 20));
		panel3.add(panel6);
		JButton clear = new JButton("���");
		JPanel panel8 = new JPanel();
		panel8.add(clear);
		panel8.setBorder(new EmptyBorder(0, 20, 0, 20));
		panel3.add(panel8);
		
	//	panel3.add(panel7);

		JPanel panel7 = new JPanel();
		JLabel label9 = new JLabel("ҽ�����ţ�");
		panel7.add(label9);
		sid = new JTextField();

		sid.setColumns(10);
		panel7.add(sid);
		
		JButton select = new JButton("����");
		panel7.add(select);
		panel7.setBorder(new EmptyBorder(0, 20, 0, 0));
		
		contentPane.add(panel1);
		contentPane.add(panel2);
		contentPane.add(panel3);
		contentPane.add(panel);
		contentPane.add(panel7);
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gid = id.getText();
				System.out.println(gid);
				if (gid.equals("")) {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
				} else {
					i = InformationDao.delInformation(gid);
					dtm.removeRow(row);
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					if (!id.getText().equals("")) {
						id.setText("");
					}
					if (!name.getText().equals("")) {
						name.setText("");
					}
					if (!address.getText().equals("")) {
						address.setText("");
					}
					if (!wchat.getText().equals("")) {
						wchat.setText("");
					}
					if (!email.getText().equals("")) {
						email.setText("");
					}
					if (!phone.getText().equals("")) {
						phone.setText("");
					}
					if (!qq.getText().equals("")) {
						qq.setText("");
					}
					if (!classid.getText().equals("")) {
						classid.setText("");
					}
					
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!id.getText().equals("")) {
					id.setText("");
				}
				if (!sid.getText().equals("")) {
					sid.setText("");
				}
				if (!name.getText().equals("")) {
					name.setText("");
				}
				if (!address.getText().equals("")) {
					address.setText("");
				}
				if (!wchat.getText().equals("")) {
					wchat.setText("");
				}
				if (!email.getText().equals("")) {
					email.setText("");
				}
				if (!phone.getText().equals("")) {
					phone.setText("");
				}
				if (!qq.getText().equals("")) {
					qq.setText("");
				}
				if (!classid.getText().equals("")) {
					classid.setText("");
				}
				
				dtm.setRowCount(0);
				ArrayList<Information> list = (ArrayList<Information>) InformationDao.getAllInformation();
				for(j = 0; j < list.size(); j++) {
					  Vector v = new Vector();
					  v.add(list.get(j).getid());
					  v.add(list.get(j).getname());
					  v.add(list.get(j).getaddress());
					  v.add(list.get(j).getwchat());
					  v.add(list.get(j).getemail());
					  v.add(list.get(j).getqq());
					  v.add(list.get(j).getphone());
					  v.add(list.get(j).getclassid());
					  
					  if (Integer.parseInt(list.get(j).getid().trim()) > num) {
						  num = Integer.parseInt(list.get(j).getid().trim());
					  }
					  
					  dtm.addRow(v);
				  }
				  num += 1;
				
			}
		});
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Information information = new Information();
				if (!id.getText().equals("")) {
					information.setid(id.getText());;
				}else {
					information.setid(null);
				}
				if (!name.getText().equals("")) {
					information.setname(name.getText());
				}else {
					information.setname(null);
				}
				if (!address.getText().equals("")) {
					information.setaddress(address.getText());
				}else {
					information.setaddress(null);
				}
				if (!wchat.getText().equals("")) {
					information.setwchat(Integer.parseInt(wchat.getText()));
				}else {
					information.setwchat(0);
				}
				if (!email.getText().equals("")) {
					information.setemail(Integer.parseInt(email.getText()));
				}else {
					information.setemail(0);
				}
				if (!phone.getText().equals("")) {
					information.setphone(phone.getText());
				}else {
					information.setphone(null);
				}
				if (!qq.getText().equals("")) {
					information.setqq(qq.getText());
				}else {
					information.setqq(null);
				}
				if (!classid.getText().equals("")) {
					information.setclassid(classid.getText());
				}else {
					information.setclassid(null);
				}
				InformationDao.editInformation(information);
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				if (!name.getText().equals("")) {
					dtm.setValueAt(name.getText(), row, 1);
				}
				if (!address.getText().equals("")) {
					dtm.setValueAt(address.getText(), row, 2);
				}
				if (!wchat.getText().equals("")) {
					dtm.setValueAt(wchat.getText(), row, 3);
				}
				if (!email.getText().equals("")) {
					dtm.setValueAt(email.getText(), row, 4);
				}
				if (!phone.getText().equals("")) {
					dtm.setValueAt(phone.getText(), row, 6);
				}
				if (!qq.getText().equals("")) {
					dtm.setValueAt(qq.getText(), row, 5);
				}
				if (!classid.getText().equals("")) {
					dtm.setValueAt(classid.getText(), row, 7);
				}
				
			}
		});
	
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddInformation addInformation = new AddInformation();		//��������Ա��������
				addInformation.setVisible(true);
				Toolkit toolkit = addInformation.getToolkit();	//���Toolkit����
				Dimension dm = toolkit.getScreenSize();		//�����Ļ�Ĵ�С
				//ʹ����Ļ����
				addInformation.setLocation((dm.width - addInformation.getWidth())/2, (dm.height - addInformation.getHeight())/2);
				
			}
		});
		
		select.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ҽ���Ų���Ϊ��");
				}else {
					dtm.setRowCount(0);
					gsid = sid.getText().trim();
					Information information = new Information();
					
					dtm.setRowCount(0);
					
					  information = InformationDao.getInformation(gsid);
				  
						  Vector v = new Vector();
						  v.add(information.getid());
						  v.add(information.getname());
						  v.add(information.getaddress());
						  v.add(information.getwchat());
						  v.add(information.getemail());
						  v.add(information.getqq());
						  v.add(information.getphone());
						  v.add(information.getclassid());
						  
						  dtm.addRow(v);
					
				}
				
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			  /**
			   * ��굥���¼�
			   * @param e �¼�Դ�¼�
			   */
			  public void mouseClicked(java.awt.event.MouseEvent e) {

				  if (table.getValueAt(table.getSelectedRow(), 0) != null) {
					  row=table.getSelectedRow();
					  if (table.getValueAt(row, 0) != null) {
						  gid = table.getValueAt(row, 0).toString();
					  }
					  if (table.getValueAt(row, 1) != null) {
						  gname = table.getValueAt(row, 1).toString();
					  }
					  if (table.getValueAt(row, 2) != null) {
						  gaddress = table.getValueAt(row, 2).toString();
					  }
					  if (table.getValueAt(row, 3) != null) {
						  gwchat = table.getValueAt(row, 3).toString();
					  }
					  if (table.getValueAt(row, 4) != null) {
						  gemail =  table.getValueAt(row, 4).toString();
					  }
					  if (table.getValueAt(row, 5) != null) {
						  gqq = table.getValueAt(row, 5).toString();		
					  }
					  if (table.getValueAt(row, 6) != null) {
						  gphone = table.getValueAt(row, 6).toString();
					  }
					  if (table.getValueAt(row, 7) != null) {
						  gclassid = table.getValueAt(row, 7).toString();
					  }
					  id.setText(gid);
					  name.setText(gname);
					  address.setText(gaddress);
					  wchat.setText(gwchat);
					  email.setText(gemail);
					  qq.setText(gqq);
					  phone.setText(gphone);
					  classid.setText(gclassid);
					  System.out.println(gphone);
				  }
				  
			  }
		});
		
		

}
