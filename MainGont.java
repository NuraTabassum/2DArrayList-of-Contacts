package ArrayList2D;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class MainGont {

	public static void main(String[] args) {
		ArrayList<Gontacts> alcontacts = new ArrayList();
		Scanner s = new Scanner(System.in);
		boolean quit = false;
		int choice = 0;
		printInstructions();
		while (!quit)// while is true,means user hit quit
		{
			System.out.println("Enter your choice: ");
			choice = s.nextInt();
			switch (choice) {
			case 0:
				printInstructions();
				break;
			case 1:
				printContactList();
				break;
			case 2:
				addContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				searchContact();
				break;
			case 6:
				updateContactInsert();
				break;
			case 7:
				quit = true;
				break;
			}

		}
	}

	public static void printInstructions() {
		System.out.println("\nPress");
		System.out.println("\t 0 - To print choice option.");
		System.out.println("\t 1 - To print list of contacts.");
		System.out.println("\t 2 - To add a contact in the list.");
		System.out.println("\t 3 - To update a contact in the list.");
		System.out.println("\t 4 - To remove a contact in the list.");
		System.out.println("\t 5 - To search a contact in the list.");
		System.out.println("\t 6 - To Insert a contact in the list.");
	}

	static ArrayList<Gontacts> alcontacts = new ArrayList();

	public static void addContact() {

		Scanner osScan = new Scanner(System.in);
		Scanner oiScan = new Scanner(System.in);

		String sName;
		int iphNumber;
		int icount;

		for (icount = 0; icount < 3; icount++) {
			System.out.println("Enter the contact name: ");
			sName = osScan.nextLine();

			System.out.println("Enter the phone number: ");
			iphNumber = oiScan.nextInt();
			alcontacts.add(new Gontacts(sName, iphNumber));
		}
		System.out.println("\n\n");
	}

	public static void printContactList() {
		System.out.println("You have " + alcontacts.size() + " Contacts in your Mobile phone");
		for (int icount = 0; icount < alcontacts.size(); icount++) {
			System.out.println((icount + 1) + ". " + "Name: " + alcontacts.get(icount).Name + "  Phone number: "
					+ alcontacts.get(icount).phNumber);
		}

	}

	public static void searchContact() {
		Scanner sCan = new Scanner(System.in);
		String sName;
		int iphNumber;
		int icount;
		System.out.println("Enter the contact name you want to search: ");
		sName = sCan.nextLine();
		Iterator<Gontacts> it = alcontacts.iterator();
		while (it.hasNext()) {
			Gontacts gontacts = it.next();
			if (sName.equals(gontacts.Name)) {
				System.out.println("The name is " + gontacts.Name);

			}
			/*
			 * for (icount = 0; icount < alcontacts.size(); icount++){
			 * if(alcontacts.get(icount).equals(sName)){
			 * System.out.println(alcontacts.get(icount).Name); }
			 */
		}

	}

	public static void removeContact() {
		Scanner osScan = new Scanner(System.in);
		Scanner oiScan = new Scanner(System.in);
		String sName;
		int iphNumber;
		int icount;
		System.out.println("Enter the contact name you want to remove: ");
		sName = osScan.nextLine();

		System.out.println("Enter the phone number you want to remove: ");
		iphNumber = oiScan.nextInt();
		Iterator<Gontacts> it = alcontacts.iterator();
		while (it.hasNext()) {
			Gontacts gontacts = it.next();
			if (sName.equals(gontacts.Name) && iphNumber == gontacts.phNumber) {
				it.remove();
				// alcontacts.remove(gontacts);
			}

			// for (icount = 0; icount < alcontacts.size(); icount++){
			// if(alcontacts.get(icount).equals(sName) ||
			// alcontacts.get(icount).equals(iphNumber)){
			// alcontacts.remove(icount);
		}
	}

	private static void updateContactInsert() {
		Scanner osScan = new Scanner(System.in);
		Scanner oiScan = new Scanner(System.in);
		String sName;
		int iphNumber;
		int icount;
		System.out.println("Enter the contact name you want to Insert: ");
		sName = osScan.nextLine();
		System.out.println("Enter the phone number you want to Insert: ");
		iphNumber = oiScan.nextInt();
		ListIterator<Gontacts> listIterator = alcontacts.listIterator();
		while (listIterator.hasNext()) {
			int indexposition = listIterator.nextIndex();
			listIterator.next();//during the loop it has to go to next so listIterator.next other wise it will stay in the same position
			if (indexposition == 1) // iterates the specified element in the list
			{
				listIterator.add(new Gontacts(sName, iphNumber));
			}
		}
	}

	private static void updateContact() {
		Scanner osScan = new Scanner(System.in);
		Scanner oiScan = new Scanner(System.in);
		int setPhone;
		String SetName;
		String sName;
		int iphNumber;
		int icount;
		System.out.println("Enter the contact name you want to replace: ");
		sName = osScan.nextLine();

		System.out.println("Enter the phone number you want to replace: ");
		iphNumber = oiScan.nextInt();
		ListIterator<Gontacts> listIterator = alcontacts.listIterator();
		while (listIterator.hasNext()) {

			Gontacts name = listIterator.next();
			if (sName.equalsIgnoreCase(name.Name) && iphNumber == (name.phNumber)) {
				System.out.println("the contact is " + name.Name + "--" + name.phNumber);
				// replace the element returned by next() or previous()with the
				// specified element
				System.out.println("Enter the contact name you want to set: ");

				SetName = osScan.nextLine();

				System.out.println("Enter the contact phone number you want to set: ");
				setPhone = oiScan.nextInt();
				name.setName(SetName);
				name.setPhNumber(setPhone);

			}

		}
	}
}
