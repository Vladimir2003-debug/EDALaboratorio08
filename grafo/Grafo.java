package grafo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo<V, E> {

    class Vertice {
        protected V element;
        protected Integer pocicion;

        public Vertice() {

        }

        public Vertice(V element, Integer pocicion) {
            this.element = element;
            this.pocicion = pocicion;
        }

        @Override
        public String toString() {
            return element.toString() + " :" + pocicion;
        }
    }

    class Edge {
        protected E arista;
        protected Vertice verticeOrigen;
        protected Vertice verticeDestino;
        protected Integer pocicion;

        public Edge() {

        }

        public Edge(E arista, Vertice verticeOrigen, Vertice verticeDestino, Integer pocicion) {
            this.arista = arista;
            this.verticeOrigen = verticeOrigen;
            this.verticeDestino = verticeDestino;
            this.pocicion = pocicion;
        }
        public void setVerticeDestino(Vertice verticeDestino) {
            this.verticeDestino = verticeDestino;
        }

        public boolean equals(Object obj) {
            Edge other = (Edge) obj;
            if(arista.equals(other)&&verticeDestino.equals(other)&&verticeOrigen.equals(other))
                return true;
            return false;
        }
        
        public String toString() {
            return arista.toString() + ":" + pocicion + " VerticeOrigen: " + verticeOrigen + " verticeDestino: " + verticeDestino;
        }
    }
    class Item {
        private Vertice vertice;
        private Edge edge;

        public Item(Vertice vertice, Edge edge) {
            this.vertice = vertice;
            this.edge = edge;
        }
        public Item(Vertice vertice) {
            this.vertice = vertice;
        }

        public String toString() {
            return vertice.toString() + ":" + edge.toString();   
        }
    }

    public ArrayList<Vertice> vertices;
    public ArrayList<Edge> edges;
    public LinkedList<Item> list;

    public Grafo() {
        this.edges = new ArrayList<Edge>();
        this.vertices = new ArrayList<Vertice>();
        this.list = new LinkedList<Item>();
    }
    /**
     * Inserta un Vertice en el grafo
     * @param o Inserta el elemento V en el grafo sin aristas
     * @throws NullPointerException Si el objeto es null
     */
    public void insertVertex(V o) {
        if(o == null)
            throw new NullPointerException();

        vertices.add(new Vertice(o, vertices.size()));
        list.add(new Item(vertices.get(vertices.size()-1),null));
    }

    /**
     * Inserta una arista en el grafo
     * @param v el vertice de origen de la arista
     * @param w el vertice de destino de la arista
     * @param o el objeto que se va a ingresar
     * @throws NullPointerException si alguno de los parametros ingresados es null
     */

    public void insertEdge(V v, V w, E o) {
        if (v == null || w == null || o == null)
            throw new NullPointerException();
        
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).element.equals(v)) {
                edges.add(new Edge(o, vertices.get(i), null, edges.size()));
                break;
            }
        }
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).element.equals(w)) {
                edges.get(edges.size()-1).verticeDestino = vertices.get(i);
                break;
            }
        }
    }

    /**
     * Permite obtener la lista de adyacencia del grafo
     * @return LinkedList la lista de adyacencia
     */
    public LinkedList getAdyacenceList() {
        LinkedList<LinkedList<Vertice>> list = new LinkedList<LinkedList<Vertice>>();
        LinkedList<Vertice> tmp;
        for (Vertice vertice : vertices) {
            tmp = new LinkedList<Vertice>();
            tmp.add(vertice);
            for (Edge e : edges) {
                if (e.verticeOrigen.equals(tmp.get(0))) {
                    tmp.add(e.verticeDestino);
                }
            }
            list.add(tmp);
        }
        return list;
    }


    /**
     * Metodo que comprueba si un grafo b esta dentro de un grafo a
     * @param a El grafo principal
     * @param b El grafo que se supone esta dentro del grafo a
     * @return true si esta dentro, false en caso no lo este   
     */
    public static boolean graphInsideGraph(Grafo a, Grafo b) {
        if(a.edges.containsAll(b.edges)) {
            return true;
        }
        return false;

    }


}