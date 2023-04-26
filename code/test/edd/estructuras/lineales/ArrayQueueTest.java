
package edd.estructuras.lineales;

/**
 * Clase que inicia el uso de pruebas unitarias para la clase ArrayQueue.
 *
 * @author mindahrelfen
 */
public class ArrayQueueTest extends QueueTestA {

    @Override
    protected Queue<String> getQueue() {
        return new ArrayQueue<>();
    }
}
