class BrowserHistory {

    class Node {
        String url;
        Node back, forward;

        Node(String url) {
            this.url = url;
        }
    }

    Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node newnode = new Node(url);
        current.forward = newnode;
        newnode.back = current;
        current = newnode;
    }

    public String back(int steps) {
        while (steps > 0 && current.back != null) {
            current = current.back;
            steps--;
        }
        return current.url;
    }

    public String forward(int steps) {
        while (steps > 0 && current.forward != null) {
            current = current.forward;
            steps--;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
