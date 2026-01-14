package seleniumPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import com.google.gson.JsonObject;

public class Practice {
	@Parameters("browser")
	@Test(groups = "smoke")
	public void Test1(String s) {
		System.out.println("Test1");
		System.out.println(s);
		

	}

	@Parameters("browser")
	@Test(groups = "smoke")
	public void Test2(String s) {
		System.out.println("Test2");
		System.out.println(s);

	}

	@Test(groups = "reg")
	public void Test3(XmlTest test) {

		System.out.println("Test3");
		System.out.println(test.getParameter("browser"));

	}

	@Test(groups = "reg")
	public void Test4(XmlTest t) {

		System.out.println("Test4");
		System.out.println(t.getParameter("browser"));

	}

	@Test(groups = "reg")
	public void Test5(XmlTest t) {

		System.out.println("Test5");
		System.out.println(t.getParameter("browser"));
	}
}
