/**
 * @ (#) EmailService.java      11/25/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/25/2024
 */
public interface EmailService {
    public void sendInvitationToCandidate(String toEmail, String subject, String body);
}
