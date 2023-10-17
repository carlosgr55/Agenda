package proyecto_agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class Lista {

    public Scanner sc = new Scanner(System.in);

    public Contacto[] lista;

    public Lista(int n) {
        lista = new Contacto[n];

    }

    public void añadirContacto() {
        for (int i = 0; i < lista.length; i++) {

            System.out.println("Nombre");
            String nom = sc.nextLine();
            System.out.println("Apellido paterno");
            String apat = sc.nextLine();
            System.out.println("Apellido materno");
            String amat = sc.nextLine();
            System.out.println("Edad");
            int edad = sc.nextInt();
            System.out.println("Número de telefono");
            String num = sc.nextLine();
            lista[i] = new Contacto(nom, apat, amat, edad, num);
        }
    }

    public void actContacto() {

    }

    public void mostrarContactos() {
        for (int i = 0; i < lista.length; i++) {
            System.out.println("[" + (i + 1) + "] " + lista[i].imprimirDatos());
        }
    }

    private void intercambiar(Contacto[] lista, int i, int j) {
        Contacto aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

    public void ordNom(Contacto[] lista) {
        ordNom(lista, 0, lista.length - 1);
    }

    private void ordNom(Contacto[] lista, int izq, int der) {
        int i, j, central;
        Contacto pivote;
        central = (izq + der) / 2;
        pivote = lista[central];
        i = izq;
        j = der;
        do {
            while (lista[i].nom.compareToIgnoreCase(pivote.nom) < 0) {
                i++;
            }
            while (lista[j].nom.compareToIgnoreCase(pivote.nom) > 0) {
                j--;
            }
            if (i <= j) {
                intercambiar(lista, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (izq < j) {
            ordNom(lista, izq, j);

        }
        if (i < der) {
            ordNom(lista, i, der);

        }
    }

    public void ordApat(Contacto[] lista) {
        ordApat(lista, 0, lista.length - 1);
    }

    private void ordApat(Contacto[] lista, int izq, int der) {
        int i, j, central;
        Contacto pivote;
        central = (izq + der) / 2;
        pivote = lista[central];
        i = izq;
        j = der;
        do {
            while (lista[i].apat.compareToIgnoreCase(pivote.apat) < 0) {
                i++;
            }
            while (lista[j].apat.compareToIgnoreCase(pivote.apat) > 0) {
                j--;
            }
            if (i <= j) {
                intercambiar(lista, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (izq < j) {
            ordApat(lista, izq, j);

        }
        if (i < der) {
            ordApat(lista, i, der);

        }
    }

    public void ordAmat(Contacto[] lista) {
        ordAmat(lista, 0, lista.length - 1);
    }

    private void ordAmat(Contacto[] lista, int izq, int der) {
        int i, j, central;
        Contacto pivote;
        central = (izq + der) / 2;
        pivote = lista[central];
        i = izq;
        j = der;
        do {
            while (lista[i].amat.compareToIgnoreCase(pivote.amat) < 0) {
                i++;
            }
            while (lista[j].amat.compareToIgnoreCase(pivote.amat) > 0) {
                j--;
            }
            if (i <= j) {
                intercambiar(lista, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (izq < j) {
            ordAmat(lista, izq, j);

        }
        if (i < der) {
            ordAmat(lista, i, der);

        }
    }

    private void ordNum(Contacto[] lista, int izq, int der) {
        int i, j, central;
        Contacto pivote;
        central = (izq + der) / 2;
        pivote = lista[central];
        i = izq;
        j = der;
        do {
            while (lista[i].numTel.compareToIgnoreCase(pivote.numTel) < 0) {
                i++;
            }
            while (lista[j].numTel.compareToIgnoreCase(pivote.numTel) > 0) {
                j--;
            }
            if (i <= j) {
                intercambiar(lista, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (izq < j) {
            ordNum(lista, izq, j);

        }
        if (i < der) {
            ordNum(lista, i, der);

        }
    }

    public void ordNumTel(Contacto[] lista) {
        ordNum(lista, 0, lista.length - 1);
    }

    private void ordEdad(Contacto[] lista, int izq, int der) {
        int i, j, central;
        Contacto pivote;
        central = (izq + der) / 2;
        pivote = lista[central];
        i = izq;
        j = der;
        do {
            while (lista[i].getEdad() < pivote.getEdad()) {
                i++;
            }
            while (lista[j].getEdad() > pivote.getEdad()) {
                j--;
            }
            if (i <= j) {
                intercambiar(lista, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (izq < j) {
            ordEdad(lista, izq, j);

        }
        if (i < der) {
            ordEdad(lista, i, der);

        }
    }

    public void ordEdad(Contacto[] lista) {
        ordEdad(lista, 0, lista.length - 1);
    }

    private int buscarEdad(Contacto[] lista, int clave) {
        ordEdad(lista);
        int central, bajo, alto;
        Contacto valorCentral;
        bajo = 0;
        alto = lista.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2; // índice de elemento central
            valorCentral = lista[central]; // valor del índice central
            if (clave == valorCentral.getEdad()) {
                return central; // encontrado, devuelve posición
            } else if (clave < valorCentral.getEdad()) {
                alto = central - 1; // ir a sublista inferior
            } else {
                bajo = central + 1; // ir a sublista superior
            }
        }
        return -1;
    }

    public void modificarCon(String contacto) {

        int pos = buscarNom(lista, contacto);
        System.out.println("¿Qué deseas modificar?");
        System.out.println("""
                           1)Nombre 
                           2)Apellido Paterno 
                           3)Apellido Materno
                           4)Edad 
                           5)N\u00famero""");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                System.out.println("Escribe el nombre");
                sc.nextLine();
                String nombre = sc.nextLine();
                lista[pos].setNom(nombre);
                break;
            case 2:
                System.out.println("Escribe el apellido");
                sc.nextLine();
                String apat = sc.nextLine();
                lista[pos].setApat(apat);
                break;
            case 3:
                System.out.println("Escribe el apellido");
                sc.nextLine();
                String amat = sc.nextLine();
                lista[pos].setAmat(amat);
                break;
            case 4:
                System.out.println("Escribe la edad");
                int edad = sc.nextInt();
                lista[pos].setEdad(edad);
                break;
            case 5:
                System.out.println("Escribe el número");
                sc.nextLine();
                String num = sc.nextLine();
                lista[pos].setNumTel(num);
                break;
            default:
                System.out.println("Opcion no correcta");
                modificarCon(contacto);
                break;
        }
        System.out.println(lista[pos].imprimirDatos());
        
    }

    public void buscarEdad(Contacto a[]) {
        int encontrado = -1;
        System.out.println("Edad a buscar");
        int clave = sc.nextInt();
        encontrado = buscarEdad(a, clave);
        if (encontrado == -1) {
            System.out.println("El contacto no existe");
        } else {
            System.out.println("El contacto está en la posición " + (encontrado + 1));
            System.out.println(a[encontrado].imprimirDatos());
        }
    }

    private int buscarNom(Contacto[] lista, String clave) {
        ordNom(lista);
        int central, bajo, alto;
        Contacto valorCentral;
        bajo = 0;
        alto = lista.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2; // índice de elemento central
            valorCentral = lista[central]; // valor del índice central
            if (clave.equalsIgnoreCase(valorCentral.nom)) {
                return central; // encontrado, devuelve posición
            } else if (clave.compareToIgnoreCase(valorCentral.nom) < 0) {
                alto = central - 1; // ir a sublista inferior
            } else {
                bajo = central + 1; // ir a sublista superior
            }
        }
        return -1;
    }

    public void buscarNombre(Contacto a[]) {
        int encontrado = -1;
        System.out.println("Nombre a buscar");
        String clave = sc.nextLine();
        encontrado = buscarNom(a, clave);
        if (encontrado == -1) {
            System.out.println("El contacto no existe");
        } else {
            System.out.println("El contacto está en la posición " + (encontrado + 1));
            System.out.println(a[encontrado].imprimirDatos());
        }
    }

    private int buscarApat(Contacto[] lista, String clave) {
        ordApat(lista);
        int central, bajo, alto;
        Contacto valorCentral;
        bajo = 0;
        alto = lista.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2; // índice de elemento central
            valorCentral = lista[central]; // valor del índice central
            if (clave.equalsIgnoreCase(valorCentral.apat)) {
                return central; // encontrado, devuelve posición
            } else if (clave.compareToIgnoreCase(valorCentral.apat) < 0) {
                alto = central - 1; // ir a sublista inferior
            } else {
                bajo = central + 1; // ir a sublista superior
            }
        }
        return -1;
    }

    public void buscarApat(Contacto a[]) {
        int encontrado = -1;
        System.out.println("Nombre a buscar");
        String clave = sc.nextLine();
        encontrado = buscarApat(a, clave);
        if (encontrado == -1) {
            System.out.println("El contacto no existe");
        } else {
            System.out.println("El contacto está en la posición " + (encontrado + 1));
            System.out.println(a[encontrado].imprimirDatos());
        }
    }

    private int buscarAmat(Contacto[] lista, String clave) {
        ordAmat(lista);
        int central, bajo, alto;
        Contacto valorCentral;
        bajo = 0;
        alto = lista.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2; // índice de elemento central
            valorCentral = lista[central]; // valor del índice central
            if (clave.equalsIgnoreCase(valorCentral.amat)) {
                return central; // encontrado, devuelve posición
            } else if (clave.compareToIgnoreCase(valorCentral.amat) < 0) {
                alto = central - 1; // ir a sublista inferior
            } else {
                bajo = central + 1; // ir a sublista superior
            }
        }
        return -1;
    }

    public void buscarAmat(Contacto a[]) {
        int encontrado = -1;
        System.out.println("Nombre a buscar");
        String clave = sc.nextLine();
        encontrado = buscarAmat(a, clave);
        if (encontrado == -1) {
            System.out.println("El contacto no existe");
        } else {
            System.out.println("El contacto está en la posición " + (encontrado + 1));
            System.out.println(a[encontrado].imprimirDatos());
        }
    }

    private int buscarNum(Contacto[] lista, String clave) {
        ordNumTel(lista);
        int central, bajo, alto;
        Contacto valorCentral;
        bajo = 0;
        alto = lista.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2; // índice de elemento central
            valorCentral = lista[central]; // valor del índice central
            if (clave.equalsIgnoreCase(valorCentral.numTel)) {
                return central; // encontrado, devuelve posición
            } else if (clave.compareToIgnoreCase(valorCentral.numTel) < 0) {
                alto = central - 1; // ir a sublista inferior
            } else {
                bajo = central + 1; // ir a sublista superior
            }
        }
        return -1;
    }

    public void buscarNumTel(Contacto a[]) {
        int encontrado;
        System.out.println("Número a buscar");
        String clave = sc.nextLine();
        encontrado = buscarNum(a, clave);
        if (encontrado == -1) {
            System.out.println("El contacto no existe");
        } else {
            System.out.println("El contacto está en la posición " + (encontrado + 1));
            System.out.println(a[encontrado].imprimirDatos());
        }
    }

    public void eliminar(String contacto) {
        lista = eliminarContacto(contacto);
    }

    private Contacto[] eliminarContacto(String contacto) {
        Contacto[] nuevaLista = new Contacto[lista.length - 1];
        int indice = buscarNom(lista, contacto);
        if (indice != -1) {
            // Creamos un nuevo arreglo sin el objeto a eliminar

            int contador = 0;
            for (int i = 0; i < lista.length; i++) {
                if (i != indice) {
                    nuevaLista[contador] = lista[i];
                    contador++;
                }
            }
        } else {
            System.out.println("La persona no fue encontrada en el arreglo.");
        }
        return nuevaLista;
    }
}
