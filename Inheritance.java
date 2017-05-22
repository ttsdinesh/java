class Parent
{
	void printParent()
	{
		System.out.println("Print Parent");
	}
}
class Child extends Parent
{
	void printChild()
	{
		System.out.println("Print Child");
	}
}

class Inheritance
{
	public static void main(String args[])
	{
		Child childObj = new Child();
		Parent parentObj = new Parent();
		
		childObj.printChild();
		parentObj.printParent();
	}
}
