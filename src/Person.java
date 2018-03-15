import java.io.Serializable;

//some of this code is from last lesson:
//Serialization.
//you removed those comments and will change whatever for this lesson

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4801633306273802062L;
	
	private int id;
	private String name;
	
	public Person(int id, String name){
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
		
}
