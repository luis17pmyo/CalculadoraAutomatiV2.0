package com.pruebatecnica;

import java.util.HashMap;
import java.util.Map;

/**
 * Servicio para gestionar usuarios del sistema
 */
public class UsuarioService {
    private Map<String, Usuario> usuarios;
    
    public UsuarioService() {
        this.usuarios = new HashMap<>();
    }
    
    /**
     * Registra un nuevo usuario en el sistema
     * @param usuario usuario a registrar
     * @return true si el registro fue exitoso, false si el usuario ya existe
     */
    public boolean registrarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser null");
        }
        
        if (usuarios.containsKey(usuario.getEmail())) {
            return false; // Usuario ya existe
        }
        
        usuarios.put(usuario.getEmail(), usuario);
        return true;
    }
    
    /**
     * Autentica un usuario en el sistema
     * @param email email del usuario
     * @param contraseña contraseña del usuario
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean login(String email, String contraseña) {
        if (email == null || contraseña == null) {
            return false;
        }
        
        Usuario usuario = usuarios.get(email);
        if (usuario == null) {
            return false;
        }
        
        return usuario.getContraseña().equals(contraseña);
    }
    
    /**
     * Obtiene un usuario por su email
     * @param email email del usuario
     * @return el usuario si existe, null en caso contrario
     */
    public Usuario obtenerUsuario(String email) {
        return usuarios.get(email);
    }
    
    /**
     * Actualiza la información de un usuario
     * @param email email del usuario a actualizar
     * @param nuevoUsuario nuevos datos del usuario
     * @return true si la actualización fue exitosa, false si el usuario no existe
     */
    public boolean actualizarUsuario(String email, Usuario nuevoUsuario) {
        if (!usuarios.containsKey(email)) {
            return false;
        }
        
        // Removemos el usuario anterior y agregamos el nuevo
        usuarios.remove(email);
        usuarios.put(nuevoUsuario.getEmail(), nuevoUsuario);
        return true;
    }
    
    /**
     * Elimina un usuario del sistema
     * @param email email del usuario a eliminar
     * @return true si la eliminación fue exitosa, false si el usuario no existe
     */
    public boolean eliminarUsuario(String email) {
        return usuarios.remove(email) != null;
    }
    
    /**
     * Verifica si existe un usuario con el email dado
     * @param email email a verificar
     * @return true si el usuario existe, false en caso contrario
     */
    public boolean existeUsuario(String email) {
        return usuarios.containsKey(email);
    }
    
    /**
     * Obtiene el número total de usuarios registrados
     * @return número de usuarios
     */
    public int obtenerNumeroUsuarios() {
        return usuarios.size();
    }
    
    /**
     * Limpia todos los usuarios del sistema
     */
    public void limpiarUsuarios() {
        usuarios.clear();
    }
}