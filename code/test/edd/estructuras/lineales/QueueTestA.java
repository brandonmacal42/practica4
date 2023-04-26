
package edd.estructuras.lineales;

import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

import edd.Calificador;

/**
 * Clase que agrega pruebas unitarias para las clases hijas de la clase Queue.
 *
 * @author mindahrelfen
 */
public abstract class QueueTestA extends Calificador {

    @Override
    protected void setCategories() {
        defineCategories(new String[] {
            "Borrado",
            "Insercion",
            "FIFO"
        }, new double[] {
            0.4,
            0.4,
            0.2
        });
    }

    @Override
    public void init() {}

    /**
     * Devuelve una cola bien construida.
     *
     * @return Queue Una cola de tipo String vacía.
     */
    protected abstract Queue<String> getQueue();

    /**
     * Revisa la igualdad semántica entre dos arreglos de Object.
     *
     * @param array1 Object[] Primer arreglo a comparar.
     * @param array2 Object[] Segundo arreglo a comparar.
     *
     * @return boolean Devuelve true si son semánticamente iguales.
     */
    protected boolean equals(Object[] array1, Object[] array2) {
        if (array1 == array2) return true;
        if (array1 == null) return false;
        if (array2 == null) return false;
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == null) {
                if (array2[i] != null) return false;
            } else {
                if (!array1[i].equals(array2[i])) return false;
            }
        }
        return true;
    }

    //dequeue

    @Test
    public void dequeueContainsTest() {
        Queue<String> structure;

        startTest("Prueba que la estructura no contenga elementos después de borrarlos", 1.0, "Borrado");

        /**
         * Inserta elementos en la estructura.
         */
        structure = getQueue();
        rsgIt = rsg.iterator();
        while (rsgIt.hasNext()) {
            structure.enqueue(rsgIt.next());
        }

        /**
         * Luego los expulsa hasta que la estructura este vacía.
         */
        while (!structure.isEmpty()) {
            structure.dequeue();
        }

        /**
         * Revisa que dequeue devuelva null.
         */
        assertTrue(structure.dequeue() == null);

        addUp(1.0);
        passed();
    }

    @Test
    public void dequeueSizeTest() {
        int index;
        Queue<String> structure;

        startTest("Revisa que la cantidad de elementos tras borrar sea consistente", 1.0, "Borrado");

        /**
         * Inserta elementos en la estructura.
         */
        structure = getQueue();
        rsgIt = rsg.iterator();
        while (rsgIt.hasNext()) {
            structure.enqueue(rsgIt.next());
        }

        /**
         * Borra los elementos de la estructura de uno en uno y revisa que cada
         * borrado mantenga el tamaño deseado.
         */
        index = 1;
        while (index <= range) {
            structure.dequeue();
            assertEquals(structure.size(), range - index++);
        }

        /**
         * Revisa que la estructura este vacía al finalizar el borrado de todos
         * sus elementos.
         */
        assertTrue(structure.isEmpty());

        addUp(1.0);
        passed();
    }

    @Test
    public void dequeueEmptyTest() {
        Queue<String> structure;

        startTest("Revisa que se devuelva null cuando se intenta borrar y no hay elementos", 1.0, "Borrado");

        /**
         * Si se intenta borrar sobre una estructura vacía debe devolver null.
         */
        structure = getQueue();
        assertNull(structure.dequeue());

        addUp(1.0);
        passed();
    }

    @Test
    public void dequeuefirstTest() {
        String str;
        Queue<String> structure;

        startTest("Prueba que first y dequeue devuelvan el mismo valor", 1.0, "Borrado");

        /**
         * Inserta elementos en la estructura.
         */
        structure = getQueue();
        rsgIt = rsg.iterator();
        while (rsgIt.hasNext()) {
            structure.enqueue(rsgIt.next());
        }

        /**
         * Revisa hasta que la estructura este vacía que el elemento devuelto
         * por first sea el mismo que devuelve expulsa.
         */
        while (!structure.isEmpty()) {
            str = structure.first();
            if (str == null) {
                assertNull(structure.dequeue());
            } else {
                assertTrue(str.equals(structure.dequeue()));
            }
        }

        addUp(1.0);
        passed();
    }

    //enqueue

    @Test
    public void enqueueSizeTest() {
        int index;
        Queue<String> structure;

        startTest("Revisa que la estructura mantenga la cantidad correcta de elementos, ademas de no estar vacía tras insertar", 1.0, "Insercion");

        /**
         * Inserta elementos en la estructura de uno en uno y revisa que cada
         * inserción mantenga el tamaño deseado. Además, revisa que ninguna
         * inserción vuelva vacía la estructura.
         */
        structure = getQueue();
        rsgIt = rsg.iterator();
        index = 1;
        while (rsgIt.hasNext()) {
            structure.enqueue(rsgIt.next());
            assertEquals(structure.size(), index++);
            assertFalse(structure.isEmpty());
        }

        addUp(1.0);
        passed();
    }

    //FIFO

    @Test
    public void FIFOTest() {
        int index;
        String str;
        String[] array1, array2;
        Queue<String> structure;

        startTest("Revisa que la cola sea una estructura FIFO", 1.0, "FIFO");

        /**
         * Inserta elementos en una estructura y en un arreglo en el mismo
         * orden y al mismo tiempo.
         */
        structure = getQueue();
        rsgIt = rsg.iterator();
        array1 = new String[range];
        index = 0;
        while (rsgIt.hasNext()) {
            str = rsgIt.next();
            structure.enqueue(str);
            array1[index++] = str;
        }

        /**
         * Borra elementos de la estructura y los guarda en un arreglo.
         */
        array2 = new String[range];
        index = 0;
        while (!structure.isEmpty()) {
            array2[index++] = structure.dequeue();
        }

        /**
         * Compara ambos arreglos, deben tener el mismo orden.
         */
        assertTrue(equals(array1, array2));

        addUp(1.0);
        passed();
    }
}
