package operation;
import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List;

import javax.swing.JList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import domain.RatePayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class CalculatePropertyTypeRateGUI implements ActionListener, ListSelectionListener {
	private JFrame jf;
	private JButton btnNext,
					btnCancel;
	private JList<RatePayer> list;
	private ArrayList<RatePayer> selectedlist;
	
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPostcode;
	private JTextField txtPhone;
	private JTextField txtType;
	
    public static void main(String[] args) throws Exception {
    	new CalculatePropertyTypeRateGUI();
    }
    

    
	public CalculatePropertyTypeRateGUI() {
		jf = new JFrame ("Rate Payers");
		
    	// initialise Vector
    	Vector<RatePayer> vList = new Vector<RatePayer>();
    	vList.add(new RatePayer("Bonnings Ltd" , "166 Sturt St, Ballarat VIC", "3350", " ", "Public Company"));
    	vList.add(new RatePayer("Joomla Pty.Ltd.",	"200 Lakeside Drive Alfredton VIC",	"3350",	"03 53789621",	"Private Company"));
    	vList.add(new RatePayer("Wilson Philanthropic Trust", "7 Wendouree Parade Ballarat VIC", "3350", "03 53783344",	"Charitable Trust")); 
    	vList.add(new RatePayer("Patcher Partners",	"16 Possibility Avenue Lake Gardens VIC",	"3350", " ", "Partnership")); 
    	vList.add(new RatePayer("North Balong Football and Netball Club", "18 Hardy St Balong VIC", "3390",	"440123456", "Sporting Club")); 
    	vList.add(new RatePayer("Rokewood Womens Shed", "15 Hamilton Highway Rokewood VIC", "3356",	"03 52675877",	"Community")); 
    	vList.add(new RatePayer("St Stephens Grammar", "11 Spencer Street Toorak VIC", "3010",	"03 98705263",	"School")); 
    	vList.add(new RatePayer("St John of God", "23 Berwick Way Berwick VIC", "3086",	"03 2456 7865",	"Charitable Trust")); 
    	// create and populate the JList
    	list = new JList<RatePayer>(vList);
    	list.addListSelectionListener(this);
    	    	    	
    	// add the panels to the window
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf.add(this.setupButtons(),"South");
    	jf.add(list, "North");
    	jf.add(this.setupCustomerPanel(), "Center");
    	
    	jf.setSize(1500,1000);
    	jf.setLocation(50, 0);
    	jf.setVisible(true);    	
    }
 	
	// helper method to set up the customer details panel
	private JPanel setupCustomerPanel () {
		JPanel jpCust = new JPanel ();
		
    	JLabel lblName = new JLabel ("Name");
    	txtName = new JTextField (20);
    	JLabel lblAddress = new JLabel ("Address");
    	txtAddress = new JTextField (20);
    	JLabel lblPostcode = new JLabel ("Post Code");
    	txtPostcode = new JTextField (5);
    	JLabel lblPhone = new JLabel ("Phone Number");
    	txtPhone = new JTextField (15);
    	JLabel lblType = new JLabel ("Company Type");
    	txtType = new JTextField (15);
    	
    	jpCust.add(lblName);
    	jpCust.add(txtName);
    	jpCust.add(lblAddress);
    	jpCust.add(txtAddress);
    	jpCust.add(lblPostcode);
    	jpCust.add(txtPostcode);
    	jpCust.add(lblPhone);
    	jpCust.add(txtPhone);
    	jpCust.add(lblType);
    	jpCust.add(txtType);
 
    	return jpCust;
	}
	
	// helper method to organise the buttons at the bottom
	private JPanel setupButtons () {
    	//Create buttons and add ActionListener
    	btnNext = new JButton("Next");
    	btnNext.addActionListener(this);
    	
    	btnCancel = new JButton("Cancel");
    	btnCancel.addActionListener(this);
    	
    	//create the panel and add the buttons
    	JPanel jpSouth = new JPanel();
    	jpSouth.add(btnNext);
    	jpSouth.add(btnCancel);
    	return jpSouth;
	}
	
    /**
     * implementation of ActionListener interface  
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNext) {
        	//Person p =  list.getSelectedValue();
           // p.display();
        	for (RatePayer r: selectedlist) {  // display all persons in list
        		r.display(); 		
        	}
        	RatePayerGUI mywindow = new RatePayerGUI();
        }
        else if (e.getSource() == btnCancel) {
            jf.dispose();
            System.exit(0);
        }
    }
    
    /**
     * implementation of ListSelectionListener interface
     */
    public void valueChanged (ListSelectionEvent e) {
    //	int index = list.getSelectedIndex();
    	//Person p = list.getSelectedValue();  // will work if only one person is selected
		
    	// more generic code to work if multiple persons are selected - save to selectedlist   	
    	selectedlist = (ArrayList<RatePayer> )list.getSelectedValuesList();
    	RatePayer r = selectedlist.get(0); // get first person selected
    	
    	//for (Person p: selectedlist) {  // will end up with displaying last person in list in txtfields
    	
    		txtName.setText(r.getName());
    		txtAddress.setText(r.getAddress());
    		txtPostcode.setText(r.getPostcode());
    		txtPhone.setText(r.getPhone());
    		txtType.setText(r.getType());
    	//}
    }
}
