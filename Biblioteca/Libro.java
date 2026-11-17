public class Libro extends MaterialBibliografico {
    private int numeroPaginas;
    private String genero;

    public Libro(String titulo, String autor, int año, int numeroPaginas, String genero) {
        super(titulo, autor, año);
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }

    @Override
    public String obtenerTipo() {
        return "Libro";
    }

    @Override
    public int calcularDiasPrestamo() {
        return 21;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("  Páginas: " + numeroPaginas + " | Género: " + genero);
    }
}
