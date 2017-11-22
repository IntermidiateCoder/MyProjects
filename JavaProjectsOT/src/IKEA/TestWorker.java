package IKEA;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

import java.util.Date;
public class TestWorker {
	private Worker w;
	@Before
	public void setUp() throws Exception{
		w = new Worker(new Date(), "tamir", "jimbory", 1500.00);
	}
	@Test
	public void TestIncreaseSalary() {
		w.increaseSalary();
		assertEquals(w.getSalary(), 1530,0);
	}
}
