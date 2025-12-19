package com.pruebatecnica.stepdefinitions;

import com.pruebatecnica.Usuario;
import com.pruebatecnica.UsuarioService;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioSteps {
    
    private UsuarioService usuarioService;
    private String nombre;
    private String email;
    private String contraseña;
    private String resultadoOperacion;
    private String mensajeResultado;
    private boolean loginExitoso;
    
    @Dado("que estoy en la página de registro")
    public void que_estoy_en_la_pagina_de_registro() {
        usuarioService = new UsuarioService();
    }
    
    @Cuando("ingreso el nombre {string}")
    public void ingreso_el_nombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Cuando("ingreso el email {string}")
    public void ingreso_el_email(String email) {
        this.email = email;
    }
    
    @Cuando("ingreso la contraseña {string}")
    public void ingreso_la_contraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    @Cuando("hago clic en registrar")
    public void hago_clic_en_registrar() {
        try {
            Usuario usuario = new Usuario(nombre, email, contraseña);
            boolean registroExitoso = usuarioService.registrarUsuario(usuario);
            
            if (registroExitoso) {
                resultadoOperacion = "exitoso";
                mensajeResultado = "Usuario registrado correctamente";
            } else {
                resultadoOperacion = "error";
                mensajeResultado = "Error en el registro";
            }
        } catch (IllegalArgumentException e) {
            resultadoOperacion = "error";
            mensajeResultado = e.getMessage();
        }
    }
    
    @Entonces("el resultado del registro debe ser {string}")
    public void el_resultado_del_registro_debe_ser(String resultadoEsperado) {
        assertThat(resultadoOperacion).isEqualTo(resultadoEsperado);
    }
    
    @Entonces("debe mostrar el mensaje {string}")
    public void debe_mostrar_el_mensaje(String mensajeEsperado) {
        assertThat(mensajeResultado).isEqualTo(mensajeEsperado);
    }
    
    @Dado("que existe un usuario registrado con email {string} y contraseña {string}")
    public void que_existe_un_usuario_registrado(String email, String contraseña) {
        usuarioService = new UsuarioService();
        Usuario usuario = new Usuario("Admin", email, contraseña);
        usuarioService.registrarUsuario(usuario);
    }
    
    @Cuando("ingreso las credenciales {string} y {string}")
    public void ingreso_las_credenciales(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }
    
    @Cuando("hago clic en iniciar sesión")
    public void hago_clic_en_iniciar_sesion() {
        loginExitoso = usuarioService.login(email, contraseña);
        if (loginExitoso) {
            mensajeResultado = "Bienvenido al sistema";
        } else {
            mensajeResultado = "Credenciales inválidas";
        }
    }
    
    @Entonces("debería estar logueado exitosamente")
    public void deberia_estar_logueado_exitosamente() {
        assertThat(loginExitoso).isTrue();
    }
    
    @Entonces("debería ver el mensaje de bienvenida {string}")
    public void deberia_ver_el_mensaje_de_bienvenida(String mensajeEsperado) {
        assertThat(mensajeResultado).isEqualTo(mensajeEsperado);
    }
    
    @Dado("que NO existe un usuario con email {string}")
    public void que_no_existe_un_usuario_con_email(String email) {
        usuarioService = new UsuarioService();
        // No registramos ningún usuario
    }
    
    @Entonces("NO debería estar logueado")
    public void no_deberia_estar_logueado() {
        assertThat(loginExitoso).isFalse();
    }
    
    @Entonces("debería ver el mensaje de error {string}")
    public void deberia_ver_el_mensaje_de_error(String mensajeEsperado) {
        assertThat(mensajeResultado).isEqualTo(mensajeEsperado);
    }
}