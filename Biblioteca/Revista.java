public class Revista extends MaterialBibliografico {
    private int numeroEdicion;
    private String periodicidad;

    public Revista(String titulo, String autor, int año, int numeroEdicion, String periodicidad) {
        super(titulo, autor, año);
        this.numeroEdicion = numeroEdicion;
        this.periodicidad = periodicidad;
    }

    @Override
    public String obtenerTipo() {
        return "Revista";
    }

    @Override
    public int calcularDiasPrestamo() {
        return 7;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("  Edición N°: " + numeroEdicion + " | Periodicidad: " + periodicidad);
    }
}
