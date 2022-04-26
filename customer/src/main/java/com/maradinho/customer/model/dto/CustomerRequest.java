package com.maradinho.customer.model.dto;

public record CustomerRequest(
        String firstName,
        String lastName,
        String email) {
}
