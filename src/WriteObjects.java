import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteObjects {

	public static void main(String[] args) {
		System.out.println("Writing objects...");

		Person[] people = {new Person(1, "Sue"), new Person(2, "Mike"), new Person(3, "Betty")};
		//an array in java is an object, and it can be serialized like any other object
		
		//when you do a write then a read, make sure you run the main method from WriteObjects first
		//otherwise you'll get an error when you try the main method in ReadObjects

		//ArrayLists are in a future lesson, but here's a quickie:
		ArrayList<Person> peopleList = new ArrayList<Person>(Arrays.asList(people));
		
		try (FileOutputStream fs = new FileOutputStream("test.ser"))
		{
			ObjectOutputStream os = new ObjectOutputStream(fs);

			os.writeObject(people);
			
			//serialize the ArrayList:
			os.writeObject(peopleList);
			
			//this will write to the file the number of objects in peopleList
			os.writeInt(peopleList.size());
			
			for (Person person: peopleList){
				os.writeObject(person);
			}
			
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
