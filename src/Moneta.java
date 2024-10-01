public class Moneta {
    private final int wartość; // wartość w groszach
    private final double waga; // waga w gramach
    private final int szansa; // ilość oczekiwanych wystąpień na 100 monet

    public int getWartość() { return wartość; }
    public double getWaga() { return waga; }
    public double getSzansa() { return szansa; }

    public Moneta(int wartość, double waga, int szansa) {
        this.wartość = wartość;
        this.waga = waga;
        this.szansa = szansa;
    }
}
