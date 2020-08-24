package com.subscription.repository;

import org.springframework.data.repository.CrudRepository;

import com.subscription.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}

