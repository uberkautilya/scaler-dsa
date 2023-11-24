package advanced.module6.zoom;

import advanced.module6.Node;

/**
 * Remove nodes which contain values other than 0
 */
public class RemoveElementsFromLL {
    public static void main(String[] args) {

        Node head = new Node(1);
        Node newNode = removeOnes(head);
    }

    private static Node removeOnes(Node head) {
        Node newHead = null;
        Node valid = null;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                temp = temp.next;
            } else {
                if (newHead == null) {
                    newHead = temp;
                    valid = temp;
                }
                valid.next = temp;
                valid = temp;
            }
        }
        return newHead;
    }

}
/*
Solution from Nigam
while(temp.next!=null || temp.data!=0 )
{ temp=temp.next}
newHead = temp
pre=temp
 */