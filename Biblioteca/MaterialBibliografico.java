public abstract class MaterialBibliografico {
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private boolean disponible;

    public MaterialBibliografico(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.disponible = true;
    }

    // Métodos abstractos
    public abstract String obtenerTipo();

    public abstract int calcularDiasPrestamo();

    // Métodos concretos
    public boolean prestar() {
        if (!disponible) {
            System.out.println("  [X] \"" + titulo + "\" no está disponible.");
            return false;
        }
        disponible = false;
        System.out.println("  [OK] Prestado: \"" + titulo + "\" (" + obtenerTipo()
                + ") por " + calcularDiasPrestamo() + " días.");
        return true;
    }

    public boolean devolver() {
        if (disponible) {
            System.out.println("  [X] \"" + titulo + "\" ya estaba en la biblioteca.");
            return false;
        }
        disponible = true;
        System.out.println("  [OK] Devuelto: \"" + titulo + "\".");
        return true;
    }

    public void mostrarInformacion() {
        System.out.println("[" + obtenerTipo() + "] " + titulo);
        System.out.println("  Autor: " + autor + " | Año: " + añoPublicacion);
        System.out.println("  Disponible: " + (disponible ? "Sí" : "No")
                + " | Días de préstamo: " + calcularDiasPrestamo());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getañoPublicacion() {
        return añoPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
