import es.etg.dam.lsgrep.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LsGrepTest {

    @Test

    void testEjecutarComandosNoLanzaExcepciones() {

        assertDoesNotThrow(() -> LsGrep.ejecutarComandos("ls", "grep a"));
    }
}
