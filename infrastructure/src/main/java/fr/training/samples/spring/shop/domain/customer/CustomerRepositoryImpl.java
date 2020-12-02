package fr.training.samples.spring.shop.domain.customer;

import org.springframework.stereotype.Repository;

import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private final CustomerDataJpaRepository customerDataJpaRepository;

	public CustomerRepositoryImpl(final CustomerDataJpaRepository customerDataJpaRepository) {
		this.customerDataJpaRepository = customerDataJpaRepository;
	}

	@Override
	public Customer findById(final String id) {
		return customerDataJpaRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	@Override
	public void save(final Customer customer) {
		customerDataJpaRepository.save(customer);
	}

}