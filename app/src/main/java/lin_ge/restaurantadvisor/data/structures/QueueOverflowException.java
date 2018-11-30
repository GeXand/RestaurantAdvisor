package lin_ge.restaurantadvisor.data.structures;

public class QueueOverflowException extends RuntimeException{

    public QueueOverflowException()
    {

    }

    public QueueOverflowException(String s)
    {
        System.out.println(s);
    }
}
