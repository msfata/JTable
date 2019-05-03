/**
 * 
 */
package com.gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 * @author msfata programminghelp
 *
 */
public class JTableToXls extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfName;
	private JTextField tfAccount;
	private JLabel lblName;
	protected String xlsFileName;
	protected DefaultTableModel model;
	protected File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableToXls frame = new JTableToXls();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTableToXls() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				tfName.requestFocus();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 705, 245);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(Color.WHITE, 3));
		scrollPane.setBounds(12, 13, 265, 172);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Account" }));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(289, 117, 380, 63);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		lblName = new JLabel("  Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblName);

		tfName = new JTextField();
		tfName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfAccount.requestFocus();
			}
		});
		panel.add(tfName);
		tfName.setColumns(10);

		JLabel lblAccount = new JLabel("  Account");
		panel.add(lblAccount);

		tfAccount = new JTextField();
		tfAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				model.insertRow(model.getRowCount(), new Object[] { tfName.getText(), tfAccount.getText() });
				tfName.setText("");
				tfAccount.setText("");
				tfName.requestFocus();
			}
		});
		panel.add(tfAccount);
		tfAccount.setColumns(10);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(572, 19, 97, 25);
		contentPane.add(btnExit);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				model.insertRow(model.getRowCount(), new Object[] { tfName.getText(), tfAccount.getText() });
				tfName.setText("");
				tfAccount.setText("");
				tfName.requestFocus();
			}
		});
		btnEnter.setBounds(289, 88, 97, 25);
		contentPane.add(btnEnter);

		JButton btnExportToExcel = new JButton("Export to excel");
		btnExportToExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(xlsFileName + ".xls");
				try {
					new ExcelExport().exportTable(table, file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					Desktop.getDesktop().open(new File(xlsFileName + ".xls"));// txtFileName+".txt"
				} catch (Exception any) {
					JOptionPane.showMessageDialog(null, "SORRY IN THIS SESSION YOU \nDIDNT SAVE ANY XLS FILE YET !\n"
							+ "FIRST SAVE A FILE WITH XLS EXTENSION\n THEN USE THIS BUTTON FOR CALLING THAT FILE ");

				}
			}
		});
		btnExportToExcel.setBounds(398, 88, 271, 25);
		contentPane.add(btnExportToExcel);
	}

}
