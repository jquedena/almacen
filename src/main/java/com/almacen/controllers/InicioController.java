package com.almacen.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {

    @RequestMapping(value = "/inicio")
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "views/index";
    }

    @RequestMapping(value = "/iniciarSesion")
    public String iniciarSesion(
        @RequestParam(value = "error", required = false) String error,
        @RequestParam(value = "cerrarSesion", required = false) String cerrarSesion) {
        return "views/login";
    }

    @RequestMapping(value = "/403")
    public String noAutorizado() {
        return "views/login";
    }

    @RequestMapping(value = "/ok")
    public String paginaPorDefecto() {
        return "views/default";
    }

    @RequestMapping(value = "/producto")
    public String paginaProducto() {
        return "views/default";
    }

    @RequestMapping(value = "/productos")
    public String paginaProductos() {
        return "views/default";
    }

    @RequestMapping(value = "/404")
    public String paginaNoEncontrada() {
        return "views/404";
    }

    @RequestMapping(value = "/paginas/producto")
    public String registrarProducto() {
        return "views/registrarProducto";
    }

    @RequestMapping(value = "/paginas/productos")
    public String consultarProductos() {
        return "views/consultarProductos";
    }
}
