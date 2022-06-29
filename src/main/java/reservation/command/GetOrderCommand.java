package reservation.command;

import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import reservation.Reservation;

@Command(name = "GetOrder", description = "Get order information by order ID")
public class GetOrderCommand implements Callable<Integer> {

  @Parameters(index = "0", paramLabel = "ORDER_ID", description = "order ID")
  private String orderId;

  @Override
  public Integer call() throws Exception {
    try (Reservation reservation = new Reservation()) {
      System.out.println(reservation.getOrderByOrderId(orderId));
    }
    return 0;
  }
}
