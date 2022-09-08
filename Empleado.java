package clases;

public class Empleado {
    
    //Atributos
    
    private String nombreEmpleado;
    private String correoEmpleado;
    private Empresa empresaEmpleado;
    private RolesEmpleado rol ;
    
    //Contador
    
    static int generador = 1;
 
    int id;
    public Empleado() {
        id = generador++;
    }
    
    
    //Constructor

    public Empleado(String nombreEmpleado, String correoEmpleado, Empresa empresaEmpleado, RolesEmpleado rol) {
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.empresaEmpleado = empresaEmpleado;
        this.rol = rol;
    }



    //Set & Get

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Empresa getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(Empresa empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public RolesEmpleado getRol() {
        return rol;
    }

    public void setRol(RolesEmpleado rol) {
        this.rol = rol;
    }

    
    
}
