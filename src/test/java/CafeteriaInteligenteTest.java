import utn.frc.bda.semana2.cafeteria.Cafeteria;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CafeteriaInteligenteTest {

    private Cafeteria cafetera;

    @BeforeEach
    public void setUp() {
        cafetera = new Cafeteria("Acme", "X100", 500, 0, false, 0, 20);
    }

    @Test
    @DisplayName("Estado inicial coherente al construir la cafetera")
    public void testEstadoInicial() {
        assertAll("Estado inicial",
                () -> assertEquals("Acme", cafetera.getMarca(), "Marca incorrecta"),
                () -> assertEquals("X100", cafetera.getModelo(), "Modelo incorrecto"),
                () -> assertEquals(500, cafetera.getCapacidadMaxima(), "Capacidad incorrecta"),
                () -> assertEquals(0, cafetera.getContenidoActual(), "Contenido actual debe ser 0"),
                () -> assertEquals(20, cafetera.getTemperatura(), "Temperatura inicial debe ser 20"),
                () -> assertFalse(cafetera.isEncendida(), "La cafetera debe estar apagada al inicio"),
                () -> assertEquals(0, cafetera.getCafeServidos(), "Cafés servidos debe ser 0")
        );
    }

    @Test
    @DisplayName("Apagar apaga la cafetera y reinicia el contador de cafés sin afectar agua ni temperatura")
    public void testApagarReiniciaContadorSinCambiarEstado() {
        // Preparación
        cafetera.encender();
        cafetera.cargarAgua(300);
        cafetera.calentar(); // +40 => 60
        cafetera.calentar(); // +40 => 100
        cafetera.servirCafe(); // Usa 100 ml, quedan 200

        int aguaAntes = cafetera.getContenidoActual();
        int tempAntes = cafetera.getTemperatura();

        // Acción
        cafetera.apagar();

        // Verificaciones
        assertAll("Estado después de apagar",
                () -> assertFalse(cafetera.isEncendida(), "La cafetera debería estar apagada"),
                () -> assertEquals(0, cafetera.getCafeServidos(), "El contador de cafés servidos debería reiniciarse"),
                () -> assertEquals(aguaAntes, cafetera.getContenidoActual(), "El agua no debería cambiar al apagar"),
                () -> assertEquals(tempAntes, cafetera.getTemperatura(), "La temperatura no debería cambiar al apagar")
        );
    }

    @Test
    @DisplayName("Cargar agua respeta capacidad máxima")
    public void testCargarAguaRespetaCapacidadMaxima() {
        cafetera.encender();

        boolean resultado = cafetera.cargarAgua(600); // 600 > 500

        assertAll("Carga de agua excediendo la capacidad",
                () -> assertTrue(resultado, "La carga debería retornar true al estar encendida"),
                () -> assertEquals(500, cafetera.getContenidoActual(), "El contenido actual no debe exceder la capacidad máxima")
        );
    }

    @Test
    @DisplayName("Calentar estando apagada no cambia temperatura y retorna false")
    public void testCalentarApagada() {
        // No encender la cafetera
        boolean resultado = cafetera.calentar();

        assertAll("Calentar en estado apagado",
                () -> assertFalse(resultado, "Calentar debería retornar false si está apagada"),
                () -> assertEquals(20, cafetera.getTemperatura(), "La temperatura debería permanecer en 20")
        );
    }
    @Test
    @DisplayName("Calentar incrementa de a 40°C sin superar los 100°C")
    public void testCalentarIncrementaYLimita() {
        cafetera.encender();

        // 20°C inicial + 3 llamadas de calentar()
        cafetera.calentar(); // 60
        cafetera.calentar(); // 100
        cafetera.calentar(); // sigue en 100
        cafetera.calentar(); // sigue en 100

        assertEquals(100, cafetera.getTemperatura(), "La temperatura no debe superar los 100°C");
    }

    @Test
    @DisplayName("Servir café con cafetera apagada retorna false")
    public void testServirCafeConCafeteraApagada() {
        // No encendemos la cafetera

        boolean resultado = cafetera.servirCafe();

        assertFalse(resultado, "Servir café con cafetera apagada debe retornar false");
    }

    @Test
    @DisplayName("Servir café exitoso consume 100 ml y aumenta contador")
    public void testServirCafeExitosoTresVeces() {
        cafetera.encender();
        cafetera.cargarAgua(300);

        // Calentar hasta 100°C (20 + 40 + 40)
        cafetera.calentar(); // 60
        cafetera.calentar(); // 100

        // Primera vez
        boolean resultado1 = cafetera.servirCafe();
        assertTrue(resultado1, "La primera llamada a servirCafe debe retornar true");
        assertEquals(200, cafetera.getContenidoActual(), "Después de servir el café 1, contenidoActual debe ser 200");
        assertEquals(1, cafetera.getCafeServidos(), "Después de servir el café 1, cafesServidos debe ser 1");

        // Segunda vez
        boolean resultado2 = cafetera.servirCafe();
        assertTrue(resultado2, "La segunda llamada a servirCafe debe retornar true");
        assertEquals(100, cafetera.getContenidoActual(), "Después de servir el café 2, contenidoActual debe ser 100");
        assertEquals(2, cafetera.getCafeServidos(), "Después de servir el café 2, cafesServidos debe ser 2");

        // Tercera vez
        boolean resultado3 = cafetera.servirCafe();
        assertTrue(resultado3, "La tercera llamada a servirCafe debe retornar true");
        assertEquals(0, cafetera.getContenidoActual(), "Después de servir el café 3, contenidoActual debe ser 0");
        assertEquals(3, cafetera.getCafeServidos(), "Después de servir el café 3, cafesServidos debe ser 3");
    }




}

