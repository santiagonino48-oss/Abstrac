public class Carrito {
    public static void main(String[] args) {
        CarritoCompras carrito = new CarritoCompras();
        carrito.agregarProducto(new Producto("Teclado mecánico", 80.00));
        carrito.agregarProducto(new Producto("Mouse inalámbrico", 35.50));
        carrito.agregarProducto(new Producto("Monitor 24\"", 150.00));

        System.out.println("===== SIMULACIÓN DE COMPRAS =====");

        // Casos aprobados
        carrito.procesarCompra(new TarjetaCredito("4111111111111111", "12/2030", "123"));
        carrito.procesarCompra(new PayPal("santiago@mail.com", 500.00));
        carrito.procesarCompra(new TransferenciaBancaria("0123456789012", "Banco de Venezuela"));

        // Casos rechazados
        carrito.procesarCompra(new TarjetaCredito("5500000000000004", "01/2020", "456"));
        carrito.procesarCompra(new PayPal("pobre@mail.com", 100.00));
        carrito.procesarCompra(new TransferenciaBancaria("12345", "Banesco"));

        System.out.println("--------------------------------------------");
    }
}
