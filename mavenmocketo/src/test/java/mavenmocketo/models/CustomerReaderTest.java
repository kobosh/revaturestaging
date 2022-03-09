package mavenmocketo.models;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

import org.junit.Test;

public class CustomerReaderTest {




	@Test
	public void happyPathScenario(){
		Customer sampleCustomer = new Customer();
		sampleCustomer.setFirstName("Susan");
		sampleCustomer.setLastName("Ivanova");
	
		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Customer.class,1L)).thenReturn(sampleCustomer);
	
		CustomerReader customerReader = new CustomerReader();
		customerReader.setEntityManager(entityManager);
	
		String fullName = customerReader.findFullName(1L);
		assertEquals("Susan Ivanova",fullName);
	}
}