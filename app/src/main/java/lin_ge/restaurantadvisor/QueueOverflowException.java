package lin_ge.restaurantadvisor;

public class QueueOverflowException extends RuntimeException{

    public QueueOverflowException()
    {

    }

    public QueueOverflowException(String s)
    {
        System.out.println(s);
    }
}
