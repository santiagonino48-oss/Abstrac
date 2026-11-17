public class CarritoCompras {
    private Producto[] listaProductos = new Producto[20];
    private int cantidad = 0;
    private double total = 0;

    public void agregarProducto(Producto p) {
        if (cantidad < listaProductos.length) {
            listaProductos[cantidad] = p;
            cantidad++;
            total += p.getPrecio();
        } else {
            System.out.println("El carrito está lleno.");
        }
    }

    public double getTotal() { return total; }

    public boolean procesarCompra(MetodoPago metodo) {
        System.out.println("--------------------------------------------");
        System.out.println("Método: " + metodo.obtenerNombreMetodo());
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("  - %-18s $%8.2f%n", listaProductos[i].getNombre(), listaProductos[i].getPrecio());
        }
        System.out.printf("  Subtotal: $%.2f%n", total);

        if (cantidad == 0) {
            System.out.println("  Rechazado: el carrito está vacío.");
            return false;
        }

        boolean exito = metodo.procesarPago(total);
        if (exito) {
            double comision = metodo.calcularComision();
            System.out.printf("  Comisión: $%.2f%n", comision);
            System.out.printf("  TOTAL COBRADO: $%.2f%n", total + comision);
            System.out.println("  Estado: APROBADO");
        } else {
            System.out.println("  Estado: RECHAZADO");
        }
        return exito;
    }
}
