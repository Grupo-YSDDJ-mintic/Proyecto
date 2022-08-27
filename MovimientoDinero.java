public class MovimientoDinero {
    private double montoMovimiento;
    private String motivoMovimiento, usuario;

    MovimientoDinero(double montoMovimiento, String motivoMovimiento, String usuario) {
        this.montoMovimiento = montoMovimiento;
        this.motivoMovimiento = motivoMovimiento;
        this.usuario = usuario;
    }

    public double getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(double montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getMotivoMovimiento() {
        return motivoMovimiento;
    }

    public void setMotivoMovimiento(String motivoMovimiento) {
        this.motivoMovimiento = motivoMovimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
