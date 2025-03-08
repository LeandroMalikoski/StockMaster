package com.master.stock.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryRegisterDTO(@NotBlank String name) {
}
