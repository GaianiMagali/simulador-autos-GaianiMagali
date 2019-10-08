package ar.edu.unahur.obj2;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestSimuladorDeAutos {
    Ecologica ecologico ;
    Deportiva deportivo ;
    Auto auto1;

    @BeforeMethod
    public void setUp() {
        ecologico = new Ecologica();
        deportivo = new Deportiva();
        auto1 = new Auto(100.0, 0.0, ecologico);
    }

    @Test
    public void testAuto1() {
        auto1.avanzar(16.0);
        Assert.assertEquals(auto1.getCombustible(), 99.0);
        Assert.assertEquals(auto1.getKilometraje(), 16.0);

        auto1.setTipoDeConduccion(deportivo);

        auto1.avanzar(5);
        Assert.assertEquals(auto1.getCombustible(), 98.0);
        Assert.assertEquals(auto1.getKilometraje(), 21.0);
    }
}
