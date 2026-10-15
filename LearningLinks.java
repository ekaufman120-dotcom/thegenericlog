public class LearningLinks {
    public static void main(String[] args) {
        
        Node<Integer> one = new Node<Integer>(1);
        Node<Integer> two = new Node<Integer>(2);
        one.setLink(two);
        Node<Integer> three = new Node<Integer>(3);
        two.setLink(three);
        Node<Integer> four = new Node<Integer>(4);
        //Node three = new Node(1);
        one.getLink().setLink(three);

        Node<Integer> temp = one;
        while(temp != null)
        {
            System.out.println(temp.getInfo());
            temp = temp.getLink();
        }
        System.out.println();
        temp = one;
        while(temp.getLink() != null)
        {
            temp = temp.getLink();
        }
        temp.setLink(four);

        temp = one;
        while(temp != null)
        {
            System.out.println(temp.getInfo());
            temp = temp.getLink();
        }
        System.out.println();

        Node<Integer> log = new Node<Integer>(1);
        log.setLink(new Node<Integer>(2));
        log.getLink().setLink(new Node<Integer>(3));
        log.getLink().getLink().setLink(new Node<Integer>(4));
        Node<Integer> curNode = log;
        for(int i = 0; i < 0-1; i++)
        {
            curNode = curNode.getLink();
        }
        Node<Integer> otherNode = curNode.getLink().getLink();
        curNode.setLink(otherNode);

        temp = log;
        while(temp != null)
        {
            System.out.println(temp.getInfo());
            temp = temp.getLink();
        }
    }
}
