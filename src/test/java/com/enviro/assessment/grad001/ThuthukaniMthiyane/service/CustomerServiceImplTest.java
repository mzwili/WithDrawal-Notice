package com.enviro.assessment.grad001.ThuthukaniMthiyane.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Customer;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCustomer() {
        // Mock data
        Customer mockCustomer = new Customer();
        mockCustomer.setId(1);
        mockCustomer.setFullName("John Doe");

        List<Customer> mockCustomerList = Arrays.asList(mockCustomer);

        // Mocking the behavior of customerRepository
        when(customerRepository.findAll()).thenReturn(mockCustomerList);

        // Call the method to be tested
        Customer resultCustomer = customerService.getCustomer();

        // Verify the interactions and assertions
        verify(customerRepository, times(1)).findAll();
        assertNotNull(resultCustomer);
        assertEquals(mockCustomer.getId(), resultCustomer.getId());
        assertEquals(mockCustomer.getFullName(), resultCustomer.getFullName());
    }
}