package by.bulaukin.shop_receipt.view;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "shop")
public class View {

    private String receipt;
    private String marketsId;
    private String marketsAddress;
    private String phone;
    private String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    private Integer itemsCount;
    private Double price;
    private String description;
    private Double totalPrice;
    private Integer discount;
    private Double taxable;


    public static class ViewsBuilder{
        private final View view;

        private ViewsBuilder(){
            view = new View();
        }

        public ViewsBuilder addItemsCount(int itemsCount){
            view.itemsCount = itemsCount;
            return this;
        }

        public ViewsBuilder addPrice(double price){
            view.price = price;
            return this;
        }

        public ViewsBuilder addDiscount(int discount){
            view.discount = discount;
            return this;
        }

        public ViewsBuilder addDescription(String description){
            view.description = description;
            return this;
        }

        public ViewsBuilder addTotalPrice(double totalPrice){
            view.totalPrice = totalPrice;
            return this;
        }

        public ViewsBuilder addTaxable(double taxable){
            view.taxable = taxable;
            return this;
        }

        public View build() {
            return view;
        }
    }
}
