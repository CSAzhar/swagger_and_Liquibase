	/**
     * Auto update updatedAt before update
     * @author azharuddin
     */
package com.studec.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;


@Table(
		name = "users",
		indexes = {
				@Index(name = "idx_user_mobile", columnList = "mobile", unique = true)
		}
)
@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "mobile", nullable = false, unique = true, length = 20)
	private String mobile;
	
	@Column(name = "full_name", length = 100)
	private String fullName;
	
	@Column(name = "email", unique = true, nullable = true, length = 150)
	private String email;
	
	
	private String userProfileImageUrl;
	
	private boolean isEmailVerified;
	private boolean isAccountActive;
	private boolean isAccountDeleted;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	private LocalDateTime lastLoggedInAt;
	
	private String password;
	
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	/**
     * Auto set createdAt before insert
     */
	@PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        role = Role.USER;
        isAccountActive = true;
    }

    /**
     * Auto update updatedAt before update
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
