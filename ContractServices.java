package Services;

import Entities.Contract;
import Entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractServices {

    private OnlinePaymentService onlinePaymentService;

    public ContractServices(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;

    }

    public void processContract (Contract contract, int months){

        double basicQuota = contract.getTotalValue() / months;
        //basic quota = 200

        for (int i =1; i <= months; i++){
            double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
        //updated quota = 202
            double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
            Date dueDate = addMonths(contract.getDate(), i);
            contract.getInstallments().add(new Installment(dueDate, fullQuota));
        }
    }

    private Date addMonths(Date date, int N) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, N);
        return  calendar.getTime();
    }

}
