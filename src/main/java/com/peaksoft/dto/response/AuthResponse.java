package com.peaksoft.dto.response;

import lombok.Builder;

@Builder
public record AuthResponse(String token) {
}
