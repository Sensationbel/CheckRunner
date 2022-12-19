package by.bulaukin.shop_receipt.view;

public class PrintingView {

    public String print(View view) {

        StringBuilder sb = new StringBuilder();
        sb
                .append("\t\t")
                .append(view.getMarketsId())
                .append("\n\t")
                .append(view.getMarketsAddress())
                .append("\n")
                .append(view.getPhone())
                .append("DATE: ")
                .append(view.getDate())
                .append("TIME: ")
                .append(view.getTime())
        ;

        return sb.toString();

    }
}
