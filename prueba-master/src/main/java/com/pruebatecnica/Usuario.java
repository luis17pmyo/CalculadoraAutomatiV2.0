package com.pruebatecnica;

/**
 * Clase que representa un usuario del sistema
 */
public class Usuario {
    private String nombre;
    private String email;
    private String contraseña;
    
    /**
     * Constructor que crea un usuario con validaciones
     * @param nombre nombre del usuario
     * @param email email del usuario
     * @param contraseña contraseña del usuario
     * @throws IllegalArgumentException si algún campo es inválido
     */
    public Usuario(String nombre, String email, String contraseña) {
        validarCampos(nombre, email, contraseña);
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
    }
    
    private void validarCampos(String nombre, String email, String contraseña) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email es obligatorio");
        }
        
        if (contraseña == null || contraseña.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }
        
        if (!esEmailValido(email)) {
            throw new IllegalArgumentException("Formato de email inválido");
        }
        
        if (contraseña.length() < 6) {
            throw new IllegalArgumentException("Contraseña muy corta");
        }
    }
    
    private boolean esEmailValido(String email) {
        return email.contains("@") && email.contains(".");
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    
    // Setters
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }
    
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (!esEmailValido(email)) {
            throw new IllegalArgumentException("Formato de email inválido");
        }
        this.email = email;
    }
    
    public void setContraseña(String contraseña) {
        if (contraseña == null || contraseña.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        if (contraseña.length() < 6) {
            throw new IllegalArgumentException("Contraseña muy corta");
        }
        this.contraseña = contraseña;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Usuario usuario = (Usuario) obj;
        return email.equals(usuario.email);
    }
    
    @Override
    public int hashCode() {
        return email.hashCode();
    }
}