public class Visitor extends Patient
{
	public Visitor( int id, String name, int age ){
		super(id, name, age);
	}
	
        @Override
	public String toString(){ 
		return "Visitor " + name + " ( ID " + id + ", age " + age + " )";
	}
}
