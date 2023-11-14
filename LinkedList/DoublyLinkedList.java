package LinkedList;

public class DoublyLinkedList {
    Cell head;

    public DoublyLinkedList(int n) {
        Cell next = null;
        Cell prev;

        for (int i = 0; i < n; i++) {
            prev = next;
            next = new Cell(i, null, prev);
            if (prev != null) {
                prev.next = next;
            }
            if (i == 0){
                head = next;
            }
        }
    }

    public static class Cell {
        int data;
        Cell next;
        Cell previous;


        public Cell(int val, Cell nextCell, Cell previousCell) {
            data = val;
            next = nextCell;
            previous = previousCell;
        }
    }

    // Add the item as the first cell in the sequence
    public void add(int item){
        // Create a new cell with given data
        if (head == null){
            head = new Cell(item, null, null);
        }
        else {
            Cell newCell = new Cell(item, head, null);
            head.previous = newCell;
            head = newCell;
        }
    }
    
    // Return the length of the sequence.
    public int length(){
        int count = 0;

        if (head == null){
            return count;
        }
        else {
            Cell last = head;

            while (last.next != null){
                last = last.next;
                count++;
            }

            count++;
        }

        return count;
    }

    // Return true or false depending on if the
    // item can be found in the sequence.
    public boolean find(int item){
        if (head == null){
            return false;
        }
        else {
            Cell last = head;

            while (last.next != null){
                if (last.data == item){
                    return true;
                }

                last = last.next;
            }

            if (last.data == item){
                return true;
            }
        }
        return false;
    }

    // Remove the item if it exists in the sequence.
    public void remove(int item){
        if (head != null && head.data == item) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
            return;
        }

        Cell last = head;

        while (last != null && last.next != null){
            if (last.next.data == item){
                Cell nextCell = last.next.next;
                last.next = nextCell;
                if (nextCell != null) {
                    nextCell.previous = last;
                }
            } else {
                last = last.next;
            }
        }
    }

    // Append a sequence to the end of a sequence
    public void append(DoublyLinkedList b) {
        if (head == null){
            head = b.head;
        }
        else {
            Cell last = head;

            while (last.next != null){
                last = last.next;
            }

            last.next = b.head;
            b.head.previous = last;
        }
    }

    // Remove a specific cell identified by a reference DoublyLinkedList
    public void unlink(Cell cell){
        if (head == null || cell == null){
            return;
        }

        if (head == cell){
            head = cell.next;
        }

        if (cell.next != null){
            cell.next.previous = cell.previous;
        }

        if (cell.previous != null){
            cell.previous.next = cell.next;
        }
    }


    // Insert a cell as the first cell in the list
    public void insert(Cell t1){
        if (head == null){
            head = t1;
            t1.next = null;
            t1.previous = null;
        }
        else {
            t1.next = head;
            head.previous = t1;
            head = t1;
        }
    }
}
