# language: es
Característica: Gestión de Usuarios
  Como administrador del sistema
  Quiero gestionar usuarios
  Para mantener la seguridad del sistema

  Esquema del escenario: Registro de usuario con diferentes datos
    Dado que estoy en la página de registro
    Cuando ingreso el nombre "<nombre>"
    Y ingreso el email "<email>"
    Y ingreso la contraseña "<contraseña>"
    Y hago clic en registrar
    Entonces el resultado del registro debe ser "<resultado>"
    Y debe mostrar el mensaje "<mensaje>"

    Ejemplos:
      | nombre    | email               | contraseña | resultado | mensaje                          |
      | Juan      | juan@test.com      | 12345678   | exitoso   | Usuario registrado correctamente |
      | María     | maria@test.com     | abc123     | exitoso   | Usuario registrado correctamente |
      |           | sinombre@test.com  | 12345678   | error     | El nombre es obligatorio         |
      | Pedro     |                    | 12345678   | error     | El email es obligatorio          |
      | Ana       | ana@test.com       |            | error     | La contraseña es obligatoria     |
      | Luis      | email-invalido     | 12345678   | error     | Formato de email inválido        |
      | Carmen    | carmen@test.com    | 123        | error     | Contraseña muy corta             |

  Escenario: Login exitoso
    Dado que existe un usuario registrado con email "admin@test.com" y contraseña "admin123"
    Cuando ingreso las credenciales "admin@test.com" y "admin123"
    Y hago clic en iniciar sesión
    Entonces debería estar logueado exitosamente
    Y debería ver el mensaje de bienvenida "Bienvenido al sistema"

  Escenario: Login fallido
    Dado que NO existe un usuario con email "inexistente@test.com"
    Cuando ingreso las credenciales "inexistente@test.com" y "password123"
    Y hago clic en iniciar sesión
    Entonces NO debería estar logueado
    Y debería ver el mensaje de error "Credenciales inválidas"