package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {

    DescuentoRepository repo = new DescuentoRepository();
    PedidoService service = new PedidoService(repo);

    @Test
    void testSinDescuentoYEnvioNormal() {
        double total = service.calcularTotal(100, "SIN_CODIGO", false);
        assertEquals(110.0, total); // sin descuento + envío normal (10)
    }

    @Test
    void testConDescuentoYEnvioExpress() {
        double total = service.calcularTotal(100, "PROMO10", true);
        assertEquals(110.0, total); // 100 - 10% + 20 = 110
    }

    @Test
    void testConDescuentoYEnvioNormal() {
        double total = service.calcularTotal(200, "PROMO10", false);
        assertEquals(190.0, total); // 200 - 10% + 10 = 190
    }

    @Test
    void testSinDescuentoYEnvioExpress() {
        double total = service.calcularTotal(150, "NINGUNO", true);
        assertEquals(170.0, total); // 150 + 20 = 170
    }
}
