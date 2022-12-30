package by.bulaukin.shop_receipt.view.convert;

import by.bulaukin.shop_receipt.view.ReceiptsView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiptsViewToString implements ConvertingViews{

    private final ReceiptsView view;

    public <T> T convertsViews() {
        StringBuilder sb = new StringBuilder();
        getHead(sb);
        getBody(sb);
        getFooter(sb);
        return (T) sb.toString();
    }

    private void getFooter(StringBuilder sb) {
        sb
                .append("\n___________________________\n")
                .append("TOTAL")
                .append("\t\t\t\t\t\t")
                .append("$")
                .append(view.getTotalPrice())
                .append("\n");
       if(view.getTaxable() > 0) {
           sb
                   .append("VAT")
                   .append(view.getDiscount())
                   .append("%\t\t\t\t\t\t$")
                   .append(view.getDiscountAmount())
                   .append("\nTAXABLE TOT")
                   .append("\t\t\t\t\t$")
                   .append(view.getTaxable())
                   .append("\n____________________________\n");
       }
    }

    private void getHead(StringBuilder sb) {
        sb
                .append("\n\t\t")
                .append(view.getReceipt())
                .append("\n\t   ")
                .append(view.getMarketsId())
                .append("\n\t\t")
                .append(view.getMarketsAddress())
                .append("\n\t")
                .append("Tel: ")
                .append(view.getPhone())
                .append("\n")
                .append("DATE: ")
                .append(view.getDate())
                .append("\n")
                .append("TIME: ")
                .append(view.getTime())
                .append("\n")
                .append("-----------------------------\n")
                ;
    }

    private void getBody(StringBuilder sb) {
        sb
                .append("Qty")
                .append("\t")
                .append("DESCRIPTION")
                .append("\t\t")
                .append("PRICE")
                .append("\t")
                .append("TOTAL")
                .append("\n");

        view.getReceiptsBody().forEach(body -> {
            sb
                    .append(body.getQuantity())
                    .append("\t")
                    .append(body.getItems())
                    .append("\t\t")
                    .append("$")
                    .append(body.getPrice())
                    .append("\t")
                    .append("$")
                    .append(body.getItemsTotalPrice())
                    .append("\n");
        });
    }
}
