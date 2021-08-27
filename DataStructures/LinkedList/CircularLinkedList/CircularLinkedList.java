/*
Circlular linked list(CLL)
a circular linkd list can be singly or doubly linked list!
the only change is that the next of the last node is not null, rather it points to the head
Advantages:
1. We can traverse thorugh the entire list from anywhere and not just the head, the only thing is we have to stop when we the
node we started from is visited again.
2. useful implementation of Queue
3. very useful in cases when we need go through the list repeatedly
4. circular doubly linked lists helps in implemention of advanced data structure like fibonacci heap
*/

/*
Implementation-->

To implement a circular singly linked list, we take an external pointer that points to the last node of the list. If we have a
pointer last pointing to the last node, then last -> next will point to the first node.
The pointer last points to node Z and last -> next points to node P.

Why have we taken a pointer that points to the last node instead of the first node?
For the insertion of a node at the beginning, we need to traverse the whole list. Also, for insertion at the end, the whole list
has to be traversed. If instead of start pointer, we take a pointer to the last node, then in both cases there won’t be any need
to traverse the whole list. So insertion at the beginning or at the end takes constant time, irrespective of the length of the
list.
*/

class CircularLinkedList
{

static class Node
{
    int data;
    Node next;
};

static Node addToEmpty(Node last, int data)
{
    // This function is only for empty list
    if (last != null)
    return last;

    // Creating a node dynamically.
    Node temp = new Node();

    // Assigning the data.
    temp.data = data;
    last = temp;

    // Creating the link.
    last.next = last;

    return last;
}

static Node addBegin(Node last, int data)
{
    if (last == null)
        return addToEmpty(last, data);

    Node temp = new Node();

    temp.data = data;
    temp.next = last.next;
    last.next = temp;

    return last;
}

static Node addEnd(Node last, int data)
{
    if (last == null)
        return addToEmpty(last, data);

    Node temp = new Node();

    temp.data = data;
    temp.next = last.next;
    last.next = temp;
    last = temp;

    return last;
}

static Node addAfter(Node last, int data, int item)
{
    if (last == null)
        return null;

    Node temp, p;
    p = last.next;
    do
    {
        if (p.data == item)
        {
            temp = new Node();
            temp.data = data;
            temp.next = p.next;
            p.next = temp;

            if (p == last)
                last = temp;
            return last;
        }
        p = p.next;
    } while(p != last.next);

    System.out.println(item + " not present in the list.");
    return last;

}

static void traverse(Node last)
{
    Node p;

    // If list is empty, return.
    if (last == null)
    {
        System.out.println("List is empty.");
        return;
    }

    // Pointing to first Node of the list.
    p = last.next;

    // Traversing the list.
    do
    {
        System.out.print(p.data + " ");
        p = p.next;

    }
    while(p != last.next);

}

// Driven code
public static void main(String[] args)
{
    Node last = null;

    last = addToEmpty(last, 6);
    last = addBegin(last, 4);
    last = addBegin(last, 2);
    last = addEnd(last, 8);
    last = addEnd(last, 12);
    last = addAfter(last, 10, 8);

    traverse(last);
}
}