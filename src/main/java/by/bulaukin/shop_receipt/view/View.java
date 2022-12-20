package by.bulaukin.shop_receipt.view;

import by.bulaukin.shop_receipt.dtoService.dto.ProductsDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
//    private Integer itemsCount;
//    private Double price;
//
//    private Double itemsTotalPrice;
//    private String description;
    private List<ProductsDto> receiptsBody;
    private Double totalPrice;
    private Integer discount;
    private Double taxable;


    public static class ViewsBuilder{
        private final View view;

        public ViewsBuilder(){
            view = new View();
        }

//        public ViewsBuilder addItemsCount(int itemsCount){
//            view.itemsCount = itemsCount;
//            return this;
//        }
//
//        public ViewsBuilder addPrice(double price){
//            view.price = price;
//            return this;
//        }

        public ViewsBuilder addDiscount(int discount){
            view.discount = discount;
            return this;
        }

//        public ViewsBuilder addDescription(String description){
//            view.description = description;
//            return this;
//        }
//
//        public ViewsBuilder addItemsTotalPrice(double itemsTotalPrice){
//            view.itemsTotalPrice = Math.ceil(itemsTotalPrice * 100) / 100;
//            return this;
//        }

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

        public View build() {
            return view;
        }
    }
}
