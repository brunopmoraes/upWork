import java.util.*;

public class Network {

    private Map<Integer, Node> elements;

    public Network(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Required a positive number");
        }
        elements = new HashMap<>();
        for (int i = 1; i <= quantity; i++) {
            elements.put(i, new Node(i));
        }
    }

    public void connect(int element1, int element2) {
        validElements(element1, element2);
        Node node1 = elements.get(element1);
        Node node2 = elements.get(element2);
        node1.connect(node2);
    }

    public boolean query(int element1, int element2) {
        validElements(element1, element2);
        return elements.get(element1).isConnected(elements.get(element2));
    }

    private void validElements(int element1, int element2) {
        if(!elements.containsKey(element1)) {
            throw new IllegalArgumentException(element1 + " is not in the set");
        } else if(!elements.containsKey(element1)) {
            throw new IllegalArgumentException(element2 + " is not in the set");
        }
    }

    private class Node {
        private int key;
        private Set<Node> connections;

        public Node(int key) {
            this.key = key;
            connections = new HashSet<>();
        }

        public void connect(Node element) {
            if (connections.contains(element))
                return;
            connections.add(element);
            element.connect(this);
        }

        public boolean isConnected(Node other) {
            if (connections.contains(other))
                return true;
            for (Node element : connections) {
                if (other.connections.contains(element))
                    return true;
            }
            return false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

}