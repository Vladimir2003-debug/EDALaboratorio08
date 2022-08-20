package grafo;
import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo<V,E> {

    class Vertice {
        V element;
        Integer pocicion;

        public Vertice() {

        }
        public Vertice(V element, Integer pocicion) {
            this.element = element;
            this.pocicion = pocicion;
        }
    }

    class Edge {
        E arista;
        Vertice verticeOrigen;
        Vertice verticeDestino;
        Integer pocicion;

        public Edge() {

        }

        public Edge(E arista, Vertice verticeOrigen, Vertice verticeDestino,Integer pocicion) {
            this.arista = arista;
            this.verticeOrigen = verticeOrigen;
            this.verticeDestino = verticeDestino;
            this.pocicion = pocicion;
        }
    }

    private ArrayList<Vertice> vertices;
    private ArrayList<Edge> edges;
    
    public Grafo () {
    }

    public void insertVertex(V o) {
        vertices.add(new Vertice(o,vertices.size()));
    }

    public void inserEdge(V v,V w,E o) {
                
    }

    public LinkedList getAdyacenceList() {
        LinkedList<LinkedList<Vertice>> list = new LinkedList<LinkedList<Vertice>>();
        LinkedList<Vertice> tmp;
        for(Vertice vertice:vertices){
            tmp = new LinkedList<Vertice>();
            tmp.add(vertice);
            for(Edge e:edges) {
                if(e.verticeOrigen.equals(tmp.get(0))) {
                    tmp.add(e.verticeDestino);    
                }
            }
            list.add(tmp);
        }
        return list;
    }
    



}