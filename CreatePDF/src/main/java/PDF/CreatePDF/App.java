package PDF.CreatePDF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	Scanner sc = new Scanner(System.in);
		List<Customer2> customer =  new ArrayList<>();
		Events evet2 = new Events();
    	
    	int Choice;
		do {
			System.out.println("========Pizza MANAGEMENT SYSTEM========");
			System.out.println("1.Take Order\n" + "2.View Order\n" + "3.Delete Order\n"
					+ "4.Search Order as per date \n"+"5.View Order form PDF  \n"+ "0.Exit");
			System.out.print("Enter your Choice : ");

			Choice = sc.nextInt();
			switch (Choice) {
			case 1:
				Customer2 obj = evet2.take_order();
				customer.add(obj);
				evet2.write(customer);
				break;
			case 2:
				evet2.display(customer);
				break;
			case 3:
				System.out.println("Ente the customer id");
				int id1 = sc.nextInt();
				evet2.search(id1,customer);
				break;
			case 4:
				System.out.println("Ente the customer id");
				int id2 = sc.nextInt();
				evet2.delete(id2,customer);
				evet2.write(customer);
				break;
			case 5:
				evet2.reader();
				break;
			case 0:// Exit
				System.out.println("Thank You for with us");
				System.exit(0);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + Choice);
			}

		} while (Choice <= 7);

    }
}
