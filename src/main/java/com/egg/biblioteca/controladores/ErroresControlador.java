package com.egg.biblioteca.controladores;


import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;


@Controller
public class ErroresControlador implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public ErroresControlador(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(WebRequest request, Model model) {
        Map<String, Object> errorDetails = errorAttributes.getErrorAttributes(request, ErrorAttributeOptions.defaults());
        String errorMsg = "";
        int statusCode = (int) errorDetails.get("status");
        switch (statusCode) {
            case 400:
                errorMsg = "El recurso solicitado no existe";
                break;
            case 401:
                errorMsg = "No se encuentra autorizado";
                break;
            case 403:
                errorMsg = "No tienes los permisos suficientes para acceder al contenido";
                break;
            case 404:
                errorMsg = "Página no encontrada";
                break;
            case 500:
                errorMsg = "Ocurrió un error interno";
                break;

            default:
                errorMsg = "Ups! Algo salió mal";
                break;
        }
        model.addAttribute("codigo", statusCode);
        model.addAttribute("mensaje", errorMsg);
        return "error";
    }
}
