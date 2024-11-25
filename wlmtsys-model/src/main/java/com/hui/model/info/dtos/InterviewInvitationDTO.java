package com.hui.model.info.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InterviewInvitationDTO {
    private Integer status;
    private String email;
    private String intervieweeName;
    private String position;
    private LocalDateTime interviewDateTime;
    private String interviewLocation;
    private String interviewerNamePosition;
    private String companyName;
    private String contactName;
    private String contactPosition;
    private String contactPhone;
    private String companyUrl;

}