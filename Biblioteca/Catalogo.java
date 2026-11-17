public class Catalogo {
    public static void main(String[] args) {
        // Catálogo centralizado (arreglo de la clase padre: polimorfismo)
        MaterialBibliografico[] catalogo = new MaterialBibliografico[6];
        catalogo[0] = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, 471, "Realismo mágico");
        catalogo[1] = new Libro("Clean Code", "Robert C. Martin", 2008, 464, "Informática");
        catalogo[2] = new Revista("National Geographic", "Varios", 2024, 312, "Mensual");
        catalogo[3] = new Revista("Muy Interesante", "Varios", 2024, 489, "Mensual");
        catalogo[4] = new AudioLibro("El Principito", "Antoine de Saint-Exupéry", 1943, 95, "Ana Torres");
        catalogo[5] = new AudioLibro("Sapiens", "Yuval Noah Harari", 2011, 900, "Luis Pérez");

        System.out.println("===== CATÁLOGO COMPLETO =====");
        for (MaterialBibliografico m : catalogo) {
            m.mostrarInformacion();
            System.out.println();
        }

        System.out.println("===== SIMULACIÓN DE PRÉSTAMOS =====");
        catalogo[0].prestar(); // Libro
        catalogo[0].prestar(); // Falla: ya prestado
        catalogo[2].prestar(); // Revista
        catalogo[4].prestar(); // AudioLibro
        catalogo[2].devolver();
        catalogo[2].devolver(); // Falla: ya devuelta

        System.out.println("\n===== DÍAS DE PRÉSTAMO POR TIPO =====");
        for (MaterialBibliografico m : catalogo) {
            System.out.println(m.obtenerTipo() + " - " + m.getTitulo() + ": "
                    + m.calcularDiasPrestamo() + " días");
        }

        System.out.println("\n===== ESTADO FINAL =====");
        for (MaterialBibliografico m : catalogo) {
            System.out.println(m.getTitulo() + " -> " + (m.isDisponible() ? "Disponible" : "Prestado"));
        }
    }
}
