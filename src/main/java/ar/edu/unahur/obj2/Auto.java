package ar.edu.unahur.obj2;

public class Auto {

    private double combustible;
    private double kilometraje;
    private TipoDeConduccion tipoDeConduccion;

    public Auto(double combustible, double kilometraje, TipoDeConduccion tipoDeConduccion) {
        this.combustible = combustible;
        this.kilometraje = kilometraje;
        this.tipoDeConduccion = tipoDeConduccion;
    }

    public double getCombustible() {
        return combustible;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setTipoDeConduccion(TipoDeConduccion tipoDeConduccion) {
        this.tipoDeConduccion = tipoDeConduccion;
    }

    public void avanzar(double kilometros) {
        double combustibleNecesario = (1/ tipoDeConduccion.consumo()) * kilometros;

        // Verifico cantidad de combustible
        if (combustible >= combustibleNecesario) {
            combustible -= combustibleNecesario;
            kilometraje += kilometros;
        } else {
            double kilometrosPosibles = tipoDeConduccion.consumo() * combustible;
            combustible = 0;
            kilometraje += kilometrosPosibles;
            throw new RuntimeException("Combustible insuficiente, solo pude recorrer " + kilometrosPosibles);
        }
    }
}

