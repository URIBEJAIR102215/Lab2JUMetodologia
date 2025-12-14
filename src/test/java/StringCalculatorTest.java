import com.mycompany.p2lab2metodologiauribejair.StringCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    
    private StringCalculator calc;

    @BeforeAll
    public static void setUpClass() {
        // Se ejecuta una sola vez antes de todos los tests
    }
    
    @AfterAll
    public static void tearDownClass() {
        // Se ejecuta una sola vez después de todos los tests
    }
    
    @BeforeEach
    public void setUp() {
        // Se ejecuta antes de cada test
        calc = new StringCalculator();
    }
    
    @AfterEach
    public void tearDown() {
        // Se ejecuta después de cada test
    }

    @Test
    public void cadenaVaciaRetornaCero() {
        assertEquals(0, calc.add(""));
    }

    @Test
    public void unNumeroRetornaSuValor() {
        assertEquals(1, calc.add("1"));
        assertEquals(5, calc.add("5"));
    }

    @Test
    public void dosNumerosSeSuman() {
        assertEquals(3, calc.add("1,2"));
        assertEquals(7, calc.add("3,4"));
    }

    @Test
    public void nNumerosSeSuman() {
        assertEquals(6, calc.add("1,2,3"));
        assertEquals(10, calc.add("1,2,3,4"));
    }

    @Test
    public void soportaSaltosDeLinea() {
        assertEquals(6, calc.add("1\n2,3"));
        assertEquals(10, calc.add("1\n2\n3,4"));
    }

    @Test
    public void soportaDelimitadorPersonalizado() {
        assertEquals(3, calc.add("//;\n1;2"));
        assertEquals(10, calc.add("//|\n2|3|5"));
    }

    @Test
    public void lanzaExcepcionConNegativos() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calc.add("1,-2,3,-4")
        );
        assertTrue(ex.getMessage().contains("-2"));
        assertTrue(ex.getMessage().contains("-4"));
    }
}
