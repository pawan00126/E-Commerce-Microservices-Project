# E-Commerce-Microservices-Project

This is a mini e-commerce backend application built using **Spring Boot Microservices Architecture**. It showcases a basic order placement flow using multiple microservices.

---
## ⚙️ Tech Stack

- **Java 21**
- **Spring Boot 3.x**
- **Spring Web / JPA / RestTemplate**
- **Spring Cloud (Eureka, OpenFeign, API Gateway)**
- **MySQL (for local DB)**
- **Maven**

---


## Microservices Overview

| Service        | Responsibility                               |
|----------------|-----------------------------------------------|
| `User-Service`     | Manages user data                         |
| `Product-Service`  | Handles product details                   |
| `Order-Service`    | Handles order creation + fetch order data |
| `API-Gateway`      | Centralized gateway for routing           |
| `Eureka Server`    | Service discovery                         |

---

## Inter-Service Communication

- **Feign Clients** are used to call `User` and `Product` services from `Order-Service`.
- **API Gateway** routes requests to appropriate services via path-based routing.
- All services are registered with **Eureka Discovery Server**.

---

## Features

- Place an order using userId and productId
- Automatically fetch user and product details in the order response
- Fetch all orders or a specific order by ID
- Basic error handling and fallback data
- Clean separation of concerns per microservice

---

## How to Run

1. **Clone the repository**
2. **Start Eureka Server**
3. **Start User, Product, and Order services**
4. **Start API Gateway**
5. Test using Postman or Browser:
    - `POST /orders` to place an order
    - `GET /orders` to fetch all orders
    - `GET /orders/{id}` to fetch order by ID

---
