package operation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import domain.RatePayer;

public class RatePayerGUI implements ActionListener,
                                       ItemListener{

	private JFrame jfProp;
	private JComboBox jcPTypes;
	private JLabel jlCIV, jlResults;
	private JTextField jtfCIV, jtfResults;
	private JTextField jtfPropValue;
	private JLabel jlPropValue;
	private JPanel jpDisplay, jpEdit, jpResults; 
	private JCheckBox jcbWM, jcbGWM, jcbFSL, jcbIWD, 
	        jcbTML,jcbEmpty, jcbCS;
	private JButton jbCalc;

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new RatePayerGUI();
		//System.out.println("Running"); // Ok

	}
	public RatePayerGUI(){
		// Create the frame for showing our GUI
		jfProp = new JFrame ("Verona Cyrus" );
		jpDisplay = setupDisplayPanel();
		jpEdit = setupEditPanel();
		jpResults = setupResultsPanel();

		jfProp.add(jpDisplay, "North");
		jfProp.add(jpEdit, "Center");
		jfProp.add(jpResults, "South");
		
		jfProp.setSize(400, 200);
		jfProp.setLocation(400, 300);
		jfProp.setTitle("Calculate Property");

		
		jfProp.setVisible(true);
	}
	private JPanel setupDisplayPanel(){
		JPanel jp  = new JPanel ();
		String[] s1 = {"Residential",
                "Commercial", 
                "Vacant Land",
                "Hospital",
                "Industrial",
                "School/Community",
                "Other"};
		jcPTypes = new JComboBox( s1 );
		
		
		jlCIV = new JLabel ("CIV Rate");
		jtfCIV = new JTextField (8);
		jtfCIV.setText( "0.39%" ); // for residential
		jcPTypes.addItemListener( this ); 
		jp.add(jcPTypes);   
		jp.add(jlCIV);   
		jp.add(jtfCIV); 
		
		
		return jp;
	}
	private JPanel setupEditPanel(){
		//JPanel jp  = new JPanel ( new BorderLayout());
		JPanel jp  = new JPanel ();

		jlPropValue = new JLabel("Enter property value");
		jp.add(jlPropValue);
		jtfPropValue = new JTextField (10);
		jp.add(jtfPropValue);
		jcbCS = new JCheckBox("Charity status");
		jp.add( jcbCS);
		jbCalc = new JButton("Calculate");
		jbCalc.addActionListener(this);
		jp.add(jbCalc);
		return jp;
	}
	
	
	private JPanel setupResultsPanel(){
		JPanel jp  = new JPanel ();
		jlResults = new JLabel ("Rate charged");
		jtfResults = new JTextField (20);

		jp.add(jlResults);  
		jp.add(jtfResults);  
		
		return jp;
	}

	public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == jbCalc) {
        	//Person p =  list.getSelectedValue();
           // p.display();
        	double result;
        	int waste = 400;
        	int greenw = 90;
        	
        	String s = (String)jcPTypes.getSelectedItem();
        	double res = Double.parseDouble(jtfPropValue.getText());
        	
        	
        	if(s == "Residential") {
        		
        		result = (res * 0.39/100 ) + waste + greenw + (110 + (0.007/100 * res));
        		
        	}else if(s == "Commercial") {
        		result = (res * 0.59/100 ) + waste + greenw + (110 + (0.007/100 * res));
        		
        		
        	}else if(s == "Vacant Land") {
        		result = (res * 0.10/100 ) + waste + greenw + (110 + (0.007/100 * res));
        		
        	}else if(s == "Hospital") {
        		result = (res * 0.36/100 ) + waste + greenw + (110 + (0.007/100 * res));
        		
        	}else if(s == "Industrial") {
        		result = (res * 0.65/100 ) + waste + greenw + (110 + (0.007/100 * res));
        		
        	}else if(s == "School/Community" ) {
        		result = (res * 0.30/100 ) + waste + greenw + (110 + (0.007/100 * res));
        		
        	}     		
        	else if(s == "Other") {
        		result = (res * 0.25/100 ) + waste + greenw + (110 + (0.007/100 * res));
        		
        	}else {
        		return;
        	}
        	
        	if(jcbCS.isSelected()) {
        		result = result - (0.2 * result);
        	}
        	
        	jtfResults.setText(Double.toString(result));
        	
        	
        	
        	
        	
        }
	}
	
	public void itemStateChanged(ItemEvent e) 
    { 
        // if the state combobox is changed 
        if (e.getSource() == jcPTypes) { 
        	String s = (String)jcPTypes.getSelectedItem();
        	if ( s == "Residential"){
        		jtfCIV.setText( "0.39%" );
        	}
        	
        	else if ( s == "Commercial"){
        		jtfCIV.setText( "0.59%" );
        	}
        	
        	else if ( s == "Vacant Land"){
        		jtfCIV.setText( "0.10%" );
        	}

        	else if ( s == "Hospital"){
        		jtfCIV.setText( "0.36%" );
        	}

        	else if ( s == "Industrial"){
        		jtfCIV.setText( "0.40%" );
        	}

        	else if ( s == "School/Community"){
        		jtfCIV.setText( "0.30%" );
        	}

        	else if ( s == "Other"){
        		jtfCIV.setText( "0.25%" );
        	}


        } 
    }
}