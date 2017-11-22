package IKEA;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class TestSalesMan {
		private SalesMan s1;
		private SalesMan s2;
		private SalesMan s3;
		private SalesMan s4;
		private SalesMan s5;
		@Before
		public void setUp() throws Exception {
			s1 = new SalesMan(LocalDate.of(2016, 11, 22), "tamir");
			s2 = new SalesMan(LocalDate.of(2000, 10, 20), "Ofek");
			s3 = new SalesMan(LocalDate.of(2005, 9, 5), "Dani Svi");
			s4 = new SalesMan("Ido");
			s5 = new SalesMan(LocalDate.of(2019, 11, 22), "Almog");
		}

		@Test
		public void test() {
			s1.requestIncreaseSalary();
			s2.requestIncreaseSalary();
			s3.requestIncreaseSalary();
			s4.requestIncreaseSalary();
			s5.requestIncreaseSalary();
			assertEquals(s1.getSalary(), 15000, 0);
			assertEquals(s2.getSalary(), 12500, 0);
			assertEquals(s3.getSalary(), 12500, 0);
			assertEquals(s4.getSalary(), 12500,0);
			assertEquals(s5.getSalary(), 12500,0);
		}
	}
