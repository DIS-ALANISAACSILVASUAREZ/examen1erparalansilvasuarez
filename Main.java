import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Bandera para saber si ha llenado la solicitud
        boolean haLlenadoSolicitud = false;
        // Variables de datos del cliente
        String nombre = "", sexo = "";
        int edad = 0;
        double sueldo = 0;
        // Saber si quiere hacer más solicitudes
        String masSolicitudes = "s";
        String eleccion = "";
        while (masSolicitudes.equalsIgnoreCase("s")) {
            System.out.println("1. Solicitud\n2. Crédito\nElige [1-2]: ");
            eleccion = sc.nextLine();
            if (eleccion.equals("1")) {
                System.out.println("Ingresa nombre: ");
                nombre = sc.nextLine();
                System.out.println("Ingresa edad: ");
                edad = sc.nextInt();
                // Consumir la línea sobrante que dejó "nextInt". Si no lo hacemos, el programa no espera para leer el sexo
                sc.nextLine();
                System.out.println("Ingresa sexo: ");
                sexo = sc.nextLine();
                while (sueldo <= 7000) {
                    System.out.println("Ingresa sueldo: ");
                    sueldo = sc.nextDouble();
                    // Consumir la línea sobrante que dejó "nextDouble"
                    sc.nextLine();
                }
                haLlenadoSolicitud = true;
            }
            if (eleccion.equals("2")) {
                if (haLlenadoSolicitud) {
                    double monto;
                    System.out.println("Ingresa el monto que solicitas: ");
                    monto = sc.nextDouble();
                    // Consumir la línea que dejó "nextDouble"
                    sc.nextLine();
                    System.out.println("1. 12 meses\n2. 24 meses\n3. 36 meses\n4. 60 meses\nElige [1-4]: ");
                    String plazo = sc.nextLine();
                    double porcentajeDeInteres = 0;
                    int meses = 0;
                    if (plazo.equals("1")) {
                        porcentajeDeInteres = 0.25;
                        meses = 12;
                    } else if (plazo.equals("2")) {
                        porcentajeDeInteres = 0.45;
                        meses = 24;
                    } else if (plazo.equals("3")) {
                        porcentajeDeInteres = 0.6;
                        meses = 36;
                    } else if (plazo.equals("4")) {
                        porcentajeDeInteres = 0.75;
                        meses = 60;
                    }
                    double interes = monto * porcentajeDeInteres;
                    double total = monto + interes;
                    double pagoMensual = total / meses;
                    System.out.println("Cliente: " + nombre);
                    System.out.println("Sexo: " + sexo + "\tEdad: " + String.valueOf(edad) + "\tSueldo Mensual: " + String.valueOf(sueldo));
                    System.out.println("Monto del crédito: $" + String.valueOf(monto) + "\tPlazo: " + String.valueOf(meses) + " meses");
                    System.out.printf("Total: $%.2f\n", total);
                    System.out.printf("Pagos de: $%.2f\n", pagoMensual);
                    System.out.println("¿Desea calcular otro monto? [S/N]");
                    masSolicitudes = sc.nextLine();
                } else {
                    System.out.println("No has llenado la solicitud");
                }
            }
        }
    }
}
