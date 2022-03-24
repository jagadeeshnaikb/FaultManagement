package com.bel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@GetMapping(value = "/sayHello")
	public String sayHello()
	{
		System.out.println("Hello ");
		return "Hello ";
	}

	@GetMapping(value = "/sayHello/{userName}")
	public String sayHelloWithPathVariable(@PathVariable String userName)
	{
		System.out.println("sayHelloWithPathVariable "+userName);
		return "sayHelloWithPathVariable "+userName;
	}
	
	@GetMapping(value = "/sayHelloWithRequestBody")
	public String sayHelloWithRequestBody(@RequestBody String userName)
	{
		System.out.println("sayHelloWithRequestBody "+userName);
		return "sayHelloWithRequestBody "+userName;
	}
	
	@PostMapping(value = "/sayHelloPostPathVariable/{userName}")
	public String sayHelloPostPathVariable(@PathVariable String userName)
	{
		return "sayHelloPostPathVariable "+userName;
	}
	
	@PostMapping(value = "/sayHelloPostRequestBody")
	public String sayHelloPostRequestBody(@RequestBody String userName)
	{
		return "sayHelloPostRequestBody "+userName;
	}
	
}
