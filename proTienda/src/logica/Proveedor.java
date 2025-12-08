package logica;

public class Proveedor extends Entidad {
    private String email;

    public Proveedor() {
    }
    public Proveedor(String nombre, Integer id, String email) {
        super(nombre, id);
        setEmail(email);
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede ser nulo ni vacío.");
        }
        String c = email.trim();
        if (!c.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("Formato de correo inválido: " + email);
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "NOMBRE PROVEEDOR: " + nombre + " | ID: " + id + " | EMAIL: " + email;
    }

}
