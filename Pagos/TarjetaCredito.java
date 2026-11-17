public class TarjetaCredito implements MetodoPago {
    private String numeroTarjeta;
    private String fechaVencimiento; // formato MM/AAAA
    private String cvv;
    private double ultimoMonto;

    public TarjetaCredito(String numeroTarjeta, String fechaVencimiento, String cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

    private boolean fechaValida() {
        try {
            String[] partes = fechaVencimiento.split("/");
            int mes = Integer.parseInt(partes[0]);
            int anio = Integer.parseInt(partes[1]);
            if (mes < 1 || mes > 12) {
                return false;
            }
            int anioActual = java.time.LocalDate.now().getYear();
            int mesActual = java.time.LocalDate.now().getMonthValue();
            return anio > anioActual || (anio == anioActual && mes >= mesActual);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean procesarPago(double monto) {
        ultimoMonto = monto;
        if (!fechaValida()) {
            System.out.println("  Rechazado: tarjeta vencida o fecha inválida (" + fechaVencimiento + ").");
            return false;
        }
        if (cvv == null || !cvv.matches("\\d{3,4}")) {
            System.out.println("  Rechazado: CVV inválido.");
            return false;
        }
        return true;
    }

    @Override
    public String obtenerNombreMetodo() {
        String ult4 = numeroTarjeta.substring(Math.max(0, numeroTarjeta.length() - 4));
        return "Tarjeta de crédito (**** " + ult4 + ")";
    }

    @Override
    public double calcularComision() { return ultimoMonto * 0.025; }
}
