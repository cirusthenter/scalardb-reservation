package reservation.command;

import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import reservation.Reservation;

@Command(name = "Repayment", description = "Repayment")
public class RepaymentCommand implements Callable<Integer> {

  @Parameters(index = "0", paramLabel = "CUSTOMER_ID", description = "customer ID")
  private int customerId;

  @Parameters(index = "1", paramLabel = "AMOUNT", description = "amount of the money for repayment")
  private int amount;

  @Override
  public Integer call() throws Exception {
    try (Reservation reservation = new Reservation()) {
      reservation.repayment(customerId, amount);
    }
    return 0;
  }
}
