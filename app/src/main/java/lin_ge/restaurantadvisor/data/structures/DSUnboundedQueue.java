package lin_ge.restaurantadvisor.data.structures;

public class DSUnboundedQueue<T> {
    protected final int DEFCAP = 100;
    protected T[] elements;
    protected int numElements = 0;
    protected int front = 0;
    protected int rear;

    public DSUnboundedQueue()
    {
        elements = (T[]) new Object[DEFCAP];
    }

    public DSUnboundedQueue(int size)
    {
        elements = (T[]) new Object[size];
    }


    public T dequeue() throws QueueUnderflowException {
        // TODO Auto-generated method stub
        if(isEmpty())
            throw new QueueUnderflowException("Dequeue not possible");
        else
        {
            T toReturn = elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            numElements --;
            return toReturn;
        }
    }

    public void enqueue(Object element) throws QueueOverflowException {
        // TODO Auto-generated method stub
        if(numElements == elements.length)
        {
            grow();
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = (T) element;
        numElements ++;
    }

    public boolean isFull() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public int size() {
        // TODO Auto-generated method stub
        return numElements;
    }

    private void grow()
    {
        T[] temp = (T[]) new Object[elements.length + DEFCAP];
        //Copy over contents of old array to new array and make sure rear and front to not be next to each other
        elements = temp;
    }
}

