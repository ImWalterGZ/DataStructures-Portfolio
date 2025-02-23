public class Main {
    public static void main(String[] args) {
        Cola<Orden> restaurante = new Cola<>();
        
        System.out.println("=== Sistema de Órdenes - Gotham City Restaurant ===");
        
        System.out.println("\nRecibiendo órdenes:");
        agregarOrden(restaurante, "Mesa Wayne", "Batburger Especial", 1);
        agregarOrden(restaurante, "Mesa Arkham", "Ensalada Venenosa de Ivy", 2);
       agregarOrden(restaurante, "Mesa Alfred", "Té Inglés de la Mansión", 3);
        
        System.out.println("\nProcesando órdenes en la Bat-cocina:");
        try {
            System.out.println("Próxima orden a preparar: " + restaurante.primero());
            
            while (!restaurante.estaVacia()) {
                Orden ordenActual = restaurante.desencolar();
                System.out.println("\nPreparando orden: " + ordenActual);
                System.out.println("Órdenes pendientes:");
                System.out.println(restaurante);
                
                // Simulando tiempo de preparación
                Thread.sleep(1000);
            }
            
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error en la simulación de tiempo");
        }
        
    }
    
    static class Orden {
        private String mesa;
        private String platillo;
        private int numeroOrden;
        
        public Orden(String mesa, String platillo, int numeroOrden) {
            this.mesa = mesa;
            this.platillo = platillo;
            this.numeroOrden = numeroOrden;
        }
        
        @Override
        public String toString() {
            return String.format("Orden #%d - %s para %s", numeroOrden, platillo, mesa);
        }
    }
    
    private static void agregarOrden(Cola<Orden> cola, String mesa, String platillo, int numeroOrden) {
        Orden nuevaOrden = new Orden(mesa, platillo, numeroOrden);
        cola.encolar(nuevaOrden);
        System.out.println("Nueva orden recibida: " + nuevaOrden);
        System.out.println("Estado actual de la cola:");
        System.out.println(cola);
    }
}