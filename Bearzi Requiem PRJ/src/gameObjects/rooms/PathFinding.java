package gameObjects.rooms;

import java.util.*;

public class PathFinding {

    private int[][] mappa;
    private boolean[][] visitati;
    private int[][] distanze;
    private PriorityQueue<Nodo> coda;
    private int inizioX, inizioY, fineX, fineY;

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};

    private class Nodo implements Comparable<Nodo> {
        int x;
        int y;
        int distanzaDalPuntoDiPartenza;
        int distanzaDalPuntoDiArrivo;
        Nodo padre;

        public Nodo(int x, int y, int distanzaDalPuntoDiPartenza, int distanzaDalPuntoDiArrivo, Nodo padre) {
            this.x = x;
            this.y = y;
            this.distanzaDalPuntoDiPartenza = distanzaDalPuntoDiPartenza;
            this.distanzaDalPuntoDiArrivo = distanzaDalPuntoDiArrivo;
            this.padre = padre;
        }

        public int compareTo(Nodo altroNodo) {
            return (distanzaDalPuntoDiPartenza + distanzaDalPuntoDiArrivo) - (altroNodo.distanzaDalPuntoDiPartenza + altroNodo.distanzaDalPuntoDiArrivo);
        }
    }

    public List<Nodo> trovaPercorso() {
        inizializza();

        while (!coda.isEmpty()) {
            Nodo nodoCorrente = coda.poll();

            if (nodoCorrente.x == fineX && nodoCorrente.y == fineY) {
                return costruisciPercorso(nodoCorrente);
            }

            if (visitati[nodoCorrente.x][nodoCorrente.y]) {
                continue;
            }

            visitati[nodoCorrente.x][nodoCorrente.y] = true;

            for (int i = 0; i < 4; i++) {
                int x = nodoCorrente.x + dx[i];
                int y = nodoCorrente.y + dy[i];

                if (x < 0 || x >= mappa.length || y < 0 || y >= mappa[0].length || mappa[x][y] != 0) {
                    continue;
                }

                int nuovaDistanzaDalPuntoDiPartenza = nodoCorrente.distanzaDalPuntoDiPartenza + 1;

                if (nuovaDistanzaDalPuntoDiPartenza < distanze[x][y]) {
                    distanze[x][y] = nuovaDistanzaDalPuntoDiPartenza;
                    coda.offer(new Nodo(x, y, nuovaDistanzaDalPuntoDiPartenza, calcolaDistanza(x, y), nodoCorrente));
                }
            }
        }

        return null;
    }

    private void inizializza() {
        visitati = new boolean[mappa.length][mappa[0].length];
        distanze = new int[mappa.length][mappa[0].length];

        for (int i = 0; i < mappa.length; i++) {
            for (int j = 0; j < mappa[0].length; j++) {
                distanze[i][j] = Integer.MAX_VALUE;
            }
        }

        distanze[inizioX][inizioY] = 0;
        coda = new PriorityQueue<>();
        coda.offer(new Nodo(inizioX, inizioY, 0, calcolaDistanza(inizioX, inizioY), null));
    }

    private List<Nodo> costruisciPercorso(Nodo nodo) {
        LinkedList<Nodo> percorso = new LinkedList<>();

        while (nodo != null) {
            percorso.addFirst(nodo);
            nodo = nodo.padre;
        }

        return percorso;
    }

    private int calcolaDistanza(int x, int y) {
        return Math.abs(x - fineX) + Math.abs(y - fineY);
    }

    public static List<Nodo> start(int[][] map, int startX, int startY, int endX, int endY)
    {
        PathFinding aStar = new PathFinding();

        aStar.mappa = map;

        aStar.inizioX = startY;  //x e y sono scambiate
        aStar.inizioY = startX;
        aStar.fineX = startY;
        aStar.fineY = startX;

        return aStar.trovaPercorso();
    }

    public static int[][] convertNodi(List<Nodo> nodi)
    {
        int[][] nodiConv = new int[2][nodi.size()];

        for(int i=0; i<nodi.size(); i++)
        {
            nodiConv[0][i] = nodi.get(i).x;
            nodiConv[1][i] = nodi.get(i).y;
        }

        return nodiConv;
    }

}


