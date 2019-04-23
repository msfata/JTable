package com.gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class JTableUsage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfName;
	private JTextField tfDob;
	private JLabel label;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableUsage frame = new JTableUsage();
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
	public JTableUsage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(278, 13, 282, 134);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Dob" }));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 254, 134);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblName = new JLabel("Name");
		panel.add(lblName);

		tfName = new JTextField();
		tfName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfDob.requestFocus();
			}
		});
		panel.add(tfName);
		tfName.setColumns(10);

		JLabel lblDob = new JLabel("Dob");
		panel.add(lblDob);

		tfDob = new JTextField();
		tfDob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();// inserting from text fields into the table
				model.insertRow(table.getRowCount(), new Object[] { tfName.getText(), tfDob.getText() });
				tfName.setText("");
				tfDob.setText("");
				tfName.requestFocus();
			}
		});
		panel.add(tfDob);
		tfDob.setColumns(10);

		JLabel label_1 = new JLabel("");
		panel.add(label_1);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model = (DefaultTableModel) table.getModel();// inserting from text fields into the table
				model.insertRow(table.getRowCount(), new Object[] { tfName.getText(), tfDob.getText() });
				tfName.setText("");
				tfDob.setText("");
				tfName.requestFocus();
			}
		});
		panel.add(btnEnter);

		label = new JLabel("");
		panel.add(label);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// exiting programe
				System.exit(0);
			}
		});
		panel.add(btnExit);
	}
}
