
public class ProjectoEjemplo {

    public static void main(String[] args) {
        Empresa ejemploEmpresa = new Empresa("Empresa E1","Cra2#321-21","123321456","432-132213");
        Empleado ejemploEmpleado = new Empleado("Pepito Perez","pepito@gmail.com","Empresa E1","Admin");
        MovimientoDinero ejemploMovimiento = new MovimientoDinero(150000,"Prima","Usu1");
    
        ejemploEmpresa.setNombre("Empresa Ejemplo 1");
        ejemploEmpresa.setDireccion("Cra 1 # 123-11");
        ejemploEmpresa.setTelefono("987654321");
        ejemploEmpresa.setNit("43-23324234");
        
        ejemploEmpleado.setNombreEmpleado("Pedro Ejemplo");
        ejemploEmpleado.setCorreoEmpleado("correoejemplo@gmail.com");
        ejemploEmpleado.setEmpresaEmpleado("Empresa Ejemplo 1");
        ejemploEmpleado.setRolEmpleado("Administrador");
        
        ejemploMovimiento.setMontoMovimiento(-150000);
        ejemploMovimiento.setMotivoMovimiento("Pago Ejemplo");
                
        System.out.println("El nombre de la empresa es:");
        System.out.println(ejemploEmpresa.getNombre());
        
        System.out.println("La dirección de la empresa es:");
        System.out.println(ejemploEmpresa.getDireccion());
        
        System.out.println("El telefono de la empresa es:");
        System.out.println(ejemploEmpresa.getTelefono());
        
        System.out.println("El NIT de la empresa es:");
        System.out.println(ejemploEmpresa.getNit());
        
        System.out.println("El nombre del empleado es:");
        System.out.println(ejemploEmpleado.getNombreEmpleado());
        
        System.out.println("El correo del empleado es:");
        System.out.println(ejemploEmpleado.getCorreoEmpleado());
        
        System.out.println("El nombre de la empresa del empleado es:");
        System.out.println(ejemploEmpleado.getEmpresaEmpleado());
        
        System.out.println("El rol del empleado es:");
        System.out.println(ejemploEmpleado.getRolEmpleado());
        
        System.out.println("El monto de dinero es:");
        System.out.println(ejemploMovimiento.getMontoMovimiento());
        
        System.out.println("El concepto del movimiento es:");
        System.out.println(ejemploMovimiento.getMotivoMovimiento());
        
        System.out.println("El usuario es:");
        System.out.println(ejemploMovimiento.getUsuario());
        
        
        
        
        
        
    
    }
}
