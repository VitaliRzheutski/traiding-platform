package com.vitali.controller;

import com.vitali.request.ForgotPasswordTokenRequest;
import com.vitali.domain.VerificationType;
import com.vitali.modal.ForgotPasswordToken;
import com.vitali.modal.User;
import com.vitali.modal.VerificationCode;
import com.vitali.repository.VerificationCodeRepository;
import com.vitali.request.ResetPasswordRequest;
import com.vitali.response.ApiResponse;
import com.vitali.response.AuthResponse;
import com.vitali.service.EmailService;
import com.vitali.service.ForgotPasswordService;
import com.vitali.service.UserService;
import com.vitali.service.VerificationCodeService;
import com.vitali.utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private  UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private VerificationCodeService verificationCodeService;
    @Autowired
    private VerificationCodeRepository verificationCodeRepository;
    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @GetMapping("/api/users/profile")
    public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String jwt) throws Exception { //???
        User user = userService.findUserByJwt(jwt);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //    sending otp
    @PostMapping ("/api/users/verification/verificationType/send-otp")
    public ResponseEntity<String> sendVerificationOtp(
            @RequestHeader("Authorization") String jwt,
            @PathVariable VerificationType verificationType) throws Exception {

        User user = userService.findUserByJwt(jwt);

        VerificationCode verificationCode = verificationCodeService.getVerificationCodeByUser(user.getId());
        if(verificationCode == null) {
            verificationCode = verificationCodeService.sendVerificationCode(user, verificationType);
        }

        if(verificationCode.equals(verificationType.EMAIL)) {
            emailService.sendVerificationOtpEmail(user.getEmail(), verificationCode.getOtp());
        }

        return new ResponseEntity<>("verification otp sent successfully", HttpStatus.OK);
    }

//verify otp
    @PatchMapping ("/api/users/enable-two-factor/verify-otp/{otp}")
    public ResponseEntity<User> enableTwoFactorAuthentication(
            @PathVariable String otp,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);

        VerificationCode verificationCode = verificationCodeService.getVerificationCodeByUser(user.getId());//user

        String sendTo = verificationCode.getVerificationType().equals(VerificationType.EMAIL)?
                verificationCode.getEmail() : verificationCode.getMobile();

        boolean isVerified=verificationCode.getOtp().equals(otp);

        if(isVerified) {
            User updatedUser=userService.enableTwoFactorAuthentication(verificationCode.getVerificationType(),sendTo,user);
            verificationCodeService.deleteVerificationCodeById(verificationCode);

            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }

        throw new Exception("Wrong otp");
    }


        @PostMapping("auth/users/reset-password/send-otp")
        public ResponseEntity<AuthResponse> sendForgotPasswordOTP(
                @RequestBody ForgotPasswordTokenRequest req) throws Exception{

            User user = userService.findUserByEmail(req.getSendTo());
            String otp = OtpUtils.generateOTP();
            UUID uuid = UUID.randomUUID();

            String id = uuid.toString();

            ForgotPasswordToken token = forgotPasswordService.findByUser(user.getId());

            if(token == null) {
                token = forgotPasswordService.createToken(user, id, otp, req.getVerificationType(),req.getSendTo());
            }
            if(req.getVerificationType().equals(VerificationType.EMAIL)) {
                emailService.sendVerificationOtpEmail(
                        user.getEmail(),
                        token.getOtp());
            }
            AuthResponse response = new AuthResponse();
            response.setSession((token.getId()));
            response.setMessage("Password reset otp send successfully");


            return new ResponseEntity<>(response,HttpStatus.OK);


    }

    @PatchMapping ("/auth/users/reset-password/verify-otp")
    public ResponseEntity<ApiResponse> resetPassword(
            @RequestParam String id,
            @RequestBody ResetPasswordRequest req,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);

       ForgotPasswordToken forgotPasswordToken = forgotPasswordService.findById(id);

       boolean isVerified = forgotPasswordToken.getOtp().equals(req.getOtp());

       if(isVerified) {
           userService.updatePassword(forgotPasswordToken.getUser(),req.getPassword());
           ApiResponse res = new ApiResponse();
           res.setMessage("Password update successfully");
            return new ResponseEntity<>(res,HttpStatus.OK);
       }
       throw new Exception("Wrong otp");



    }




}
