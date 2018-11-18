package sr;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;


import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainWindow {

	private JFrame frame;
	private JTextField ntIdTextField;
	private JComboBox comboBox;
	private JTable tabledump;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Mobile Utilities");
		frame.setBounds(100, 100, 669, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ArrayList<String> ntIdUserList = new ArrayList<String>();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Easy Launch ", null, panel, null);

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(new TitledBorder(null, "Quick Launch", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setLayout(null);

		Button button = new Button("Start Terminals ");
		button.setBackground(new Color(204, 255, 153));
		button.setBounds(43, 52, 109, 28);
		panel_1.add(button);

		ntIdTextField = new JTextField();
		ntIdTextField.setToolTipText("Example:\r\n\r\ncable\\kpalam943");
		ntIdTextField.setBounds(97, 29, 99, 20);
		panel_1.add(ntIdTextField);
		ntIdTextField.setColumns(10);

		JLabel lblNtid = new JLabel("Enter your NtId :");
		lblNtid.setBounds(10, 32, 90, 14);
		panel_1.add(lblNtid);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Reserve Device", null, panel_2, null);

		
	
		tabledump = new JTable();
		
		
		panel_2.add(tabledump);
		
		JScrollPane scrollPanedump = new JScrollPane(tabledump);
		//tabledump.setauto

		JButton btnFetch = new JButton("fetch");
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatabaseHelper dh = new DatabaseHelper();
				
				try {
					ResultSet rs = (ResultSet) dh.dbget();

				
						
						tabledump.setModel(DbUtils.resultSetToTableModel(rs));//converting to fit with
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				
				

			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnFetch, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(scrollPanedump, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
							.addGap(66))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(btnFetch)
					.addGap(18)
					.addComponent(scrollPanedump, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
		);
		panel_2.setLayout(gl_panel_2);
		
		

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ntID = ntIdTextField.getText();
				if (ntID.isEmpty()) {
					JOptionPane.showMessageDialog(null, "NtId is Empty , Please enter your NtId", "NtId is Empty", 0);

				} else {
					JOptionPane.showMessageDialog(null, ntID, "Launching Terminals", 1);
					comboBox.addItem(ntID); // adding to dropdown
				}
			}

		});

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = (String) comboBox.getSelectedItem();
				ntIdTextField.setText(temp);
			}
		});
		for (String temp : ntIdUserList) {
			comboBox.addItem(temp);// (mylist)
		}
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
		);
		frame.getContentPane().setLayout(groupLayout);

	}
}
