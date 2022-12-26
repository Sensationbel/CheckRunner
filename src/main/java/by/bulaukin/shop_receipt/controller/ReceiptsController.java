package by.bulaukin.shop_receipt.controller;

import by.bulaukin.shop_receipt.pars_data.data.DataFromRequest;
import by.bulaukin.shop_receipt.pars_data.data.ItemsFromRequest;
import liquibase.pro.packaged.D;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@Log4j2
public class ReceiptsController {

    private final DataFromRequest dataFromRequest;

//    @ModelAttribute("dataFromRequest")
//    public DataFromRequest dataFromRequest() {
//        return dataFromRequest;
//    }

    @GetMapping("/")
    public String handleMain(Model model){
        model.addAttribute("dataFromRequest", new DataFromRequest());
        return "index";
    }

    @PostMapping(value = "/addItems", params={"addRow"})
    public String addRow(final DataFromRequest dataFromRequest){
        dataFromRequest.getItems().add(new ItemsFromRequest());
        log.info("addRow");
        return "/index";
    }

    @PostMapping(value="/addItems", params={"removeRow"})
    public String removeRow(final DataFromRequest dataFromRequest,
            final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        dataFromRequest.getItems().remove(rowId.intValue());
        log.info("remove");
        return "index";
    }

    @PostMapping(value = "/addItems", params = {"save"})
    public String save(final DataFromRequest dataFromRequest){
        log.info("save: " + dataFromRequest.getItems() + "  " + dataFromRequest.getCardNumber());
        return "index";
    }
}
