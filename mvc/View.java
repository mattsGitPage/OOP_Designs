package mvc;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame{

	private String[] order = {"1","2","3","4"};
	private JTextField firstNumber  = new JTextField(20);

	private JButton checkPassword = new JButton("Filter It");
	private JTextField passResult = new JTextField(20);
	private JCheckBox noSpace = new JCheckBox("no spaces filter");
	private JCheckBox noDuplicates = new JCheckBox("no duplicates filter");
	private JCheckBox noCap = new JCheckBox("no capital letters filter");
	private JCheckBox noNum = new JCheckBox("no numbers filter");
	private JComboBox orderList = new JComboBox(order);
	private JComboBox orderList1 = new JComboBox(order);
	private JComboBox orderList2 = new JComboBox(order);
	private JComboBox orderList3 = new JComboBox(order);
	
	
	View(){
		
		//set up the GUI for the user make it look pretty
		
		JPanel calcPanel = new JPanel();
		JPanel filterPanel = new JPanel();
		JPanel selectionOrder = new JPanel();
		calcPanel.setBorder(BorderFactory.createTitledBorder("password check"));
		filterPanel.setLayout(new GridLayout(4,1));
		filterPanel.setBorder(BorderFactory.createTitledBorder("filters"));
		selectionOrder.setLayout(new GridLayout(4,1));
		selectionOrder.setBorder(BorderFactory.createTitledBorder("Select order to execute"));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 200);
		
		calcPanel.add(firstNumber);
		calcPanel.add(checkPassword);
		calcPanel.add(passResult);
		filterPanel.add(noSpace);
		filterPanel.add(noDuplicates);
		filterPanel.add(noCap);
		filterPanel.add(noNum);
		selectionOrder.add(orderList);
		orderList1.setSelectedItem("2");
		selectionOrder.add(orderList1);
		orderList2.setSelectedItem("3");
		selectionOrder.add(orderList2);
		orderList3.setSelectedItem("4");
		selectionOrder.add(orderList3);
		
		//add this to the frame
		this.add(calcPanel, BorderLayout.PAGE_START);
		this.add(filterPanel, BorderLayout.LINE_START);
		this.add(selectionOrder, BorderLayout.CENTER);
		
	}
	
	/**
	 * return if user wants no space filter
	 * @return if user wants no space filter
	 */
	public boolean getNoSpace(){
		return noSpace.isSelected();
	}
	
	/**
	 * return if user wants no duplicates
	 * @return if user wants no duplicates
	 */
   public boolean getNoDuplicates(){
		
		return noDuplicates.isSelected();
		
	}
   
   /**
    * return id user wants no space filter
    * @return if user wants no caps
    */
   public boolean getNoCaps(){
		
		return noCap.isSelected();
		
	}
   
   /**
    * returns if user wants no numbers in password
    * @return if user wants no numbers in password
    */
   public boolean getNoNum(){
		
		return noNum.isSelected();
		
	}
	
   /**
    * returns the users entered password
    * @return the password the user wants filterd
    */
   public String getPassword(){
	   return firstNumber.getText();
   }

   /**
    * this is used to get the order of filters from the user
    * @return the order of execution
    */
	public String[] getOrder(){
		String[] temp = new String[4];
		temp[0]=  (String) orderList.getSelectedItem();
		temp[1] = (String) orderList1.getSelectedItem();
		temp[2] = (String) orderList2.getSelectedItem();
		temp[3] = (String) orderList3.getSelectedItem();
		return temp;
	}
	

	public void setPasswordPassOrFail(String result){
		passResult.setText(result);
	}
	
	
	
	
	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed
	
	void addCalculateListener(ActionListener listenForCalcButton){
		
		checkPassword.addActionListener(listenForCalcButton);
		
	}
	
	//throw a nasty message if you try and mess with my program 
	//we care about the pattern nothing more
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
}
