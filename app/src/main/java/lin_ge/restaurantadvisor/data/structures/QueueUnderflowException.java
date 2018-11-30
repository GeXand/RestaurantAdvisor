package lin_ge.restaurantadvisor.data.structures;

public class QueueUnderflowException extends RuntimeException{

    public QueueUnderflowException()
    {}

    public QueueUnderflowException(String s)
    {
        System.out.println(s);
    }
}
