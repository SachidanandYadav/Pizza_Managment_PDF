package PDF.CreatePDF;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

public class Events {

	int id = 01, quantity;
	String name;
	private double price, total;
	boolean flag;
	Scanner sc = new Scanner(System.in);

	public void write(List<Customer2> customer) throws IOException {
		File file = new File("src/main/resources/Hello.pdf");
		PDDocument doc = PDDocument.load(file);

		PDPage page = doc.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(doc, page);

		contentStream.beginText();
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
		contentStream.setLeading(14.5f);
		contentStream.newLineAtOffset(45, 700);

		contentStream.showText("Order_Id  Pizza Name Quantity Price Amount");
		contentStream.newLine();

		for (Customer2 list : customer) {
			contentStream.showText(list.getId() + "   " + list.getName() + "   " + list.getQuantity() + "   "
					+ list.getPrice() + "    " + list.getTotal());
			contentStream.newLine();
		}

		contentStream.close();

		doc.save(new File("src/main/resources/Hello.pdf"));
		doc.close();
	}

	public Customer2 take_order() {
		System.out.println("Enter Pizza name :");
		name = sc.next();
		System.out.println("Enter Pizza Quantity :");
		quantity = sc.nextInt();
		System.out.println("Enter Pizza Price :");
		price = sc.nextDouble();

		Customer2 data = new Customer2();
		data.setId(id);
		data.setName(name);
		data.setQuantity(quantity);
		data.setPrice(price);
		data.setTotal(quantity * price);
		id++;
		return data;
	}

	public void display(List<Customer2> customer) {
		System.out.println("All Customer Data.");
		System.out.println("Cust_Id\tCust_Name");
		for (Customer2 user : customer)
			System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getQuantity() + "\t" + user.getPrice()
					+ "\t" + user.getTotal());
	}

	public void search(int id1, List<Customer2> customer) {
		System.out.println("Cust_Id\tCust_Name");
		for (Customer2 u : customer) {
			if (u.getId() == id1)
				System.out.println(u.getId() + "\t" + u.getName() + "\t" + u.getQuantity() + "\t" + u.getPrice() + "\t"
						+ u.getTotal());
			flag = true;
		}
		if (flag = false)
			System.out.println(id1 + " Not found.");

	}

	public void delete(int id2, List<Customer2> customer) {
		for (Customer2 c : customer) {
			if (id2 == c.getId()) {
				customer.remove(c);
				System.out.println(id2 + " is removed");
				flag = true;
				break;
			}
		}
		if (flag = false)
			System.out.println(id2 + " Not found.");

	}
	
	
	public void reader() throws InvalidPasswordException, IOException {
		File file = new File("/home/v2stech/git/Pizza_Managment_PDF/CreatePDF/src/main/resources/Hello.pdf");
	      PDDocument document = PDDocument.load(file);
	      PDFTextStripper pdfStripper = new PDFTextStripper();

	      String text = pdfStripper.getText(document);
	      System.out.println(text);

	      document.close();
	}

}
