public class Main {

    public static void main(String[] args) {

        Network network = new Network(8);
        network.connect(1, 2);
        network.connect(6, 2);
        network.connect(2, 4);
        network.connect(5, 8);

        System.out.println(network.query(1, 6));
        System.out.println(network.query(6, 4));
        System.out.println(network.query(7, 4));
        System.out.println(network.query(5, 6));
        System.out.println(network.query(7, 6));

    }

}