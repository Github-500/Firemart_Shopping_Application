package com.application;

import java.util.List;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.application.exception.BusinessException;
import com.application.model.Cart;
import com.application.model.Customer;
import com.application.model.Order;
import com.application.model.Product;
import com.application.registration.service.CartService;
import com.application.registration.service.CustomerLoginService;
import com.application.registration.service.CustomerRegistrationService;
import com.application.registration.service.EmployeeLoginService;
import com.application.registration.service.OrderService;
import com.application.registration.service.impl.CartServiceImpl;
import com.application.registration.service.impl.CustomerLoginServiceImpl;
import com.application.registration.service.impl.CustomerRegistrationServiceImpl;
import com.application.registration.service.impl.EmployeeLoginServiceImpl;
import com.application.registration.service.impl.OrderServiceImpl;

public class AppMain {
	private static Logger log = Logger.getLogger(AppMain.class);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		log.info("Welcome to FireMart Shopping App");
		log.info("==========================================");
		int ch = 0;
		do {
			log.info("\nWhat you wish to do today?");
			log.info("1)Employee Login");
			log.info("2)Customer Login");
			log.info("3)Customer Registration");
			log.info("4)Exit");
			log.info("Please enter your choice(1-4)");
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				log.info("only use numbers");
			}
			int id = 0;
			String name = null;
			String email = null;
			String password = null;
			long contact = 0l;
			String gender = null;
			String address = null;
			double price = 0.0;
			Product product = null;
			String ss = null;
			String status = null;
			int p_id = 0;
			switch (ch) {
			case 1:
				EmployeeLoginService employeeLoginService = new EmployeeLoginServiceImpl();
				log.info("Enter Employee Login");
				log.info("Enter Employee email");
				try {
					email = scanner.nextLine();
				} catch (NumberFormatException e) {
				}
				log.info("Enter Employee Password");
				try {
					password = scanner.nextLine();
				} catch (NumberFormatException e) {
				}
				try {
					if (employeeLoginService.validEmployee(email, password) == 1) {
						log.info("Employee login successful");
						int option = 0;
						do {
							log.info("1)Add Product");
							log.info("2)Remove Product");
							log.info("3)List All Products");
							log.info("4)List All Customers");
							log.info("5)View Customer Orders and Change order status");
							log.info("6)Change order status by order id");
							log.info("7)Logout");
							log.info("Please choose between 1-7");
							try {
								option = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {
								log.info("only use numbers");
							}
							switch (option) {
							case 1:
								log.info("Enter Product Id");
								try {
									id = Integer.parseInt(scanner.nextLine());
								} catch (NumberFormatException e) {
									log.info("Invalid Id");
								}
								log.info("Enter Product name");
								try {
									name = scanner.nextLine();
								} catch (NumberFormatException e) {
								}
								log.info("Enter Product Price");
								try {
									price = Double.parseDouble(scanner.nextLine());
								} catch (NumberFormatException e) {
									log.info("Invalid Price");
								}
								product = new Product(id, name, price);
								try {
									if (employeeLoginService.addProduct(product) == 1) {
										log.info("Product with below details successfully added");
										log.info(product);
									}
								} catch (BusinessException e) {
									log.info(e.getMessage());
								}

								break;
							case 2:
								log.info("Enter Product Id to delete");
								try {
									id = Integer.parseInt(scanner.nextLine());
								} catch (NumberFormatException e) {
								}
								try {
									if (employeeLoginService.deleteProduct(id) == 1) {
										log.info("Product with id " + id + " deleted successfully ");
									}
								} catch (BusinessException e) {
									log.info(e.getMessage());
								}
								break;
							case 3:
								try {
									List<Product> productList = employeeLoginService.getAllProducts();
									log.info("Total we have " + productList.size()
											+ " products... Below are the details");
									for (Product product1 : productList) {
										log.info(product1);
									}
								} catch (BusinessException e) {
									log.info(e.getMessage());
								}
								break;
							case 4:
								try {
									List<Customer> customerList = employeeLoginService.getAllCustomers();
									log.info("Total we have " + customerList.size()
											+ " customers... Below are the details");
									for (Customer customer : customerList) {
										log.info(customer);
									}
								} catch (BusinessException e) {
									log.info(e.getMessage());
								}
								break;
							case 5:
								OrderService orderService = new OrderServiceImpl();
								log.info("All orders based on customer_id");
								log.info("Enter the customer id");
								try {
									id = Integer.parseInt(scanner.nextLine());
								} catch (NumberFormatException e) {
									log.info("Invalid Id");
								}
								try {
									List<Order> orderList = orderService.getAllOrders(id);
									log.info("customer with id " + id + " have " + orderList.size()
											+ " orders in his orders");
									for (Order order : orderList) {
										log.info(order);
									}
									log.info("Do you wish to change order status of the product type yes|no");
									try {
										ss = scanner.nextLine();
									} catch (NumberFormatException e) {
									}
									try {
										if (ss.equals("yes")) {
											log.info("Change Order Status");
											log.info("Enter the product id which you want to change order status");
											try {
												p_id = Integer.parseInt(scanner.nextLine());
											} catch (NumberFormatException e) {
												log.info("Invalid Id");
											}
											log.info("Enter Status of order");
											try {
												status = scanner.nextLine();
											} catch (NumberFormatException e) {
											}
											try {
												if (orderService.updateOrderStatus(status, p_id, id) > 0) {
													log.info("Order Status successfully updated");
												} else {
													log.info("Order status not updated");
												}
											} catch (BusinessException e) {
												log.warn(e.getMessage());
											}
										}
									} catch (Exception e) {
										log.warn(e.getMessage());
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 6:
								int order_id=0;
								OrderService orderService1 = new OrderServiceImpl();
								log.info("Change Order Status");
								log.info("Enter the order id which you want to change order status");
								try {
									order_id = Integer.parseInt(scanner.nextLine());
								} catch (NumberFormatException e) {
									log.info("Invalid order_id");
								}
								log.info("Enter Status of order");
								try {
									status = scanner.nextLine();
								} catch (NumberFormatException e) {
								}
								try {
									if (orderService1.updateOrderStatus(status, order_id) > 0) {
										log.info("Order Status successfully updated");
									} else {
										log.info("Order status not updated");
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 7:
								log.info("\n\nGOING BACK TO MAIN MENU......\n\n");
								break;
							default:
								log.info(
										"Invalid Search Option... Choice should be only number between 1-7 only. Kindly Retry ");
								break;
							}
						} while (option != 7);
					}
				} catch (BusinessException e1) {
					log.info(e1.getMessage());
				}

				break;
			case 2:
				CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();
				CartService cartService = new CartServiceImpl();
				log.info("Customer Login");
				log.info("Enter Customer email");
				try {
					email = scanner.nextLine();
				} catch (NumberFormatException e) {
				}
				log.info("Enter Customer Password");
				try {
					password = scanner.nextLine();
				} catch (NumberFormatException e) {
				}
				try {
					int customer_id = customerLoginService.validCustomer(email, password);
					if (customer_id != 0) {
						int option = 0;
						do {
							log.info("1)view products");
							log.info("2)Search Products by Id");
							log.info("3)Search Products by Name");
							log.info("4)View Cart");
							log.info("5)My Orders");
							log.info("6)Logout");
							log.info("Please choose between 1-6");
							try {
								option = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {
								log.info("only use numbers");
							}
							switch (option) {
							case 1:
								try {
									List<Product> productList = customerLoginService.getAllProducts();
									log.info("Total we have " + productList.size()
											+ " products... Below are the details");
									for (Product product1 : productList) {
										log.info(product1);
									}
									log.info("Do you wish to add any of this products into your cart type yes|no");
									try {
										ss = scanner.nextLine();
									} catch (NumberFormatException e) {
									}
									try {
										if (ss.equals("yes")) {
											log.info("Select the product id which you want to add into cart");
											try {
												id = Integer.parseInt(scanner.nextLine());
											} catch (NumberFormatException e) {
												log.info("only use numbers");
											}
											try {
												if (cartService.addCartProduct(id, customer_id) == 1) {
													log.info("Product with id " + id
															+ " added successfully to the cart");
												}
											} catch (BusinessException e) {
												log.info(e.getMessage());
											}
										} else {
											log.info("sorry you haven't added product to your cart");
										}
									} catch (Exception e) {
										log.warn(e.getMessage());
									}
								} catch (BusinessException e) {
									log.info(e.getMessage());
								}
								break;
							case 2:
								log.info("Enter product id to get product details");
								try {
									id = Integer.parseInt(scanner.nextLine());
									product = customerLoginService.getProductById(id);
									if (product != null) {
										log.info("Product with id " + id
												+ " found successfully... Below is the details");
										log.info(product);
										log.info("Do you wish to add this product into your cart type yes|no");
										try {
											ss = scanner.nextLine();
										} catch (NumberFormatException e) {
										}
										try {
											if (ss.equals("yes")) {
												try {
													if (cartService.addCartProduct(id, customer_id) == 1) {
														log.info("Product with id " + id
																+ " added successfully to the cart");
													}
												} catch (BusinessException e) {
													log.info(e.getMessage());
												}
											} else {
												log.info("sorry you haven't added this product to your cart");
											}
										} catch (Exception e) {
											log.warn(e);
										}
									}

								} catch (NumberFormatException e) {
									log.warn("Product Id should be digit only... Try Again");
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 3:
								log.info("Enter product name to get product details");
								try {
									name = scanner.nextLine();
									product = customerLoginService.getProductByName(name);
									if (product != null) {
										log.info("Product with name " + name
												+ " found successfully... Below is the details");
										log.info(product);
										log.info("Do you wish to add this product into your cart type yes|no");
										try {
											ss = scanner.nextLine();
										} catch (NumberFormatException e) {
											log.info("only use numbers");
										}
										try {
											if (ss.equals("yes")) {
												try {
													if (cartService.addCartProduct(product.getP_id(),
															customer_id) == 1) {
														log.info("Product with id " + product.getP_id()
																+ " added successfully to the cart");
													}
												} catch (BusinessException e) {
													log.info(e.getMessage());
												}
											} else {
												log.info("sorry you haven't added this product to your cart");
											}
										} catch (Exception e) {
											log.warn(e);
										}
									}
								} catch (NumberFormatException e) {
									log.warn("Try Again");
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 4:
								try {
									List<Cart> cartList = cartService.getCartProducts(customer_id);
									log.info("Total you have " + cartList.size() + " products in your cart");
									for (Cart cart : cartList) {
										log.info(cart);
									}
									int choice = 0;
									do {
										log.info("1)Add products into cart");
										log.info("2)delete products from cart");
										log.info("3)Place Order");
										log.info("4)Back");
										log.info("Please choose between 1-4");
										try {
											choice = Integer.parseInt(scanner.nextLine());
										} catch (NumberFormatException e) {
											log.info("only use numbers");
										}
										switch (choice) {
										case 1:
											log.info("Select the product id which you want to add into cart");
											try {
												id = Integer.parseInt(scanner.nextLine());
											} catch (NumberFormatException e) {
												log.info("only use numbers");
											}
											try {
												if (cartService.addCartProduct(id, customer_id) == 1) {
													log.info("Product with id " + id
															+ " added successfully to the cart");
												}
											} catch (BusinessException e) {
												log.info(e.getMessage());
											}
											break;
										case 2:
											int c_id = 0;
											log.info("Select the product id which you want to delete from your cart");
											try {
												p_id = Integer.parseInt(scanner.nextLine());
											} catch (NumberFormatException e) {
												log.info("only use numbers");
											}
											log.info(
													"Select the customer id from which you want to delete product in cart");
											try {
												c_id = Integer.parseInt(scanner.nextLine());
											} catch (NumberFormatException e) {
												log.info("only use numbers");
											}
											try {
												if (cartService.deleteCartProduct(p_id, c_id) > 0) {
													log.info("Product with id " + p_id
															+ " deleted successfully from the cart");
												}
											} catch (BusinessException e) {
												log.info(e.getMessage());
											}
											break;
										case 3:
											try {
												OrderService orderService = new OrderServiceImpl();
												if (orderService.placeOrder(customer_id) == 1) {
													log.info("Order Successfully placed");
													log.info("You can check your order id in your my orders section");
													if (cartService.emptyCart(customer_id) > 0) {
														log.info("Cart is empty");
													} else {
														log.info("Cart is already empty");
													}
												} else {
													log.info("order not placed");
												}
											} catch (BusinessException e) {
												log.info(e.getMessage());
											}
											break;
										case 4:
											log.info("\nGOING BACK ......\n");
											break;
										default:
											log.warn(
													"Invalid Search Option... Choice should be only number between 1-4 only. Kindly Retry ");
											break;
										}
									} while (choice != 4);
								} catch (BusinessException e) {
									log.info(e.getMessage());
								}
								break;
							case 5:
								OrderService orderService = new OrderServiceImpl();
								try {
									List<Order> orderList = orderService.getAllOrders(customer_id);
									log.info("Total you have " + orderList.size() + " orders in your My orders");
									for (Order order : orderList) {
										log.info(order);
									}
									if (orderList.size() != 0) {
										log.info("Mark as Delivered If you receive your order");
										log.info("Do you wish to mark received any product type yes|no");
										try {
											ss = scanner.nextLine();
										} catch (NumberFormatException e) {
										}
										try {
											if (ss.equals("yes")) {
												log.info("Enter Product Id for which you received your order");
												try {
													id = Integer.parseInt(scanner.nextLine());
												} catch (NumberFormatException e) {
													log.info("only use numbers");
												}
												try {
													if (orderService.updateOrderStatus("Delivered", id,
															customer_id) != 0) {
														log.info("You have received your product with id " + id);
													} else {
														log.info("Not received product");
													}
												} catch (BusinessException e) {
													log.warn(e.getMessage());
												}
											} else {
												log.info("You haven't received your order yet");
											}
										} catch (Exception e) {
											log.info(e.getMessage());
										}
									} else {
										log.info("You don't have any orders in your My orders");
									}

								} catch (BusinessException e) {
									log.info(e.getMessage());
								}
								break;
							case 6:
								log.info("\n\nGOING BACK TO MAIN MENU......\n\n");
								break;
							default:
								log.info(
										"Invalid Search Option... Choice should be only number between 1-6 only. Kindly Retry ");
								break;
							}
						} while (option != 6);
					}
				} catch (BusinessException e1) {
					log.info(e1.getMessage());
				}

				break;
			case 3:
				CustomerRegistrationService customerRegistrationService = new CustomerRegistrationServiceImpl();
				log.info("Customer Registration");
				log.info("Enter Customer Id");
				try {
					id = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					log.info("Invalid Id");
				}
				log.info("Enter Customer name");
				try {
					name = scanner.nextLine();
				} catch (NumberFormatException e) {
				}
				log.info("Enter Customer email");
				try {
					email = scanner.nextLine();
				} catch (NumberFormatException e) {
				}
				log.info("Enter Customer Password");
				try {
					password = scanner.nextLine();
				} catch (NumberFormatException e) {
				}
				log.info("Enter Customer contact");
				try {
					contact = Long.parseLong(scanner.nextLine());
				} catch (NumberFormatException e) {
					log.info("Invalid contact");
				}
				log.info("Enter Customer gender");
				try {
					gender = scanner.nextLine();
				} catch (NumberFormatException e) {
				}
				log.info("Enter Customer address");
				try {
					address = scanner.nextLine();
				} catch (NumberFormatException e) {
				}
				Customer customer = new Customer(id, name, email, password, contact, gender, address);
				try {
					if (customerRegistrationService.createCustomer(customer) == 1) {
						log.info("Customer Registered successfully");
						log.info(customer);
					}
				} catch (BusinessException e) {
					log.info(e.getMessage());
				}

				break;
			case 4:
				log.info("Thanks for using this APP we will see you soon :) ");
				break;
			default:
				log.warn("Invalid Search Option... Choice should be only number between 1-4 only. Kindly Retry ");
				break;
			}
		} while (ch != 4);
		scanner.close();
	}
}
