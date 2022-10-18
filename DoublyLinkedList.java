package out.com;

import java.util.Scanner;



public class DoublyLinkedList {

    // node creation
    Node head;
    Node tail;

    class Node {
        String data;
        Node prev;
        Node next;
        //Node tail = null;


        Node(String d) {
            data = d;
        }

        Node head, tail = null;

        public void addNode(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                head.prev = null;
                tail.next = null;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                tail.next = null;
            }
        }

    }



    // add song in front
    public void addinFront(String data) {

        Node newNode = new Node(data);

        newNode.next = head;
        newNode.prev = null;

        if (head != null)
            head.prev = newNode;

            head = newNode;

    }



    // insert a node after a specific node
    /*public void addAfter(Node prev_node, String data) {

        // check if previous node is null
        if (prev_node == null) {
            System.out.println("previous node cannot be null");
            return;
        }

        // allocate memory for newNode and assign data to newNode
        Node new_node = new Node(data);

        // set next of newNode to next of prev node
        new_node.next = prev_node.next;

        // set next of prev node to newNode
        prev_node.next = new_node;

        // set prev of newNode to the previous node
        new_node.prev = prev_node;

        // set prev of newNode's next to newNode
        if (new_node.next != null)
            new_node.next.prev = new_node;
    }*/

    // add song at the end fo the playlist
    void insertEnd(String data) {

        Node new_node = new Node(data);

        Node temp = head;
        new_node.next = null;

        // if the linked list is empty, make the newNode as head node
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        // if the linked list is not empty, traverse to the end of the linked list
        while (temp.next != null)
            temp = temp.next;

        temp.next = new_node;

        new_node.prev = temp;
    }

    // delete inputed position of a song
    public void deletePos(int n) {
        if(head == null) {
            return;
        }
        else {
            Node current = head;

            int pos =n;
            for(int i = 1; i < pos; i++){
                current = current.next;
            }

            if(current == head) {
                head = current.next;
            }
            else if(current == tail) {
                tail = tail.prev;
            }
            else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            current = null;
        }
    }



    // print the doubly linked list
    public void printlist(Node node) {
        Node last = null;
        while (node != null) {
            System.out.print(node.data + "-->");
            last = node;
            node = node.next;
        }
        System.out.println();
    }

    // search inputed song
    public void searchNode(String value) {
        int i = 1;
        Node current = head;

        //Checks if list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        int fnd = 0;
        while (current != null) {
            //Compare value to be searched with each node in the list

            if ((current.data.equals(value)) == true) {
                System.out.println("the same ");
                System.out.println("Node is present in the list at the position : " + i);
                break;
            } else {

                System.out.println("Node is not present in the list");
            }

            current = current.next;
            i++;
        }

    }



    // print reverse, play back playlist
    public void printReverse(Node head_ref) {
        Node tail = head_ref;
        while (tail.next != null)
        {
            tail = tail.next;
        }

        while (tail != head_ref)
        {
            System.out.print( tail.data + "--> ");
            tail = tail.prev;
        }
        System.out.println( tail.data );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DoublyLinkedList Playlist = new DoublyLinkedList();

        Playlist.printlist(Playlist.head);


        int b=0;
        while(b<10){



            System.out.println("---------------Music Playing App ver. 2.5.1------------------\n   \n" +
                    "1. Add song at the front.\n2. Add song at the End. \n3. Delete song. \n4. Play the playlist \n5. Play in reverse \n6. Search song\n7. Close app \n ");
            int option = sc.nextInt();

            switch (option) {

                // Case add song infront
                case 1:
                    System.out.println("How many songs do you want to add at the front? ");
                    int cse1 = sc.nextInt();

                    for (int i = 0; i < cse1; i++) {
                        System.out.println("Enter name of song to add to playlist. (Use commas, NO SPACES!!!)");
                        String songadd = sc.next();
                        Playlist.addinFront(songadd);
                    }


                    break;

                // Case add song at the end
                case 2:
                    System.out.println("How many songs do you want to add at the End? ");
                    int cse2 = sc.nextInt();

                    for (int i = 0; i < cse2; i++) {
                        System.out.println("enter name of song to add at the end.)");
                        String songadd1 = sc.next();
                        Playlist.insertEnd(songadd1);
                    }

                    break;

                // Case delete song
                case 3:
                    System.out.println("Enter position of song you want to delete");
                    int Posdelete= sc.nextInt();
                    Playlist.deletePos(Posdelete);

                    break;

                // Case print list
                case 4:
                    System.out.println("1. Repeat on? \n2. Repeat off \n  ");
                    int rpt= sc.nextInt();
                    if(rpt==1){
                        int kk=0;
                        System.out.println("Your music is: ");
                        while(kk<10){

                            Playlist.printlist(Playlist.head);

                        }

                    } else if(rpt==2) {
                        System.out.println("Your music is: ");
                        Playlist.printlist(Playlist.head);
                    }
                    break;

                //print in reverse
                case 5:
                    System.out.println(" List in reverse order is ");
                    Playlist.printReverse(Playlist.head);
                    break;

                // search for a song
                case 6:
                    System.out.println(" Enter song you want to search");
                    String srch = sc.next();
                    Playlist.searchNode(srch);
                    break;

                // close app
                case 7:
                    b=10;
                    break;

                // Default case
                default:
                    System.out.println("Error: input type not permitted");

            }
        }
        System.out.println("The playlist is: ");
        Playlist.printlist(Playlist.head );


    }
}
