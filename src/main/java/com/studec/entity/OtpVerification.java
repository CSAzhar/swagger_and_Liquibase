package com.studec.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "otp_verification", indexes = {
    @Index(name = "idx_mobile", columnList = "mobile")
})
public class OtpVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mobile", nullable = false, length = 20)
    private String mobile;

    @Column(name = "otp_code", nullable = false, length = 6)
    private String otpCode;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    // ✅ New column to track OTP usage
    @Column(name = "is_used", nullable = false)
    private boolean isUsed = false;

    
    @PrePersist
    protected void onCreate() {
        expiresAt = LocalDateTime.now().plusMinutes(5); // OTP valid for 5 min
    }
}
