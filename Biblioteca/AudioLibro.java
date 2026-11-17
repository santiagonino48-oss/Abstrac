public class AudioLibro extends MaterialBibliografico {
    private int duracionMinutos;
    private String narrador;

    public AudioLibro(String titulo, String autor, int año, int duracionMinutos, String narrador) {
        super(titulo, autor, año);
        this.duracionMinutos = duracionMinutos;
        this.narrador = narrador;
    }

    @Override
    public String obtenerTipo() {
        return "AudioLibro";
    }

    @Override
    public int calcularDiasPrestamo() {
        return 14;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("  Duración: " + duracionMinutos + " min | Narrador: " + narrador);
    }
}
