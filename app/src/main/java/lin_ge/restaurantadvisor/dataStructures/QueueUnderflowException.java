package lin_ge.restaurantadvisor.dataStructures;

public class QueueUnderflowException extends RuntimeException{

    public QueueUnderflowException()
    {}

    public QueueUnderflowException(String s)
    {
        System.out.println(s);
    }
}
