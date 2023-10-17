package proyecto_agenda;

import java.util.Scanner;
import proyecto_agenda.Lista;

public class Proyecto_Agenda {

    public static Scanner sc = new Scanner(System.in);

    public static Lista contactos = new Lista(10);

    public static void main(String[] args) {
        // TODO code application logic here

        contactos.lista[0] = new Contacto("Rosalia", "Vita", "tobello", 30, "6141111111");
        contactos.lista[1] = new Contacto("Bad", "Gyal", "Cadenas", 31, "6142318149");
        contactos.lista[2] = new Contacto("Tokischa", "Estilazo", "Gomez", 20, "6145555555");
        contactos.lista[3] = new Contacto("Ethel", "Cain", "Ptolemaea", 98, "6140000000");
        contactos.lista[4] = new Contacto("Mistki", "francis", "forever", 47, "6144809625");
        contactos.lista[5] = new Contacto("Lana", "del", "Rey", 44, "6147896541");
        contactos.lista[6] = new Contacto("Shakira", "Mebarak", "Ribol", 45, "6145472304");
        contactos.lista[7] = new Contacto("Alejandra", "Pizarnik", "Flora", 36, "6147582938");
        contactos.lista[8] = new Contacto("Beyonce", "Knowles", "Carter", 42, "6147895620");
        contactos.lista[9] = new Contacto("Phoebe", "Bridgers", "Lucille", 30, "6142308493");

        Menu();

    }

    public static void Menu() {
        int op;
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1) Agregar contactos");
            System.out.println("2) Modificar contacto");
            System.out.println("3) Mostrar contactos");
            System.out.println("4) Ordenar contactos");
            System.out.println("5) Buscar contacto");
            System.out.println("6) Eliminar contacto");
            System.out.println("7) Salir");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    contactos.añadirContacto();
                    break;
                case 2:
                    modificarCon();
                    break;
                case 3:
                    contactos.mostrarContactos();
                    break;
                case 4:
                    ordenarCon();
                    break;
                case 5:
                    buscarCon();
                    break;
                case 6:
                    eliminarContacto();
                    break;
            }
        } while (op != 7);

    }

    public static void modificarCon() {
        sc.nextLine();
        System.out.println("Ingresa el nombre del contacto a modificar");
        String contacto = sc.nextLine();
        contactos.modificarCon(contacto);
        contactos.mostrarContactos();
    }

    public static void buscarCon() {
        int op;
        System.out.println("Buscar contacto por");
        System.out.println("""
                           1)Nombre 
                           2)Apellido Paterno 
                           3)Apellido Materno
                           4)Edad 
                           5)N\u00famero""");
        op = sc.nextInt();
        switch (op) {
            case 1:
                contactos.buscarNombre(contactos.lista);
                break;
            case 2:
                contactos.buscarApat(contactos.lista);
                break;
            case 3:
                contactos.buscarAmat(contactos.lista);
                break;
            case 4:
                contactos.buscarEdad(contactos.lista);
                break;
            case 5:
                contactos.buscarNumTel(contactos.lista);
                break;
            default:
                System.out.println("Opcion no valida");
                buscarCon();
                break;
        }
        contactos.mostrarContactos();

    }

    public static void ordenarCon() {
        int op;
        System.out.println("Ordenar contactos por");
        System.out.println("""
                           1)Nombre 
                           2)Apellido Paterno 
                           3)Apellido Materno
                           4)Edad 
                           5)N\u00famero""");
        op = sc.nextInt();
        switch (op) {
            case 1:
                contactos.ordNom(contactos.lista);
                break;
            case 2:
                contactos.ordApat(contactos.lista);
                break;
            case 3:
                contactos.ordAmat(contactos.lista);
                break;
            case 4:
                contactos.ordEdad(contactos.lista);
                break;
            case 5:
                contactos.ordNumTel(contactos.lista);
                break;
            default:
                System.out.println("Opcion no valida");
                ordenarCon();
                break;
        }
        contactos.mostrarContactos();
    }

    public static void eliminarContacto() {
        System.out.println("Ingresa el nombre a eliminar");
        sc.nextLine();
        contactos.eliminar(sc.nextLine());
        contactos.mostrarContactos();
    }
}
