import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class ReadObjects {

	public static void main(String[] args){
		System.out.println("Reading objects...");
				
		try(FileInputStream fi = new FileInputStream("test.ser")){
			
			ObjectInputStream os = new ObjectInputStream(fi);
			
			Person[] people = (Person[])os.readObject();
			
			for(Person person: people){
				System.out.println(person);
			}
			
			//serializing the ArrayList:
			ArrayList<Person> peopleList = (ArrayList<Person>)os.readObject();
						
			//for the ArrayList:
			for(Person person: peopleList){
				System.out.println(person);
			}
			
			int num = os.readInt();
			
			for(int i=0; i < num; i++){
				Person person = (Person)os.readObject();
			}
						
			os.close();
						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//rt click on project-- run as-- java application