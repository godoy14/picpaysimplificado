package com.picpaysimplificado.dtos;

import com.picpaysimplificado.domain.user.UserType;

import java.math.BigDecimal;

public record CreateUserDTO(String firstName, String lastName, String email, String document, BigDecimal balance, String password, UserType userType) {
}
