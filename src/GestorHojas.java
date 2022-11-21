import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class GestorHojas extends Thread {



    /*
    Soluciones de internet
   - Do not make any changes to a collection while an Iterator loops through it
    -If you can’t stop the underlying collection from being modified during iteration, create a clone of the target data structure and iterate through the clone
    -Use a fail-safe collection class that will not throw the ConcurrentModificationException
    -Simply catch the ConcurrentModificationException, log the error, and move on
     */
    private static  List<String> lista = new ArrayList<String>();

    @Override
    public void run() {


        //List<String> listaCopia = null;

        /*
              for (int i = 0; i < 10; i++) {
            // listaCopia = lista;
            //listaCopia.add(new String("Texto" + i));
            lista.add(new String("Texto" + i));
        }
         */


        CopyOnWriteArraySet<String> copiaLista = new CopyOnWriteArraySet<>(lista);
        for (int i = 0; i < 10; i++) {
            copiaLista.add(new String("Texto" + i));
        }

        for (String string : copiaLista) {
            System.out.println(string);
        }



        //lista.addAll(listaCopia);
/*
        listaCopia.addAll(lista);
        for (String string : listaCopia) {
            System.out.println(string);
        }
    }
 */

/*
        Iterator<String> iterator = lista.listIterator();

        while (iterator.hasNext()) {
            String string = iterator.next();
            System.out.println(string);
        }
 */
/*
    for (String string : lista) {
            System.out.println(string);
        }

 */

    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new GestorHojas().start();
        }

    }


}
