import grafo.*;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Worl");
        Grafo<Integer,Integer> grafo1 = new Grafo<Integer,Integer>();
        Grafo<Integer,Integer> grafo2 = new Grafo<Integer,Integer>();
        grafo1.insertVertex(34);
        grafo1.insertVertex(22);

        grafo2.insertVertex(34);
        grafo2.insertVertex(22);
        grafo2.insertVertex(13);
        
        grafo1.insertEdge(34, 22, 1);
        grafo2.insertEdge(34, 22, 1);
        grafo2.insertEdge(22, 13, 5);
        print(grafo1.edges);
        System.out.println();
        print(grafo2.edges);
        System.out.println();
        print(grafo1.vertices);
        System.out.println();
        print(grafo2.vertices);
        System.out.println();
        System.out.println(grafo1.getAdyacenceList());
        System.out.println(grafo2.getAdyacenceList());
        System.out.println(Grafo.graphInsideGraph(grafo2,grafo1));
    }    

    public static<V> void print(ArrayList<V> list) {
        for(V e:list){
            System.out.print(e + "  ");
        }
    }
}
