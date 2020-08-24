package com.subscription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subscription.model.Payment;
import com.subscription.repository.PaymentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepository;

	@GetMapping("/payment")
	public List<Payment> getPayment() {
		return (List<Payment>) paymentRepository.findAll();
	}

	@PostMapping("/payment")
	void addPayment(@RequestBody Payment payment) {
		paymentRepository.save(payment);
	}

}
