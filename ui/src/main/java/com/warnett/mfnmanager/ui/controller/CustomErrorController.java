package com.warnett.mfnmanager.ui.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        final var status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        final var message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            model.addAttribute("errorCode", statusCode);
            model.addAttribute("errorMessage", message != null ? message : getErrorMessage(statusCode));
        } else {
            model.addAttribute("errorCode", "UNKNOWN");
            model.addAttribute("errorMessage", "An unknown error occurred");
        }

        return "error"; // Thymeleaf template name
    }

    private String getErrorMessage(int statusCode) {
        return switch (statusCode) {
            case 400 -> "Bad Request";
            case 403 -> "Forbidden";
            case 404 -> "Page Not Found";
            case 500 -> "Internal Server Error";
            default -> "Unknown Error";
        };
    }
}