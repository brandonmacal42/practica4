
package edd.estructuras.lineales;

/**
 * Clase que inicia el uso de pruebas unitarias para la clase LinkedQueue.
 *
 * @author mindahrelfen
 */
public class LinkedQueueTest extends QueueTestA {

    @Override
    protected Queue<String> getQueue() {
        return new LinkedQueue<>();
    }
}
