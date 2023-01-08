package by.bulaukin.shop_receipt.view;

import by.bulaukin.shop_receipt.dto_service.dto.ProductsDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Getter
@Setter
@ConfigurationProperties(prefix = "shop")
public class ReceiptsView {

    private String receipt;
    private String marketsId;
    private String marketsAddress;
    private String phone;
    private final String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private final String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    private List<ProductsDto> receiptsBody;
    private double totalPrice;
    private int discount;
    private double taxable;
    private double discountAmount;


    @Service
    @RequiredArgsConstructor
    public static class ViewsBuilder{
        private final ReceiptsView view;

        public ViewsBuilder addDiscountAmount(double discountAmount){
            view.discountAmount = Math.ceil(discountAmount * 100) / 100;
            return this;
        }

        public ViewsBuilder addDiscount(int discount){
            view.discount = discount;
            return this;
        }

        public ViewsBuilder addReceiptsBody(List<ProductsDto> receiptsBody){
            view.receiptsBody = receiptsBody;
            return this;
        }

        public ViewsBuilder addTotalPrice(double totalPrice){
            view.totalPrice = Math.ceil(totalPrice * 100) / 100;;
            return this;
        }

        public ViewsBuilder addTaxable(double taxable){
            view.taxable = Math.ceil(taxable * 100) / 100;;
            return this;
        }

        public ReceiptsView build() {
            return view;
        }
    }
}
