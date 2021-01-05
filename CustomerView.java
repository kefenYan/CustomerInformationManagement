package com.project02;

public class CustomerView {
	private CustomerList customerList = new CustomerList(10);
	
	
	
public CustomerView() {
	
		Customer customer =new Customer("mary",'f',22,"3439988888","mary@gmail.com");
		customerList.addCustomer(customer);
	}
// menu
	public void enterMainMenu() {
		boolean isFlag = true;
		while(isFlag) {
		System.out.println("--Customer Information Management software--\n");
		System.out.println("           1.Add customer");
		System.out.println("           2.Modify customer");
		System.out.println("           3.Delete customer");
		System.out.println("           4.List customer");
		System.out.println("           5.Exist System\n");
		System.out.print("     please choose ( 1-5 ):");
		char menu = CMUtility.readMenuSelection();
		switch(menu) {
		case'1':
			addNewCustomer();
			break;
		case'2':
			modifyCustomer();
			break;
		case'3':
			deleteCustomer();
			break;
		case'4':
			listAllCustomers() ;
			break;
		case'5':
//			System.out.println("Exist system");
			System.out.print("Confirm whether to exit (Y/N):");
			char isExist = CMUtility.readConfirmSelection();
			if(isExist == 'Y') {
				isFlag = false;
			}
//			break;
		}
		
		}		
	}
	//	Add customer action
	public void addNewCustomer() {
//		System.out.println("Add customer action");
		System.out.println("-------------------Add customer -------------------");
		System.out.print("name:");
		String name = CMUtility.readString(10);
		
		System.out.print("gender:");
		char gender = CMUtility.readChar();
		
		System.out.print("age: ");
		int age = CMUtility.readInt();
		System.out.print("phone NO.: ");
		String phone = CMUtility.readString(12);
		System.out.print("email: ");
		String email = CMUtility.readString(30);
//		Encapsulate the above objects in the customer object
		Customer customer = new Customer(name,gender,age,phone,email);
		boolean isSuccess = customerList.addCustomer(customer);
		if(isSuccess) {
			System.out.println("--------------------Add complete-------------------- ");
		}else {
			System.out.println("----------------Customer directory is full Add failed--------------- ");
		}
		
		
	}
	public void modifyCustomer() {
//		System.out.println("modifyCustomer");
		System.out.println("--------------------Modify customer--------------------");
		Customer cust ;
		int number ;
		for(;;) {
		System.out.println("Please select the customer number to be modified (-1 to exit):");
		number = CMUtility.readInt();
		if(number == -1) {
			return;
		}
		cust = customerList.getCustomer(number-1);
		if(cust == null) {
			System.out.println("Cannot find the specified customer");
		}else {//Customer found
			break;//The code is too long to jump out of the loop
		}
	}
//		Connect to the cycle to modify customer information
		System.out.print("name("+cust.getName()+"):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.print("gender("+cust.getGender()+"):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.print("age("+cust.getAge()+"):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.print("phone NO.("+cust.getPhone()+"):");
		String phone = CMUtility.readString(12, cust.getPhone());
		System.out.print("email("+cust.getEmail()+"):");
		String email = CMUtility.readString(30, cust.getEmail());
		
		Customer newCust = new Customer(name,gender,age,phone,email);
		boolean isReplaced = customerList.replaceCustomer(number-1, newCust);
		if(isReplaced) {
			System.out.println("--------------------Modification completed--------------------");
		}else {
			System.out.println("--------------------fail to edit--------------------");
		}
		
	}
	public void deleteCustomer() {
//		System.out.println("deleteCustomer");
		System.out.println("--------------------delete Customer--------------------");
		int number;
		for(;;) {
		System.out.println("Please select the customer number to be deleted (-1 to exit):");
		number = CMUtility.readInt();
		if(number == -1) {
			return ;
		}
		Customer customer = customerList.getCustomer(number-1);
		if(customer == null) {
			System.out.println("Cannot find the specified customer!");
		}else {
			break ;
		}
	}
//		Find the specified customer that needs to be deleted
		System.out.println("Confirm whether to delete (Y/N):");
		char isDelete = CMUtility.readConfirmSelection();
		if(isDelete== 'Y') {
			boolean deleteSuccess = customerList.deleteCustomer(number-1);
			if(deleteSuccess) {
				System.out.println("--------------------Delete complete--------------------");
			}else {
				System.out.println("--------------------failed to delete--------------------");
			}
		} else {
			return;

		}
		
		
	}
//	Customer List
	public void listAllCustomers() {
//		System.out.println("Customer List");
		System.out.println("--------------------Customer List-------------------");
		int total = customerList.getTotal();
		if(total == 0) {
			System.out.println("No customer records");
		}else {
			System.out.println("ID\tname\tgender\tage\tphone NO\t\temail");
			Customer[] custs = customerList.getAllCustomers();
			for(int i = 0;i < custs.length;i++) {
				Customer cust = custs[i];
				System.out.println((i+1)+"\t"+cust.getName()
				+"\t"+cust.getGender()+"\t"+cust.getAge()+"\t"
						+cust.getPhone()+"\t"+cust.getEmail());
			}
		}
		
		
		
		System.out.println("------------------Customer list complete------------------");
		
		
	}
	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
		
		
	}

}
